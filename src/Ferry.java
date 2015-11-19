
public class Ferry {

	private int vehicleSpace = 0;
	private final int MAX_PASSENGERS = 200;
	private int passengers = 0;
	
	public boolean isEmpty() {
		return vehicleSpace == 0? true: false;
	}

	public boolean acceptingNewPassenger() {
	
		return passengers < MAX_PASSENGERS;
	}


}
