/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celestial.banking.core;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public  class Account
{

    private final int id;
    private final String name;
    private double  balance;
    private final AbstractList<Transaction>  transactions = new ArrayList<>();
    
    public  Account( int id, String name, double amt )
    {
        this.id = id;
        this.name = name;
        
        credit( amt );
    }
     
    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public double availableBalance()
    {
        return balance;
    }

    public double currentbalance()
    {   
        double balance = 0;
        
        for( Transaction txn : transactions )
            balance += txn.getAmount();
        
        return balance;
    }
    
    public  double  credit( double amt )
    {
        balance += amt;
        transactions.add(new Transaction(amt));
        
        return  balance;
    }
    
    public  double  dedit( double amt )
    {
        balance += amt * -1;
        transactions.add(new Transaction(amt * -1));
        
        return  balance;
    }
}
