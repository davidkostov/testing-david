package com.clouway.testing;

import java.math.BigDecimal;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Sumator {

    private final String illegalArgumentMessage;

    public Sumator(String illegalArgumentMessage) {
        this.illegalArgumentMessage = illegalArgumentMessage;
    }

    /**
     * Summs two numbers
     *
     * @param a first number
     * @param b second number
     * @return the sum of a and b
     */
    public String sum(String a, String b) {
        try {
            return new BigDecimal(a).add(new BigDecimal(b)).toString();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(illegalArgumentMessage);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(illegalArgumentMessage);
        }
    }

}
