package oodesign.VendorMachine;

public class Run {

	public static class Foo {
		String	name;
		int		value;
		@Override
		public String toString () {
			return String.format("[%s,%d]",name, value);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Foo[]		lof  =  new Foo[2];
		for ( Foo e : lof) {
			System.out.println( e );
		}
		Exception	e  =  new SoldOutException("asfasd");
		System.out.println( e.getMessage() );
	}

}
