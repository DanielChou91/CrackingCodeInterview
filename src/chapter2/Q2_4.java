package chapter2;

// partition a linked list around a value x

public class Q2_4 {
	public static void main (String[] args) {
		LinkedListNode		head = new LinkedListNode(15);
		head.appendToTail(9);
		head.appendToTail(4);
		head.appendToTail(3);
		head.appendToTail(10);
		head.appendToTail(11);
		head.appendToTail(1);
		partition( head, 5 );
	}
	public static LinkedListNode partition ( LinkedListNode head, int x ) {
		int		  listSize  =  getListSize(head);
		LinkedListNode  nd  =  head;
		LinkedListNode pre  =  new LinkedListNode(-1);
		pre.next  =  head;
		LinkedListNode dum  =  pre;
		for ( int i=0; i != listSize; ++i ) {
			LinkedListNode		cur = nd;
			if ( cur.data >= x ) {
				nd  =  nd.next;
			// 1. delete any element that is bigger than x.
				pre.next = cur.next;
				cur.next  = null;
			// 2. append such element to the tail.
				pre.appendToTail( cur );
			} else {
				pre  =  nd;
				nd   =  nd.next;
			}			
			System.out.println( dum.next.toString() );
		}
		return dum.next;
	}

	// returns the length of a linked list.
	public static int getListSize( LinkedListNode head ) {
		int		acc = 0;
		LinkedListNode		iter = head;
		while ( iter != null ) {
			acc++ ;
			iter =  iter.next;
		}
		return acc;
	}
}
