package com.blz.io.java;

import java.util.Arrays;
import org.junit.Test;

public class EmployeePayRollServiceTest {

	@Test
	public void given2EmloyeesDetails_WrittenToFile_ShouldMatchWithEntries() {
		EmployeePayRollData[] arrayofEmps = { new EmployeePayRollData(1, "James", 25000.0),
				new EmployeePayRollData(2, "Mickey", 50000.0)
		};
		EmployeePayRollService empPayrollService;
		empPayrollService = new EmployeePayRollService(Arrays.asList(arrayofEmps));
		empPayrollService.writeEmployeePayRollData(com.blz.io.java.EmployeePayRollService.IOService.FILE_IO);
	}
}

