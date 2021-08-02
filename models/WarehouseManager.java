package models;

import java.util.ArrayList;

/**
 * Clase necesaria para rompre el ciclo de Almacen con Vacunas
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WarehouseManager {
    // instance variables - replace the example below with your own
    private Warehouse warehouse;

    /**
     * Constructor for objects of class GestorAlmacen
     */
    public WarehouseManager() {
        this.warehouse = new Warehouse();
    }

    public boolean remove(String name, Article article) {
        return this.getWarehouse().eliminar(name, article);
    }

    private Warehouse getWarehouse() {
        return this.warehouse;
    }

    public void add(String name, ArrayList<Article> article) {
        this.getWarehouse().insertar(name, article);
    }

    public void add(String name, Article article) {
        this.getWarehouse().insertar(name, article);
    }
}
