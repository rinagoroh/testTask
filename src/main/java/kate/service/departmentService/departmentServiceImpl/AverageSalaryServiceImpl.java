package kate.service.departmentService.departmentServiceImpl;

import static kate.service.RequestSender.AVG_SALARY;

import java.util.Scanner;
import kate.TaskExecutor;
import kate.repo.DepartmentRepo;
import kate.service.departmentService.AverageSalaryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AverageSalaryServiceImpl implements AverageSalaryService, TaskExecutor {
    private static final Scanner SC = new Scanner(System.in);
    private DepartmentRepo repo;

    @Override
    public void execute() {
        System.out.println("Enter name of department (Economy, Theatre, History, Math) : ");
        String name = SC.nextLine();
        System.out.println("The average salary of " + name + " is " + avgSalary(name));
    }

    @Override
    public int getNumberOfTask() {
        return AVG_SALARY;
    }

    @Override
    public double avgSalary(String name) {
        return repo.avgSalary(name);
    }
}
