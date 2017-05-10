package devyellow.services;

import devyellow.entities.Faculty;
import devyellow.repositories.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 10.04.2017.
 */

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public List<Faculty> findFaculties(){
        return this.facultyRepository.findAll();
    }
}
