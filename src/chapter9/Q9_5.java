package chapter9;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Q9_5 {

	public static void main (String[] args) {
		List<Character>		s0  =  new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e'));
		List<?>				ret  =  allPermutation(s0);
		System.out.println( ret );
		System.out.println( "size: " + ret.size() );
	}
	public static List<String> allPermutation (List<Character> s) {
		return topDown(s);
	}
	public static List<String> topDown (List<Character> s) {
		// trivial case
		if ( s.size() == 2 ) {
			String  s1  =  new String(new char[]{s.get(0), s.get(1)});
			String  s2  =  new String(new char[]{s.get(1), s.get(0)});
			ArrayList<String>  al  =  new ArrayList<>();
			al.add(s1);
			al.add(s2);
			return  al;
		}
		List<String>	ret  =  new ArrayList<>();		
		for ( Character c : s ) {
			List<Character>  dup  =  new ArrayList<>(s);
			dup.remove(c);
			List<String>	l = topDown( dup );
			for ( String str : l) {
				ret.add( str + c );
			}
		}
		return ret;
	}

	public static List<String> bottomUp (List<Character> s) {
		return null;
	}

}
