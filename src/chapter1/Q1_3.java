package chapter1;

import java.util.Arrays;

public class Q1_3 {
	
	public static void main( String[] args ) {
	}
	
	
	public static boolean isPermutation (String s1, String s2) {
		char[]	set1	=	s1.toCharArray();
		char[]	set2	=   s2.toCharArray();
		
		Arrays.sort(set1); Arrays.sort(set2);
		String	s1_sorted =  new String (set1);
		String  s2_sorted =  new String (set2);
		
		return s1_sorted.equals(s2_sorted);
	}
}
