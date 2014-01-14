package chapter9;

import java.util.Arrays;

public class Q9_8 {

	public static void main (String[] args) {
		int[]	 k   =	new int[]{25, 10, 5, 1};
		Arrays.sort(k);
		System.out.println( waysOfCents( 15, k ) );
	}
	public static int waysOfCents ( int n, int[] k ) {
		// temporary array to store the immediate ret
		int[][]		s  =  new int[n+1][k.length];
		
		// initialize the s Matrix
		// 1. init the bottom row
		for ( int i=0; i != k.length; i++ ) {
			s[1][i]  =  1;
			s[0][i]  =  1;
		}
		// 2. init the left column to j
		for ( int j=1; j <= n; ++j ) {
			s[j][0]  =  1;
		}
		
		// build up the s table from left to right
		for ( int i=1; i != k.length; ++i ) {
			// iterate through n
			int		denom  =  k[i];
			for ( int w=1; w <= n; ++w ) {
				// iterate through k.length combination
				int  j  =  0;
				int  ret  =  0;
				while ( j*denom <= w ) {
					ret  += s[w-j*denom][i-1];
					j++;
				}
				s[w][i]  =  ret;
			}
		}
		return s[n][k.length-1];
 	}
}