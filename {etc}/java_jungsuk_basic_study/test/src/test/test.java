package test;

public class test {
	public static void main(String[] args) {
		double a = 3.889;

		
		System.out.println(Math.round(a)); // 반올림
		System.out.println(Math.round(a*100)/100.0); // 특정자리 반올림
		System.out.println();
		
		StringBuffer sb = new StringBuffer("bbc");
		StringBuffer sb2 = new StringBuffer("bbc");
		
		String tosb = sb.toString();
		String tosb2 = sb2.toString();
		
		
		System.out.println(sb.equals(sb2));
		System.out.println(tosb.equals(tosb2));



	}

	@Override
	public String toString() {
		return "test [toString()=" + super.toString() + "]";
	}
	
	

}
