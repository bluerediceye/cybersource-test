package com.vistra.notification;

/**
 * @author Ming Li
 */

public enum CyberSourcePaymentStatus {
    /**
     * Payment status is unknown
     */
    UNKNOWN,
    /**
     * Payment is complete and successful. Defined by CyberSource
     */
    ACCEPT,
    /**
     * Payment is declined. Defined by CyberSource
     */
    DECLINE,
    /**
     * Payment is under review. Defined by CyberSource
     */
    REVIEW,
    /**
     * Payment failed. Defined by CyberSource
     */
    ERROR,
    /**
     * Order waiting for payment
     */
    PENDING
}
