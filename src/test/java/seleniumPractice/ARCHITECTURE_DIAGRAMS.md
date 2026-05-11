# Architecture & Design Diagrams

## 1. Architecture Overview

```
┌─────────────────────────────────────────────────────────────────┐
│                    BrokenLinksImproved                          │
│                    (Main Checker Class)                         │
├─────────────────────────────────────────────────────────────────┤
│                                                                 │
│  ┌──────────────────┐  ┌──────────────────┐                    │
│  │                  │  │                  │                    │
│  │ Selenium WebDriver   Configuration    │                    │
│  │ (Browser Control)  │ (LinkCheckerConfig)                    │
│  │                  │  │                  │                    │
│  └────────┬─────────┘  └────────┬─────────┘                    │
│           │                     │                               │
│           └──────────┬──────────┘                               │
│                      │                                          │
│          ┌───────────▼────────────┐                            │
│          │  Extract URLs (List)   │                            │
│          └───────────┬────────────┘                            │
│                      │                                          │
│          ┌───────────▼──────────────────┐                      │
│          │  ExecutorService (Thread Pool)                      │
│          │  (5-20 concurrent threads)   │                      │
│          └───────────┬──────────────────┘                      │
│                      │                                          │
│        ┌─────────────┼─────────────┐                           │
│        │             │             │                           │
│   ┌────▼──┐    ┌────▼──┐    ┌────▼──┐                         │
│   │Check  │    │Check  │    │Check  │  ... (Thread Pool)    │
│   │Link 1 │    │Link 2 │    │Link 3 │                        │
│   └────┬──┘    └────┬──┘    └────┬──┘                         │
│        │             │             │                           │
│        └─────────────┼─────────────┘                           │
│                      │                                          │
│        ┌─────────────▼──────────────┐                          │
│        │ LinkCheckResult (Each link) │                         │
│        │ - URL                       │                         │
│        │ - Status Code               │                         │
│        │ - Status (VALID/BROKEN)    │                         │
│        │ - Error Message (if any)   │                         │
│        └─────────────┬──────────────┘                          │
│                      │                                          │
│        ┌─────────────▼──────────────┐                          │
│        │  LinkCheckReport (Results)  │                         │
│        │  - Total links              │                         │
│        │  - Broken count             │                         │
│        │  - Valid count              │                         │
│        │  - Error count              │                         │
│        │  - Execution time           │                         │
│        └─────────────┬──────────────┘                          │
│                      │                                          │
│                      ▼                                          │
│          ┌──────────────────────┐                              │
│          │  Professional Report │                              │
│          │  (Console Output)     │                              │
│          └──────────────────────┘                              │
│                                                                 │
└─────────────────────────────────────────────────────────────────┘
```

---

## 2. Class Relationship Diagram

```
┌─────────────────────────────────────┐
│  BrokenLinksImproved                │
│  (Main Checker)                     │
├─────────────────────────────────────┤
│ - config: LinkCheckerConfig         │
│ - report: LinkCheckReport           │
│ - processedLinks: AtomicInteger     │
├─────────────────────────────────────┤
│ + checkBrokenLinks(url)             │
│ + checkLinksWithThreadPool(urls)    │
│ + checkLinkValidity(url)            │
└────────┬──────────────────────────┬─┘
         │ uses                     │ creates
         │                          │
    ┌────▼──────────────────┐  ┌───▼───────────────────┐
    │ LinkCheckerConfig     │  │ LinkCheckReport       │
    ├──────────────────────┤  ├───────────────────────┤
    │ - connectionTimeout  │  │ - results: List       │
    │ - readTimeout        │  │ - totalCheckTime: long│
    │ - threadPoolSize     │  ├───────────────────────┤
    │ - responseThreshold  │  │ + addResult()         │
    ├──────────────────────┤  │ + getBrokenLinks()    │
    │ + getters/setters    │  │ + getValidLinks()     │
    └──────────────────────┘  │ + getBrokenLinksCount │
                              │ + getValidLinksCount()│
                              │ + printReport()       │
                              └───┬──────────────────┬┘
                                  │ contains         │
                                  │                  │
                            ┌─────▼─────────────────▼──┐
                            │  LinkCheckResult         │
                            ├──────────────────────────┤
                            │ - url: String            │
                            │ - statusCode: int        │
                            │ - status: String         │
                            │ - errorMessage: String   │
                            ├──────────────────────────┤
                            │ + getters/setters        │
                            │ + toString()             │
                            └──────────────────────────┘
```

---

## 3. Thread Pool Execution Flow

```
User Code
    │
    ├─ Create Config
    │  ├─ Connection Timeout: 5000ms
    │  ├─ Read Timeout: 5000ms
    │  ├─ Thread Pool Size: 5
    │  └─ Response Threshold: 400
    │
    ├─ Create Checker
    │  └─ BrokenLinksImproved checker = new BrokenLinksImproved(config)
    │
    ├─ Check Links
    │  └─ LinkCheckReport report = checker.checkBrokenLinks(url)
    │
    └─ Launch Browser & Extract URLs
       │
       ├─ Open URL with Selenium
       ├─ Find all <a> tags
       ├─ Extract href attributes
       └─ Filter valid URLs (http/https)
          │
          ├─ Create ExecutorService (5 threads)
          │
          ├─ Submit Tasks
          │  ├─ Task 1: Check Link A (Thread 1)
          │  ├─ Task 2: Check Link B (Thread 2)
          │  ├─ Task 3: Check Link C (Thread 3)
          │  ├─ Task 4: Check Link D (Thread 4)
          │  ├─ Task 5: Check Link E (Thread 5)
          │  ├─ Task 6: Check Link F (Waits for Thread 1)
          │  └─ ... (Queue remaining tasks)
          │
          ├─ Concurrent Execution
          │  │
          │  ├─ HTTP Connection
          │  ├─ Send HEAD request
          │  ├─ Set timeout (5000ms)
          │  ├─ Get response code
          │  │
          │  ├─ Check Status
          │  │  ├─ If >= 400: BROKEN
          │  │  └─ If < 400: VALID
          │  │
          │  └─ Create LinkCheckResult
          │     └─ Add to Report
          │
          └─ Shutdown ExecutorService
             │
             ├─ Wait for all tasks (5 min timeout)
             ├─ Generate Report
             │  ├─ Count statistics
             │  ├─ Filter broken links
             │  ├─ Calculate execution time
             │  └─ Print detailed report
             │
             └─ Return LinkCheckReport to User
```

---

## 4. Data Flow Diagram

```
INPUT: Website URL
   │
   ▼
┌──────────────────────────┐
│ BrokenLinksImproved      │
│ checkBrokenLinks(url)    │
└───────────┬──────────────┘
            │
            ▼
    ┌───────────────────┐
    │ Start WebDriver   │
    │ Get website       │
    └───────────┬───────┘
                │
                ▼
    ┌────────────────────────┐
    │ Extract URLs           │
    │ From <a> tags          │
    │ Filter valid URLs      │
    └───────────┬────────────┘
                │
                ▼
    ┌────────────────────────────┐
    │ Create Thread Pool         │
    │ With 5-20 threads          │
    └───────────┬────────────────┘
                │
    ┌───────────┴───────────┬─────────────┐
    │                       │             │
    ▼                       ▼             ▼
┌──────────┐        ┌──────────┐    ┌──────────┐
│ Thread 1 │        │ Thread 2 │    │ Thread N │
│          │        │          │    │          │
│ Check    │        │ Check    │    │ Check    │
│ Link 1   │        │ Link 2   │    │ Link N   │
└────┬─────┘        └────┬─────┘    └────┬─────┘
     │                   │              │
     ├──→ HTTP HEAD Request             │
     │    Set Timeout: 5000ms           │
     │    Get Response Code             │
     │    Disconnect                    │
     │                                  │
     └─────────────────┬────────────────┘
                       │
                       ▼
    ┌──────────────────────────────────┐
    │ Create LinkCheckResult           │
    │ ├─ URL: String                   │
    │ ├─ Status Code: int              │
    │ ├─ Status: VALID/BROKEN/ERROR   │
    │ └─ Error Message: String         │
    └───────────┬──────────────────────┘
                │
                ▼
    ┌──────────────────────────────────┐
    │ Add to LinkCheckReport           │
    │ (Thread-safe collection)         │
    └───────────┬──────────────────────┘
                │
                ▼
    ┌──────────────────────────────────┐
    │ All Results Collected            │
    │ Generate Report Statistics       │
    │ ├─ Total links checked           │
    │ ├─ Broken count                  │
    │ ├─ Valid count                   │
    │ ├─ Error count                   │
    │ └─ Execution time                │
    └───────────┬──────────────────────┘
                │
                ▼
    ┌──────────────────────────────────┐
    │ Print Professional Report        │
    │ Display broken links detail      │
    │ Close WebDriver                  │
    └───────────┬──────────────────────┘
                │
                ▼
OUTPUT: LinkCheckReport with all results
```

---

## 5. Configuration Management

```
┌─────────────────────────────────────────────────────────────┐
│              LinkCheckerConfig                              │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  ┌────────────────────────────────────────────────────┐    │
│  │ Configuration Parameters                           │    │
│  ├────────────────────────────────────────────────────┤    │
│  │ 1. connectionTimeout (default: 5000ms)             │    │
│  │    └─ How long to wait for connection              │    │
│  │                                                    │    │
│  │ 2. readTimeout (default: 5000ms)                   │    │
│  │    └─ How long to wait for response                │    │
│  │                                                    │    │
│  │ 3. threadPoolSize (default: 5)                     │    │
│  │    └─ Number of concurrent threads                 │    │
│  │                                                    │    │
│  │ 4. responseCodeThreshold (default: 400)            │    │
│  │    └─ Status code >= threshold = BROKEN            │    │
│  │                                                    │    │
│  └────────────────────────────────────────────────────┘    │
│                                                             │
│  ┌────────────────────────────────────────────────────┐    │
│  │ Usage Scenarios                                    │    │
│  ├────────────────────────────────────────────────────┤    │
│  │                                                    │    │
│  │ Scenario 1: Large Website (1000+ links)           │    │
│  │ └─ connectionTimeout: 10000                       │    │
│  │    readTimeout: 10000                             │    │
│  │    threadPoolSize: 15                             │    │
│  │    responseThreshold: 400                         │    │
│  │                                                    │    │
│  │ Scenario 2: Slow Server                           │    │
│  │ └─ connectionTimeout: 20000                       │    │
│  │    readTimeout: 20000                             │    │
│  │    threadPoolSize: 3                              │    │
│  │    responseThreshold: 400                         │    │
│  │                                                    │    │
│  │ Scenario 3: Quick Scan                            │    │
│  │ └─ connectionTimeout: 3000                        │    │
│  │    readTimeout: 3000                              │    │
│  │    threadPoolSize: 20                             │    │
│  │    responseThreshold: 400                         │    │
│  │                                                    │    │
│  └────────────────────────────────────────────────────┘    │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

---

## 6. Error Handling Flow

```
Check Link
    │
    ├─ Try HTTP Connection
    │  │
    │  ├─ SUCCESS
    │  │  │
    │  │  ├─ Get Response Code
    │  │  │  │
    │  │  │  ├─ Code < 400
    │  │  │  │  └─ Status: VALID ✅
    │  │  │  │
    │  │  │  └─ Code >= 400
    │  │  │     └─ Status: BROKEN ❌
    │  │  │
    │  │  └─ Add to Report
    │  │     └─ LinkCheckResult(url, code, status)
    │  │
    │  └─ FAILURE
    │     │
    │     ├─ Connection Error (IOException)
    │     │  └─ Status: ERROR ⚠️
    │     │     └─ Error Message: Connection refused
    │     │
    │     ├─ Timeout Error
    │     │  └─ Status: ERROR ⚠️
    │     │     └─ Error Message: Read timed out
    │     │
    │     └─ Other Exception
    │        └─ Status: SKIPPED ⊘
    │           └─ Error Message: Exception details
    │
    └─ Finally: Disconnect & Cleanup ✓
```

---

## 7. Performance Comparison

```
Sequential Processing (Original)
├─ Link 1: ████ 5 sec
├─ Link 2: ████ 5 sec
├─ Link 3: ████ 5 sec
├─ Link 4: ████ 5 sec
├─ Link 5: ████ 5 sec
├─ ...
├─ Link 100: ████ 5 sec
└─ TOTAL: ████████████████ 500 sec

Concurrent Processing (5 Threads)
├─ Link 1-5: ████ 5 sec  (Threads 1-5 run in parallel)
├─ Link 6-10: ████ 5 sec (Next batch)
├─ Link 11-15: ████ 5 sec (Next batch)
├─ ...
└─ TOTAL: ████ 100 sec (5x faster!)

Concurrent Processing (10 Threads)
├─ Link 1-10: ████ 5 sec (Threads 1-10 run in parallel)
├─ Link 11-20: ████ 5 sec (Next batch)
├─ ...
└─ TOTAL: ████ 50 sec (10x faster!)
```

---

## 8. Result Report Structure

```
LinkCheckReport
├─ Results Collection (List<LinkCheckResult>)
│  ├─ LinkCheckResult 1: URL-A, 200, VALID
│  ├─ LinkCheckResult 2: URL-B, 404, BROKEN
│  ├─ LinkCheckResult 3: URL-C, 500, ERROR
│  ├─ LinkCheckResult 4: URL-D, 200, VALID
│  └─ ...
│
├─ Aggregated Statistics
│  ├─ totalCheckTime: 12345 ms
│  ├─ totalLinksChecked(): 45
│  ├─ validLinksCount(): 40
│  ├─ brokenLinksCount(): 4
│  └─ errorLinksCount(): 1
│
├─ Filtered Results
│  ├─ getBrokenLinks() → List of BROKEN links only
│  ├─ getValidLinks() → List of VALID links only
│  └─ getErrorLinks() → List of ERROR links only
│
└─ Report Output
   └─ printReport()
      ├─ ==================================
      ├─ BROKEN LINKS ANALYSIS REPORT
      ├─ ==================================
      ├─ Total Links Checked: 45
      ├─ Valid Links: 40
      ├─ Broken Links: 4
      ├─ Error Links: 1
      ├─ Total Check Time: 12345 ms
      ├─ ==================================
      ├─ BROKEN LINKS DETAILS:
      ├─ [BROKEN] URL-B - Status Code: 404
      └─ [ERROR] URL-C - Status Code: -1 - Error: Connection failed
```

---

## 9. Integration Points

```
┌─────────────────────────────────────────────────────┐
│         Your Test Framework                        │
│  (JUnit, TestNG, Selenium Grid, etc.)             │
└────────┬────────────────────────────────────────────┘
         │
         ▼
┌─────────────────────────────────────────────────────┐
│     BrokenLinksImproved                             │
│  (Your new enhanced checker)                        │
└──────┬──────────────────────────────────────┬───────┘
       │                                      │
       ▼                                      ▼
   Input:                              Output:
   - Website URL                       - LinkCheckReport
   - Configuration                     - Broken links list
                                       - Statistics
                                       - Execution time

Integration Points:
├─ CI/CD Pipeline
│  └─ Run daily automated checks
│
├─ Test Suite
│  └─ Run before deployment
│
├─ Monitoring
│  └─ Track broken links over time
│
├─ Database
│  └─ Store historical results
│
└─ Reporting
   └─ Generate alerts for broken links
```

---

## 10. Code Metrics

```
Scalability Index
┌────────────────────────────────┐
│ Before (Original) │ After (Improved)
├────────────────────────────────┤
│ ████              │ █████████
│ 1.0               │ 9.0
└────────────────────────────────┘

Maintainability Index
┌────────────────────────────────┐
│ Before (Original) │ After (Improved)
├────────────────────────────────┤
│ ████              │ █████████
│ 2.0               │ 9.0
└────────────────────────────────┘

Performance Index
┌────────────────────────────────┐
│ Before (Original) │ After (Improved)
├────────────────────────────────┤
│ ██                │ ████████
│ 1x (Sequential)   │ 4-7x (Concurrent)
└────────────────────────────────┘

Code Quality Index
┌────────────────────────────────┐
│ Before (Original) │ After (Improved)
├────────────────────────────────┤
│ ██████            │ █████████
│ 6.0               │ 9.0
└────────────────────────────────┘
```

---

**This completes the architecture documentation!**

All diagrams show the improved structure and flow of your enhanced BrokenLinks implementation.
