package chapter11;

import java.util.TreeMap;
import java.util.Map;

public class Machine {

	private TreeMap<Integer, Integer>	hm;
	public Machine () {
		hm  =  new TreeMap<>();
	}

	public void track(Integer i) {
		// 1. already existed in the hm
		if ( hm.containsKey(i) ) {
			// try later
			hm.put(i, hm.get(i) + 1);
		} else {
		// 2. the integer is new put the new entry into hm
			hm.put(i, 1);
		}
	}
	
	public int getRankOfNumber(int i) {
		// retrieve all entry before i and sum up their value
		int	rank  =  0;
		Map<Integer, Integer>	subMap  =  hm.headMap(i, true);
		for (Map.Entry<Integer, Integer> e : subMap.entrySet()) {
			rank += e.getValue();
		}
		return rank;
	}
}