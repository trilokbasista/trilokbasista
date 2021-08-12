package eBIS.HomePage.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UnderMaintainancePageController {

	@GetMapping(value = "/UnderMaintainance")
	 public ModelAndView HomePagePage() {  
		ModelAndView mv=new ModelAndView(); 
      String message = "UnderMaintainance";
      System.out.println(message);
      mv.setViewName("UnderMaintainance");
      return mv;   
  }
}
