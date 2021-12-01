package myspring.di.xml;

import java.util.List;
import java.util.Map;

public class Hello {
	
	private String name;
	private Printer printer;
	private List<String> names;
	
	// 기본 생성자 
	public Hello() {
		super();
	}

	public Hello(String name, Printer printer) {
		super();
		this.name = name;
		this.printer = printer;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public String sayHello() {
		return "Hello" + name;
	}
	
	public void print() {
		this.printer.print(sayHello());
	}

	public List<String> getNames() {
		return names;
	}
	

	public void setNames(List<String> names) {
		this.names = names;
	}


	
	
	
	
	
}
