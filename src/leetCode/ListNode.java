package leetCode;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
	@Override
	public String toString () {
		StringBuffer	sb  =  new StringBuffer();
		ListNode	n  =  this;
		sb.append("[");
		while ( n != null ){
			sb.append(n.val+", ");
			n  =  n.next;
		}
		sb.append("]");
		return sb.toString();
	}
	
	public void appendToTail( int value ) {
		ListNode	n  =  new ListNode(value);
		ListNode	iter = this;
		
		while ( iter.next != null ) {
			iter = iter.next;
		}
		
		iter.next = n;
	}
}