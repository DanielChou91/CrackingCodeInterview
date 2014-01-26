package leetCode;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution4 {
	public static void main (String[] args) {
		ListNode	h  =  new ListNode(9);
		h  =  Solution2.append(h, new ListNode(8));
		h  =  Solution2.append(h, new ListNode(1));
		h  =  Solution2.append(h, new ListNode(2));
		h  =  Solution2.append(h, new ListNode(3));
		h  =  Solution2.append(h, new ListNode(10));
		
		System.out.println( new Solution4().insertionSortList(h) );
	}
    public ListNode insertionSortList(ListNode head) {
        if ( head == null ) {
            return null;
        } else if ( head.next == null ) {
            return head;
        } else {
            return insertHelper(head);
        }
    }
    private ListNode    insertHelper(ListNode head) {
        ListNode    dum =  new ListNode(-999999);
        
        ListNode    p1  =  head;    
        while ( p1 != null ) {
            ListNode    _p1  =  p1.next;
            ListNode    pre2  =  dum;
            ListNode      p2  =  dum.next;
            while ( p2 != null ) {
                if ( p2.val > p1.val ) {
                    pre2.next  =  p1;
                    p1.next  =  p2;
                    break;
                }
                pre2  =  pre2.next;
                p2    =  p2.next;
            }
            if ( p2 == null ) {
                pre2.next  =  p1;
                p1.next  =  p2;
            }
            p1  =  _p1;    
        }
        return dum.next;
    }
}