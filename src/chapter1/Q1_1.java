package chapter1;

import java.util.Scanner;

public class Q1_1 {

	public static void main(String[] args) {
		Scanner		sc = new Scanner( System.in );
		System.out.println("Please enter a string:");
		String	str = sc.nextLine();
		System.out.println( isAllUnique( str ) );
		
		sc.close();
	}

	public static boolean isAllUnique(String s) {
		if	( s.length() > 256 ) return false;
		
		// by default, all values in boolean array are set to #f
		boolean[]	charSet = new boolean[256];
		for (int i=0 ; i != s.length(); ++i ) {
			int		c  =  s.charAt(i);
			if ( charSet[c] ) {
				return false;
			}
			charSet[ c ] = true;
		}
		return true;
	}

	public static void shiftProblem() {
		// TODO Auto-generated method stub
		int i = -2147483648;
		System.out.println("arithmatic left shift <<:");
		System.out.println(Integer.toBinaryString(i << 1));

		System.out.println("arithmatic right shift >>:");
		System.out.println(Integer.toBinaryString(i >> 1));

		// logical shift always shifts in 0
		// while arithmetic shift shifts in digit same as that on
		// the highest bit or lowest bit.
		System.out.println("logical right shift >>>:");
		System.out.println(Integer.toBinaryString(i >>> 1));
	}
}
