public class Ferry {

	private int vehicleSpace = 0;
	private final int MAX_PASSENGERS = 200;
	private int passengers = 0;
	private final int MAX_VEHICLES = 200;

	public boolean isEmpty() {
		return vehicleSpace == 0? true: false;
	}

	public boolean acceptingNewPassenger() {
		return getNumberOfPassengers() >= MAX_PASSENGERS ? false : true;
	}

	public boolean acceptingNewVehicle() {
		return getNumberOfVehicleSpacesOccupied() >= MAX_VEHICLES ? false : true;
	}

	public int getNumberOfPassengers() {
		return this.passengers;
	}

	public void embarkNewPassenger(Passenger p){
		if(acceptingNewPassenger()){
			p.newPassenger();
			passengers++;
		}else {
			throw new RuntimeException("Ferry has no more space for passengers");
		}
	}

	public int getNumberOfVehicleSpacesOccupied() {
		return this.vehicleSpace;
	}
	
	public int getVehicleSpace(Vehicle v){
		return v.getSpace();
	}

}

