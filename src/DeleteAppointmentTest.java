import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class DeleteAppointmentTest {
	static AppointmentList appointmentList = new AppointmentList();
	
	@BeforeAll
	static void initAll() {
		AppointmentList.ListItem item1 = new AppointmentList.ListItem();
		AppointmentList.ListItem item2 = new AppointmentList.ListItem();
		AppointmentList.ListItem item3 = new AppointmentList.ListItem();
		
		item1.appointmentName = "christmas party";
		item1.date = "12/24";
		item1.location = "hongdae";
		item1.peopleNum = 5;
		
		item2.appointmentName = "dinner with song";
		item2.date = "12/28";
		item2.location = "myeongsin restaurant";
		item2.peopleNum = 2;
		
		item3.appointmentName = "a travel with friends to Japan";
		item3.date = "1/13";
		item3.location = "Incheon International Airport";
		item3.peopleNum = 3;
		
		appointmentList.addListItem(item1, -1);
		appointmentList.addListItem(item2, -1);
		appointmentList.addListItem(item3, -1);
	}
	
	@BeforeEach
	void init() {
		;
	}
	
	@Test
	void testSuccessToFind() {
		String keyName = "dinner with song";
		assertTrue(appointmentList.searchListItem(keyName) == 1);
	}
	
	@Test
	void testFailToFind() {
		String keyName = "dinner with john";
		assertFalse(appointmentList.searchListItem(keyName) == 1);
	}
	@Test
	void testDelete() {
		appointmentList.deleteListItem(1);
		assertEquals(appointmentList.appointments.get(1).appointmentName, "a travel with friends to Japan");
		assertEquals(appointmentList.appointments.get(1).date, "1/13");
		assertEquals(appointmentList.appointments.get(1).location, "Incheon International Airport");
		assertEquals(appointmentList.appointments.get(1).peopleNum, 3);
		
		assertTrue(appointmentList.appointments.size() == 2);
	}
	
	@AfterEach
	void tearDown() {
		;
	}
	
	@AfterAll
	static void tearDownAll() {
		;
	}
}
