package com.lec.sts19_rest.vo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
public class EmployeVO {

	@XmlAttribute
	private Integer id;
	@XmlElement
	private String name;
	@XmlElement
	private int age;
	@XmlElement
	private int[] score;
	@XmlElement
	private double point;
	
	public EmployeVO() {
		super();
	}

	public EmployeVO(Integer id, String name, int age, int[] score, double point) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
		this.point = point;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int[] getScore() {
		return score;
	}

	public double getPoint() {
		return point;
	}
	
	
	
}
