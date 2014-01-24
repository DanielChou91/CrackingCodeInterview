package chapter11;

import java.util.Arrays;

public class Q11_1 {

	public static void main (String[] args) {
		int[]		a  =  new int[14];
		int[]		b  =  new int[4]; 
		for (int i=0; i !=4 ; i++) {
			a[i]  =  i * i;			
		}
		for ( int i=0; i != b.length;  ++i ) {
			b[i]  =  i * 2;
		}
		mergeB2A(a, b, 4, b.length);
		System.out.println( Arrays.toString(a) );
	}
	/**
	* Merge array b into a, assuming a have enough space to hold the
	* concatenation of a and b.
	* @param lenA is the length of array A that contains element
	* @param lenB is the length of array B
	*/
	public static void mergeB2A( int[] a, int[] b , int lenA, int lenB) {
		assert( lenA + lenB < a.length ) : "invalid array size";
		int		iA  =  lenA - 1;		// last element of A
		int		iB  =  lenB - 1;		// last element of B
		int		 k  =  lenA + lenB - 1; // position of the ret array we r modifying
		
		// iterate through array b until iB reaches its head.
		while ( iB >= 0 ) {
			// if a[iA] is bigger, copy a[iA] at the position of k
			if ( a[iA] > b[iB] ) {
				a[k] = a[iA];
				iA--;
			} else {
			// else copy b[iB] at the position of k
				a[k] = b[iB];
				iB--;
			}
			k--;
		}
	}
}
