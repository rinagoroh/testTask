package kate;

import java.util.List;
import java.util.Scanner;
import kate.entity.Lector;
import kate.service.DepartmentService;
import kate.service.LectorService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Main {
    private static final Scanner SC = new Scanner(System.in);
    private DepartmentService departmentService;
    private LectorService lectorService;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("kate");
        context.refresh();
        context.getBean(Main.class).startApplication();
    }

    private static void printMenu() {
        System.out.println("----Menu---- \n" +
            "1 - Who is head of department \n" +
            "2 - Show department statistic \n" +
            "3 - Show the average salary of department \n" +
            "4 - Show count of lectors \n" +
            "5 - Global search by template \n" +
            "6 - menu \n" +
            "Just pick number from the list: \n");
    }

    public void startApplication() {
        while (true) {
            printMenu();
            String choice = SC.nextLine();
            switch (choice) {
                case "1":
                    getHeadOfDepartment();
                    break;
                case "2":
                    getStatisticForDepartment();
                    break;
                case "3":
                    getAvgSalaryOfEmployeesForDepartment();
                    break;
                case "4":
                    getContOfEmployeeForDepartment();
                    break;
                case "5":
                    getListEmployeesNameOfDepartment();
                    break;
                default:
                    System.out.println("Wrong input");
            }
        }
    }

    private void getListEmployeesNameOfDepartment() {
        System.out.println("Global search by: ");
        String regex = SC.nextLine();
        List<Lector> lectors = lectorService.findAllByRegex(regex);
        lectors.forEach(l -> System.out.println(l.getName()));
    }

    private void getContOfEmployeeForDepartment() {
        System.out.println("Enter name of department (Economy, Theatre, History, Math) : ");
        String nameOfDepartmentForCount = SC.nextLine();
        checkValidValue(nameOfDepartmentForCount);
        System.out.println(departmentService.countOfEmployee(nameOfDepartmentForCount) + " employee(s).");
    }

    private void getAvgSalaryOfEmployeesForDepartment() {
        System.out.println("Enter name of department (Economy, Theatre, History, Math) : ");
        String nameOfDepartmentForAvg = SC.nextLine();
        checkValidValue(nameOfDepartmentForAvg);
        System.out.println("The average salary of " + nameOfDepartmentForAvg + " is " + departmentService.avgSalary(nameOfDepartmentForAvg));
    }

    private void getStatisticForDepartment() {
        System.out.println("Enter name of department (Economy, Theatre, History, Math) : ");
        String nameOfDepartmentForStatistic = SC.nextLine();
        checkValidValue(nameOfDepartmentForStatistic);
        System.out.println("Assistans - " + departmentService.countOfAssistantByDepartmentName(nameOfDepartmentForStatistic));
        System.out.println("Associate professors - " + departmentService.countOfAssistantProfessorByDepartmentName(nameOfDepartmentForStatistic));
        System.out.println("Professors - " + departmentService.countOfProfessorsByDepartmentName(nameOfDepartmentForStatistic));
    }

    private void getHeadOfDepartment() {
        System.out.println("Enter name of department (Economy, Theatre, History, Math) : ");
        String name = SC.nextLine();
        checkValidValue(name);
        Lector lector = departmentService.findHead(name);
        System.out.println("Head of department = " + lector.getName());
    }

    private void checkValidValue(String name) {
        if (!name.matches("^[a-zA-Z]+$") || name.isEmpty()) {
            System.out.println("It seems like you did not enter name of department.");
        }
    }
}
