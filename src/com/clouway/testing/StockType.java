package com.clouway.testing;

import java.util.Objects;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class StockType {

    private String name;
    private Integer maxQuantity;
    private Integer quantity;

    public StockType(String name, Integer maxQuantity) {
        this.name = name;
        this.maxQuantity = maxQuantity;
        quantity = 0;
    }

    public void amendQuantity(Integer quantity) {
        this.quantity += quantity;
    }

    public String getName() {
        return name;
    }

    public boolean hasEnoughQuantity(Integer quantityToCheck) {
        if (quantity - quantityToCheck < 0) {
            return false;
        }
        return true;
    }

    public boolean isFull() {
        if (quantity <= maxQuantity) {
            return false;
        }
        return true;
    }

    public boolean overMaxQuantity(Integer quantityToCheck) {
        if (quantityToCheck + quantity <= maxQuantity) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockType stockType = (StockType) o;
        return Objects.equals(name, stockType.name) &&
                Objects.equals(maxQuantity, stockType.maxQuantity) &&
                Objects.equals(quantity, stockType.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxQuantity, quantity);
    }
}

