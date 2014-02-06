package oodesign.VendorMachine;

public class Bucket {
	String  name ;
	int		value;
	int		count;
	int		capacity;
	public Bucket (String name, int value, int count) {
		this.name  =  name;
		this.value =  value;
		this.count =  count;
	}
	public void sell (int c) {
		if ( count < c ){
			return;
		}
		count -= c;
	}
	public void store (int c) { 
		if ( count + c < capacity ){
			count += c;
		}
	}
}
