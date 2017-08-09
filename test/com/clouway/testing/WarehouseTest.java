package com.clouway.testing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class WarehouseTest {

    private Warehouse warehouse = new Warehouse(new ArrayList<StockType>(Arrays.asList(
            new StockType("Food", 500),
            new StockType("Clothing", 300),
            new StockType("Electronics", 200)
    )));

    @Test
    public void sellStockWorks() {
        warehouse.receive(new Stock("Food", "Potatoes", 350, 1.80, "kg"));
        warehouse.sell("Potatoes", 200);

        assertThat(warehouse.getInventory().findStockByName("Potatoes").get().getQuantity(), equalTo(150));
    }

    @Test(expected = IllegalStateException.class)
    public void notEnoughStockToSell() {
        warehouse.receive(new Stock("Food", "Potatoes", 350, 1.80, "kg"));

        warehouse.sell("Potatoes", 200);
        warehouse.sell("Potatoes", 160);
    }

    @Test(expected = IllegalStateException.class)
    public void receiveStockOverLimit() {
        warehouse.receive(new Stock("Clothing", "Pants", 100, 22.9, "piece"));
        warehouse.receive(new Stock("Clothing", "Jackets", 250, 35.8, "piece"));
    }

    @Test
    public void printProductsSortedByPriceWorks() {
        warehouse.receive(new Stock("Food", "Potatoes", 350, 1.80, "kg"));
        warehouse.receive(new Stock("Clothing", "Pants", 100, 22.9, "piece"));
        warehouse.receive(new Stock("Electronics", "Keyboards", 80, 15.7, "piece"));

        assertThat(warehouse.getStockSortedByPrice(),
                equalTo(new ArrayList<>(Arrays.asList(
                            new Stock("Food", "Potatoes", 350, 1.80, "kg"),
                            new Stock("Electronics", "Keyboards", 80, 15.7, "piece"),
                            new Stock("Clothing", "Pants", 100, 22.9, "piece")
                        ))));

    }

}
