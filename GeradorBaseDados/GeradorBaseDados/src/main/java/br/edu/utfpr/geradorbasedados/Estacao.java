package br.edu.utfpr.geradorbasedados;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Estacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seqGenerator", sequenceName = "id", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "seqGenerator", strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private String nome;

    @Column
    private String latitude;

    @Column
    private String longitude;

    @Column
    private int nivelAcessibilidade;

    public Estacao(){
        
    }
    
    public Estacao(String nome, String latitude, String longitude, int nivelAcessibilidade) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nivelAcessibilidade = nivelAcessibilidade;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
