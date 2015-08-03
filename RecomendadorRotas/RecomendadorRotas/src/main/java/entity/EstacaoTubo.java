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
public class EstacaoTubo {
    private String nome;
    private String latitude;
    private String longitude;
    private int nivelAcessibilidade;
    private String distancia;
    private String duracao;

    public EstacaoTubo(String nome, String latitude, String longitude, int nivelAcessibilidade, String distancia, String duracao) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nivelAcessibilidade = nivelAcessibilidade;
        this.distancia = distancia;
        this.duracao = duracao;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getNivelAcessibilidade() {
        return nivelAcessibilidade;
    }

    public void setNivelAcessibilidade(int nivelAcessibilidade) {
        this.nivelAcessibilidade = nivelAcessibilidade;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
    
    
}
