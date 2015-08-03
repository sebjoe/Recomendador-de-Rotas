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
 *
 * @author sebastien
 */
public class AccessLevelMatrix {

    public static List<RateBusStop> accessLevelMatrix = new ArrayList<RateBusStop>();
    
    /**
     * Acces Level Matrix of all the station in the System
     */
    public AccessLevelMatrix() {
        
        
        double sumE = 0;
        int cpt = 0;
        //System.out.println("EstacaoDao.allStations size "+EstacaoDao.allStations.size());
        //System.out.println("User.users size : "+User.users.size());
        int i = 0;
        int j = 0;
        int k = 0;

        
        for (Estacao estacao : EstacaoDao.allStations){  
            //System.out.println("i => "+i);i++;
            for(User user : User.users){
//                System.out.println("jj => "+j);j++;
//                System.out.println("user.ratesLocation.getRateLocations() : "+user.ratesLocation.getRateLocations().size());
                for(RateLocation rateLocation : user.ratesLocation.getRateLocations()){
//                    //System.out.println("3I For");
//                    System.out.println("kkk => "+k);k++;
//                    System.out.println("estacao lat = "+estacao.getLatitude());
                    if(rateLocation.inTheRangeOfDelta(0.000050, estacao)){                        
                        sumE = sumE + rateLocation.getRate();
                        cpt = cpt +1; 
                        //System.out.println("CPT : "+cpt+" rateLocation.getRate()"+rateLocation.getRate());
                    }
                }k=0;
            }//j=0;

            if(sumE == 0.0 || cpt == 0){
                accessLevelMatrix.add(new RateBusStop(0, estacao));
                sumE = 0;
                cpt = 0;
            }
            else{
                double c = sumE/cpt;
                //System.out.println("Estacao : "+estacao.getNome()+"SumE : "+sumE+" cpt :"+cpt+" division :"+c);
                //System.out.println("Estacao : "+estacao.getNome());
                accessLevelMatrix.add(new RateBusStop(c, estacao));
                sumE = 0;
                cpt = 0;
            }
            
        }
        
    }
    
    

}
