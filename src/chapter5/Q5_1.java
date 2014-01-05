package chapter5;

public class Q5_1 {

	public static void main (String[] args) {
		int		a  =  0b10000000000;
		int		b  =  0b10011;
		System.out.println( Integer.toBinaryString(insertM2N (b, a, 2, 6)));
	}
	public static int insertM2N ( int m, int n, int i, int j ) {
		// we assume that i < j and length( m ) is less or equal than j - i - 1
		// i and j are included
		// 1. clear the i -> j bit to zeros in n  = > new_n
		int		mask1  =  -1;
		mask1  =  mask1 << (j + 1);
		
		int		mask2  =  ~(-1<<i);
		int		new_n  =  n & (mask1 | mask2); 
		
		// 2. append i 0's at the end of m => new_m
		int		new_m  =  m << i;		

		// 3. return new_m & new_n
		return new_m | new_n;
	}
}
