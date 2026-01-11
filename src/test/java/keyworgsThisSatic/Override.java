package keyworgsThisSatic;

 class Override {

	static String m() {
	    return "this is m method1";
	}
	
	
	static class override1 extends Override{
		
		static String m() {
			return "This is methid m2";
			
		}
		
		
		static class overridemain{
			public static void main(String[] args) {
				override1 ov1 = new override1();
				String results =ov1.m();
				System.out.println(results);
			}
		}
	}
}
