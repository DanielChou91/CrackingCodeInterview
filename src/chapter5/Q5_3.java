package chapter5;

public class Q5_3 {

	public static void main ( String[] args ) {

	}
	public static int smallestSuccessor( int n ) {
		// get p, get c0 and c1
		// p is the position of the first non-trailing zero
		// c0 is the length of the trailing zeros
		// c1 is the length the 1's left to the trailing zeros
		
		//c0 
		int		num  =  n;
		int		c0  =  0;
		while ( isLastDigitZero( num ) ) {
			c0++; 
			num  =  num >> 1;
		}
		if ( c0 >= 30 ) { return -1; } // no such successsor exists


		int		c1  =  0;
		while ( isLastDigitOne( num ) ) {
			c1++;
			num  =  num >> 1;
		}
		if ( c0 + c1 >= 31 ) {
			return -1;
		}
		
		int		p  =  c0 + c1;

		// set pth digit to 1
		n  =  n | (1 << p);
		// set the c0 + c1 digits to 0s
		n  =  n & ( -1 << p );
		// set the last c1-1 digits to 1s
		n  =  n | ~(-1 << c1-1);
		return n;
	}

	public static boolean isLastDigitZero( int n ) {
		int		mask  =  -1 << 1;
		return  (n | mask ) != -1 ;
	}
	public static boolean isLastDigitOne( int n ) {
		int		mask  =  -1 << 1;
		return (n | mask) == -1 ;
	}
}
