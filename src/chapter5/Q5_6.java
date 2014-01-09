package chapter5;

public class Q5_6 {

	public static void main (String[] args) {
		
	}
	public static int swap ( int n ) {
		// 1. build a mask like 0101010...101
		int   mask  =  0;
		for ( int i=0; i <= 30; i = i + 2) {
			mask  =  mask | ( 1 << i );
		}
		// 2. get the even digit  => n0
		int		n0  =  n & mask;
		// 3. get the odd digit => n1
		int		n1  =  n & (mask << 1);
		// final ,left shift n0 right shift n1 and return |
		return  (n0 << 1) | ( n1 >> 1 );
	}
}
