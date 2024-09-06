import static org.junit.Assert.*;

import org.junit.Test;
import com.abcresttaurant.model.Staff;

public class StaffRegistrationTesting {

    @Test
    public void testStaffConstructorWithArgs() {
        int staffId = 1;
        String name = "Rukmal Bandara";
        String role = "Admin";
        String email = "rb@gmail.com";
        String password = "admin234";

        Staff staff = new Staff(staffId, name, role, email, password);

        assertEquals(staffId, staff.getStaffId());
        assertEquals(name, staff.getName());
        assertEquals(role, staff.getRole());
        assertEquals(email, staff.getEmail());
        assertEquals(password, staff.getPassword());
    }

    @Test
    public void testStaffDefaultConstructorAndSetters() {
        Staff staff = new Staff();

        staff.setStaffId(2);
        staff.setName("Nilushi Gunasekara");
        staff.setRole("Staff");
        staff.setEmail("nilushigunasekara@gmail.com");
        staff.setPassword("nilushistaff2");

        assertEquals(2, staff.getStaffId());
        assertEquals("Nilushi Gunasekara", staff.getName());
        assertEquals("Staff", staff.getRole());
        assertEquals("nilushigunasekara@gmail.com", staff.getEmail());
        assertEquals("nilushistaff2", staff.getPassword());
    }

    @Test
    public void testGettersAndSetters() {
        Staff staff = new Staff();

        staff.setStaffId(3);
        staff.setName("Nipun Weerasinghe");
        staff.setRole("staff");
        staff.setEmail("nipunw@gmail.com");
        staff.setPassword("nipun31");

        assertEquals(3, staff.getStaffId());
        assertEquals("Nipun Weerasinghe", staff.getName());
        assertEquals("staff", staff.getRole());
        assertEquals("nipunw@gmail.com", staff.getEmail());
        assertEquals("nipun31", staff.getPassword());
    }

    @Test
    public void testStaffEmailSetter() {
        Staff staff = new Staff();
        String email = "test@example.com";

        staff.setEmail(email);

        assertEquals(email, staff.getEmail());
    }

    @Test
    public void testStaffPasswordSetter() {
        Staff staff = new Staff();
        String password = "newPassword123";

        staff.setPassword(password);

        assertEquals(password, staff.getPassword());
    }
}
