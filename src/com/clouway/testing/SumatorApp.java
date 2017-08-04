package com.clouway.testing;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class SumatorApp {

    public static void main(String[] args) {

        Sumator sumator = new Sumator("An illegal argument has been detected!");
        System.out.println(sumator.sum("2.5","6.70"));
        System.out.println(sumator.sum("x","6.70"));
        System.out.println(sumator.sum(null,"6.70"));

    }

}
