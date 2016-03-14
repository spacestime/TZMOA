package cn.tzm.oa.test;

public class testSwop {

	public static void main(String[] args) {
		int a=1;
		int b=2;
		System.out.println("前  a="+a+"; b="+b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("后  a="+a+"; b="+b);
	}

}
