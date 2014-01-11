package chapter9;

public class RodCut {

	public static void main (String[] args) {
		int[]	p  =  {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		System.out.println(RodCut1(p.length, p)); 
	}
	public static int RodCut1 (int n, int[] p) {
		return RodCutBottomUp(p.length, p);
	}
	public static int RodCutTopDown(int n, int[] p) {
		int[]		s  =  new int[p.length+1];
		for (int i=0; i != s.length; ++i)
			s[i] = Integer.MIN_VALUE;
		s[0]  =  0;		s[1]  =  p[0];
		return RodCutTopDownHelper(n, p, s);
	}
	private static int RodCutTopDownHelper(int n, int[] p, int[] s) {
		if ( s[n] != Integer.MIN_VALUE ) return s[n];
		
		// divide the problem into subproblem
		int		max  =  Integer.MIN_VALUE;
		for ( int i=1; i <= n ; ++i ) {
			// conquer each subproblem and combine them together
			max  =  Math.max(max, p[i-1]+RodCutTopDownHelper(n-i,p,s) );	
		}
		s[n]  =  max;
		return max;
	}
	
	public static int RodCutBottomUp(int n, int[] p) {
		int[] 	s  =  new int[p.length+1];
		for (int i=0; i!=s.length; ++i)
			s[i]  =  Integer.MIN_VALUE;
		
		// base case and trivial case
		s[0]  =  0;
		s[1]  =  p[0];
		
		// build up the table
		for ( int i=2; i <= n; ++i ){
			int		max  =  Integer.MIN_VALUE;
			for ( int j=1; j <= i; ++j ) {
				max  =  Math.max( max, p[j-1] + s[i-j] );
			}
			s[i]  =  max;
		}
		return s[n];
	}
}