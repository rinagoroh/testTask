package kate.service.departmentService;

import kate.entity.Department;

public interface FindHeadService {
    Department findByName(String name);
}
