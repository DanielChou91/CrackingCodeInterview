package oodesign.VendorMachine;

import java.util.List;

public class WrapperMoney {
	List<Money>	content;
	public WrapperMoney(List<Money> content) {
		this.content  =  content;
	}
	public int sum () {
		int		sum  =  0;
		for ( Money e : content) {
			sum += e.domination;
		}
		return sum;
	}
}
