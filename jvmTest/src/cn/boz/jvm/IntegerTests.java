package cn.boz.jvm;

public class IntegerTests {

	public static void main(String[] args) {
		String a1 = new String("abc").intern();
		String a2 = "abc";
		a2.intern();
		a1.intern();
		boolean rst = a2==a1;
		System.out.println(rst);
//		for(int i=-256;i<256;i++) {
//			Integer i1=Integer.valueOf(i);
//			Integer i2=Integer.valueOf(i);
//			if(i1==i2) {
//				System.out.println("true");
//				System.out.println(i);
//			}else {
//				System.out.println("false");
//			}
//		}
	}
}
