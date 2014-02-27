package com.mondido.mondido_sdk;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PaymentData {

    private String amount;
    private String currency;
    private String merchantId;
    private String orderId;
    private String hash;
    private String test;
    private String successUrl;
    private String errorUrl;
    private Map<String, String> metaData = new HashMap<String, String>();

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getErrorUrl() {
        return errorUrl;
    }

    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
    }

    public void addMetadata(String name, String value) {
        metaData.put(name, value);
    }


    //Hash should really be fetched from backend, this is for testing...
    public String createHash(String secret) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            String hashString = merchantId + orderId + amount + secret;
            byte[] array = md5.digest(hashString.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte anArray : array) {
                sb.append(Integer.toHexString((anArray & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            Log.wtf("MondidoSdk", "No such algorithm??", e);
        }
        return null;
    }

    String asPostDataString() throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("merchant_id=");
        stringBuilder.append(URLEncoder.encode(merchantId, "UTF-8"));
        stringBuilder.append("&amount=");
        stringBuilder.append(URLEncoder.encode(amount, "UTF-8"));
        stringBuilder.append("&currency=");
        stringBuilder.append(URLEncoder.encode(currency, "UTF-8"));
        stringBuilder.append("&order_id=");
        stringBuilder.append(URLEncoder.encode(orderId, "UTF-8"));
        stringBuilder.append("&hash=");
        stringBuilder.append(URLEncoder.encode(hash, "UTF-8"));
        stringBuilder.append("&success_url=");
        stringBuilder.append(URLEncoder.encode(successUrl, "UTF-8"));
        stringBuilder.append("&error_url=");
        stringBuilder.append(URLEncoder.encode(errorUrl, "UTF-8"));
        stringBuilder.append("&test=");
        stringBuilder.append(URLEncoder.encode(test, "UTF-8"));
        stringBuilder.append("&");
        stringBuilder.append(metadataAsPostDataString());
        return stringBuilder.toString();
    }

    private String metadataAsPostDataString() throws UnsupportedEncodingException {
        StringBuilder data = new StringBuilder();
        Set<String> keys = metaData.keySet();
        for (String key : keys) {
            if (data.length() != 0) {
                //Already data added, separate with "&"
                data.append("&");
            }
            data.append(URLEncoder.encode(key, "UTF-8"));
            data.append("=");
            data.append(URLEncoder.encode(metaData.get(key), "UTF-8"));
        }
        return data.toString();
    }
}
