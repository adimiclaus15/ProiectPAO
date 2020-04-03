package com.company;

public class Candidat {
    protected String nume;
    protected long cnp;

    public Candidat(String nume,long cnp){
        this.nume=nume;
        this.cnp=cnp;
    }
    public double medieAdmitere(){
        return 0;
    }
    public String getNume(){
        return this.nume;
    }
    public long getCnp(){
        return this.cnp;
    }
    public void setNume(String nume){
        this.nume=nume;
    }
    public void setCnp(long cnp){
        this.cnp=cnp;
    }
}
