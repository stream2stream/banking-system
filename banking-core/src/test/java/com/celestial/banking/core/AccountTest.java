/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celestial.banking.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Admin
 */
public class AccountTest
{
    @Test
    public  void    test_does_balance_match_opening_amount_on_acount()
    {
        // arrange & act
        double  openingBalance = 56.78;
        
        Account acc = new Account( 1, "Selvyn", openingBalance);
        
        // assert
        assertEquals(openingBalance, acc.availableBalance());
        assertEquals(openingBalance, acc.currentbalance());        
    }

}
