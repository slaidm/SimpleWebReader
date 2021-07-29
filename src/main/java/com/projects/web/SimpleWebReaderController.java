package com.projects.web;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//TODO
@Controller
public class SimpleWebReaderController {
  Stack<Book> books = new Stack<>();
  boolean forward = true;
  
  @RequestMapping("/")
  public String welcome(Model model) {
	  model.addAttribute("welcome");
	  return "welcome";
  }
  
  @GetMapping("/quote")
  public String quoteForward(Model model) {
	Book b = TextReader.getText();
	forward = true;
    model.addAttribute("book", b);
	books.push(b);
    return "quote";
  }
  
  @PostMapping("/quote")
  public String quoteBackward(Model model) {
	Book b = null;
	if(books.size() > 1) {
		books.pop();
		forward = false;
	}
	b = books.peek();
    model.addAttribute("book", b);	
    return "quote";
  }  

}