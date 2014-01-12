package chapter9;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Q9_4 {
	
	public static void main ( String[] args ) {
		Set<Integer>	s  =  new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
		Set<?>  s0  =  allSubSet(s);
		System.out.println( s0 );
		System.out.println( s0.size());
	}
	public static Set<Set<Integer>> allSubSet ( Set<Integer> s ) {
		
		Set<Set<Integer>>   pre  =  new HashSet<>();
		
		for ( Integer e : s ) {			
//			System.out.println( pre );
			// iterate through each set in pre
			// 1. add the new incoming element to each set in the set of set
			// 2. add the new incoming element as an individual set into
			// the pre set;
			Set<Set<Integer>>	dup  =  new HashSet<>();
			for ( Set<Integer> ss : pre ) {
				dup.add(new HashSet<Integer>(ss));
				ss.add(e);
			}
			pre.addAll(dup);
			pre.add(new HashSet<Integer>(Arrays.asList(e)));
		}		
		return pre;
	}
}