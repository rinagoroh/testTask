package kate.service.departmentService.departmentServiceImpl;

import static kate.constants.Constants.CAN_NOT_FOUND_HEAD_OF_DEPARTMENT_BY_NAME;
import static kate.constants.Constants.ENTER_NAME_OF_DEPARTMENT_NAME;
import static kate.constants.RequestSender.FIND_HEAD;

import java.util.Scanner;
import kate.TaskExecutor;
import kate.entity.Department;
import kate.repo.DepartmentRepo;
import kate.service.departmentService.FindHeadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindHeadServiceImpl implements FindHeadService, TaskExecutor {
    private static final Scanner SC = new Scanner(System.in);
    private DepartmentRepo repo;

    @Override
    public Department findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public void execute() {
        System.out.println(ENTER_NAME_OF_DEPARTMENT_NAME);
        String name = SC.nextLine();
        try {
            System.out.println("Head of department - " + findByName(name).getHead().getName());
        } catch (Exception e) {
            System.out.println(CAN_NOT_FOUND_HEAD_OF_DEPARTMENT_BY_NAME);
        }
    }

    @Override
    public int getNumberOfTask() {
        return FIND_HEAD;
    }
}
