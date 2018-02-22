package com.vistra.notification;

import com.google.common.base.Joiner;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @author Ming Li
 */
@RestController
@Log4j2
public class NotificationController {

    @Resource
    private PaymentStorageService paymentStorageService;


    @GetMapping
    @RequestMapping("/")
    public String home(final HttpServletRequest request) {
        log.info("HOME");
        logRequest(request);
        return "Home";
    }

    @PostMapping
    @RequestMapping("/callback")
    public void updatePaymentStatus(final HttpServletRequest request) {
        Joiner.MapJoiner mapJoiner = Joiner.on(System.lineSeparator()).withKeyValueSeparator("=");
        Map<String, String> data = createNotificationData(request);

        log.info(mapJoiner.join(data));

        String referenceNumber = data.get("req_reference_number");
        CyberSourcePaymentStatus status = CyberSourcePaymentStatus.valueOf(data.get("decision"));

        paymentStorageService.setCyberSourcePaymentStatus(referenceNumber, status);
    }

    @PostMapping
    @RequestMapping("/update/{referenceNumber}")
    public void updatePaymentStatus(@PathVariable final  String referenceNumber, @RequestBody final CyberSourcePaymentStatus status) {
        log.info("reference number: " + referenceNumber, "Payment status: " + status.toString());
        paymentStorageService.setCyberSourcePaymentStatus(referenceNumber, status);
    }

    @GetMapping
    @RequestMapping("/query/{referenceNumber}")
    public CyberSourcePaymentStatus query(@PathVariable final String referenceNumber) {
        log.info("reference number: " + referenceNumber);
        return log.traceExit(paymentStorageService.getCyberSourcePaymentStatus(referenceNumber));
    }

    private void logRequest(final HttpServletRequest request){
        Enumeration<String> attrs =  request.getParameterNames();
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        while(attrs.hasMoreElements()) {
            String e = attrs.nextElement();
            stringJoiner.add(e + " : " + request.getParameterValues(e)[0]);
        }
        log.info("IMPORTANT:\n" + stringJoiner.toString());
    }

    private Map<String, String> createNotificationData(final HttpServletRequest request) {
        Enumeration<String> attrs = request.getParameterNames();
        Map<String, String> data = new HashMap<>(request.getParameterMap().size());
        if (attrs.hasMoreElements()) {
            String e = attrs.nextElement();
            data.put(e, request.getParameter(e));
        }
        return data;
    }
}