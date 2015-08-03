/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modification;

import entity.Estacao;
import java.util.ArrayList;
import java.util.List;
import jpa.EstacaoDao;

/**
 * This class is mainly there to control the rates of a user. 
 * It has the list of all rate made by a user and also the location. 
 * @author sebastien
 */
public class RatesLocations {
    
    private List<RateLocation> rateLocations;
    
    /**
     * This constructor create a random list of vote for a user
     */
    public RatesLocations(){        
        rateLocations = new ArrayList<RateLocation>();
        for(Estacao estacao : EstacaoDao.allStations){
            rateLocations.add(new RateLocation(randomRate(), randomLatitude(estacao.getLatitude()),randomLongitude(estacao.getLongitude())));
        }
    }
    
    
    
    /**
     * Generate a random value between 1 and 3. 
     * @return the value
     */
    private int randomRate(){
        int lower = 1;
        int higher = 4;
        return (int)(Math.random() * (higher-lower)) + lower;
        
    }
    
    /**
     * This function generate a random latitude around -0.0000999 and 0.0000999
     * @param lat the reference latitude
     * @return a latitude between -0.0000999 and 0.0000999 of the ref lat
     */
    private String randomLatitude(String lat){
        double lower = -0.0000999;
        double higher = 0.0000999;
        double latDouble = Double.parseDouble(lat);
        double rand = (double)(Math.random() * (higher-lower)) + lower;
        double val = latDouble + rand;
        String latString = String.valueOf(val);
        return latString;
        
    }
    
    /**
     * This function generate a random longitude around -0.0000999 and 0.0000999
     * @param lon the reference longitude
     * @return a longitude between -0.0000999 and 0.0000999 of the ref lon
     */
    private String randomLongitude(String lon){
        double lower = -0.0000999;
        double higher = 0.0000999;
        double lonDouble = Double.parseDouble(lon);
        double rand = (double)(Math.random() * (higher-lower)) + lower;
        double val = lonDouble + rand;
        String lonString = String.valueOf(val);
        return lonString;
        
    }

    public List<RateLocation> getRateLocations() {
        return rateLocations;
    }
    
    
}
