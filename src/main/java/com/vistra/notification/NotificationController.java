package com.vistra.notification;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.StringJoiner;
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
        logRequest(request);
        return "Home";
    }

    @GetMapping
    @RequestMapping("/test")
    public String testGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        log.info("Test");
        logRequest(request);
        return "Test";
    }

    @PostMapping
    @RequestMapping("/callback")
    public String testCallback(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        log.info("Callback");
        logRequest(request);
        return "Callback";
    }

    public void logRequest(final HttpServletRequest request){
        Enumeration<String> attrs =  request.getParameterNames();
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        while(attrs.hasMoreElements()) {
            String e = attrs.nextElement();
            stringJoiner.add(e + " : " + request.getParameterValues(e)[0]);
        }
        log.info("IMPORTANT:\n" + stringJoiner.toString());


    }
}
