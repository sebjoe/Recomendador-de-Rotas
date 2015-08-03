/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.util.List;

/**
 *
 * @author marlon
 */
public class GsonDistanceMatrix {

	private List<String> destination_addresses;
	private List<String> origin_addresses;
	private List<Rows> rows;
        private String status;
        
        public String getDestinationAddresses(int i) {
            return this.destination_addresses.get(i);
	}
        
        public String getOriginAddresses(int i) {
            return this.origin_addresses.get(i);
	}
        
	public int getValueDistance(int i, int j) {
            return this.rows.get(i).elements.get(j).distance.value;
	}
        
        public String getTextDistance(int i, int j) {
            return this.rows.get(i).elements.get(j).distance.text;
	}
        
        public int getValueDuration(int i, int j) {
            return this.rows.get(i).elements.get(j).duration.value;
	}
        
        public String getTextDuration(int i, int j) {
            return this.rows.get(i).elements.get(j).duration.text;
	}
        
        public String getStatus(int i, int j) {
            return this.rows.get(i).elements.get(j).status;
	}
        
        public String getStatus(){
            return status;
        }
	private class Rows {
		private List<Element> elements;
	}
	
	private class Element {
		private TexVal distance;
		private TexVal duration;
		private String status;
	}
	
	private class TexVal {
		private String text;
		private int value;
	}
	
	
	public int getDimension() {
		return this.origin_addresses.size();
	}
}
