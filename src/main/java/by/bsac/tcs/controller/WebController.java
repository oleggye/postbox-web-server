package by.bsac.tcs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("secure")
public class WebController {

  @GetMapping("/home")
  public ModelAndView home() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("home");
    return mav;
  }

  @GetMapping("/hello")
  public ModelAndView hello() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("hello");
    return mav;
  }

  @GetMapping("/index")
  public ModelAndView index() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("index");
    return mav;
  }

  @GetMapping("/template")
  public String template() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("template");
    return "template";
  }
}
