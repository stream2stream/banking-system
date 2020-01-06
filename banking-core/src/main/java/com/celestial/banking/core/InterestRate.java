/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celestial.banking.core;

/**
 *
 * @author Admin
 */
public enum InterestRate
{
    HOME_LOAN( 5.67 ),
    BUSINESS_LOAN(2.34 );
    
    private final   double  rate;
    
    InterestRate(double rate)
    {
        this.rate = rate;
    }
    
    public  double  rate()
    {
        return rate;
    }
}
