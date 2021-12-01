package myspring.di.annot;

import java.util.List;
import java.util.Map;
import javax.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hello {
	
	//@Value("${myname}")
	
	
	//@Value("Spring")
	@Value("${myname}")
	private String name;
	
	
	//@Resource(name="${printer1}")
	//@Autowired  // 의존하는 객체를 자동으로 주입 
	//@Qualifier("stringPrinter") //Qualifer 어노테이션은 동일한타입의 Bean 객체가 여러개 존재할 때 특정 Bean을 찾기위해서 사용 
	@Resource(name="${printer1}")
	private Printer printer;
	
	// 기존에 있던 setter 메서드를 삭제해줌 
	
	public String sayHello() {
		return "Hello" + name;
	}
	
	public void print() {
		this.printer.print(sayHello());
	}




	
	
	
	
	
}
