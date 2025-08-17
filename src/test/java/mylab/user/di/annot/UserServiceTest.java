package mylab.user.di.annot;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void userService_notNull() {
		assertNotNull(userService);
	}

	@Test
	public void repo_injected_and_dbType_is_MySQL() {
		assertNotNull(userService.getUserRepository());
		assertEquals("MySQL", userService.getUserRepository().getDbType());
	}

	@Test
	public void security_injected() {
		assertNotNull(userService.getSecurityService());
	}

	@Test
	public void registerUser_returns_true_when_authenticated() {
		assertTrue(userService.registerUser("u01", "Alice", "pw123"));
	}

	@Test
	public void registerUser_returns_false_when_password_invalid() {
		assertFalse(userService.registerUser("u02", "Bob", null));
		assertFalse(userService.registerUser("u03", "Eve", ""));
	}

}