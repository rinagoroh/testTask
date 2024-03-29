package kate.service.department_service.department_service_impl;

import static kate.constants.Constants.ENTER_NAME_OF_DEPARTMENT_NAME;
import static kate.constants.RequestSender.AVG_SALARY;

import java.util.Scanner;
import kate.TaskExecutor;
import kate.repo.DepartmentRepo;
import kate.service.department_service.AverageSalaryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AverageSalaryServiceImpl implements AverageSalaryService, TaskExecutor {
    private static final Scanner SC = new Scanner(System.in);
    private DepartmentRepo repo;

    @Override
    public void execute() {
        System.out.println(ENTER_NAME_OF_DEPARTMENT_NAME);
        String name = SC.nextLine();
        System.out.println("The average salary of " + name + " is " + avgSalary(name));
    }

    @Override
    public double avgSalary(String name) {
        return repo.avgSalary(name);
    }

    @Override
    public int getNumberOfTask() {
        return AVG_SALARY;
    }
}
