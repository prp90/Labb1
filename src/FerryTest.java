import static org.mockito.Mockito.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class FerryTest extends TestCase {

	private Ferry testFerryObject;

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



}
