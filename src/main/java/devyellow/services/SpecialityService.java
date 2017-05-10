package devyellow.services;

import devyellow.entities.Speciality;
import devyellow.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Admin on 11.04.2017.
 */
@Service
public class SpecialityService {

@Autowired
    private SpecialityRepository specialityRepository;

    public List<Speciality> findSpecialities(){
      return this.specialityRepository.findAll();
    }

}
