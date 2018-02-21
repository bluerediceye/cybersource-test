package com.vistra.notification;

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
@RequestMapping("/notification")
public class NotificationController {

    @GetMapping
    @RequestMapping("/test")
    public String testGet(final HttpServletRequest request, final HttpServletResponse response){
        return "Test";
    }

    @PostMapping
    @RequestMapping("/callback")
    public String testCallback(final HttpServletRequest request, final HttpServletResponse response){
        return "Callback";
    }
}
