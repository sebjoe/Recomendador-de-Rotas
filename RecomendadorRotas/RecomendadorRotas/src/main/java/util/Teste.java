/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import entity.Rota;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marlon
 */
public class Teste {


/**
 *
 * @author marlon
 */
    
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, MalformedURLException, InterruptedException {
//        Date time = new Date();
//        System.out.println(time.getTime()/1000);
//        
        Recomendador rec = new Recomendador();
        
//        
//        List<Rota> rotas = rec.getJson("Estação Tubo UTFPR, Rebouças, Curitiba - Paraná, Brasil", "Estação Tubo Profª. Maria Aguiar Teixeira", 3).getRotas();
//        
//        
//        for(int i=0; i<rotas.size(); i++){
//            System.out.println("ORIGEM");
//            System.out.println(rotas.get(i).getEstacaoTuboOrigem().getNome());
//            System.out.println(rotas.get(i).getEstacaoTuboOrigem().getDistancia());
//            System.out.println(rotas.get(i).getEstacaoTuboOrigem().getNivelAcessibilidade());
//            
//            for(int j=0; j<rotas.get(i).getTravel_detail().size(); j++){
//                System.out.println(rotas.get(i).getTravel_detail().get(j).getArrival_stop().getNome());
//                System.out.println(rotas.get(i).getTravel_detail().get(j).getArrival_stop().getNivelAcessibilidade());
//                
//                System.out.println(rotas.get(i).getTravel_detail().get(j).getHtml_instruction());
//                
//                System.out.println(rotas.get(i).getTravel_detail().get(j).getDeparture_stop().getNome());
//                System.out.println(rotas.get(i).getTravel_detail().get(j).getDeparture_stop().getNivelAcessibilidade());
//            }
//            
//            System.out.println("DESTINO");
//            System.out.println(rotas.get(i).getEstacoTuboDestino().getNome());
//            System.out.println(rotas.get(i).getEstacoTuboDestino().getDistancia());
//            System.out.println(rotas.get(i).getEstacoTuboDestino().getNivelAcessibilidade());
//            
//            System.out.println(rotas.get(i).getTempoViagem());
//            System.out.println(rotas.get(i).getMediaNivelAcessRota());
//            
//            System.out.println("================================ \n");
//        }
        
        
        
    }
}
//http://maps.googleapis.com/maps/api/directions/json?origin=Estação Tubo UTFPR, Rebouças, Curitiba - Paraná, Brasil&destination=Estação Tubo Mercês, Mercês, Curitiba - Paraná, Brasil&language=pt-BR&sensor=false&mode=transit&departure_time=12