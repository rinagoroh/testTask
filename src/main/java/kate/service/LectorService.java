package kate.service;

import java.util.List;
import kate.entity.Lector;
import org.springframework.data.repository.query.Param;

public interface LectorService {
    List<Lector> findAllByRegex(String regex);
}
