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
}