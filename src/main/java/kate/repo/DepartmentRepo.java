package kate.repo;

import java.util.Optional;
import kate.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String name);

    @Query(value = "select round(avg(l.salary), 0) as sum_salary from Lector l join " +
        "Department d on d.lector.id = l.id where d.name = :name")
    Double avgSalary(@Param("name") String name);

    @Query(value = "select count(l.id) from Lector l join Department d on d.lector.id = l.id " +
        "where d.name = :name")
    Integer countOfEmployee(@Param("name") String name);

    @Query(value = "select count(l.id) from Lector l join Department d on d.lector.id = l.id where l.degree = 2" +
        " and d.name = :name")
    Integer countOfProfessorsAtDepartment(@Param("name") String name);

    @Query(value = "select count(l.id) from Lector l inner join Department d on d.lector.id = l.id where (l.degree = 0" +
        "and d.name = :name)")
    Integer countOfAssistantAtDepartment(@Param("name") String name);

    @Query(value = "select count(l.id) from Lector l join Department d on d.lector.id = l.id where l.degree = 1" +
        " and d.name = :name")
    Integer countOfAssistantProfessorAtDepartment(@Param("name") String name);
}
