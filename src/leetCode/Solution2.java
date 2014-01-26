package leetCode;
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution2 {
	public static void main (String[] args) {
		ListNode	h  =  new ListNode(9);
		h  =  append(h, new ListNode(8));
		h  =  append(h, new ListNode(1));
		h  =  append(h, new ListNode(2));
		h  =  append(h, new ListNode(3));
		h  =  append(h, new ListNode(10));
		
		System.out.println( new Solution2().sortList(h) );
	}
    public ListNode sortList(ListNode head) {
        return mergeSort( head );
    }
    private ListNode mergeSort (ListNode head) {
        if ( head.next == null ) {
            return head;
        }
        ListNode    mid  =  midNode (head);
        ListNode    head2  =  mid.next;
        mid.next  =  null;
        
        ListNode     h1  =  mergeSort(head);
        ListNode     h2  =  mergeSort(head2);
        return merge( h1, h2 );
    }
    private ListNode merge (ListNode h1, ListNode h2) {
        ListNode    p1  =  h1;
        ListNode    p2  =  h2;
        ListNode    head  =  null;
        ListNode	tail  =  head;
        while ( p1 != null && p2 != null) {
            if ( p1.val > p2.val ) {
                if ( head == null ){
                    head  =  p2;
                    tail  =  p2;
                    ListNode tmp  =  p2.next;
                    p2.next  =  null;
                    p2  =  tmp;
                } else {
                    tail.next = p2;
                    tail  =  tail.next;
                    p2  =  p2.next;
                }
            } else {
                if ( head == null ){
                    head  =  p1;
                    tail  =  p1;
                    ListNode tmp  =  p1.next;
                    p1.next  =  null;
                    p1  =  tmp;
                } else {
                    tail.next = p1;
                    tail  =  tail.next;
                    p1  =  p1.next;
                }
            }
        }
        
        if ( p1 != null ) {
            head  =  append(head, p1 );
        } else {
            head  =  append(head, p2 );
        }
        return head;
    }
    private ListNode midNode (ListNode head) {
        ListNode    n1  =  head;
        ListNode    n2  =  head;
        while ( n2.next != null &&n2.next.next != null ) {
            n1  =  n1.next;
            n2  =  n2.next.next;
        }
        return n1;
    }
    private static ListNode append (ListNode head, ListNode n) {
        if ( head == null) {
            return n;
        }
        ListNode    p  =  head;
        while ( p.next != null ){
            p  =  p.next;
        }
        p.next  =  n;
        return head;
    }
}