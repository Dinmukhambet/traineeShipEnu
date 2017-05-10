package devyellow.repositories;

import devyellow.entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 23.03.2017.
 */
@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {}