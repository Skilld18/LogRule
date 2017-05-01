package com.example.rdunk.logrule;

import static java.lang.Math.pow;

/**
 * Created by rdunk on 01/05/17.
 */

public class Calculator {

    public static double calc_doyle_bdft(int width, int length){
        return pow((width - 4) / 4.0f,2) * length;
    }
}
