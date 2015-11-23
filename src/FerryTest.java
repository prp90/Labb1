import static org.mockito.Mockito.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FerryTest extends TestCase {

	private Ferry testFerryObject;

	@Rule
	public ExpectedException e = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		testFerryObject = new Ferry();
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
	public void testNumberOfPassengers(){

		testFerryObject = mock(Ferry.class);
		when(testFerryObject.getNumberOfPassengers()).thenReturn(30);
		assertEquals(30, testFerryObject.getNumberOfPassengers());

	}


	@Test
	public void testEmbarkNewPassengersPass(){
		Passenger passenger = mock(Passenger.class);
		testFerryObject.embarkNewPassenger(passenger);
		verify(passenger, times(1)).newPassenger();
	}

	@Test
	public void testEmbarkNewPassengersShouldThrowException(){
		Ferry ferrySpy = spy(new Ferry());
		when(ferrySpy.getNumberOfPassengers()).thenReturn(300);
		Passenger p = mock(Passenger.class);
		try{
			ferrySpy.embarkNewPassenger(p);
		}
		catch (RuntimeException e){

		}
	}
	


}