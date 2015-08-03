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
public class Recomendacao implements Comparable<Recomendacao> {
    
    private List<Rota> rotas;
    private String origem;
    private String destino;
    private int nivelAcessibilidadeOrigem;
    private int nivelAcessibilidadeDestino;
    private double mediaAcessibilidade;

    public Recomendacao(String origem, String destino, int nivelAcessibilidadeOrigem, int nivelAcessibilidadeDestino, double mediaAcessibilidade) {
        this.origem = origem;
        this.destino = destino;
        this.nivelAcessibilidadeOrigem = nivelAcessibilidadeOrigem;
        this.nivelAcessibilidadeDestino = nivelAcessibilidadeDestino;
        this.mediaAcessibilidade = mediaAcessibilidade;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getNivelAcessibilidadeOrigem() {
        return nivelAcessibilidadeOrigem;
    }

    public void setNivelAcessibilidadeOrigem(int nivelAcessibilidadeOrigem) {
        this.nivelAcessibilidadeOrigem = nivelAcessibilidadeOrigem;
    }

    public int getNivelAcessibilidadeDestino() {
        return nivelAcessibilidadeDestino;
    }

    public void setNivelAcessibilidadeDestino(int nivelAcessibilidadeDestino) {
        this.nivelAcessibilidadeDestino = nivelAcessibilidadeDestino;
    }

    public double getMediaAcessibilidade() {
        return mediaAcessibilidade;
    }

    public void setMediaAcessibilidade(double mediaAcessibilidade) {
        this.mediaAcessibilidade = mediaAcessibilidade;
    }

    public List<Rota> getRotas() {
        return rotas;
    }

    public void setRotas(List<Rota> rotas) {
        this.rotas = rotas;
    }
    
    @Override
    public int compareTo(Recomendacao o) {
        if (this.mediaAcessibilidade < o.mediaAcessibilidade) {
            return -1;
        }if (this.mediaAcessibilidade > o.mediaAcessibilidade) {
            return 1;
        }
        return 0;
    }

    
}
