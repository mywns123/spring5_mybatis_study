package spring5_mybatis_study.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextDataSource.class})
public class ContextDataSourceTest {
	private static final Log log = LogFactory.getLog(ContextDataSource.class);
		@After
	public void tearDown() throws Exception {
		System.out.println();

	}

	@Autowired
	private DataSource dataSource;

	@Test
	public void testDataSource() throws SQLException {
	log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	log.debug("DataSource " + dataSource);
	log.debug("LoginTimeout " + dataSource.getLoginTimeout());
	Assert.assertNotNull(dataSource);
	}

}
