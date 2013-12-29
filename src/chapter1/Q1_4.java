package chapter1;

import java.util.Scanner;

public class Q1_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner		 sc =  new Scanner( System.in );
		System.out.println("Enter a string");
		String		str =  sc.nextLine();
		
		char[]		  s =  new char[100];
		System.arraycopy(str.toCharArray(), 0, s, 0, str.length());
		
		System.out.println(parseSpace( s, str.length() ));
		
		sc.close();
	}
	public static String parseSpace(char[] s, int length) {
		// 1.check number of space in original array
		int		count = 0;
		for (char c : s) {
			if (c == ' ') {
				++count;
			}
		}
		
		int	newLength = length + count * 2;
		int	j = newLength - 1;
		for ( int i=length-1; i >=0; --i ){
			if ( s[i] == ' ' ){
				s[j--] = '0';
				s[j--] = '2';
				s[j--] = '%';
			}else{
				s[j--] = s[i]; 
			}
		}
		return new String( s );
	}
}