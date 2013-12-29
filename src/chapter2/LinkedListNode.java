package chapter2;

public class LinkedListNode {

	int					data;
	LinkedListNode		next;

	public LinkedListNode (int data) {
		this.data  =  data;
		this.next  =  null;
	}

	public void appendToTail (int d) {
		LinkedListNode	newNode = new LinkedListNode(d);
		LinkedListNode     iter = this;
		
		// find the end of the list
		while( iter.next != null ) {
			iter = iter.next;
		}

		iter.next = newNode;
	}
	
	public void appendToTail (LinkedListNode n) {
		LinkedListNode		iter = this;
		
		//find the end of the list
		while ( iter.next != null ) {
			iter = iter.next;
		}
		iter.next = n;
	}
	
	@Override
	public String toString () {
		StringBuffer  sb = new StringBuffer();
		LinkedListNode iter = this;
		while ( iter.next != null ) {
			sb.append( iter.data + ", ");
			iter  =  iter.next;
		}
		sb.append( iter.data );
		return sb.toString();
	}
	
	public LinkedListNode addToHead ( int data ) {
		// return the head of the new list
		LinkedListNode	newNode = new LinkedListNode (data);
		
		newNode.next = this;
		return newNode;
	}
	public int length() {
		LinkedListNode	iter = this;
		int				 acc = 0;
		while ( iter != null) {
			acc++;
			iter = iter.next;
		}
		return acc;
	}
	
	public static void main (String[] args) {
		LinkedListNode  nd = new LinkedListNode(0);
		nd = nd.addToHead(1);
		nd = nd.addToHead(4);
		nd = nd.addToHead(9);
		
		System.out.println( nd.toString() );
	}
}
