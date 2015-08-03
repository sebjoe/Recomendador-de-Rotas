/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.geradorbasedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marlon
 */
public class EstacaoDao extends AbstractDao<Estacao>{
     
    private int numRow = 999;
    
    public EstacaoDao(){
        super(Estacao.class);
    }
    
     public List<Estacao> findParadasProximas(Double latitude, Double longitude, int numeroEstacoesProximas) throws SQLException, ClassNotFoundException {
         List<Estacao> estacoesProximas = new ArrayList<Estacao>();
         Class.forName("org.postgresql.Driver");
         Connection connection =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/estacoes", "postgres", "");
         String psql = "SELECT *, ST_Distance(geom::geography, 'SRID=4326;POINT("+longitude+" "+latitude+")'::geography) as dist_m "
                 + "FROM estacao ORDER BY geom <->'SRID=4326;POINT("+longitude+" "+latitude+")'::geometry LIMIT ?";
         PreparedStatement psQuery =  connection.prepareStatement(psql);
         psQuery.setInt(1, numeroEstacoesProximas);
         
         ResultSet res = psQuery.executeQuery();
         while(res.next()){
             estacoesProximas.add(new Estacao(res.getString("nome"), res.getString("latitude"), res.getString("longitude"), res.getInt("nivelacessibilidade")));
         }
         res.close();
         connection.close();
         return estacoesProximas;
     }
     
     public Estacao findEstacao(String estacaoParam) throws SQLException, ClassNotFoundException {
        String est [] = estacaoParam.split(" ");
        StringBuilder str = new StringBuilder();
        Estacao estacao = null;
        for(int i=0; i<est.length; i++){
            str.append(est[i]);
            getEstacao(str.toString());
            if(numRow==2){
                getEstacao(str.toString());
            }else if (numRow==1){
                estacao = getEstacao(str.toString());
                break;
            }
            if(i != est.length-1){
                str.append(" ");
            }
        }
//         System.out.println("dao "+estacao.getNome());
        return estacao;
     }
    
     private Estacao getEstacao(String estacaoParam) throws SQLException, ClassNotFoundException{
         Estacao estacao = new Estacao();
         Class.forName("org.postgresql.Driver");
         Connection connection =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/estacoes", "postgres", "");
         String psql = "SELECT * FROM estacao WHERE upper(nome) LIKE upper('"+estacaoParam+"%');";
//         System.out.println("SELECT * FROM estacao WHERE upper(nome) LIKE upper('"+estacaoParam+"%');");
         PreparedStatement psQuery =  connection.prepareStatement(psql);
         
         ResultSet res = psQuery.executeQuery();
         while(res.next()){
             numRow = res.getRow();
             estacao.setId(res.getLong("id"));
             estacao.setLatitude(res.getString("latitude"));
             estacao.setLongitude(res.getString("longitude"));
             estacao.setNivelAcessibilidade(res.getInt("nivelacessibilidade"));
             estacao.setNome(res.getString("nome"));
         }
         res.close();
         connection.close();
         return estacao;
     }
}
