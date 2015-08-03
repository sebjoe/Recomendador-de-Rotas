/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modification;

import entity.Estacao;

/**
 * This class is the vote of a location made by a user
 * @author sebastien
 */
public class RateLocation {
    private int rate;
    private String latitude;
    private String longitude;
    
    /**
     * This constructor put a rate to a location
     * @param rate
     * @param latitude
     * @param longitude 
     */
    public RateLocation(int rate, String latitude, String longitude){
        this.rate = rate;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getRate() {
        return rate;
    }
    
    
    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
    
    /**
     * Allow to see if a location is in the range of delta
     * @param delta the radius
     * @param estacao the origin
     * @return 
     */
    public boolean inTheRangeOfDelta(double delta, Estacao estacao){
        if((Double.parseDouble (estacao.getLatitude()) - delta) < Double.parseDouble(latitude)
                && (Double.parseDouble (estacao.getLatitude()) + delta) > Double.parseDouble(latitude) ){
            if (Double.parseDouble(longitude) < (Double.parseDouble(estacao.getLongitude()) + delta)
                    && Double.parseDouble(longitude) > (Double.parseDouble(estacao.getLongitude()) - delta)) {
                return true;
            }
            return false;            
        }
        return false;
    }

    public String toString(){
        return "For lat: "+latitude+" long: "+longitude+" rate: "+rate;
        
    }
    
    
}

