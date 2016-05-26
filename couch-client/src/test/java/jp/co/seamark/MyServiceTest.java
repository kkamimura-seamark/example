package jp.co.seamark;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(value=Application.class)
public class MyServiceTest {

	@Autowired
	MyService service;

	@Test
	public void testDefault() throws Exception {
		service.doWork();
	}

}
