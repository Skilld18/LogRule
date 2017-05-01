package com.example.rdunk.logrule;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rdunk on 01/05/17.
 */
public class CalculatorTest {
    public double epsilon = 0.00000001;

    @Test
    public void calc_doyle_bdft() throws Exception {
        assertEquals(1.5, Calculator.calc_doyle_bdft(6,6), epsilon);

    }

}