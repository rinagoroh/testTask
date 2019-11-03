package kate.repo;

import java.util.List;
import kate.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorRepo extends JpaRepository<Lector, Long> {

    @Query(value = "select l from Lector l where l.name like %:template%")
    List<Lector> globalSearch(@Param("template") String template);

    @Query(value = "select l from Lector l join Department d on d.lector.id = l.id where d.name = :name")
    List<Lector> getAllByDepartmentName(@Param("name") String name);
}
