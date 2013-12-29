package chapter3;

// sort the elements in a stack with only one additional stack
import java.util.Stack;

public class Q3_6 {

	public static void main (String[] args) {
		Stack<Integer>	s = new Stack<Integer>();
		s.push( 10 );
		s.push( 11 );
		s.push( 1 );
		s.push( 2 );
		s.push( 3 );
		
		stackSort( s );
		System.out.println( s.toString() );
	}

	public static void stackSort (Stack<Integer> s) {
		Stack<Integer>	helper  =  new Stack<>();
		// follow the rountine of bubble sort,
		// smaller elements go down and bigger elements go up
		int		size  =  s.size();
		for (int i=0 ; i != size-1; ++i ) {
			Integer  min  =  s.pop();
			for (int j = size-i-1; j >0 ; j-- ) {
				Integer  cur  =  s.pop();
				if ( cur > min ) {
					helper.push( cur );
				} else {
					Integer  tmp  =  cur;
					cur  =  min;
					min  =  tmp;
					helper.push( cur );
				}
			}
			s.push( min );
			// pop all elements from helper stack and 
			// push them back into s
			while ( !helper.isEmpty() ) {
				s.push ( helper.pop() );
			} 
		}
	}
}