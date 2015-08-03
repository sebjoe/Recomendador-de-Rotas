/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

/**
 *
 * @author marlon
 */
public class TravelDetail{
    private String html_instruction;
    private Estacao departure_stop;
    private Estacao arrival_stop;

    public String getHtml_instruction() {
        return html_instruction;
    }

    public void setHtml_instruction(String html_instruction) {
        this.html_instruction = html_instruction;
    }

    public Estacao getDeparture_stop() {
        return departure_stop;
    }

    public void setDeparture_stop(Estacao departure_stop) {
        this.departure_stop = departure_stop;
    }

    public Estacao getArrival_stop() {
        return arrival_stop;
    }

    public void setArrival_stop(Estacao arrival_stop) {
        this.arrival_stop = arrival_stop;
    }
    
}
