package com.company;

import java.util.ArrayList;

public class Service {
    private ArrayList<Universitate> listaUniversitati;
    public Service(){
        this.listaUniversitati=new ArrayList<>();
    }
    public void adaugareUniversitate(Universitate u){
        this.listaUniversitati.add(u);
    }
    public Universitate getUniversitate(String s)
    {
        Universitate univ=null;
        for(Universitate u: listaUniversitati){
            if(u.getNume().equals(s))
                univ=u;
        }
        return univ;
    }
    public void afisareUniversitati(){
        for(Universitate u: listaUniversitati)
            System.out.println(u);
    }
}
