package chapter2;

/*find kth to the last element in a linked list*/

public class Q2_2 {

	public static void main( String[] args ) {
		LinkedListNode	head = new LinkedListNode(1);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);
		findKth(head, 4);
		System.out.println( findKthHelper(head, 4, new MyInteger()).data );
	}

	public static int findKth( LinkedListNode head, int k ) {
		if ( head == null ) {
			System.err.println("head cannot be null!");
		}
		if ( k < 0 ) {
			System.err.println("Invalid k!");
		}
		// the initial value for the accumulator should be zero.
		return findKthHelper( head, k );
	}

	public static int findKthHelper( LinkedListNode nd, int k ) {
		// trivial case
		if ( nd == null ){
			return 0;
		} 
		int		idx = findKthHelper( nd.next, k );
		if ( idx == k ) {
			System.out.println( "found: " + nd.data );
		}
		return idx + 1;
	}
	
	// version2, in this version
	//we don't return the back index of the entry
	public static LinkedListNode findKthHelper (LinkedListNode nd, int k, MyInteger idx) {
		if ( nd == null ) {
			return null;
		}
		/* pay attention to this place!!!!!*/
		/* idx is tricky
		 * suppose now nd.next in this recursion is null
		 * then nd is the last element in the array,
		 * so its idx should be zero, yet +idx.value increase it to 1,
		 * therefore, the initial value for idx should be -1*/
		
		LinkedListNode	ret  =  findKthHelper(nd.next, k, idx);
		++idx.value ;
		if ( idx.value == k ) {
			return nd;
		}
		return ret;
	}
	public static class MyInteger {
		public int value = -1;
	}
}
