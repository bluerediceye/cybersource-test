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

        Enumeration<String> attrs =  request.getParameterNames();
        while(attrs.hasMoreElements()) {
            String e = attrs.nextElement();
            log.info(e + " >>::::::>> "  + request.getAttribute(e));
        }

        return "Home";
    }

    @GetMapping
    @RequestMapping("/test")
    public String testGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        log.info("Test");

        Enumeration<String> attrs =  request.getParameterNames();
        while(attrs.hasMoreElements()) {
            String e = attrs.nextElement();
            log.info(e + " >>::::::>> "  + request.getAttribute(e));
        }

        return "Test";
    }

    @PostMapping
    @RequestMapping("/callback")
    public String testCallback(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        log.info("Callback");

        Enumeration<String> attrs =  request.getParameterNames();
        while(attrs.hasMoreElements()) {
            String e = attrs.nextElement();
            log.info(e + " >>::::::>> "  + request.getAttribute(e));
        }

        return "Callback";
    }
}
