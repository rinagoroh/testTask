package kate.service.lectorService;

import java.util.List;
import kate.entity.Lector;

public interface LectorsByTemplateService {
    List<Lector> globalSearch(String template);
}
