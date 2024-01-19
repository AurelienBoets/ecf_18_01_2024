package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String level;

    @ManyToOne
    @JoinColumn(name = "mainTeacher")
    private Teacher mainTeacher;

    @OneToMany(mappedBy = "class",cascade = CascadeType.ALL)
    private List<Schedule> schedules;

    @OneToMany(mappedBy = "class",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Student> students;

    public Class(String name, String level, Teacher teacher) {
        this.name = name;
        this.level = level;
        this.mainTeacher = teacher;
    }

    public Class() {
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Teacher getTeacher() {
        return mainTeacher;
    }

    public void setTeacher(Teacher teacher) {
        this.mainTeacher = teacher;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
