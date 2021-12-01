package myspring.di.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJunitTest {
	
	private ApplicationContext context;
	
	@Before
	public void init() {
		context = new GenericXmlApplicationContext("config/beans.xml");
	}

	@Test
	public void bean1() {
		Hello hello = (Hello) context.getBean("hello");
		assertEquals("HelloSpring", hello.sayHello());
		hello.print();
		
		Printer printer = (Printer) context.getBean("printer");
		assertEquals("HelloSpring", printer.toString());
	}
	
	@Test
	public void bean2() {
		Printer printer = (Printer) context.getBean("printer");
		Printer printer2 = context.getBean("printer", Printer.class);
		
		assertSame(printer, printer2);
	}

}






























