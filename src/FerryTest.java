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
	
	
}
