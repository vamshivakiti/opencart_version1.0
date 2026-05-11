package interview;

//import java.security.PublicKey;
//import java.util.HashMap;
//
//import org.apache.commons.collections4.map.StaticBucketMap;

public class FirstNonRepeaticeChar {

	public static void main(String[] args) {
		String input = "automation";
		input=input.toLowerCase();

        Character result = findFirstNonRepeatingChar(input);

        if (result != null) {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }

    public static Character findFirstNonRepeatingChar(String str) {
        // Store character count
        java.util.LinkedHashMap<Character, Integer> map = new java.util.LinkedHashMap<>();

        // Count frequency of each character
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Find the first character with frequency 1
        for (char ch : map.keySet()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }

        return null;
	}

}
