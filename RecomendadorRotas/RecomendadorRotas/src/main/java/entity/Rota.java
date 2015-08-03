/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author marlon
 */
public class Rota implements Serializable{
    private EstacaoTubo estacaoTuboOrigem;
    private EstacaoTubo estacaoTuboDestino;
    private String tempoViagem;
    private double mediaNivelAcessRota;
    private List<TravelDetail> travel_detail; 

    public EstacaoTubo getEstacaoTuboOrigem() {
        return estacaoTuboOrigem;
    }

    public void setEstacaoTuboOrigem(EstacaoTubo estacaoTuboOrigem) {
        this.estacaoTuboOrigem = estacaoTuboOrigem;
    }

    public EstacaoTubo getEstacaoTuboDestino() {
        return estacaoTuboDestino;
    }

    public void setEstacaoTuboDestino(EstacaoTubo estacaoTuboDestino) {
        this.estacaoTuboDestino = estacaoTuboDestino;
    }

    public String getTempoViagem() {
        return tempoViagem;
    }

    public void setTempoViagem(String tempoViagem) {
        this.tempoViagem = tempoViagem;
    }

    public double getMediaNivelAcessRota() {
        return mediaNivelAcessRota;
    }

    public void setMediaNivelAcessRota(double mediaNivelAcessRota) {
        this.mediaNivelAcessRota = mediaNivelAcessRota;
    }

    public List<TravelDetail> getTravel_detail() {
        return travel_detail;
    }

    public void setTravel_detail(List<TravelDetail> travel_detail) {
        this.travel_detail = travel_detail;
    }

    
}
