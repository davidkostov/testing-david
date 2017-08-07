package com.clouway.testing;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class ArrayApp {

    public static void main(String[] args) {
        Integer[] arr = {2,3,-7,0,-2};
        Array array = new Array(arr);
        System.out.println("The array: ");
        array.printArray();
        System.out.println("has "+array.getMinElement()+" as a minimum element\n" +
                "and the sum of its elements is "+array.getSum()+".");
    }

}
