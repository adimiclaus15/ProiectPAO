package com.company;

import java.util.ArrayList;

public class Universitate {
    private String nume;
    private int id;
    private ArrayList<Facultate> listaFacultati;
    public Universitate(String nume,int id)
    {
        this.nume=nume;
        this.id=id;
        listaFacultati=new ArrayList<Facultate>();
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
    public void adaugareFacultate(Facultate f){
        this.listaFacultati.add(f);
    }
    public void afisareFacultati(){
        for(Facultate f : listaFacultati)
            System.out.println(f);
    }
    @Override
    public String toString() {
        return this.nume+" "+this.id;
    }
}
