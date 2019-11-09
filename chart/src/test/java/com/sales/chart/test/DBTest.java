package com.sales.chart.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sales.chart.model.vo.SaleVO;
import com.sales.chart.service.SaleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
      })
@WebAppConfiguration
public class DBTest {
	
	/*
	 * @Autowired ApplicationContext context;
	 */
	@Autowired
	ServletContext servletContext;
	@Autowired
	SaleService service;
	
	private static final Logger log = LoggerFactory.getLogger(DBTest.class);
	
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	
	private static final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER="LHJ_GUEST";
	private static final String PW="1234";

	@Test @Ignore
	public void test() throws Exception {
		Class.forName(DRIVER);
		try(Connection conn = DriverManager.getConnection(URL, USER, PW)) {
			log.info("오라클 연결!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * @Test @Ignore public void repositoryTest() { SaleRepository repository =
	 * context.getBean("repository", SaleRepository.class); List<SaleVO> list =
	 * repository.list(100000, "", "", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, "F");
	 * 
	 * for(SaleVO sale : list) { System.out.println(sale); } }
	 */
	
	@Test
	public void getSaleTblTest() throws SQLException {
		List<SaleVO> list = service.list(100000, "", "", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, "F");
		
		System.out.println("--------------------------------------------");
		for(SaleVO sale : list) {
			System.out.println(sale);
		}	
		System.out.println("--------------------------------------------");
	}

}
