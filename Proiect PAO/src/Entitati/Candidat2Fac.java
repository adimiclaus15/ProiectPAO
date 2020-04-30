package Entitati;

public class Candidat2Fac extends Candidat implements Comparable<Candidat2Fac>{
    private double medieBac;
    private double medieFac;
    public Candidat2Fac(String nume,long cnp,double medieBac,double medieFac){
        super(nume,cnp);
        this.medieBac=medieBac;
        this.medieFac=medieFac;
    }
    public double getMedieBac(){
        return this.medieBac;
    }
    public double getMedieFac(){
        return this.medieFac;
    }
    public void setMedieBac(double medieBac){
        this.medieBac=medieBac;
    }
    public void setMedieFac(double medieFac){
        this.medieFac=medieFac;
    }
    public double medieAdmitere(){
        return 0.6*this.medieFac+0.4*this.medieBac;
    }
    @Override
    public boolean equals(Object o){
        if(this==o)
            return true;
        if(o==null || this.getClass()!=o.getClass())
            return false;
        Candidat2Fac c=(Candidat2Fac) o;
        return this.medieAdmitere()==c.medieAdmitere();
    }
    @Override
    public int compareTo(Candidat2Fac c){
        double x=this.medieAdmitere();
        double y=c.medieAdmitere();
        if(x>=y)
            return -1;
        else
            return 1;
    }
    @Override
    public String toString(){
        return this.nume+","+this.cnp+","+this.medieAdmitere();
    }
}
