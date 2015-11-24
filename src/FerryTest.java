import static org.mockito.Mockito.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;


public class FerryTest extends TestCase {

	private Ferry testFerryObject;
	private Ferry ferrySpy;
	private Passenger passenger;
	private Vehicle vehicle;

	@Before
	public void setUp() throws Exception {
		testFerryObject = new Ferry();
		ferrySpy = spy(new Ferry());
		passenger = mock(Passenger.class);
	}

	@Test
	public void testFerryObjectNotNull(){
		assertNotNull(testFerryObject);
	}

	@Test
	public void testFerryObjectIsEmptyShouldReturnTrue(){
		assertTrue(testFerryObject.isEmpty());
	}

	@Test
	public void testThereIsSpaceForPassengerShouldReturnTrue(){
		assertTrue(testFerryObject.acceptingNewPassenger());
	}

	@Test
	public void testThereIsSpaceForPassengerShouldReturnFalse(){
		testFerryObject = mock(Ferry.class); 
		when(testFerryObject.getNumberOfPassengers()).thenReturn(201);
		when(testFerryObject.acceptingNewPassenger()).thenCallRealMethod();
		assertFalse(testFerryObject.acceptingNewPassenger());
	}

	@Test
	public void testThereIsSpaceForVehicleShouldReturnTrue(){
		assertTrue(testFerryObject.acceptingNewVehicle());
	}

	@Test
	public void testThereIsSpaceForVehicleShouldReturnFalse(){
		testFerryObject = mock(Ferry.class);
		when(testFerryObject.getNumberOfVehicleSpacesOccupied()).thenReturn(200);
		when(testFerryObject.acceptingNewVehicle()).thenCallRealMethod();
		assertFalse("Should Return false", testFerryObject.acceptingNewVehicle());
	}

	@Test
	public void testNumberOfPassengersReturnValue(){
		testFerryObject = mock(Ferry.class);
		when(testFerryObject.getNumberOfPassengers()).thenReturn(30);
		assertEquals(30, testFerryObject.getNumberOfPassengers());
	}


	@Test
	public void testEmbarkNewPassengersShouldPass(){
		testFerryObject.embarkNewPassenger(passenger);
		verify(passenger, times(1)).newPassenger();
	}

	@Test
	public void testEmbarkNewPassengersShouldThrowException(){
		when(ferrySpy.getNumberOfPassengers()).thenReturn(300);
		try{
			ferrySpy.embarkNewPassenger(passenger);
		}
		catch (RuntimeException e){
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testNumberOfVehiclesSpacesOccupiedReturnValue(){
		testFerryObject = mock(Ferry.class);
		when(testFerryObject.getNumberOfVehicleSpacesOccupied()).thenReturn(50);
		assertEquals(50, testFerryObject.getNumberOfVehicleSpacesOccupied());
	}

	@Test 
	public void testGetVehicleSpace(){
		Vehicle vehicle = new Vehicle(5,4);
		assertEquals(5, testFerryObject.getVehicleSpace(vehicle));
	}

	@Test
	public void testGetVehicleSpaceForCar(){
		Car car = new Car(1);
		assertEquals(5, testFerryObject.getVehicleSpace(car));
	}
	
	@Test
	public void testGetVehicleSpaceForBicycle(){
		Bicyle bicycle = new Bicyle();
		assertEquals(1, testFerryObject.getVehicleSpace(bicycle));
	}

	@Test
	public void testGetNumberOfPassengersInsideVehicle(){
		Car car = new Car(2);
		assertEquals(2, testFerryObject.getVehiclePassengers(car));
	}

	@Test
	public void testEmbarkNewVehicleShouldPass(){
		Vehicle v = mock(Vehicle.class);
		testFerryObject.embarkNewVehicle(v);
		verify(v, times(1)).newVehicle();
	}

	@Test(expected = RuntimeException.class)
	public void testEmbarkNewVehicleShouldThrowException(){

		vehicle = new Vehicle(2,2);	
		when(ferrySpy.getNumberOfVehicleSpacesOccupied()).thenReturn(300);
		try{
			ferrySpy.embarkNewVehicle(vehicle);
		} catch (RuntimeException e){
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testEnoughSpaceForNewVehicleSpaceShouldPass(){
		Car car = new Car(2);	
		when(ferrySpy.getNumberOfVehicleSpacesOccupied()).thenReturn(195);
		assertTrue(ferrySpy.spaceAvailableForVehicle(car));
	}

	@Test
	public void testEnoughSpaceForNewVehicleSpaceShouldThrowException(){

		Car car = new Car(2);
		when(ferrySpy.getNumberOfVehicleSpacesOccupied()).thenReturn(196);
		try{
			ferrySpy.embarkNewVehicle(car);
		} catch (RuntimeException e){
			System.out.println(e.getMessage());

		}
	}
	

}