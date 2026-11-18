package interview;

import java.awt.RenderingHints.Key;
import java.util.HashSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CompareTwoIntArrays {

	public static void main(String[] args) {
		WebDriver driver  = new ChromeDriver();
    int [] arr1 = {1,2,3,4,5};
    int []arr2= {2,3,5};
    
    HashSet<Integer> set = new HashSet<>();
    
    for(int n:arr2) {
    	set.add(n);
    }
    
    for(int n:arr1) {
    	if(!set.contains(n)) {
    		System.out.print(n+" ,");
    	}
    }Actions act = new Actions(driver);
    //act.keyDown(Key.SHIFT).sendKeys("hello").keyUp(Key.SHIFT).perform();
    
	}

}
