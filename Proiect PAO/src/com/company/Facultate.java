package com.company;

import java.util.ArrayList;

public class Facultate {
    private String nume;
    private int id;
    private ArrayList<Specializare> specializari;
    public Facultate(String nume,int id){
        this.nume=nume;
        this.id=id;
        specializari=new ArrayList<>();
    }
    public String getNume(){
        return this.nume;
    }
    public void setNume(String nume){
        this.nume=nume;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public Specializare getSpecializare(String nume)
    {
        Specializare sp=null;
        for(Specializare s:this.specializari)
        {
            if(s.getNume().equals(nume))
                sp=s;
        }
        return sp;
    }
    public void adaugareSpecializare(Specializare s){
        specializari.add(s);
    }
    public void afisareSpecializari(){
        for(Specializare s: this.specializari)
            System.out.println(s);
    }
    @Override
    public String toString(){
        return this.nume+" "+this.id;
    }
}
