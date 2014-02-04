package leetCode;

import java.util.Stack;

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
public class Solution5 {
	public static void main (String[] args) {
		ListNode	h2  = null;
		ListNode	h  =  new ListNode(9);
		ListNode	h3 =  new ListNode(10);
		h  =  Solution2.append(h, new ListNode(8));
		h  =  Solution2.append(h, new ListNode(1));
		h  =  Solution2.append(h, new ListNode(2));
		h  =  Solution2.append(h, new ListNode(10));
		h  =  Solution2.append(h, new ListNode(3));
		new Solution5().reorderList(h);
		new Solution5().reorderList( h2 );
		new Solution5().reorderList( h3 );
		
		System.out.println( h );
		System.out.println( h2 );
		System.out.println( h3 );
	}    
    public void reorderList(ListNode head) {
        // deal with the trivial case when head is null
        if ( head == null || head.next == null ) {
            return;
        }
        // 1. find the first element that should moved forward 
        ListNode         p  =  findMover(head);
        Stack<ListNode>		s  =  new Stack<>();
        while ( p != null ){
        	s.push( p );
        	p  =  p.next;
        }
        
        // 2. do recursion
        ListNode	iter  =  head;
        while ( !s.isEmpty() ) {
        	ListNode	n  =  s.pop();
        	n.next  =  iter.next;
        	iter.next  =  n;
        	iter  =  iter.next.next;
        }
    }
    private ListNode findMover( ListNode head ) {
        ListNode    p1  =  head;    // move 1 step each step
        ListNode    p2  =  head;    // move 2 steps each step
        
        while ( p2 != null && p2.next != null ) {
            p1  =  p1.next;
            p2  =  p2.next.next;
        }
        
        // 1. cut down the list
        ListNode    ret  =  p1.next;
        p1.next  =  null;
        
        // 2. return the next element of p1
        return ret;
    }
}