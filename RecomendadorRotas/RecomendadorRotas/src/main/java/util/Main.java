/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import entity.Estacao;
import java.io.IOException;
import java.sql.SQLException;
import jpa.EstacaoDao;

/**
 *
 * @author marlon
 */
public class Main {
    
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        EstacaoDao dao = new EstacaoDao();
        
        
        for(Estacao estacaoProxima : dao.findParadasProximas(-25.4299755, -49.2675032, 5)){
            System.out.println(estacaoProxima.getNome()+estacaoProxima.getLatitude()+estacaoProxima.getLongitude()+estacaoProxima.getNivelAcessibilidade());
        }
    }
}
