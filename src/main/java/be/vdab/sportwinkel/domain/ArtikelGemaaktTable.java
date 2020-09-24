package be.vdab.sportwinkel.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artikelsgemaakt")
public class ArtikelGemaaktTable {
    @Id
    private long id;
    private String naam;
    protected ArtikelGemaaktTable(){}

    public ArtikelGemaaktTable(Artikel artikel){
        this.id=artikel.getId();
        this.naam=artikel.getNaam();
    }
    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
