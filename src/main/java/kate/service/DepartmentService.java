package kate.service;

import kate.entity.Lector;

public interface DepartmentService {
    Lector findHead(String name);

    double avgSalary(String name);

    int countOfEmployee(String name);

    int countOfProfessorsByDepartmentName(String name);

    int countOfAssistantByDepartmentName(String name);

    int countOfAssistantProfessorByDepartmentName(String name);
}
