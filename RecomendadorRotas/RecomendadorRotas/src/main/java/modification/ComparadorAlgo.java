/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modification;

import entity.Estacao;
import entity.Rota;
import entity.TravelDetail;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author sebastien
 */
public class ComparadorAlgo implements Comparator<Rota>{
    
    private final double delta = 0.000050; 
    static User c = new User("cReference");
    
    
    
    @Override
    public int compare(Rota o1, Rota o2) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        double r1_c_s;
        double r2_c_s;
       
        if(o1 != null ){
            System.out.println("ROUTE 1 :  ");
            System.out.println("Taille liste de bus stop : "+o1.getTravel_detail().size());
            r1_c_s = equationDois(o1);
            System.out.println("Temps :"+o1.getTempoViagem());
            //System.out.println("MediaNivelAcessRota :"+o1.getMediaNivelAcessRota());
            System.out.println("r1_c_s =  "+r1_c_s);
        }
        else{
            r1_c_s =0.0;
            System.out.println("ROUTE 1 :  NULL :( \n");
        }
        
        
        if(o2 != null ){
            System.out.println("\nROUTE 2 :  ");
            System.out.println("Taille liste de bus stop : "+o2.getTravel_detail().size());
            r2_c_s = equationDois(o2);
            System.out.println("Temps :"+o2.getTempoViagem());
            //System.out.println("MediaNivelAcessRota :"+o2.getMediaNivelAcessRota());
            System.out.println("r2_c_s =  "+r2_c_s+"\n");
        }
        else{
            r2_c_s =0.0;
            System.out.println("\nROUTE 2 :  NULL :( \n");
        }     
       
        return (int)r2_c_s - (int)r1_c_s;
       
    }
    
    
    /**
     * Find users who have similar profile
     * @return list of user similar to a reference user
     */
    public List<User> findSim(){        
        List<User> userSimList = new ArrayList<User>();
        for(User user: User.users){
            if(c.profile.isSimilar(user.profile)){
                userSimList.add(user);
            }
        }
        return userSimList;
    }
    
    
    

    
    public double equationUm(Estacao estacao){
        //System.out.println("AccessLevelMatrix.accessLevelMatrix size :"+AccessLevelMatrix.accessLevelMatrix.size());
        
        for (RateBusStop accessLevelMatrix : AccessLevelMatrix.accessLevelMatrix) {
            if(estacao != null){
                if(accessLevelMatrix.equal(estacao)){
                   // System.out.println("1111111111111 : equationUmVersionTwo");
                    //System.out.println("equationUmVersionTwo => estacao :"+estacao.getNome()+" averageRate : "+accessLevelMatrix.getAverageRate());
                    return accessLevelMatrix.getAverageRate();
                }
            }
        }
        return 0.0;
    }
    
    
    
    public double equationDois(Rota r){
        //System.out.println("\nequationDois => ");
        double sumR_c_s =0.0;
        double dep=0.0;
        double arri=0.0;
        for(int i = 0; i < r.getTravel_detail().size() ; i++){
            System.out.println(i);
            //System.out.println(r.getTravel_detail().get(i).getDeparture_stop().getNome());
            //System.out.println(r.getTravel_detail().get(i).getArrival_stop().getNome());
            if(r.getTravel_detail().get(i).getDeparture_stop() != null){
                if(r.getTravel_detail().get(i).getDeparture_stop().getNome() != null){
                    if(!r.getTravel_detail().get(i).getDeparture_stop().getNome().contains("Sem")){
                        System.out.println("nome Dep : "+r.getTravel_detail().get(i).getDeparture_stop().getNome());
                        dep = equationTres(r.getTravel_detail().get(i).getDeparture_stop());
                    }
                    else{
                        System.out.println("nome Dep : "+r.getTravel_detail().get(i).getDeparture_stop().getNome());                
                        dep = 0;
                    }
                
                    
                }
                else{
                    System.out.println("nome Dep : "+r.getTravel_detail().get(i).getDeparture_stop().getNome());                
                    dep = 0;
                }
            }
            else{
                System.out.println("nome Dep : "+r.getTravel_detail().get(i).getDeparture_stop().getNome());
                
                dep = 0;
            }
            
            if(r.getTravel_detail().get(i).getArrival_stop() != null){
                if(r.getTravel_detail().get(i).getArrival_stop().getNome() != null){
                    if(!r.getTravel_detail().get(i).getArrival_stop().getNome().contains("Sem")){
                        System.out.println("nome Arr : "+r.getTravel_detail().get(i).getArrival_stop().getNome());
                        arri = equationTres(r.getTravel_detail().get(i).getArrival_stop());
                    }
                     else {
                        System.out.println("nome Arr : "+r.getTravel_detail().get(i).getArrival_stop().getNome());
                        arri = 0;
                    }
                    
                }
                 else {
                    System.out.println("nome Arr : "+r.getTravel_detail().get(i).getArrival_stop().getNome());
                    arri = 0;
                }
                
            }
            else {
                System.out.println("nome Arr : "+r.getTravel_detail().get(i).getArrival_stop().getNome());
                arri = 0;
            }
            sumR_c_s = sumR_c_s + dep  + arri ;
            dep = 0.0;
            arri = 0.0;
            
        }
        
        //System.out.println("equationDois => sumR_c_s :"+sumR_c_s);
        return sumR_c_s;
    }
    
    
    
    public double equationTres(Estacao estacao){
        System.out.println("equationTres => ");
        double sumR_c_sj = 0;
        List<User> simList = findSim();
        //System.out.println("List Sim Taille = "+simList.size());
        
        double eqUm = 0;
        double simi = 0;       
        
        for(User cc : simList){
            //System.out.println("Profile : "+cc.profile.toString());
            if(estacao != null){
                eqUm = equationUm(estacao);
                simi = cosSim(cc);
                sumR_c_sj = sumR_c_sj + simi * eqUm;
                System.out.println("sumR_c_sj :"+sumR_c_sj+" eqUm "+eqUm+" simi :"+simi);
            }
           
        }
        
        
        System.out.println("Eq3 pour stop :"+estacao.getNome()+" est :"+sumR_c_sj);
        return sumR_c_sj;
    }
    
    
    
    
    
    // Set of function for the cosine similarity
    public double cosSim(User cc){
        double numerator = 0;
        
        for(int i = 0; i < cc.profile.getProfile().size(); i++){
            numerator = numerator + c.ratesLocation.getRateLocations().get(i).getRate() + cc.ratesLocation.getRateLocations().get(i).getRate();
        }
        double n1 = norme(c);
        double n2 = norme(cc);       
        return numerator/(n1*n2);       
        
    }
    
    
    public double norme(User c){
        double sum = 0;
        
        for(int i = 0; i < c.profile.getProfile().size(); i++){
             sum = (double) (sum + Math.pow(c.ratesLocation.getRateLocations().get(i).getRate(),2));
        }
        return Math.sqrt(sum);
    }

    
    
    
    
    
    
}
