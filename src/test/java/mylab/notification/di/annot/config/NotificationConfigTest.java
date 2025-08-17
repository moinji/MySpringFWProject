package mylab.notification.di.annot.config;

import mylab.notification.di.annot.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {

	@Autowired
	private NotificationManager notificationManager;

	@Test
	public void manager_not_null() {
		assertNotNull(notificationManager);
	}

	@Test
	public void email_service_injected_and_values() {
		assertNotNull(notificationManager.getEmailService());
		EmailNotificationService email = (EmailNotificationService) notificationManager.getEmailService();
		assertEquals("smtp.gmail.com", email.getSmtpServer());
		assertEquals(587, email.getPort());
	}

	@Test
	public void sms_service_injected_and_values() {
		assertNotNull(notificationManager.getSmsService());
		SmsNotificationService sms = (SmsNotificationService) notificationManager.getSmsService();
		assertEquals("SKT", sms.getProvider());
	}

	@Test
	public void send_methods_execute() {
		notificationManager.sendNotificationByEmail("테스트 이메일");
		notificationManager.sendNotificationBySms("테스트 SMS");
	}

}