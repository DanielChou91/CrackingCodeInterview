package chapter3;

public abstract class AbstractAnimal implements Animal{
	protected		int		timeStamp;
	
	public AbstractAnimal ( ) {
	}
	
	public int getTime () {
		return timeStamp;
	}
	
	public void setTime ( int timeStamp ) {
		this.timeStamp  =  timeStamp;
	}
}