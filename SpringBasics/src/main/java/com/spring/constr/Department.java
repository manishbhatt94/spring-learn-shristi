package com.spring.constr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Department {

	private String deptName;
	private String deptHead;

	public String getDeptName() {
		return deptName;
	}

	@Value("${student.dept.name}")
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptHead() {
		return deptHead;
	}

	@Value("${student.dept.head}")
	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}

	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", deptHead=" + deptHead + "]";
	}

}
