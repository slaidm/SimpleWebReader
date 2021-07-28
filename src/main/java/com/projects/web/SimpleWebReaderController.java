package com.projects.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleWebReaderController {
	
  private List<Greeting> list = new ArrayList<>();

  @RequestMapping("/")
  public String welcome(Model model) {
	  model.addAttribute("welcome");
	  return "welcome";
  }
  
  @GetMapping("/greeting")
  public String greetingForm(Model model) {
    model.addAttribute("greeting", new Greeting());
    return "greeting";
  }

  @PostMapping("/greeting")
  public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
    model.addAttribute("greeting", greeting);
    list.add(greeting);
    return "result";
  }
  
  @RequestMapping("/show")
  public String show(Model model) {
	  model.addAttribute("show", list);
	  return "show";
  }
  
  @RequestMapping("/display")
  public String display(Model model) {
	  model.addAttribute("book", TextReader.getText("https://www.gutenberg.org/cache/epub/8300/pg8300.txt"));
	  return "display";
  }

}