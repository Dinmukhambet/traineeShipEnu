package devyellow.repositories;

import devyellow.entities.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 23.03.2017.
 */
@Repository
public interface FacultyRepository  extends JpaRepository<Faculty, Integer> {

}