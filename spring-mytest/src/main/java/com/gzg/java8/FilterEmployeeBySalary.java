package com.gzg.java8;

/**
 * @author guozengguang
 * @date 2019-06-25 13:13
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {
	@Override
	public boolean compare(Employee employee) {
		return employee.getSalary() >= 5000;
	}
}
