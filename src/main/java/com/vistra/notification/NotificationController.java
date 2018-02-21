package com.vistra.notification;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ming Li
 */
@RestController
@Log4j2
public class NotificationController {

    @GetMapping
    @RequestMapping("/")
    public String home(final HttpServletRequest request, final HttpServletResponse response){
        log.info("HOME");
        return "Home";
    }

    @GetMapping
    @RequestMapping("/test")
    public String testGet(final HttpServletRequest request, final HttpServletResponse response){
        log.info("Test");
        return "Test";
    }

    @PostMapping
    @RequestMapping("/callback")
    public String testCallback(final HttpServletRequest request, final HttpServletResponse response){
        log.info("Callback");
        return "Callback";
    }
}
