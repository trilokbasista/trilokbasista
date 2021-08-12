package eBIS.HomePage.Controller;


import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexPageController {
	@GetMapping(value = "/")
	 public ModelAndView IndexPage(HttpServletRequest request) {  
		ModelAndView mv=new ModelAndView(); 
        mv.setViewName("indexpage");
        return mv;   
    } 
}
