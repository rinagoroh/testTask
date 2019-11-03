package kate.service.lectorService.lectorServiceImpl;

import static constants.Constants.GLOBAL_SEARCH_BY;
import static constants.RequestSender.GLOBAL_SEARCH;

import java.util.List;
import java.util.Scanner;
import kate.TaskExecutor;
import kate.entity.Lector;
import kate.repo.LectorRepo;
import kate.service.lectorService.LectorsByTemplateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LectorsTemplateServiceImpl implements LectorsByTemplateService, TaskExecutor {
    private static final Scanner SC = new Scanner(System.in);
    private LectorRepo repo;

    @Override
    public List<Lector> globalSearch(String template) {
        return repo.globalSearch(template);
    }

    @Override
    public void execute() {
        System.out.println(GLOBAL_SEARCH_BY);
        String template = SC.nextLine();
        System.out.println(template);
        List<Lector> lectors = globalSearch(template);
        lectors.forEach(l -> System.out.println(l.getName()));
    }

    @Override
    public int getNumberOfTask() {
        return GLOBAL_SEARCH;
    }
}
