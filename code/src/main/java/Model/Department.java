package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departements")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<Teacher> teachers;

    public Department() {
    }

    public Department(String name, Institution institution) {
        this.name = name;
        this.institution = institution;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
