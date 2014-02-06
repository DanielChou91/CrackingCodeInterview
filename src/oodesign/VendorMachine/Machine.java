package oodesign.VendorMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Machine {

	Bucket[]	cache;
	int			size;
	int			one_count ;
	int			dime_count;
	int			quarter_count;
	int			dollar_count;
	
	public Machine (int size,int one, int ten, int quarter, int dollar) {
		cache  =  new Bucket[size];
		one_count   =  one;
		dime_count   =  ten;
		quarter_count  =  quarter;
		dollar_count   =  dollar;
	}
	
	public void storeItemBucket(int idx, int count) {
		if (  !isValidItem(idx) ) {
			return;
		}
		Bucket  b  =  cache[idx];
		b.store( count );
	}
	public WrapperMoney sellItemBucket(int idx, int count, WrapperMoney in) {
		if ( !isValidItem(idx) ) {
			return null;
		}	
		Bucket  b  =  cache[idx];
		int		diff = b.value * count - in.sum();
		if (diff < 0 ) {
			return null;
		}
		if ( diff ==0 ){
			return new WrapperMoney(Arrays.asList(Money.zero));
		}
		return getChange(diff);
	}
	
	public void addNewBucket(int idx, Bucket b) {
		if ( !isValidItem(idx) ) {
			return ;
		}
		cache[idx] = b;
	}
	
	private boolean isValidItem (int idx) {
		return (idx >=0 && idx < size && cache[idx] != null);
	}
	
	private WrapperMoney getChange( int m ) {
		List<Money>		lom  =  new ArrayList<>();
		
		while ( m > 0 ) {
			if ( m > 100 && dollar_count > 0 ) {
				lom.add(Money.dollar);
				m  -= 100;
				dollar_count--;
			} else if ( m > 25 && quarter_count > 0 ) {
				lom.add(Money.quarter);
				m -= 25;
				quarter_count--;
			} else if ( m > 10 && dime_count > 0 ) {
				lom.add(Money.dime);
				m -= 10;
				dime_count--;
			} else if ( m > 1 && one_count > 0 ){
				lom.add(Money.cent);
				m--;
				one_count--;
			} else 
				break;
		}
		return new WrapperMoney(lom);
	}
}