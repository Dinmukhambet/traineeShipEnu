package devyellow.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class StudentValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return StudentForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","password.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"confirmPass","confirmPassword.empty");
            StudentForm student =  (StudentForm)o;
        if (!student.getPassword().equals(student.getConfirmPass())){
            errors.rejectValue("confirmPass","confirmPassword.notequal");
        }
        if (student.getNickName().equals(null)){
            errors.rejectValue("nickName","nickname.empty");
        }
        if (student.getDateOfBirth() == null){
            errors.rejectValue("dateOfBirth","date.empty");
        }

        if (student.getFirstName().equals(null)){
            errors.rejectValue("firstName","firstname.empty");
        }

        if (student.getFirstName().length()<2){
            errors.rejectValue("firstName","firstname.size");
        }
        if (student.getSecondName().equals(null)){
            errors.rejectValue("secondName","secondname.empty");
        }

        if (student.getSecondName().length()<2){
            errors.rejectValue("secondName","secondname.size");
        }
        if (student.getMiddleName().equals(null)){
            errors.rejectValue("middleName","middlename.empty");
        }

        if (student.getMiddleName().length()<2){
            errors.rejectValue("middleName","middlename.size");
        }
    }
}
