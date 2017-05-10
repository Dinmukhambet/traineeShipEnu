package devyellow.repositories;

import devyellow.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 21.03.2017.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

 Student findByNickName(String nickname);

}