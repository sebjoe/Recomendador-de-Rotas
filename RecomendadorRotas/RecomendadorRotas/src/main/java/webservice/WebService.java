/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webservice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.JsonModel;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import util.Recomendador;

/**
 * REST Web Service
 *
 * @author marlon
 */
@Path("service")
public class WebService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebService
     */
    public WebService() {
    }

    /**
     * Retrieves representation of an instance of webservice.WebService
     * @param origem
     * @param destino
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/get/{origem}/{destino}")
    @Produces("application/json")
    public String getEstacoesProximas(@PathParam("origem") String origem ,@PathParam("destino") String destino) throws IOException, SQLException, ClassNotFoundException, MalformedURLException, InterruptedException {
//        System.out.println("ORIGEM: "+origem + "\nDESTINO: "+destino);
        Recomendador recomendador = new Recomendador();
//        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.serializeSpecialFloatingPointValues();
//        Gson gson = gsonBuilder.setPrettyPrinting().create();
//        Gson gson = new Gson();
        Gson gson =  new GsonBuilder().serializeSpecialFloatingPointValues().setPrettyPrinting().create();
//        System.out.println(gson.toJson(processos.getJsonModel()));
        return gson.toJson(recomendador.getJson(origem, destino, 3), JsonModel.class);
    }
    /**
     * PUT method for updating or creating an instance of WebService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    @GET
    @Path("/aluno/{nome}/{idade}") 
    @Produces("text/html")
    public String helloFulano( @PathParam("nome") String nome ,@PathParam("idade") int idade ){
        return "<h1>Bem vindo " + nome + "</h1>" + "<h2>Sua idade: " + idade + "</h2>"; 
    }
}

