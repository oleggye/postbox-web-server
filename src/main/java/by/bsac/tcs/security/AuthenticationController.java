package by.bsac.tcs.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

  @GetMapping("login")
  public ModelAndView login() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("login");
    return mav;
  }

  @GetMapping("error")
  public ModelAndView error() {
    ModelAndView mav = new ModelAndView();
    String errorMessage = "You are not authorized for the requested data.";
    mav.addObject("errorMsg", errorMessage);
    mav.setViewName("403");
    return mav;
  }
}