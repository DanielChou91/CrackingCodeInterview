package chapter6;

public class Q6_5 {
	public static void main ( String[] args ) {
		int			f  =  150;
		int			e  =  2;
		
		int[][]		s  =  new int[f+1][e+1];
		for ( int j=0; j!=f+1; ++j) {
			for (int i=0; i!=e+1; ++i) {
				s[j][i]  =  -9999999;
			}
		}
		int[][]		c  =  new int[f+1][e+1];
		System.out.println( eggOnFloor(f, e, s, c) );
		backTrace(s, c, f, e, 0);
	}
	public static int eggOnFloor (int f, int e, int[][] s, int[][] c ) {
		if ( s[f][e] != -9999999) {
			return s[f][e];
		}
		
		if ( f == 0 ) {
			return 0;
		}
		
		if ( e <= 0) {
			return 9999999;
		}
		
		int	min  =  99999999;
		for (int i = 1; i <= f; ++i) {
			int   tmp  =  Math.max(eggOnFloor(i-1, e-1, s, c), 
					eggOnFloor(f-i, e, s, c)) + 1;
			if ( tmp < min ) {
				c[f][e]  =  i;
				min  =  tmp;
			}
		}
		s[f][e]  =  min;
		System.out.println( String.format("floor: %d, egg: %d => %d", f, e, min));
		return min;
	}
	public static void backTrace (int[][] s, int[][] c, int f, int e, int base) {
		if ( e == 0 || f == 0 ) {
			return;
		}
		int		p  =  c[f][e];
		System.out.println(String.format("floor: %d, egg: %d, choose %d", f, e, p+base) );
		if ( s[p-1][e-1] > s[f-p][e] ) {
			backTrace(s, c, p-1, e-1, base);
		} else {
			backTrace(s, c, f-p, e, base+p);
		}
	}
}
