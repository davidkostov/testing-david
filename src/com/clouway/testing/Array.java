package com.clouway.testing;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Array {

    private Integer[] contents;

    public Array(Integer[] contents) {
        this.contents = contents;
    }

    /**
     * prints the contents of the array
     */
    public void printArray() {
        for (int i = 0; i < contents.length; i++) {
            if (i + 1 == contents.length) {
                System.out.print(contents[i] + " ");
            } else {
                System.out.print(contents[i] + ", ");
            }
        }
    }

    /**
     * @return the sum of all elements in the array
     */
    public Integer getSum() {
        Integer sum = 0;
        for (Integer x : contents) {
            sum += x;
        }
        return sum;
    }

    /**
     * @return the minimum element of the array
     */
    public Integer getMinElement() {
        Integer minElement = contents[0];
        for (Integer x : contents) {
            if (x < minElement) {
                minElement = x;
            }
        }
        return minElement;
    }

}
