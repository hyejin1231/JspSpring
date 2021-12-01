package myspring.di.xml.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class HelloBeanSpringTest {

	@Autowired
	private ApplicationContext context;
	
	@Test @Ignore
	public void bean1() {
		Hello hello = (Hello) context.getBean("hello");
		assertEquals("HelloSpring", hello.sayHello());
		hello.print();
		assertEquals("HelloSpring",context.getBean("printer").toString());
		
		Hello hello2 = context.getBean("hello", Hello.class);
		hello2.print();
		assertSame(hello, hello2);
	}
	
	@Test
	public void bean2() {
		// 2. getBean() 호출 
		//Hello hello = (Hello) context.getBean("hello2");
		Hello hello = (Hello) context.getBean("hello3");
		
		// 3. Hello의 sayHello() 호출 
		assertEquals("HelloSpring", hello.sayHello());
		
		// 4. Hello의 printer() 호출 
		hello.print();
		
		assertEquals(3, hello.getNames().size());
		List<String> list = hello.getNames();
		for(String value : list) {
			System.out.println(value);
		}
		
		Printer printer = context.getBean("printer", Printer.class);
		assertEquals("HelloSpring", printer.toString());
	}
	
	
	

}
























