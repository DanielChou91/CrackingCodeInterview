package chapter2;

import java.util.Stack;

public class Q2_5 {

	public static void main (String[] args) {
		LinkedListNode	h1 = new LinkedListNode(1);
		h1.appendToTail(9);
		h1.appendToTail(6);
		
		LinkedListNode  h2 = new LinkedListNode(7);
		h2.appendToTail(2);
		h2.appendToTail(8);
		h2.appendToTail(1);
		h2.appendToTail(9);
		
		System.out.println( addReverse(h1, h2).toString() );
		System.out.println( add(h1, h2).toString() );
	}
	// digits are stored in reversed order
	public static LinkedListNode addReverse (LinkedListNode n1, LinkedListNode n2) {
		// returns a new pointer to the head of the list of addition
		LinkedListNode		h1 = n1;
		LinkedListNode		h2 = n2;
		int				 carry = 0;	// store carry of summation
		LinkedListNode	  head = new LinkedListNode(0); // head of the result

		while ( h1 != null && h2 != null ) {
			int		d = h1.data + h2.data + carry;
			assert( d < 20 );
			carry     = d / 10;
			int	    onedigit = d % 10;
			head.appendToTail( onedigit );

			h1 = h1.next; h2 = h2.next;
		}

		LinkedListNode		nd = null;	
		if ( h1 != null )
			nd = h1;
		else
			nd = h2;

		while ( nd != null ) {
			head.appendToTail( nd.data + carry );
			carry = 0;
			nd  =  nd.next;
		}

		return head.next;
	}

	public static LinkedListNode add (LinkedListNode n1, LinkedListNode n2) {
		// number are stored in regular order
		int		length_n1 = n1.length();
		int		length_n2 = n2.length();

		LinkedListNode	l = null;
		LinkedListNode  s = null;

		int		dif  =  Math.abs( length_n1 - length_n2 );
		if ( length_n1 > length_n2 ){
			l  =  n1;	s = n2;			
		} else {
			l  =  n2;   s = n1;
		}
				
		for (int i=0; i != dif ; ++i ) {
			s = s.addToHead(0);
		}
		
		Stack<Integer>		ret = new Stack<>(); // this is a dummy head
		addHelper(l, s, ret);
		
		LinkedListNode	ret2  =  new LinkedListNode(ret.pop());
		while ( !ret.isEmpty() ) {
			ret2.appendToTail( ret.pop() );
		}
		return ret2;	
	}

	private static int addHelper( LinkedListNode l1, LinkedListNode l2, Stack<Integer> head ) {
		if ( l1.next == null && l2.next == null ) {
			int  sum  =  l1.data + l2.data ;
			head.push( sum % 10 );
			return   sum / 10;
		}
		int   carry = addHelper( l1.next, l2.next, head );
		int		sum = l1.data + l2.data + carry;
				
		head.push( sum % 10 );
		return  sum / 10;
	}
}