package com.biogade.starwarsbrowse.models;

public class Peliculas {

    private String nombre;
    private int numeroPelicula;
    private String fecha;
    private String director;
    private String productor;
    private String resumen;

    public Peliculas(SwapiPelis peli){
        this.nombre = peli.title();
        this.numeroPelicula = Integer.valueOf(peli.episode_id());
        this.fecha = peli.release_date();
        this.director = peli.director();
        this.productor = peli.producer();
        this.resumen = peli.opening_crawl();
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return  "******************************************************************\n\nCAPITULO ENCONTRADO:\n\n" +
                "Nombre: " + this.nombre + "\nCapítulo: " + this.numeroPelicula + "\nDirector: " + this.director +
                "\nProducido por: " + this.productor + "\nFecha: " + this.fecha + "\n\nResumen:\n" + this.resumen +
                "\n\n******************************************************************";
    }
}