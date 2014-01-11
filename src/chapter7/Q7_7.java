package chapter7;

import java.util.TreeSet;

public class Q7_7 {

	public static void main (String[] args) {
		for ( int i=0; i != 10; ++i ) {
			System.out.println( getKthPrime(i+1));
		}
	}
	public static int getKthPrime( int k ) {
		// 3, 5, 7
		// 1, initialize the queue structure with 3, 5, 7
		TreeSet<Integer>	q  =  new TreeSet<>();
		q.add(3);  q.add(5);  q.add(7);

		// 2, loop until we get the k element
		int		ret  =  -1;
		for ( int i=1; i <= k; ++i ) {
			int		min  =  q.pollFirst();
			q.add( min * 3 );
			q.add( min * 5 );
			q.add( min * 7 );
			ret  =  min;
		}		
		return	ret;
	}
}