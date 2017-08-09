package com.clouway.testing;

import java.util.*;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Warehouse {

    private final Inventory inventory;

    public Warehouse(List<StockType> stockTypes) {
        inventory = new Inventory(stockTypes);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public List<Stock> getStockSortedByPrice() {
        sortInventoryByPrice();
        return inventory.getContents();
    }

    public void receive(Stock newStock) {
        Checker checker = new Checker();
        StockType targetType = checker.getTypeIfExists(newStock.getType(),inventory);

        if (targetType.isFull() || targetType.overMaxQuantity(newStock.getQuantity())) {
            throw new IllegalStateException("'" + newStock.getType()
                    + "' - type is either full or cannot accept that much stock!");
        }

        if (inventory.hasStock(newStock.getName())) {
            Stock stock = checker.getStockIfExists(newStock.getName(),inventory);
            targetType.amendQuantity(newStock.getQuantity());
            stock.amendQuantity(newStock.getQuantity());
        }
        targetType.amendQuantity(newStock.getQuantity());
        inventory.addStock(newStock);

    }

    public void sell(String name, Integer quantity) {
        Checker checker = new Checker();
        Stock stock = checker.getStockIfExists(name,inventory);
        StockType targetType = checker.getTypeIfExists(stock.getType(),inventory);

        if (!targetType.hasEnoughQuantity(quantity)) {
            throw new IllegalStateException("There isn`t enough in stock from that item!");
        }

        targetType.amendQuantity(quantity * (-1));
        stock.amendQuantity(quantity * (-1));
    }

    public void sortInventoryByPrice() {
        inventory.sortByPrice();
    }


}
