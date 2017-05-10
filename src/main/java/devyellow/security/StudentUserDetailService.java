package devyellow.security;

import devyellow.entities.Student;
import devyellow.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 25.03.2017.
 */

@Service("studentUserDetailService")
public class StudentUserDetailService implements UserDetailsService{

    @Autowired
    private StudentService studentService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String nickName) throws UsernameNotFoundException {
        Student student = studentService.findByNickName(nickName);
        if (student==null){
            throw  new UsernameNotFoundException("Nickname no found");
        }
        return new User(student.getNickName(),student.getPassword(),getGrantedAuthorities(student));

    }

    private List<GrantedAuthority> getGrantedAuthorities(Student student) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : student.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
        }
        return authorities;
    }
}
