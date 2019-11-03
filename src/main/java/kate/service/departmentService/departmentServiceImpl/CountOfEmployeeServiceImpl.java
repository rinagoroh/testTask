package kate.service.departmentService.departmentServiceImpl;

import static constants.Constants.ENTER_NAME_OF_DEPARTMENT_NAME;
import static constants.RequestSender.COUNT_OF_LECTORS;

import java.util.Scanner;
import kate.TaskExecutor;
import kate.repo.DepartmentRepo;
import kate.service.departmentService.CountOfEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountOfEmployeeServiceImpl implements CountOfEmployeeService, TaskExecutor {
    private static final Scanner SC = new Scanner(System.in);
    private DepartmentRepo repo;

    @Override
    public void execute() {
        System.out.println(ENTER_NAME_OF_DEPARTMENT_NAME);
        String name = SC.nextLine();
        System.out.println(countOfEmployee(name) + " employee(s).");
    }

    @Override
    public int countOfEmployee(String name) {
        return repo.countOfEmployee(name);
    }

    @Override
    public int getNumberOfTask() {
        return COUNT_OF_LECTORS;
    }
}
