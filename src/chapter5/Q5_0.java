package chapter5;

/*
* check if a number is a prime number
*/

public class Q5_0 {

	public static void main (String[] args) {
		long	s  =  System.nanoTime();
		System.out.println( isPrime_v0( 3571 ));
		System.out.println( System.nanoTime() - s);
		
		s  =  System.nanoTime();
		System.out.println( isPrime_v1( 3571 ));
		System.out.println( System.nanoTime() - s);
		
		s  =  System.nanoTime();
		System.out.println( isPrime_v2( 3571 ));
		System.out.println( System.nanoTime() - s);
	}

	public static boolean isPrime_v0 (int num) {
		if ( num == 1 )
			return true;
		
		for (int i=2 ; i <= Math.sqrt(num); ++i) {
			if ( num % i ==0 ) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPrime_v1 (int num) {
		if ( num == 1) {
			return true;
		} 
		if ( num % 2 == 0 ){
			return false;
		}
		for ( int i = 3 ; i <= Math.sqrt(num); i += 2 ) {
			if ( num % i == 0 ) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isPrime_v2 ( int num ){
		// tirival case
		if ( num == 1) {
			return true;
		}
		
		// non trivial case
		int		size  = (int)Math.sqrt(num) + 1;
		int[]	cache  =  new int[size];
		
		for (int i=2 ; i != cache.length ; ++i) {
			if ( cache[i] == 0 ) {
				if ( num % i == 0 ){
					return false;
				} else {
					crossOut(cache, i);
				}
			}
		}
		return true;
	}
	private static void crossOut(int[] arr, int base) {
		int			   i  =   1;
		int		multiple  =   base * i;
		
		while ( multiple * i < arr.length ) {
			arr[multiple * i] = 1;
			i++;
		}
	}

}