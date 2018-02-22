package com.vistra.notification;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * The type Memory payment data storage service.
 *
 * @author Ming Li
 */
@Service
public class PaymentStorageService {

    private final Cache<String, CyberSourcePaymentStatus> CYBER_SOURCE_STORAGE = CacheBuilder.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES) .build();

    public void setCyberSourcePaymentStatus(final String referenceNumber, final CyberSourcePaymentStatus status) {
        CYBER_SOURCE_STORAGE.put(referenceNumber, status);
    }

    public CyberSourcePaymentStatus getCyberSourcePaymentStatus(final String referenceNumber) {
        return CYBER_SOURCE_STORAGE.getIfPresent(referenceNumber);
    }
}
