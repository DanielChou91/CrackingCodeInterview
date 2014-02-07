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
	
	public void storeItemBucket(int idx, int count) throws Exception {
		isValidItem(idx);
		Bucket  b  =  cache[idx];
		b.store( count );
	}
	public WrapperMoney sellItemBucket(int idx, int count, WrapperMoney in) throws Exception {
		isValidItem(idx);
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
	
	public void addNewBucket(int idx, Bucket b) throws Exception {
		testValidIndex( idx );
		cache[idx] = b;
	}
	
	private void testValidIndex( int idx ) throws Exception {
		if ( idx <0 && idx >= size ) {
			throw new InvalidItemIdException("Check Item Id!");
		}
	}
	private void isValidItem (int idx) throws Exception {
		if ( idx < 0 && idx >= size) {
			throw new InvalidItemIdException("Check Item Id!");
		}
		if ( cache[idx] == null ) {
			throw new SoldOutException("Sold Out!");
		}
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