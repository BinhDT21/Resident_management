package com.nhom13.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MoMoConfig {
    public static final String moMoApiUrl = "https://test-payment.momo.vn/v2/gateway/api";
    public static final String partnerCode = "MOMOLRJZ20181206";
    public static final String accessKey = "mTCKt9W3eU1m39TW";
    public static final String secretKey = "SetA5RDnLHvt51AULf51DyauxUo3kDU6";
    public static final String moMoPayUrl = "https://test-payment.momo.vn";
}
