package com.company;

public class CandidatID extends Candidat implements Comparable<CandidatID>{
    private double medieBac;
    private double notaInterviu;
    public CandidatID(String nume,long cnp,double medieBac,double notaInterviu){
        super(nume,cnp);
        this.medieBac=medieBac;
        this.notaInterviu=notaInterviu;
    }
    public double getMedieBac(){
        return this.medieBac;
    }
    public double getNotaInterviu(){
        return this.notaInterviu;
    }
    public void setMedieBac(double medieBac){
        this.medieBac=medieBac;
    }
    public void setNotaInterviu(double notaInterviu){
        this.notaInterviu=notaInterviu;
    }
    @Override
    public double medieAdmitere(){
        if(this.notaInterviu>=5.0)
            return 0.6*notaInterviu+0.4*medieBac;
        else
            return 0;
    }
    @Override
    public boolean equals(Object o){
        if(this==o)
            return true;
        if(o==null || this.getClass()!=o.getClass())
            return false;
        CandidatID c=(CandidatID) o;
        return this.medieAdmitere()==c.medieAdmitere();
    }
    @Override
    public int compareTo(CandidatID c){
        double x=this.medieAdmitere();
        double y=c.medieAdmitere();
        if(x>=y)
          return -1;
        else
            return 1;
    }
    @Override
    public String toString(){
        return this.nume+" "+this.cnp+" "+this.medieAdmitere();
    }
}
