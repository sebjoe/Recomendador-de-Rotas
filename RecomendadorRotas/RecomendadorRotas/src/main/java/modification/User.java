/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modification;

import java.util.ArrayList;
import java.util.List;

/**
 * Here is all the informations that are in relation with a user.
 * The name of the user. His profile, and also his vote regarding the accessibility level 
 * of bus stops
 * @author sebastien
 */
public class User {
    private static int idTotal = 0;
    private final int idUser;
    private String name;
    public Profile profile;
    public RatesLocations ratesLocation;
    public static List<User> users = new ArrayList<User>();
    
    /**
     * For now the user only need a name.
     * In the future we will need to take care of the profile, 
     * and the list of vote that he mad. For now the profile and the list of vote are 
     * generated randomly. 
     * @param name The name of the user. 
     */
    public User(String name){
        idUser = idTotal++;
        this.name = name;
        profile = new Profile();
        ratesLocation = new RatesLocations();
        users.add(this);
    }
    
    public String getName() {
        return name;
    }

    public int getIdUser() {
        return idUser;
    }
    
    

   
    
    
}
