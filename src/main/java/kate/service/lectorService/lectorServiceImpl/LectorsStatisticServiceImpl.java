package kate.service.lectorService.lectorServiceImpl;

import static kate.service.RequestSender.EMPLOYEE_STATISTIC;
import static kate.service.RequestSender.GLOBAL_SEARCH;

import java.util.List;
import java.util.Scanner;
import kate.TaskExecutor;
import kate.entity.Lector;
import kate.entity.enums.Degree;
import kate.repo.LectorRepo;
import kate.service.lectorService.LectorsByTemplateService;
import kate.service.lectorService.LectorsStatisticService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LectorsStatisticServiceImpl implements LectorsStatisticService, TaskExecutor {
    private static final Scanner SC = new Scanner(System.in);
    private LectorRepo repo;

    @Override
    public void execute() {
        System.out.println("Enter name of department (Economy, Theatre, History, Math) : ");
        String name = SC.nextLine();
        int countAssistants = 0;
        int countAssociateProfessors = 0;
        int countProfessors = 0;

        List<Lector> lectors = getDepartmentStatistic(name);
        for (Lector lector: lectors) {
            if (lector.getDegree().equals(Degree.ASSISTANT)) {
                countAssistants++;
            } else if (lector.getDegree().equals(Degree.ASSOCIATE_PROFESSOR)) {
                countAssociateProfessors++;
            } else if (lector.getDegree().equals(Degree.PROFESSOR)) {
                countProfessors++;
            }
        };

        System.out.println("Assistans - " + countAssistants);
        System.out.println("Associate professors - " + countAssociateProfessors);
        System.out.println("Professors - " + countProfessors);
    }

    @Override
    public int getNumberOfTask() {
        return EMPLOYEE_STATISTIC;
    }

    @Override
    public List<Lector> getDepartmentStatistic(String name) {
        return repo.getAllByDepartmentName(name);
    }
}
