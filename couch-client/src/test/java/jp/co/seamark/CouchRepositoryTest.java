package jp.co.seamark;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.stream.StreamSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.geo.Point;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(value=Application.class)
public class CouchRepositoryTest {

	@Autowired
	UserRepository repo;

	@Test
	public void testDefault() throws Exception {
		// init
		repo.deleteAll();
		// given
		User u = new User();
		u.setLastName("Hoge");
		u.setLocation(new Point(123.123,12.22));
		u.putValue("key1", "value1");
//		u.putValue("key2", new BigDecimal("1234.56789"));
		u.putValue("key3", true);
		u.putValue("key4", new Date(2016,6,3));

		// when
		User ret = repo.save(u);
		User searchu = repo.findOne(u.getId());

		// then
		System.out.println(ret == u);
		System.out.println(u == searchu);
		
		assertThat(searchu.getId(), is(u.getId()));
		assertThat(searchu.getLastName(), is(u.getLastName()));
		assertThat(searchu.getLocation(), is(u.getLocation()));
		
//		assertThat(searchu.getValue("key4"), is(u.getValue("key4")));
		
		
		repo.findAll().forEach(itm -> {
			System.out.println(itm.getId());
		});;
	}

}
