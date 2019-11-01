package kate.service.impl;

import java.util.List;
import kate.entity.Lector;
import kate.repo.LectorRepo;
import kate.service.LectorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LectorServiceImpl implements LectorService {
    private LectorRepo repo;

    @Override
    public List<Lector> findAllByRegex(String regex) {
        return repo.findAllByRegex(regex);
    }
}
