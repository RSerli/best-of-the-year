package com.yearrimander.best_of_the_year.model;

public class movies {

    private String nome;

    private int id;

    private String genere;

    private int anno;

    private double valutazione;

    public movies(String nome, int id, String genere, int anno, double valutazione) {
        this.nome = nome;
        this.id = id;
        this.genere = genere;
        this.anno = anno;
        this.valutazione = valutazione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public double getValutazione() {
        return valutazione;
    }

    public void setValutazione(double valutazione) {
        this.valutazione = valutazione;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id=").append(id);
        sb.append(" Titolo:").append(nome);
        sb.append(", genere:").append(genere);
        sb.append(", anno:").append(anno);
        sb.append(", valutazione:").append(valutazione);
        return sb.toString();
    }

    
}
