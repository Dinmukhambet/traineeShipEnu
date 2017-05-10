package devyellow.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Admin on 21.03.2017.
 */
@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column
    private String nameOfFaculty;

    @OneToMany(fetch = FetchType.LAZY,  cascade = {CascadeType.MERGE, CascadeType.PERSIST},mappedBy = "faculty")
    private Set<Speciality> specs;

    @OneToMany(fetch = FetchType.LAZY,  cascade = {CascadeType.MERGE, CascadeType.PERSIST},mappedBy = "faculty")
    private Set<Student> studs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfFaculty() {
        return nameOfFaculty;
    }

    public void setNameOfFaculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    public Set<Speciality> getSpecs() {
        return specs;
    }

    public void setSpecs(Set<Speciality> specs) {
        this.specs = specs;
    }

    public Set<Student> getStuds() {
        return studs;
    }

    public void setStuds(Set<Student> studs) {
        this.studs = studs;
    }
}
