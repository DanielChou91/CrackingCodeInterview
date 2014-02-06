package	oodesign.VendorMachine;

public class Controller {
	private static Controller  instance;
	
	public Controller getInstance () {
		if (instance == null){
			instance  =  new Controller();
		}
		return instance;
	}

	Machine		m;
	private Controller () {
		m  =  new Machine(20,0,0,0,0);
	}

	public void sell (int bIdx, int count , WrapperMoney in) {
		WrapperMoney	ret  =  m.sellItemBucket(bIdx, count, in);
		System.out.println( ret );
	}
	
	public void update (int idx, Bucket b) {
		m.addNewBucket(idx, b);
	}
	
	public void store (int idx, int count) {
		m.storeItemBucket(idx, count);
	}
}