package	chapter1;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Q1_7 {

	public static void main(String[] args ) {
		int[][]		m = {{1, 2, 3, 4},
				{2, 3, 4, 5},
				{0, 1, 2, 4},
				{1, 2, 0, 3}};
		setZeros( m );
		
		for ( int[] subArr : m ){
			System.out.println( Arrays.toString(subArr) );
		}
	}
	public static void setZeros( int[][] m ) {
		// m is a two dimenstional array which represents a Matrix
		int	rows = m.length ;
		int	cols = m[0].length;

		List<Integer>	rIdx = new ArrayList<>();
		List<Integer>   cIdx = new ArrayList<>();

		// 1.iterate through the matrix to find all 0
		for ( int y=0; y != rows; ++y )
			for( int x=0; x != cols; ++x ) {
				if ( m[y][x] == 0 ) {
					rIdx.add( y );
					cIdx.add( x );
				}
		}	

		// 2. set all rows to zeros.
		
		for ( int i : rIdx ) {
			for ( int j=0; j != cols; j++) {
				m[i][j] = 0;
			}
		}

		// 3. set all column to zeros.

		for ( int i : cIdx ) {
			for ( int j=0; j != cols; j++) {
				m[j][i] = 0;
			}
		}
	} 
}