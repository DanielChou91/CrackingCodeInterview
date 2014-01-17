package chapter11;


public class Q11_3 {

	public static void main (String[] args) {
		System.out.println(search(new int[]{7,8,9,1,2,3,4,5}, 3)); 
	}
	public static int search(int[] arr, int tgt) {
		/** arr is the result of a sorted int array
		/* that has been rotated for n times
		**/
		return searchHelper(arr, tgt, 0, arr.length-1);
	}
	public static int searchHelper(int[] arr, int tgt, int p, int r) {
		
		int		m  =  (p + r) / 2;
		int		valMid   =   arr[m];
		
		// trivial case
		if ( valMid == tgt ) {
			return		m;
		}
		// non trivial cases
		if ( valMid < tgt ) {
			if ( arr[r] >= tgt ) {
				return searchHelper(arr, tgt, m+1, r);
			} else {
				return searchHelper(arr, tgt, p, m-1);
			}
		} else {
			if ( arr[p] <= tgt ) {
				return searchHelper(arr, tgt, p, m-1);
			} else {
				return searchHelper(arr, tgt, m+1, r);
			}
		}
	}
}