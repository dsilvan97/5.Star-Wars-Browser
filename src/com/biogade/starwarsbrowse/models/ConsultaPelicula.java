package com.biogade.starwarsbrowse.models;

import com.biogade.starwarsbrowse.exceptions.ErrorPeticionCorrectaException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPelicula {
    
    public void consultarPeli(String opcion){
        System.out.println("Entró");
        String link;

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        try{
            /*Se ajusta la opción ya que de la API la opción 1 no corresponde al capítulo 1, por lo que se acomoda para dar la información que se solicite
            por el usuario según nuestro menú anterior*/
            switch (opcion){
                case "1":
                    opcion = "4";
                    break;

                case "2":
                    opcion = "5";
                    break;

                case "3":
                    opcion = "6";
                    break;

                case "4":
                    opcion = "1";
                    break;

                case "5":
                    opcion = "2";
                    break;

                case "6":
                    opcion = "3";
                    break;

                case "7":
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    throw new ErrorPeticionCorrectaException("Petición incorrecta, vuelva a elegir porfavor...");
            }

            link = "https://swapi.py4e.com/api/films/" + opcion + "/";


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(link))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            SwapiPelis tomarPeli = gson.fromJson(json, SwapiPelis.class);

            Peliculas miPeli = new Peliculas(tomarPeli);

            System.out.println(miPeli);

            CreadorArchivo generador = new CreadorArchivo();
            generador.GenerarArchivo(tomarPeli);

        }catch (ErrorPeticionCorrectaException e){
            System.out.println(e.getMessage());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }




}
