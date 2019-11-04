package kate;

import static java.util.stream.Collectors.toMap;
import static kate.constants.Constants.INTEGER_INPUT;
import static kate.constants.Constants.MENU;
import static kate.constants.Constants.MENU_NUMBER_RANGE;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {
    private static final Scanner SC = new Scanner(System.in);
    private Map<Integer, TaskExecutor> map;

    public Main(List<TaskExecutor> taskExecutors) {
        map = taskExecutors.stream().collect(toMap(TaskExecutor::getNumberOfTask, Function.identity()));
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("kate");
        context.refresh();

        context.getBean(Main.class).startApplication();
    }

    public void startApplication() {
        TaskExecutor taskExecutor;

        int select;
        String input;

        while (true) {
            System.out.println(MENU);

            input = SC.nextLine();

            try {
                select = Integer.valueOf(input);
            } catch (Exception c) {
                System.out.println(INTEGER_INPUT);
                continue;
            }

            taskExecutor = map.get(select);

            if (taskExecutor == null) {
                System.out.println(MENU_NUMBER_RANGE);
                continue;
            }

            taskExecutor.execute();
        }
    }
}
