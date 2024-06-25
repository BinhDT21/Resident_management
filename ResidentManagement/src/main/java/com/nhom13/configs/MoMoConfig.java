package com.nhom13.configs;

import com.mservice.shared.sharedmodels.Environment;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class MoMoConfig {
    public static Environment environment;
    public static final String moMoApiUrl = "https://test-payment.momo.vn/v2/gateway/api";
    public static final String partnerCode = "MOMOLRJZ20181206";
    public static final String accessKey = "mTCKt9W3eU1m39TW";
    public static final String secretKey = "SetA5RDnLHvt51AULf51DyauxUo3kDU6";
    public static final String moMoPayUrl = "https://test-payment.momo.vn";

    public static String signHmacSHA256(String data) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        return Hex.encodeHexString(sha256_HMAC.doFinal(data.getBytes("UTF-8")));
    }

    public static boolean validateSignature(String signature) {
        return false;
    }

    public static String buildUrlPayment(String data) {
        return moMoApiUrl + "?" + data;
    }
}
