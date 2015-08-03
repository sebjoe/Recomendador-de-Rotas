/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author marlon
 */
public class JsonModel implements Serializable{
    
    
    
    private List<Rota> rotas;
    

    public JsonModel(List<Rota> rotas) {
        this.rotas = rotas;
    }

    public List<Rota> getRotas() {
        return rotas;
    }

    public void setRotas(List<Rota> rotas) {
        this.rotas = rotas;
    }
    
}
