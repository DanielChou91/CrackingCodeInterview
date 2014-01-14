package chapter9;

import java.util.List;
import java.util.ArrayList;


public class Q9_6 {

	public static void main (String[] args) {
		System.out.println( validParen(3).size() );
	}
	public static List<String> validParen ( int n ) {
		return validParen(n, n);
	}
	private static List<String> validParen(int numLeft, int numRight) {
		// TODO Auto-generated method stub
		
		List<String>	los  =  new ArrayList<>();
		// trivial cases
		if ( numLeft == 0 && numRight == 1) {
			los.add(")");
		}
		if ( numLeft >= 1) {
			for (String ss : validParen(numLeft-1, numRight)){
				los.add( '('+ss );
			}
		}
		if ( numRight > numLeft ) {
			for ( String ss : validParen(numLeft, numRight-1) ) {
				los.add(')' + ss);
			}
		}
		return los;
	}
}
