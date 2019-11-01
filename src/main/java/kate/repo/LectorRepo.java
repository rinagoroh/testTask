package kate.repo;

import java.util.List;
import kate.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LectorRepo extends JpaRepository<Lector, Long> {

    @Query(value = "select l from Lector l where l.name like %:regex%")
    List<Lector> findAllByRegex(@Param("regex") String regex);
}
