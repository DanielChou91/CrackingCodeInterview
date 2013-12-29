package chapter2;

import java.util.Stack;

public class Q2_7 {
	public static void main (String[] args) {
		
		LinkedListNode		head = new LinkedListNode(15);
		head.appendToTail(9);
		head.appendToTail(4);
		head.appendToTail(3);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(9);
		head.appendToTail(15);
		
		System.out.println( isPalindrome(head) );
	}
	public static boolean isPalindrome (LinkedListNode head) {
		LinkedListNode		slow  =  null;
		LinkedListNode		fast  =  null;

		slow = head; fast = head;
		Stack<Integer>		half  =  new Stack<>();

		while ( fast != null && fast.next != null) {
			half.push( slow.data );
			slow = slow.next;
			fast = fast.next.next;
		}
		// if the size of the element is odd fast doesn't pts to null
		if ( fast != null ) slow = slow.next;

		// pop element out of stack
		while ( !half.isEmpty() ) {
			Integer  i  =  half.pop();
			if ( i != slow.data ) { return false;}
			slow = slow.next;
		}

		return true;
	}
}
