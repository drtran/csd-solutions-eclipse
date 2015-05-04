package com.bemach.labguide.common;

/**
 * Created by ktran on 4/25/2015.
 *
 * 'Bad practice to expose fields this way'
 *
 *  Always expose them, when required, with getters/setters for all
 *  mutable fields.
 *
 */
public class PaymentInfo {
    public String orderName = "Pet Lover";
    public String orderAddress = "123 Main Street\nBrooklyn, NY 10101";
    public String orderEmail = "petlover@email.com";
    public String orderPaymentType = "Check";
}
