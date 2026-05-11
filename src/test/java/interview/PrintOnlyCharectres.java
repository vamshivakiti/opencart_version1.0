package interview;

public class PrintOnlyCharectres {

	public static void main(String[] args) {
		String input = "abc123def456ghi789";
		for(int i=0; i<input.length();i++) {
			char ch =input.charAt(i);
			if(Character.isLetter(ch)) {
				System.out.print(ch);
			}
		}

	}

}
