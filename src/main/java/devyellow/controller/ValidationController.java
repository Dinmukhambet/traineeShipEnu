package devyellow.controller;

import devyellow.entities.Faculty;
import devyellow.entities.Speciality;
import devyellow.repositories.FacultyRepository;
import devyellow.repositories.SpecialityRepository;
import devyellow.services.FacultyService;
import devyellow.services.SpecialityService;
import devyellow.validation.StudentForm;
import devyellow.validation.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Admin on 11.04.2017.
 */
@Controller
public class ValidationController {

    @Autowired
    FacultyService facultyService;

    @Autowired
    SpecialityService specialityService;

    @Autowired
    StudentValidator studentValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(studentValidator);
    }

    @GetMapping("/registration")
    public String showRegistrationForm(StudentForm studentForm){
        return "registration";
    }

    @PostMapping("/registration")
    public String checkStudentInfo(@Validated StudentForm studentForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "registration";
        }

        return "/";
    }

    @ModelAttribute("allFaculties")
    public List<Faculty> faculties(){
        return facultyService.findFaculties();
    }


    @ModelAttribute("allSpec")
    public List<Speciality> specialities(){
        return specialityService.findSpecialities();
    }



}
