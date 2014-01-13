package chapter9;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Q9_6 {

	public static void main (String[] args) {
			System.out.println( validParen(5));
	}
	public static List<String> validParen ( int n ) {
		return bottomUp(n);
	}
	public static List<String> bottomUp ( int n ) {
		List<List<String>>	s  =  new ArrayList<>();
		s.add( new ArrayList<String>(Arrays.asList("()")));
		s.add( new ArrayList<String>(Arrays.asList("(())","()()")));
		bottomUpHelper(n, s );
		return  s.get(s.size()-1);
	}
	public static void bottomUpHelper( int n, List<List<String>> s ) {
		for ( int i=3 ; i <= n ; ++i ) {
			// 1 -> i-1 perfect paren
			List<String>	newStr  =  new ArrayList<>();
			for ( int j=1 ; j <= i-1; ++j ) {
				List<String>	sub  =  s.get(i-j-1);
				for ( String ss : sub ) {
					newStr.add( perfectParen(j) + ss );
				}				
			}
			// the last special case
			newStr.add(perfectParen(i));
			// add the new Str into our trace matrix
			s.add(newStr);
		}
	}
	public static String perfectParen( int n ) {
		StringBuffer		sb  =  new StringBuffer();
		char[]	  leftParen  =  new char[n];
		char[]	 rightParen  =  new char[n];
		Arrays.fill( leftParen, '(');
		Arrays.fill( rightParen, ')');
		sb.append(leftParen);
		sb.append(rightParen);
		return sb.toString();
	}
}
