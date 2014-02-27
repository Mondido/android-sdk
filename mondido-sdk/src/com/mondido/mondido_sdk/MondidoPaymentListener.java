package com.mondido.mondido_sdk;

public interface MondidoPaymentListener {

    public void paymentStarted();
    public void paymentSucess();
    public void paymentFailed();
    public void paymentError();
}
