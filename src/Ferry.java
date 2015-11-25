

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
			if(spaceAvailableForVehicle(v)){
				if(spaceAvailableForPassengersInsideVehicle(v)){
					v.newVehicle();
					vehicleSpaceOccupied += getVehicleSpace(v);
					passengers += getVehiclePassengers(v);
				}
				else{
					throw new RuntimeException("Not enough space for vehicles passengers.");
				}
			}
			else{
				throw new RuntimeException("Ferry's available space is not enough for this vehicle");
			}
		}
		else{
			throw new RuntimeException("Ferry has no more space for vehicles");
		}
	}

	public boolean spaceAvailableForVehicle(Vehicle v) {
		return acceptingNewVehicle() ? ((MAX_VEHICLES-getNumberOfVehicleSpacesOccupied()) >= getVehicleSpace(v))
				: false;

	}

	public boolean spaceAvailableForPassengersInsideVehicle(Vehicle v) {

		return acceptingNewPassenger() ? ((MAX_PASSENGERS-getNumberOfPassengers())) >= getVehiclePassengers(v)
				: false;
	}

	public void disembarkFerry() {
		
		passengers = 0;
		vehicleSpaceOccupied = 0;
	}
	
	public int getTotalSpaceOccupied(){
		return getNumberOfPassengers() + getNumberOfVehicleSpacesOccupied();
	}



}



