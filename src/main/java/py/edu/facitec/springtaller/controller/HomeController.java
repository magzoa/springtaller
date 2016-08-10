package py.edu.facitec.springtaller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// para indicar que esta clase interactua con los requests venidos de la web.
@Controller


public class HomeController {
	

	

@RequestMapping("/")	
public String index(){
	
	
	return "hello-world";
}	


	
	
	
	
	

}
