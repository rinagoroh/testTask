package kate.service.lectorService;

import java.util.List;
import kate.entity.Lector;

public interface LectorsStatisticService {
    List<Lector> getDepartmentStatistic(String name);
}
