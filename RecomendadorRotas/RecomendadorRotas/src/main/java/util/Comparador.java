/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import entity.Rota;
import java.util.Comparator;

/**
 *
 * @author marlon
 */
public class Comparador implements Comparator<Rota> {
    
    //para deixar em ordem crescente comparar sempre o primeiro obj com o segundo obj exemplo: o1.compareTo(o2)
    //para deixar em ordem decrescente comparar sempre o segundo obj com o primeiro obj exemplo: o2.compareTo(o1)
    
    public int compare(Rota o1, Rota o2) {  
       int mediaNivelAcessibilidade = String.valueOf(o2.getMediaNivelAcessRota()).compareTo(String.valueOf(o1.getMediaNivelAcessRota())); 
       if (mediaNivelAcessibilidade != 0) 
           return mediaNivelAcessibilidade; //Caso as medias sejam diferentes, ordena pela media.  
  
       //Se forem iguais, ordena pela estação mais próxima origem.  
       int distanciaOrigem = o1.getEstacaoTuboOrigem().getDistancia().compareTo(o2.getEstacaoTuboOrigem().getDistancia());  
       if (distanciaOrigem != 0) 
           return distanciaOrigem;   
       
       //Se forem iguais,  ordena pela estação mais próxima destino.  
       return o1.getEstacaoTuboDestino().getDistancia().compareTo(o2.getEstacaoTuboDestino().getDistancia());  
    }
}