package com.blz.io.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayRollService {
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}
	private List<EmployeePayRollData> empPayrollList;
	
	public EmployeePayRollService(List<EmployeePayRollData> empPayrollList) {
		super();
		this.empPayrollList = empPayrollList;
	}
	
	public EmployeePayRollService() {
		super();
	}
	
	private void readEmployeePayRollData(Scanner sc) {
		System.out.println("Enter Employee Id: ");
		int empId = sc.nextInt();
		System.out.println("Enter Employee Name: ");
		String empName = sc.next();
		System.out.println("Enter Employee salary: ");
		double salary = sc.nextDouble();
		empPayrollList.add(new EmployeePayRollData(empId, empName, salary));
	}
	
	void writeEmployeePayRollData(IOService ioService) {
		if(ioService.equals(com.blz.io.java.EmployeePayRollService.IOService.CONSOLE_IO))
			System.out.println("Employee Payroll Details: "+empPayrollList);
		if(ioService.equals(com.blz.io.java.EmployeePayRollService.IOService.FILE_IO))
			new EmployeePayRollFileIOService().writeData(empPayrollList);
	}
	
	public void printData(IOService ioService) {
		if(ioService.equals(IOService.FILE_IO))
			new EmployeePayRollFileIOService().printData();
	}
	
	public long countEntries(IOService ioService) {
		if(ioService.equals(IOService.FILE_IO))
			return new EmployeePayRollFileIOService().countEntries();
		return 0;
	}
	
	public static void main(String[] args) {
		ArrayList<EmployeePayRollData> empPayrollList = new ArrayList<>();
		EmployeePayRollService empPayrollService = new EmployeePayRollService(empPayrollList);
		Scanner sc = new Scanner(System.in);
		empPayrollService.readEmployeePayRollData(sc);
		empPayrollService.writeEmployeePayRollData(IOService.CONSOLE_IO);
	}
}
