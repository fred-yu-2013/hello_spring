package com.fred.tutorialspoint.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoController {
	
    private final TodoService service;
    
    private final MessageSource messageSource;
 
    @Autowired
    public TodoController(MessageSource messageSource, TodoService service) {
        this.messageSource = messageSource;
        this.service = service;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String findAll(Model model) {
        List<Todo> models = service.findAll();
        model.addAttribute("todos", models);
        return "todo/list";
    }
    
}
