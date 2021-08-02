package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author (your name)
 * @version (a version number or a date)
 */
public class Warehouse {
    // instance variables - replace the example below with your own
    private HashMap<String, ArrayList<Article>> articulos;

    public Warehouse() {
        this.articulos = new HashMap();
    }

    public int getNumeroArticulos() {
        return this.getArticulos().values().size();
    }

    private HashMap<String, ArrayList<Article>> getArticulos() {
        return this.articulos;
    }

    public void insertar(String nombreArticulo, Article article) {
        this.getColeccion(nombreArticulo).add(article);
    }

    public ArrayList<Article> getColeccion(String nombre) {
        return this.getArticulos().get(nombre);
    }

    public void insertar(String nombreArticulo, ArrayList<Article> article) {
        this.getArticulos().put(nombreArticulo, article);
    }

    public Article getArticulo(String nombre, Article article) {

        Iterator iterador = this.getColeccion(nombre).iterator();
        return this.buscarArticulo(iterador, article);
    }

    private Article buscarArticulo(Iterator<Article> iterador, Article articleBuscado) {
        while (iterador.hasNext()) {
            Article article = iterador.next();
            if (article == articleBuscado) {
                return article;
            }
        }
        return null;
    }

    public boolean eliminar(String nombre, Article article) {
        return this.getColeccion(nombre).remove(article);
    }
}
