package com.lec.sts16_interceptor;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lec.sts16_interceptor.vo.BoardVO;

public class BoardVaildator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		//System.out.println("supports ( " + clazz.getName() + ")");
		
		return BoardVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		System.out.println("validate()");
		BoardVO board = (BoardVO) target;
		
		String name = board.getName();
		if(name == null || name.trim().isEmpty()) {
			System.out.println("name 오류 : 반드시 한글자라도 입력해야 합니다.");
			errors.rejectValue("name", "emptyName");
		}
		
		String subject = board.getSubject();
		if(subject == null || subject.trim().isEmpty()) {
			System.out.println("subject 오류 : 반드시 한글자라도 입력해야 합니다.");
			errors.rejectValue("subject", "emptySubject");
		}
	}

}
