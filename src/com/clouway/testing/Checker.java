package com.clouway.testing;

import java.util.Optional;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Checker {

    public StockType getTypeIfExists(String type, Inventory inventory) {
        Optional<StockType> possibleType = inventory.findStockTypeByName(type);
        if(!possibleType.isPresent()){
            throw new IllegalArgumentException(String.format
                    ("Requested stock type '%s' was unknown.", type));
        }
        return possibleType.get();
    }

    public Stock getStockIfExists(String stock, Inventory inventory){
        Optional<Stock> possibleStock = inventory.findStockByName(stock);
        if(!possibleStock.isPresent()){
            throw new IllegalArgumentException(String.format
                    ("Requested stock '%s' was unknown.", stock));
        }
        return possibleStock.get();
    }

}
