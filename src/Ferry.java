
public class Ferry {

	private int vehicleSpace = 0;
	private final int MAX_PASSENGERS = 200;
	private int passengers = 0;
	private final int MAX_VEHICLES = 200;
	private int vehicles = 0;
	
	
	public boolean isEmpty() {
		return vehicleSpace == 0? true: false;
	}

	public boolean acceptingNewPassenger() {
	
		return (passengers < MAX_PASSENGERS);
	}

	public boolean acceptingNewVehicle() {
		return (vehicles < MAX_VEHICLES);
	}

	public int getNumberOfPassengers() {
	
		return passengers;
	}

	public void embarkNewPassenger() {
		// TODO Auto-generated method stub
		
	}

	

}
