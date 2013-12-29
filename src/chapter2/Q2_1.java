package chapter2;

/* remove duplicated entry in a linked list */

import java.util.HashMap;

public class Q2_1 {
	
	public static void main( String[] args ) {
		
	}	
	public static void remove ( LinkedListNode head ) {
		LinkedListNode		nd = head;
		LinkedListNode	   pre = null;
		HashMap<Integer, Boolean>  hm = new HashMap<>();
		// travel through the list
		while ( nd != null ) {
			// 1. check if the data has aldy existed in the HashTable
			if ( hm.containsKey(nd.data) ) {
				pre.next = nd.next;
				nd = nd.next;
			}else {
				hm.put(nd.data, true);
				pre = nd;
				nd  = nd.next;
			}	
		}
	}	
}
