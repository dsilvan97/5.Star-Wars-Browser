package com.biogade.starwarsbrowse.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreadorArchivo {

    public void GenerarArchivo(SwapiPelis pelicula){
        System.out.println("Entró x2?");
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        // Especifica la carpeta existente
        String carpeta = "jsonscreated"; // Tu carpeta ya existente
        File directorio = new File(carpeta);

        // Sanitiza el nombre del archivo para evitar caracteres inválidos
        String nombreArchivo = pelicula.title().replaceAll("[\\\\/:*?\"<>|]", "_") + ".json";

        // Crea el archivo dentro de la carpeta jsonscreated
        File archivo = new File(directorio, (pelicula.episode_id() + ". " + pelicula.title() + ".json"));


        try {
            FileWriter escritura = new FileWriter(archivo);
            escritura.write(gson.toJson(pelicula));
            escritura.close();
        } catch (IOException e) {
            System.out.println("erroress");
            throw new RuntimeException(e);
        }

        System.out.println(pelicula.title());
    }
}
