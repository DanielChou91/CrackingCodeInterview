package	oodesign.VendorMachine;

/*
 * The Cotroller catches all exception 
 * throwed from the bottom level up
 */
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
		WrapperMoney ret = null;
		try {
			ret = m.sellItemBucket(bIdx, count, in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println( e.getMessage() );
			e.printStackTrace();
		} 
		System.out.println( ret );
	}
	
	public void update (int idx, Bucket b) {
		try {
			m.addNewBucket(idx, b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println( e.getMessage() );
			e.printStackTrace();
		}
	}
	
	public void store (int idx, int count) {
		try {
			m.storeItemBucket(idx, count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println( e.getMessage() );
			e.printStackTrace();
		}
	}
}