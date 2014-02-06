package oodesign.VendorMachine;

public enum Money {
	zero(0), cent(1), dime(10), quarter(25), dollar(100);
	int		domination;
	private Money (int domination) {
		this.domination  = domination;
	}
}
