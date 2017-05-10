package devyellow.services;

import devyellow.entities.Student;
import devyellow.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 25.03.2017.
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studRepository;

    public Student findByNickName(String nickName){
        return studRepository.findByNickName(nickName);
    }


}
