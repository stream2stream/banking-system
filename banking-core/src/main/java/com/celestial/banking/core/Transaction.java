/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celestial.banking.core;

import java.time.Instant;

/**
 *
 * @author Admin
 */
public class Transaction 
{
    private double  amount;
    private Instant when = Instant.now();
    
    public  Transaction( double amt )
    {
        amount = amt;
    }
    
    public double   getAmount()
    {
        return  amount;
    }
    
    public  String  getWhen()
    {
        return when.toString();
    }
}
