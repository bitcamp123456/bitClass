package ch02;

public class typeTest {
	public static void main(String[] args) {
		
		long l = 10_000_000_000L;
		
		
		double d = 2e3;
		System.out.println(d);
		
		
		int b = 0b10;
		int oct = 010;
		int hex = 0x10;
		System.out.println(b+","+oct+","+hex);
		
		System.out.printf("%x%n",hex);
		System.out.printf("%x%n",16);
		System.out.printf("%o%n",50);
		
		int i = new Integer(100).intValue();
		
		String str = String.valueOf(new Integer(100));
		
		
		char ch = 'A';
		System.out.println(ch);
		
		int ii = 'A';
		System.out.println(ii);
		
		int iii = 3;
		
		char c = (char) (iii+'0');
		
		System.out.println(c);
		
		System.out.println("789".charAt(2));
		
		
	
		


	}

}
