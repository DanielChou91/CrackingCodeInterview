package chapter11;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q11_7 {
	
	public static class Person {
		int		height;
		int		weight;
		public Person (int height, int weight) {
			this.height  =  height;
			this.weight  =  weight;
		}
		public Person () {
			this(0, 0);
		}
		@Override
		public int hashCode () {
			// two persons have exactly the same hash code
			// iff they are identical in height and weight
			// we use linear function to get the hash code
			// the equation are given by
			// index  =  alpha * height + beta * weight
			return ( 31 * height + 13 * weight );
		}
		@Override
		public boolean equals( Object p) {
			return this.hashCode() == p.hashCode();
		}
		@Override
		public String toString () {
			StringBuffer	sb  =  new StringBuffer();
			sb.append("[" + height + ", " + weight + "]");
			return sb.toString();
		}
	}
	public static void main (String[] args) {
		List<Person>	lop  =  new ArrayList<>();
		lop.add(new Person(65, 120));
		lop.add(new Person(70, 150));
		lop.add(new Person(56, 90));
		lop.add(new Person(75, 130));
		lop.add(new Person(60, 95));
		lop.add(new Person(68, 110));
		System.out.println( tallestTower(lop) );
	}
	public static List<Person> tallestTower(List<Person> lop) {
		// 1. sort the list of person based on height;
		List<Person>	l1  =  new ArrayList<>(lop);
		List<Person>    l2  =  new ArrayList<>(lop);
		Collections.sort(l1, new Comparator<Person>(){
			@Override
			public int compare(Person p1, Person p2){
				if ( p1.height > p2.height ) {
					return 1;
				} else if ( p1.height == p2.height ) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		// 2. sort the list of persons based on their weight;
		Collections.sort(l2, new Comparator<Person>(){
			@Override
			public int compare(Person p1, Person p2){
				if ( p1.weight > p2.weight ) {
					return 1;
				} else if ( p1.weight == p2.weight ) {
					return 0;
				} else {
					return -1;
				}
			}
		});		
		System.out.println( l1 );
		System.out.println( l2 );
		// Longest Common Sequence
		List<Person>	ret  =  LCS(l1, l2);		
		return ret;
	}
	public static List<Person>  LCS(List<Person>  lop1, List<Person> lop2) {
		
		// trivial case
		if ( lop1.isEmpty() || lop2.isEmpty()) {
			return new ArrayList<Person>();
		}
		// non trivial case
		int		size1  =  lop1.size();
		int		size2  =  lop2.size();
		if ( lop1.get(size1-1) == lop2.get(size2-1)){
			List<Person>  ret =  LCS(lop1.subList(0, size1-1), lop2.subList(0, size2-1));
			ret.add(lop1.get(size1-1));
			return		ret;
		} else {
			List<Person>	ret1  =  LCS(lop1.subList(0, size1), lop2.subList(0, size2-1));
			List<Person>	ret2  =  LCS(lop1.subList(0, size1-1), lop2.subList(0, size2));
			if ( ret1.size() > ret2.size() ){
				return ret1;
			} else 
				return ret2;
		}
	}
}