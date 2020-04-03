package com.company;

import java.util.SortedSet;
import java.util.TreeSet;

public class Specializare {
    private String nume;
    private int id;
    private int nrID;
    private int nrIF;
    private int nr2FAC;
    private SortedSet<CandidatIF> candidatiIF;
    private SortedSet<CandidatID> candidatiID;
    private SortedSet<Candidat2Fac> candidati2FAC;
    public Specializare(String nume,int id,int nrID,int nrIF,int nr2FAC){
        this.nume=nume;
        this.id=id;
        this.nrID=nrID;
        this.nrIF=nrIF;
        this.nr2FAC=nr2FAC;
        candidatiIF=new TreeSet<>();
        candidatiID=new TreeSet<>();
        candidati2FAC=new TreeSet<>();
    }
    public void adaugareCandidat(Candidat c){
        if(c instanceof CandidatIF)
            candidatiIF.add((CandidatIF)c);
        if(c instanceof CandidatID)
            candidatiID.add((CandidatID)c);
        if(c instanceof Candidat2Fac)
            candidati2FAC.add((Candidat2Fac)c);
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
    public int getNrID(){
        return this.nrID;
    }
    public void setNrID(int nrID){
        this.nrID=nrID;
    }
    public int getNrIF(){
        return this.nrIF;
    }

    public void setNrIF(int nrIF){
        this.nrIF=nrIF;
    }
    public int getNr2FAC(){
        return this.nr2FAC;
    }
    public void setNr2FAC(int nr2FAC){
        this.nr2FAC=nr2FAC;
    }
    public void afisareCandidatiIF(){
        for(CandidatIF c : this.candidatiIF)
            System.out.println(c);
    }
    public void afisareCandidatiID(){
        for(CandidatID c : this.candidatiID)
            System.out.println(c);
    }
    public void afisareCandidati2FAC(){
        for(Candidat2Fac c : this.candidati2FAC)
            System.out.println(c);
    }
    public void admisiIF()
    {
        int sz=0;
        for(CandidatIF c:this.candidatiIF){
            sz++;
            if(sz>this.nrIF || c.medieAdmitere()<5.0)
                break;
            System.out.println(c);
        }
    }
    public void respinsiIF()
    {
        for(CandidatIF c:this.candidatiIF){
            if(c.medieAdmitere()<5.0)
                System.out.println(c);
        }
    }
    public void asteptareIF()
    {
        int sz=0;
        for(CandidatIF c:this.candidatiIF)
        {
            sz++;
            if(sz>this.nrIF && c.medieAdmitere()>=5.0)
                System.out.println(c);
        }
    }
    public void admisiID()
    {
        int sz=0;
        for(CandidatID c:this.candidatiID){
            sz++;
            if(sz>this.nrID || c.medieAdmitere()<5.0)
                break;
            System.out.println(c);
        }
    }
    public void asteptareID()
    {
        int sz=0;
        for(CandidatID c:this.candidatiID)
        {
            sz++;
            if(sz>this.nrID && c.medieAdmitere()>=5.0)
                System.out.println(c);
        }
    }
    public void respinsiID()
    {
        for(CandidatID c:this.candidatiID){
            if(c.medieAdmitere()<5.0)
                System.out.println(c);
        }
    }
    public void admisi2FAC()
    {
        int sz=0;
        for(Candidat2Fac c:this.candidati2FAC){
            sz++;
            if(sz>this.nr2FAC || c.medieAdmitere()<5.0)
                break;
            System.out.println(c);
        }
    }
    public void asteptare2FAC()
    {
        int sz=0;
        for(Candidat2Fac c:this.candidati2FAC)
        {
            sz++;
            if(sz>this.nr2FAC && c.medieAdmitere()>=5.0)
                System.out.println(c);
        }
    }
    public void respinsi2FAC()
    {
        for(Candidat2Fac c:this.candidati2FAC){
            if(c.medieAdmitere()<5.0)
                System.out.println(c);
        }
    }
    public Candidat getCandidat(long cnp)
    {
        Candidat res=null;
        for(CandidatIF c:this.candidatiIF){
            if(c.cnp==cnp)
                res=c;
        }
        for(CandidatID c:this.candidatiID){
            if(c.cnp==cnp)
                res=c;
        }
        for(Candidat2Fac c:this.candidati2FAC){
            if(c.cnp==cnp)
                res=c;
        }
        return res;
    }
    @Override
    public String toString(){
        return this.nume+" "+this.id+" "+this.nrID+" "+this.nrIF+" "+this.nr2FAC;
    }
}
