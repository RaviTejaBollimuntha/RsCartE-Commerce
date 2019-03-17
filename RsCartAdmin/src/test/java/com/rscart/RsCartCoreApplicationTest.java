package com.rscart;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rscart.common.services.EmailService;

/**
 * @author Raviteja Bollimuntha
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RsCartCoreApplication.class)
public class RsCartCoreApplicationTest
{
	@Autowired DataSource dataSource;
	@Autowired EmailService emailService;
	
	@Test
	public void testDummy() throws SQLException
	{
		String schema = dataSource.getConnection().getCatalog();
		assertTrue("jcart".equalsIgnoreCase(schema));
	}
	
	@Test
	@Ignore
	public void testSendEmail()
	{
		emailService.sendEmail("admin@gmail.com", "JCart - Test Mail", "This is a test email from JCart");
	}
	
}
