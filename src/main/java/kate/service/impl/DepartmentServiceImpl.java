package kate.service.impl;

import kate.entity.Lector;
import kate.repo.DepartmentRepo;
import kate.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepo repo;

    @Override
    public Lector findHead(String name) {
        return repo.findByName(name).orElseThrow(() -> new RuntimeException("Can't find by name.")).getHead();
    }

    @Override
    public double avgSalary(String name) {
        return repo.avgSalary(name);
    }

    @Override
    public int countOfEmployee(String name) {
        return repo.countOfEmployee(name);
    }

    @Override
    public int countOfProfessorsByDepartmentName(String name) {
        return repo.countOfProfessorsAtDepartment(name);
    }

    @Override
    public int countOfAssistantByDepartmentName(String name) {
        return repo.countOfAssistantAtDepartment(name);
    }

    @Override
    public int countOfAssistantProfessorByDepartmentName(String name) {
        return repo.countOfAssistantProfessorAtDepartment(name);
    }
}
