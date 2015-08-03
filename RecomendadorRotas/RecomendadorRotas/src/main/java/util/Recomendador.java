/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import entity.Estacao;
import entity.EstacaoTubo;
import entity.GoogleDirectionsObject;
import entity.GsonDistanceMatrix;
import entity.GsonGeocode;
import entity.JsonModel;
import entity.Rota;
import entity.TravelDetail;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.EstacaoDao;
import modification.AccessLevelMatrix;
import modification.ComparadorAlgo;
import modification.GenerateFakeData;

/**
 *
 * @author marlon
 */
public class Recomendador {
    
    private InputStream is;
    private Date time;
    private Gson gson;
    private EstacaoDao dao;
    private  List<Estacao> estacoesProximasOrigem;
    private List<Estacao> estacoesProximasDestino;
    private List<EstacaoTubo> estacoTuboOrigem;
    private List<EstacaoTubo> estacaoTuboDestino;
    private JsonModel jsonModel;
    
    public Recomendador() {
        this.is = null;
        this.gson = new Gson();
        this.time = new Date();
        dao = new EstacaoDao();
       
    }
    
    //0- Metodo que chama todos os outros metodos
    public JsonModel getJson(String origem ,String destino, int numeroEstacoes) {

        //trasforma origem/destino em latLng
        String origemLatLng = getLatLong(origem);
        String destinoLatLng = getLatLong(destino);
        
        //recebe as 3 estações tubos mais prxóimas segundo o postgis
        this.estacoesProximasOrigem = getEstacoesTuboProximas(origemLatLng, numeroEstacoes);
        this.estacoesProximasDestino = getEstacoesTuboProximas(destinoLatLng, numeroEstacoes);
        
        //recebe as 3 estações tubos mais próximas com os valores gerados pela API do MAPS
        this.estacoTuboOrigem = getDistanciaPe(origemLatLng, getTodasLatLngEstacoesProximas(this.estacoesProximasOrigem), estacoesProximasOrigem);
        this.estacaoTuboDestino = getDistanciaPe(destinoLatLng, getTodasLatLngEstacoesProximas(this.estacoesProximasDestino), estacoesProximasDestino);
        
        //Para ordenar o resultado por ordem
        List<Rota> rotas = tracarNoveRotas(estacoTuboOrigem, estacaoTuboDestino);
//        Comparador comparador = new Comparador();
//        Collections.sort(rotas, comparador);
        
        
        
        System.out.println("\n\nooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
        
        // BEGIN MODIFICATION
        
        //System.out.println("Size rotas :"+rotas.size());
        try {
            dao.getAllStation();            
        } catch (SQLException ex) {
            Logger.getLogger(Recomendador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("/n/nEEEEERRRR :"+ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Recomendador.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("/n/nEEEEERRRR :"+ex);
        }
        
        //Generate the fake users with profils and rates
        GenerateFakeData generateFakeData = new GenerateFakeData();
        
        //Calculate the accessibility level matrix        
        AccessLevelMatrix accessLevelMatrix = new AccessLevelMatrix();
        
        ComparadorAlgo comp = new ComparadorAlgo();
        Collections.sort(rotas, comp);
     
        
        System.out.println("\n\nACAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        
        
        
        // END MODIFICATION 
       
        
        //retorna um JSon com as 9 rotas e seus dados
        return new JsonModel(rotas);
    }
    
    //1- Pega o endereço de origem/destino da interface e transforma em Lat e Lng.
    //Passa um endereço
    //Retorna sua lat e lng.
    //OBS: A URL para a api geocode, está usando como parametro a cidade de curitiba, ou seja, independente do que for digitado, se é outra cidade ou não
    //a api tentará buscar algo parecido com o resultado e jogando a lat e lng para dentro da cidade de curitiba
    private String getLatLong(String endereco) {
        System.out.println("ENDEREÇO: "+endereco);
        try {
            this.is = new URL("http://maps.google.com/maps/api/geocode/json?address="+ getStringSemEspaco(endereco) +"&components=country:BR|administrative_area:Curitiba&sensor=false").openStream();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Recomendador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Recomendador.class.getName()).log(Level.SEVERE, null, ex);
        }
        GsonGeocode gsonGeocode = gson.fromJson(readAll(this.is), GsonGeocode.class);
        if(gsonGeocode.getStatus().equals("OK")){
            System.out.println("Lat/Long: "+gsonGeocode.getResults().get(0).getGeometry().getLocation().getLat()+","+gsonGeocode.getResults().get(0).getGeometry().getLocation().getLng());
            return gsonGeocode.getResults().get(0).getGeometry().getLocation().getLat()+","+gsonGeocode.getResults().get(0).getGeometry().getLocation().getLng();
        }else
            return "Erro ao buscar Latitude e Longitude";
    }
        
    //2- Pega as 3 Estaçãoes Tubos Proximas da latLng de acordo com o Postgis
    private List<Estacao> getEstacoesTuboProximas(String latLng, int numeroEstacoes) {
        //Separa a lat e lng em 2 variavies do tipo double
        String latLngVet[] = latLng.split(","); 
        Double lat = Double.parseDouble(latLngVet[0]);
        Double lng = Double.parseDouble(latLngVet[1]);
        try {
            //retorna estacoesProximasOrigem recebe do postgis uma lista das estacoes proximas
            for(Estacao est : dao.findParadasProximas(lat, lng, numeroEstacoes))
                System.out.println("Estação próxima: "+est.getNome());
            return dao.findParadasProximas(lat, lng, numeroEstacoes);
        } catch (SQLException ex) {
            Logger.getLogger(Recomendador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Recomendador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //3- Passa LatLng de uma origem e a LatLon de um destino 
    //Retorna a distancia entre eles e o tempo a pé
    private List<EstacaoTubo> getDistanciaPe(String origem, String destino, List<Estacao> estacao){
        try {
            this.is = new URL("http://maps.googleapis.com/maps/api/distancematrix/json?origins=" + origem + "&destinations=" + destino + "&mode=walking&language=pt-BR&sensor=false").openStream();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Recomendador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Recomendador.class.getName()).log(Level.SEVERE, null, ex);
        }
        GsonDistanceMatrix gsonDistanceMatrix = gson.fromJson(readAll(this.is), GsonDistanceMatrix.class);
        if(gsonDistanceMatrix.getStatus().equals("OK"))
            return setEstacaoTuboValues(gsonDistanceMatrix, estacao);
        else
            return null;
    
    }
    //4- Recebe por parametro um objeto GsonDistanceMatrix e uma Lista de estação
    //retorna uma lista de estação tubo, contendo lat, lng, distancia e duracao
    //Esse metodo cria um json com as listas
    private List<EstacaoTubo> setEstacaoTuboValues(GsonDistanceMatrix gsonDistanceMatrix, List<Estacao> estacao) {
        List<EstacaoTubo> estacoes = new ArrayList<EstacaoTubo>();
        for(int i=0; i<estacao.size(); i++){
            estacoes.add(new EstacaoTubo(estacao.get(i).getNome(), 
                    estacao.get(i).getLatitude(), estacao.get(i).getLongitude(), 
                    estacao.get(i).getNivelAcessibilidade(), metrosParaKm(gsonDistanceMatrix.getTextDistance(0, i)), gsonDistanceMatrix.getTextDuration(0, i)));
        }
        return estacoes;
    }
    
    //5- Traça as 9 rotas possiveis entre origem e destino
    private List<Rota> tracarNoveRotas(List<EstacaoTubo> origem, List<EstacaoTubo> destino) {
        List<Rota> rotas = new ArrayList<Rota>();
        for(int i=0; i<origem.size(); i++){
            for(int j=0; j<destino.size(); j++){
                 rotas.add(getRota(origem.get(i), destino.get(j)));
            }
        }
        return rotas;
    } 
    
    //6- Passa o nome da estação tubo de origem e o nome da estação tubo destino
    //Retorna uma rota de ônibus com seus valores dados pela API do MAPS
    private Rota getRota(EstacaoTubo estacaoTuboOrigem, EstacaoTubo estacaoTuboDestino) {
        try {
            Rota rota = new Rota();
            rota.setEstacaoTuboOrigem(estacaoTuboOrigem);
            rota.setEstacaoTuboDestino(estacaoTuboDestino);
            double numEstacoesTubo = 2;
            double totalNivelAcessibilidade = rota.getEstacaoTuboOrigem().getNivelAcessibilidade() + rota.getEstacaoTuboDestino().getNivelAcessibilidade();;
            
            rota.setTravel_detail(new ArrayList<TravelDetail>());
            TravelDetail travel = new TravelDetail();
            this.is = new URL("http://maps.googleapis.com/maps/api/directions/json?origin="+getStringSemEspaco(rota.getEstacaoTuboOrigem().getNome())+"&destination="+getStringSemEspaco(rota.getEstacaoTuboDestino().getNome())+"&language=pt-BR&sensor=false&mode=transit&departure_time="+this.time.getTime()/1000).openStream();
            
            Gson gson = new Gson();
            TypeToken<GoogleDirectionsObject> tokenPoint = new TypeToken<GoogleDirectionsObject>() {};
            GoogleDirectionsObject user = gson.fromJson(readAll(this.is), tokenPoint.getType());
            
            Thread.sleep(2500);
            if(user.getStatus().equals("OK")){
                for(int a=0; a<user.getRoutes().size(); a++){
                    for(int b=0; b<user.getRoutes().get(a).getLegs().size(); b++){
                        //aqui seta o valor da duração da viagem dessa rota
                        rota.setTempoViagem(user.getRoutes().get(a).getLegs().get(b).getDuration().getText());
                        for(int c=0; c<user.getRoutes().get(a).getLegs().get(b).getSteps().size(); c++){
                            try{
                                travel.setDeparture_stop(dao.findEstacao(user.getRoutes().get(a).getLegs().get(b).getSteps().get(c).getTransit_details().getDeparture_stop().getName()));
                                totalNivelAcessibilidade += travel.getDeparture_stop().getNivelAcessibilidade();
                                numEstacoesTubo++;
                                System.out.println("TRY Nivel "+totalNivelAcessibilidade + " Num Est "+numEstacoesTubo);
                                System.out.println("\n Nome  === "+travel.getDeparture_stop().getNome());
                            } catch(java.lang.NullPointerException e){
                                System.out.println("DEU ERRO NO 1 TRY :"+e.toString());
                                travel.setDeparture_stop(new Estacao("Sem Informação", "Sem Informação", "Sem Informação", 0));
//                                System.out.println(travel.getDeparture_stop().getNome());
                            } catch (SQLException ex) {
                                Logger.getLogger(Recomendador.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(Recomendador.class.getName()).log(Level.SEVERE, null, ex);
                            }try{
                                travel.setHtml_instruction(user.getRoutes().get(a).getLegs().get(b).getSteps().get(c).getHtml_instructions());
                            }catch (java.lang.NullPointerException e){
                                System.out.println("DEU ERRO NO 2 TRY");
                                travel.setHtml_instruction("Sem Informação");
                            }try{
                                travel.setArrival_stop(dao.findEstacao(user.getRoutes().get(a).getLegs().get(b).getSteps().get(c).getTransit_details().getArrival_stop().getName()));
                                totalNivelAcessibilidade += travel.getArrival_stop().getNivelAcessibilidade();
                                numEstacoesTubo++;
                                System.out.println("TRY Nivel "+totalNivelAcessibilidade + " Num Est "+numEstacoesTubo);
                                System.out.println("\n Nome  === "+travel.getArrival_stop().getNome());
                            }catch (java.lang.NullPointerException e){
                                System.out.println("DEU ERRO NO 3 TRY");
                                travel.setArrival_stop(new Estacao("Sem Informação", "Sem Informação", "Sem Informação", 0));
                            } catch (SQLException ex) {
                                Logger.getLogger(Recomendador.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(Recomendador.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            rota.getTravel_detail().add(travel);
                            travel = new TravelDetail();
                        }
//                        System.out.println("Total Nivel "+totalNivelAcessibilidade + " Media "+totalNivelAcessibilidade/numEstacoesTubo);
                        rota.setMediaNivelAcessRota(totalNivelAcessibilidade/numEstacoesTubo);
                    }
                }
                return rota;
            }else
                return null;
        } catch (MalformedURLException ex) {
            Logger.getLogger(Recomendador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Recomendador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Recomendador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //Passa uma string com espaços
    //Retorna uma string sem espaços
    private String getStringSemEspaco(String string){
        return string.replaceAll(" ", "%20");
    }
    
    //Faz leitura do JSon recebendo um Reader
    //Retorna uma string JSon
    private String readAll(InputStream is) {
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            return sb.toString();
        } catch (IOException ex) {
            Logger.getLogger(Recomendador.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro ao ler JSon";
        }
    }
    
    //Passa uma lista de estação
    //Retorna somente as LatLng concatenados Lat,Lng|Lat,Lng|Lat,Lng
    private String getTodasLatLngEstacoesProximas(List<Estacao> estacoesProximas){
        StringBuilder str =new StringBuilder();
        for(int i=0; i<estacoesProximas.size(); i++){
            str.append(estacoesProximas.get(i).getLatitude()+","+estacoesProximas.get(i).getLongitude());
            if(i != estacoesProximas.size()-1)
                str.append("|");
        }
        return str.toString();
    }
    
    
    //Converte metros em km
    private String metrosParaKm(String distancia){
        if(distancia.endsWith("km")){
            return distancia;
        }else{
            DecimalFormat df = new DecimalFormat("0.0##");
            String metros = distancia.replaceAll(" m", "");
            double km = Double.parseDouble(metros)/1000;
            return df.format(km)+" km";
        }
    }
}


//http://maps.google.com/maps/api/geocode/json?address=Estação Tubo Central, Curitiba - Paraná&components=country:BR|administrative_area:Curitiba&sensor=false
//http://54.200.173.96:8080/RecomendadorRotas/webresources/service/get/Estação Tubo Central, Centro, Curitiba - Paraná, Brasil/Estação Tubo UTFPR - Desembarque, Curitiba - Paraná, Brasil
//54.200.173.96:8080/RecomendadorRotas-1.0-SNAPSHOT/webresources/service/get/Estação Tubo Central, Centro, Curitiba - Paraná, Brasil/Estação Tubo UTFPR - Desembarque, Curitiba - Paraná, Brasil