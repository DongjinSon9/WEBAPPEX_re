package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.springex.dto.TodoDTO;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {

    @RequestMapping("/list")
    public void list() {
        log.info("list..........");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register() {
        log.info("register............");
    }

    @PostMapping("/register")
    public void registerPost(TodoDTO todoDTO) {
        log.info("post todo register..........");
        log.info(todoDTO);
    }

}
