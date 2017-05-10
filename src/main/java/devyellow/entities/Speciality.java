package devyellow.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Admin on 21.03.2017.
 */
@Entity
public class Speciality {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column
    private String nameOfSpec;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "speciality")
    private Set<Student> students;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfSpec() {
        return nameOfSpec;
    }

    public void setNameOfSpec(String nameOfSpec) {
        this.nameOfSpec = nameOfSpec;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
