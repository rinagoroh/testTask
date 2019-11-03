package kate;

import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {
    private static final Scanner SC = new Scanner(System.in);
    private static Map<Integer, TaskExecutor> map;

    public Main(List<TaskExecutor> taskExecutors) {
        map = taskExecutors.stream().collect(toMap(TaskExecutor::getNumberOfTask, Function.identity()));
    }

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
            "Just pick number from the list: \n");
    }

    public void startApplication() {
        TaskExecutor taskExecutor;
        int select;
        String input;

        while (true) {
            printMenu();

            input = SC.nextLine();

            try {
                select = Integer.valueOf(input);
            } catch (Exception c) {
                System.out.println("You have to input integer.");
                continue;
            }

            taskExecutor = map.get(select);

            if (taskExecutor == null) {
                System.out.println("You have to input number between 1 and 5");
                continue;
            }

            taskExecutor.execute();
        }
    }
}
