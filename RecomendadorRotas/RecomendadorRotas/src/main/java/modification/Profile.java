/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modification;

import java.util.ArrayList;
import java.util.List;


/**
 * Profile of a user. With this we know the need of a user
 * For now it is just a array of 0 and 1. In the future we can create a enumType. 
 * @author sebastien
 */
public class Profile {
    private List<Integer> profileList;
    
    /**
     * For now lets imagine that a profile is a list of 0 and 1 with 2 frame.
     * 1 if the user need the element 0 otherwise
     * |Beep | Tactile Floor|
     * This constructor just create a random profile
     */
    public Profile(){
        profileList = new ArrayList<Integer>();
        for(int i = 0; i<3; i++){
            profileList.add(randomProfile());            
        }
    }

    public List<Integer> getProfile() {
        return profileList;
    }
    
    /**
     * Generate a random value between 0 and 1.
     * @return the value
     */
    private int randomProfile(){
        int lower = 0;
        int higher = 2;
        return (int)(Math.random() * (higher-lower)) + lower;
        
    }
    
    /**
     * Check if two profile are similar
     * @param inProfil : the profile with who we wan to compare.
     * @return true if the profiles are similar else false
     */
    public boolean isSimilar(Profile inProfil){
        for(int i = 0; i < profileList.size();i++){
            if (inProfil.getProfile().get(i) != profileList.get(i)){
                return false;
            }
        }
        return true;
    }
    
    public String toString(){
        
        StringBuilder c = new StringBuilder();  
        c.append("Profile | ");
        for(int i = 0; i < profileList.size();i++){
             c.append(profileList.get(i).toString()+"| ");
            
        }
         return c.toString();
    }
}
