package com.company;

public class CandidatIF extends Candidat implements Comparable<CandidatIF>{
    private double medieBac;
    private double notaExamen;
    public CandidatIF(String nume,long cnp,double medieBac,double notaExamen){
        super(nume,cnp);
        this.medieBac=medieBac;
        this.notaExamen=notaExamen;
    }
    public double getMedieBac(){
        return this.medieBac;
    }
    public double getNotaExamen(){
        return this.notaExamen;
    }
    public void setMedieBac(double medieBac){
        this.medieBac=medieBac;
    }
    public void setNotaExamen(double notaExamen){
        this.notaExamen=notaExamen;
    }
    public double medieAdmitere(){
        if(this.notaExamen>=5.0)
            return 0.8*this.notaExamen+0.2*this.medieBac;
        else
            return 0;
    }
    @Override
    public boolean equals(Object o){
        if(this==o)
            return true;
        if(o==null || this.getClass()!=o.getClass())
            return false;
        CandidatIF c=(CandidatIF) o;
        return this.medieAdmitere()==c.medieAdmitere();
    }
    @Override
    public int compareTo(CandidatIF c){
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
