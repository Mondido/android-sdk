package com.mondido.mondido_test_app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import com.mondido.mondido_sdk.MondidoPayment;
import com.mondido.mondido_sdk.MondidoPaymentListener;
import com.mondido.mondido_sdk.PaymentData;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        MondidoPayment mondidoPayment = new MondidoPayment();

        PaymentData testPaymentData = createTestPaymentData();
        mondidoPayment.makeHostedPaymentWithResponseListener((WebView)findViewById(R.id.webView), testPaymentData, new MondidoPaymentListener() {

            @Override
            public void paymentStarted() {
                Log.i("MondidoTest", "Payment started");
            }

            @Override
            public void paymentSucess() {
                Log.i("MondidoTest", "Payment success");
            }

            @Override
            public void paymentFailed() {
                Log.i("MondidoTest", "Payment failed");
            }

            @Override
            public void paymentError() {
                Log.i("MondidoTest", "Payment error");
            }
        });
    }

    private PaymentData createTestPaymentData() {
        PaymentData paymentData = new PaymentData();
        paymentData.setAmount("1.00");
        paymentData.setCurrency("SEK");
        paymentData.setMerchantId("5");
        paymentData.setOrderId("test1");
        paymentData.setTest("true");
        paymentData.setOrderId(generateRandomOrderId());
        paymentData.setSuccessUrl("https://mondido.com/success");
        paymentData.setErrorUrl("https://mondido.com/fail");
        paymentData.addMetadata("metadata[products][1][name]", "productName");
        paymentData.addMetadata("metadata[products][1][color]", "red");

        // In a real application, the hash would be fetched from server, and not generated in client
        // (since the client shouldn't have the secret
        paymentData.setHash(paymentData.createHash("$2a$10$5OGLq7v86uROMbF3Yfi3kO"));

        return paymentData;
    }

    private String generateRandomOrderId() {
        return "test" + (int)(Math.random() * 10000);
    }
}
