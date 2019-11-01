package kate.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import kate.entity.enums.Degree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private Double salary;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private Degree degree;

    @OneToOne(mappedBy = "head")
    private Department department;

    @OneToMany(mappedBy = "lector")
    private List<Department> departments = new ArrayList<>();
}
