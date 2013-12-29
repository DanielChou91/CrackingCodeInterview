/*
 * Implement a method to perform basic string compression using
 * counts of repeated characters. 
 * Examples:
 *    aabcccccaaa => a2b1c5a3
 */

package chapter1;

import java.util.Scanner;

public class Q1_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner		sc  =  new Scanner( System.in );
		String		str =  sc.nextLine();
		
		System.out.println( compress(str) );
		
		sc.close();
	}
	public static String compress (String str) {
		
		char	     pre =  str.charAt( 0 );
		int	   	   count = 1;
		char	     cur = ' ';
		StringBuffer  sb = new StringBuffer();

		for (int i = 1; i < str.length(); ++i ) {
			cur = str.charAt(i) ;
			if ( cur == pre ) {
				++count;
			}else {
				sb.append( pre );
				sb.append( Integer.toString(count) );
				// sb.append( String.valueOf(count) );
				pre = cur;
				count = 1;
			}
		}
		
		// deal with the last sequence of the same characters.
		sb.append(cur);
		sb.append( Integer.toString(count) );
		return sb.toString();
	}
}
