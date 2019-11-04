package kate.service.department_service;

import kate.entity.Department;

public interface FindHeadService {
    Department findByName(String name);
}
