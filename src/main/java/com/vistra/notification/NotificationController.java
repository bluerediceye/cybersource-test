package com.vistra.notification;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * @author Ming Li
 */
@RestController
@Log4j2
public class NotificationController {

    @GetMapping
    @RequestMapping("/")
    public String home(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        log.info("HOME");
        log.info("Request: " + request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
        return "Home";
    }

    @GetMapping
    @RequestMapping("/test")
    public String testGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        log.info("Test");
        log.info("Request: " + request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
        return "Test";
    }

    @PostMapping
    @RequestMapping("/callback")
    public String testCallback(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        log.info("Callback");
        log.info("Request: " + request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
        return "Callback";
    }
}
