package com.clouway.testing;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Stock {
    private Integer quantity;
    private Double price;
    private String name;
    private String priceUnit;
    private String type;

    public Stock(String type, String name, Integer quantity, Double price, String priceUnit) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.priceUnit = priceUnit;
    }

    public void amendQuantity(Integer quantity) {
        this.quantity += quantity;
    }

    public String toString() {
        return name + " - " + quantity + " -> " +
                new DecimalFormat("0.#").format(price) + "$/" + priceUnit;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(quantity, stock.quantity) &&
                Objects.equals(price, stock.price) &&
                Objects.equals(name, stock.name) &&
                Objects.equals(priceUnit, stock.priceUnit) &&
                Objects.equals(type, stock.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, price, name, priceUnit, type);
    }
}
