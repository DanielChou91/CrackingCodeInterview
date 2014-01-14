package chapter9;

public class Q9_11 {

	public static class Res {
		int		cTrue  =  0;
		int		cFalse =  0;
		public Res (int t, int f) {
			this.cTrue  =  t;
			this.cFalse =  f;
		}
		public void add (Res ret) {
			this.cTrue  +=  ret.cTrue;
			this.cFalse +=  ret.cFalse;
		}
	}
	public static void main (String[] args) {
		String		expr  =  new String("1^0|0|1");
		System.out.println( cResult(expr, true) );
	}
	public static int cResult (String expr, boolean b) {
		// bottom up approach
		Res  ret  =  cResultHelper(expr);
		if ( b == true ) {
			return	ret.cTrue;
		} else {
			return  ret.cFalse;
		}
	}
	public static Res cResultHelper(String expr) {
		// the helper function return number of true combination
		// as well as the number of false combination
		// do some string parsing
		int		n  =  expr.length() / 2 + 1;   	// number of bit
		
		Res[][]		s   =   new Res[n][n];
		// initialize the table
		for ( int d = 0 ; d != n; ++d ){
			if ( expr.charAt(d * 2) == '1' ) {
				s[d][d]  =  new Res(1, 0);
			} else {
				s[d][d]  =  new Res(0, 1);
			}
		}
		// compute the table from bottom up
		for ( int l=2; l <= n; ++l ) {
			// l indicates the length expr we want to compute
			for (int i=0; i <= n-l; ++i) {
				// i is the start position of the sub expr
				// the index of sub is i -> i+l-1
				Res   ret  =  new Res(0, 0);
				for ( int j=0; j != l-1; ++j) {
					ret.add(combine ( s[i][i+j],  s[i+j+1][i+l-1], expr.charAt((i+j)*2 +1) ));
				}
//				System.out.println(String.format("computing %d -> %d, #t: %d    #f: %d", i,i+l-1,ret.cTrue,ret.cFalse));
				s[i][i+l-1]  =  ret;
			}
		}
		return s[0][n-1];
	}
	

	public static Res combine (Res l, Res r, char op) {
		int  total  =  ( l.cTrue + l.cFalse ) * (r.cTrue + r.cFalse);
		int		t  =  0;
		int		f  =  0;
		if ( op == '^' ){
			t  =  l.cFalse * r.cTrue + l.cTrue * r.cFalse;
			f  =  total - t;			
		} else if ( op == '&' ) {
			t  =  l.cTrue * r.cTrue;
			f  =  total  -  t;
		} else {
			f  =  l.cFalse * r.cFalse;
			t  =  total -  f;			
		}
		return  new Res(t, f);
	}
}