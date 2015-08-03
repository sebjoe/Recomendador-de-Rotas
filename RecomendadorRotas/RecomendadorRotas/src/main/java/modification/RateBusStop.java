/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modification;

import entity.Estacao;

/**
 *
 * @author sebastien
 */
public class RateBusStop {
    private double averageRate;
    private Estacao estacao;
    
    /**
     * Put an average vote for a Bus Stop
     * @param averageRate The value of the rate
     * @param estacao the station that should have that value
     */
    public RateBusStop(double averageRate, Estacao estacao){
        
        this.averageRate = averageRate;
        this.estacao = estacao;
        //System.out.println("OUT");
    }

    public double getAverageRate() {
        return averageRate;
    }

    public Estacao getEstacao() {
        return estacao;
    }
    
    /**
     * Verify if two station are equals
     * @param estacao
     * @return 
     */
    public boolean equal(Estacao estacao){
        //System.out.println("me getNome : "+this.estacao.getNome()+" ===== "+estacao.getNome() );
        if(estacao != null){
            return estacao.getNome().contentEquals(this.getEstacao().getNome());
        }
        else{
            return false; 
        }
        
    }
}
