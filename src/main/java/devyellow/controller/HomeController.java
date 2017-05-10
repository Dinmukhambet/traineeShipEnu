package devyellow.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

	@RequestMapping("/")
	public String indexPage(){
		return "index";
	}

	@RequestMapping("/login")
	public String loginPage(){
		return "login";
	}
	/*@RequestMapping("/registration")
	public  String registrationPage(){
		return "registration";
	}*/
}
