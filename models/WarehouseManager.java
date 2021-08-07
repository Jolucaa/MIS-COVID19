package models;


import java.util.List;

/**
 * Class needed to break cycle of Warehouse with Vaccine
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WarehouseManager {
    // instance variables - replace the example below with your own
    private Warehouse warehouse;

    /**
     * Constructor for objects of class WarehouseManager
     */
    public WarehouseManager() {
        this.warehouse = new Warehouse();
    }

    public boolean remove(String name, Item item) {
        return this.getWarehouse().remove(name, item);
    }

    private Warehouse getWarehouse() {
        return this.warehouse;
    }

    public void add(String name, List<Item> item) {
        this.getWarehouse().add(name, item);
    }

    public void add(String name, Item item) {
        this.getWarehouse().add(name, item);
    }
}
