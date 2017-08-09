package com.clouway.testing;

import java.util.*;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Inventory {

    private List<Stock> contents;
    private List<StockType> stockTypes;

    public Inventory(List<StockType> stockTypes) {
        contents = new ArrayList<>();
        this.stockTypes = stockTypes;
    }

    public void addStock(Stock newStock) {
        contents.add(newStock);
    }

    public List<Stock> getContents() {
        return contents;
    }

    public boolean hasStock(String name) {
        return findStockByName(name).isPresent();
    }

    public Optional<Stock> findStockByName(String stockName) {
        for (Stock each : contents) {
            if (each.getName().equals(stockName)) {
                return Optional.of(each);
            }
        }
        return Optional.empty();
    }

    public Optional<StockType> findStockTypeByName(String typeName) {
        for (StockType each : stockTypes) {
            if (each.getName().equals(typeName)) {
                return Optional.of(each);
            }
        }
        return Optional.empty();
    }

    public void sortByPrice() {
        contents.sort(Comparator.comparingDouble(Stock::getPrice));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(contents, inventory.contents) &&
                Objects.equals(stockTypes, inventory.stockTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contents, stockTypes);
    }
}
