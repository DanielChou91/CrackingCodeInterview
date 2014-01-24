package chapter11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class Q11_2 {

	public static void main (String[] args) {
		String[]	aos  =  new String[]{"asdf","1234","4321","dasf","gesdfd","gr"};
		System.out.println( Arrays.asList(arrangeAnagram(aos)) );
	}
	/**
	* arrage anagrams in a array of string together.
	* @param aos an array of string
	* @return array of string
	*/
	public static String[] arrangeAnagram (String[] aos) {
		// 1. arrange the input date in a HashMap
		HashMap<String, List<String>>	hm  =  new HashMap<>();
		for ( String ss : aos) {
			String		key   =   getKey(ss);
			if ( !hm.containsKey(key) ) {
				hm.put(key, new LinkedList<String>());
			}
			List<String>	bucket  =  hm.get(key);
			bucket.add(ss);
		}
		/* 2. retrieve the bucket date from the HashMap
		 * and form a new array */
		List<String>	los  =  new LinkedList<>();
		
		for ( List<String> ll : hm.values()) {
			los.addAll(ll);
		}
		return los.toArray(new String[los.size()]);
	}
	private static String getKey(String s) {
		char[]		c_str  = s.toCharArray();
		Arrays.sort(c_str);
		return	new String( c_str  );
	}
}
