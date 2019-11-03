package kate.service.departmentService.departmentServiceImpl;

import static kate.service.RequestSender.FIND_HEAD;

import java.util.Scanner;
import kate.TaskExecutor;
import kate.entity.Lector;
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
    public Lector findHead(String name) {
        return repo.findByName(name).orElseThrow(() -> new RuntimeException("Can't find by name.")).getHead();
    }

    @Override
    public void execute() {
        System.out.println("Enter name of department (Economy, Theatre, History, Math) : ");
        String name = SC.nextLine();
        System.out.println("Head of department = " + findHead(name).getName());
    }

    @Override
    public int getNumberOfTask() {
        return FIND_HEAD;
    }
}
