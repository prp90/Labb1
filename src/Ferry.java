public class Ferry {

	private int vehicleSpaceOccupied = 0;
	private final int MAX_PASSENGERS = 200;
	private int passengers = 0;
	private final int MAX_VEHICLES = 200;

	public boolean isEmpty() {
		return vehicleSpaceOccupied == 0? true: false;
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
		return this.vehicleSpaceOccupied;
	}

	public int getVehicleSpace(Vehicle v){
		return v.getSpace();
	}

	public int getVehiclePassengers(Vehicle v) {

		return v.getNumberOfPassengersInsideVehicle();
	}

	public void embarkNewVehicle(Vehicle v) {
		if(acceptingNewVehicle()){
			v.newVehicle();
			vehicleSpaceOccupied += getVehicleSpace(v);
		}
		else{
			throw new RuntimeException("Ferry has no more space for vehicles");
		}
	}

	public boolean spaceAvailableForVehicle(Vehicle v) {
		 return false;
		
	}

}



