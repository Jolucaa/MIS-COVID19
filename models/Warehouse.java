package models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author (your name)
 * @version (a version number or a date)
 */
public class Warehouse {
    // instance variables - replace the example below with your own
    private HashMap<String, List<Item>> items;

    public Warehouse() {
        this.items = new HashMap<>();
    }

    public int getNumberItems() {
        return this.getItems().values().size();
    }

    private HashMap<String, List<Item>> getItems() {
        return this.items;
    }

    public void add(String itemName, Item item) {
        this.getCollection(itemName).add(item);
    }

    public List<Item> getCollection(String nombre) {
        return this.getItems().get(nombre);
    }

    public void add(String itemName, List<Item> item) {
        this.getItems().put(itemName, item);
    }

    public Item getItem(String name, Item item) {

        Iterator<Item> iterator = this.getCollection(name).iterator();
        return this.searchItem(iterator, item);
    }

    private Item searchItem(Iterator<Item> iterator, Item searchedItem) {
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item == searchedItem) {
                return item;
            }
        }
        return null;
    }

    public boolean remove(String nombre, Item item) {
        return this.getCollection(nombre).remove(item);
    }
}
