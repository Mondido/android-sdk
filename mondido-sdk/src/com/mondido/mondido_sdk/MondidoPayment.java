package com.mondido.mondido_sdk;

import android.annotation.SuppressLint;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.apache.http.util.EncodingUtils;

import java.io.UnsupportedEncodingException;

public class MondidoPayment {

    private String paymentUrl;

    public MondidoPayment() {
        this("https://pay.mondido.com/v1/form");
    }

    public MondidoPayment(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void makeHostedPaymentWithResponseListener(final WebView webView, PaymentData paymentData, final MondidoPaymentListener paymentListener) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished (WebView view, String url) {
                if (url.contains("status=approved")) {
                    paymentListener.paymentSucess();
                } else if (url.contains("status=declined")) {
                    paymentListener.paymentFailed();
                } else if (url.equals(paymentUrl)) {
                    paymentListener.paymentStarted();
                } else {
                    paymentListener.paymentError();
                }
            }
        });
        try {
            String postString = paymentData.asPostDataString();
            webView.postUrl(paymentUrl, EncodingUtils.getBytes(postString, "BASE64"));
        } catch (UnsupportedEncodingException e) {
            Log.wtf("MondidoSdk", "What? No UTF-8 encoding?", e);
        }

    }

}
