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
public class CreditAccount  extends     Account
{
    InterestRate rate;
    
    public  CreditAccount(int id, String name, double amt, InterestRate rate )
    {
        super( id, name, amt );
        
        this.rate = rate;
    }

    @Override
    public double dedit(double amt)
    {
        if( super.availableBalance() - amt < 0 )
        {
            amt += (rate.rate()/100)*amt;
        }
        super.dedit(amt);
        return super.availableBalance();    
    }
}
