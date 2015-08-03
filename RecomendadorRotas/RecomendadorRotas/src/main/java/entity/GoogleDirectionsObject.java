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
public class GoogleDirectionsObject {
    
        private String status;
        private List<Routes> routes;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<Routes> getRoutes() {
            return routes;
        }

        public void setRoutes(List<Routes> routes) {
            this.routes = routes;
        }
    
    public class Bounds {
        private Northeast northeast;
        private Southwest southwest;

        public Northeast getNortheast() {
            return northeast;
        }

        public void setNortheast(Northeast northeast) {
            this.northeast = northeast;
        }

        public Southwest getSouthwest() {
            return southwest;
        }

        public void setSouthwest(Southwest southwest) {
            this.southwest = southwest;
        }
    }
    
    public class Distance {
        private String text;
        private String value;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
    
    public class Duration {
        private String text;
        private String value;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
    
    public class Endlocation {
        private String lat;
        private String lng;

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }
    }
    
    public class Legs {
        private Distance distance;
        private Duration duration;
        private String end_address;
        private Endlocation end_location;
        private String start_address;
        private Startlocation start_location;
        private List<Steps> steps;
        private List<String> via_waypoint;

        public List<String> getVia_waypoint() {
            return via_waypoint;
        }

        public void setVia_waypoint(List<String> via_waypoint) {
            this.via_waypoint = via_waypoint;
        }

        public Distance getDistance() {
            return distance;
        }

        public void setDistance(Distance distance) {
            this.distance = distance;
        }

        public Duration getDuration() {
            return duration;
        }

        public void setDuration(Duration duration) {
            this.duration = duration;
        }

        public String getEnd_address() {
            return end_address;
        }

        public void setEnd_address(String end_address) {
            this.end_address = end_address;
        }

        public Endlocation getEnd_location() {
            return end_location;
        }

        public void setEnd_location(Endlocation end_location) {
            this.end_location = end_location;
        }

        public String getStart_address() {
            return start_address;
        }

        public void setStart_address(String start_address) {
            this.start_address = start_address;
        }

        public Startlocation getStart_location() {
            return start_location;
        }

        public void setStart_location(Startlocation start_location) {
            this.start_location = start_location;
        }

        public List<Steps> getSteps() {
            return steps;
        }

        public void setSteps(List<Steps> steps) {
            this.steps = steps;
        }
    }
    
    public class Northeast {
        private String lat;
        private String lng;
        public String getLat() {
            return lat;
        }
        public void setLat(String lat) {
            this.lat = lat;
        }
        public String getLng() {
            return lng;
        }
        public void setLng(String lng) {
            this.lng = lng;
        }
    }
    
    public class Overviewpolyline {

    }
    
    public class Polyline {
        private String points;

        public String getPoints() {
            return points;
        }

        public void setPoints(String points) {
            this.points = points;
        }
    }
    
    public class Departurestop{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    
    public class Routes {
        private Bounds bounds;
        private String copyrights;
        private List<Legs> legs;
        private Overviewpolyline overview_polyline;
        private String summary;
        private List<String> warnings;
        private List<String> waypoint_order;

        public Bounds getBounds() {
            return bounds;
        }

        public void setBounds(Bounds bounds) {
            this.bounds = bounds;
        }

        public String getCopyrights() {
            return copyrights;
        }

        public void setCopyrights(String copyrights) {
            this.copyrights = copyrights;
        }

        public List<Legs> getLegs() {
            return legs;
        }

        public void setLegs(List<Legs> legs) {
            this.legs = legs;
        }

        public Overviewpolyline getOverview_polyline() {
            return overview_polyline;
        }

        public void setOverview_polyline(Overviewpolyline overview_polyline) {
            this.overview_polyline = overview_polyline;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<String> getWarnings() {
            return warnings;
        }

        public void setWarnings(List<String> warnings) {
            this.warnings = warnings;
        }

        public List<String> getWaypoint_order() {
            return waypoint_order;
        }

        public void setWaypoint_order(List<String> waypoint_order) {
            this.waypoint_order = waypoint_order;
        }
    }
    
    public class Southwest {
        private String lat;
        private String lng;
        public String getLat() {
            return lat;
        }
        public void setLat(String lat) {
            this.lat = lat;
        }
        public String getLng() {
            return lng;
        }
        public void setLng(String lng) {
            this.lng = lng;
        }
    }
    
    public class Startlocation {
        private String lat;
        private String lng;

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }
    }
    
    public class Arrivalstop{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    
    public class Transitdetails{
        private Departurestop departure_stop;
        private Arrivalstop arrival_stop;

        public Departurestop getDeparture_stop() {
            return departure_stop;
        }

        public void setDeparture_stop(Departurestop departure_stop) {
            this.departure_stop = departure_stop;
        }

        public Arrivalstop getArrival_stop() {
            return arrival_stop;
        }

        public void setArrival_stop(Arrivalstop arrival_stop) {
            this.arrival_stop = arrival_stop;
        }
        
    }
    
    public class Steps {
        private Distance distance;
        private Duration duration;

        private Endlocation end_location;

        private Startlocation start_location;
        private String html_instructions;
        private String travel_mode;
        private Polyline polyline;
        private Transitdetails transit_details;

        private List<Steps> steps;
        
        public Distance getDistance() {
            return distance;
        }

        public void setDistance(Distance distance) {
            this.distance = distance;
        }

        public Duration getDuration() {
            return duration;
        }

        public void setDuration(Duration duration) {
            this.duration = duration;
        }

        public Endlocation getEnd_location() {
            return end_location;
        }

        public void setEnd_location(Endlocation end_location) {
            this.end_location = end_location;
        }

        public Startlocation getStart_location() {
            return start_location;
        }

        public void setStart_location(Startlocation start_location) {
            this.start_location = start_location;
        }

        public String getHtml_instructions() {
            return html_instructions;
        }

        public void setHtml_instructions(String html_instructions) {
            this.html_instructions = html_instructions;
        }

        public String getTravel_mode() {
            return travel_mode;
        }

        public void setTravel_mode(String travel_mode) {
            this.travel_mode = travel_mode;
        }

        public Polyline getPolyline() {
            return polyline;
        }

        public void setPolyline(Polyline polyline) {
            this.polyline = polyline;
        }

        public List<Steps> getSteps() {
            return steps;
        }

        public void setSteps(List<Steps> steps) {
            this.steps = steps;
        }

        public Transitdetails getTransit_details() {
            return transit_details;
        }

        public void setTransit_details(Transitdetails transit_details) {
            this.transit_details = transit_details;
        }

    }   
}


