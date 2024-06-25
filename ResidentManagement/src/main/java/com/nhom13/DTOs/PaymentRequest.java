package com.nhom13.DTOs;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class PaymentRequest {
    private String partnerCode;
    private String requestId;
    private String orderId ;
    private String orderInfo;
    private Long amount;
    private String redirectUrl;
    private String ipnUrl;
    private String requestType;
    private String extraData;
    private String lang;
    private String signature;
}
