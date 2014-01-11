package chapter9;

import java.util.Arrays;

public class Q9_1 {

	public static void main (String[] args) {
		System.out.println( waysOfRun(5));
	}
	public static int	waysOfRun( int n ) {
		return bottomUp(n);
	}
	public static int topDown ( int n ) {
		int[]	 s  =  new int[n+1];
		s[0]  =  0;		s[1]  =  1;
		s[2]  =  2;		s[3]  =  4;
		int	ret  =  topDownHelper(n, s);
		
		System.out.println( "result: " + Arrays.toString(s));
		return  ret;
	}
	private static int topDownHelper( int n, int[] s) {
		if ( s[n] != 0 ) { return s[n]; }
		// non-trivial cases
		int		ret  =  topDownHelper(n-1, s) +
				topDownHelper(n-2, s) + topDownHelper(n-3, s);
		s[n]  =  ret;
		return ret;
	}
	
	private static int bottomUp( int n ) {
		// s table
		int[]		s  =  new int[n+1];
		s[0]  =  0;		s[1]  =  1;
		s[2]  =  2;		s[3]  =  4;
		for (int i = 4; i <= n ; ++i ) {
			s[i] = s[i-1] + s[i-2] + s[i-3];
		}
		return s[n];
	}
}
