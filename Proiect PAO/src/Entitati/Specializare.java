package Entitati;

import Servicii.Audit;

import java.io.IOException;
import java.util.Iterator;
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
    public Specializare(int id,String nume,int nrID,int nrIF,int nr2FAC){
        this.nume=nume;
        this.id=id;
        this.nrID=nrID;
        this.nrIF=nrIF;
        this.nr2FAC=nr2FAC;
        candidatiIF=new TreeSet<>();
        candidatiID=new TreeSet<>();
        candidati2FAC=new TreeSet<>();
    }
    public Iterator<CandidatIF> getListaCandidatiIF() throws IOException
    {
        Audit.afisareQuery("getListaCandidatiIF");
        return this.candidatiIF.iterator();
    }
    public Iterator<CandidatID> getListaCandidatiID() throws IOException
    {
        Audit.afisareQuery("getListaCandidatiID");
        return this.candidatiID.iterator();
    }
    public Iterator<Candidat2Fac> getListaCandidati2FAC() throws IOException
    {
        Audit.afisareQuery("gedListaCandidati2FAC");
        return this.candidati2FAC.iterator();
    }
    public void adaugareCandidat(Candidat c) throws IOException
    {
        Audit.afisareQuery("adaugareCandidat");
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
    public void afisareCandidatiIF() throws IOException
    {
        Audit.afisareQuery("afisareCandidatiIF");
        for(CandidatIF c : this.candidatiIF)
            System.out.println(c);
    }
    public void afisareCandidatiID() throws IOException
    {
        Audit.afisareQuery("afisareCandidatiID");
        for(CandidatID c : this.candidatiID)
            System.out.println(c);
    }
    public void afisareCandidati2FAC() throws IOException
    {
        Audit.afisareQuery("afisareCandidati2FAC");
        for(Candidat2Fac c : this.candidati2FAC)
            System.out.println(c);
    }
    public void admisiIF() throws IOException
    {
        Audit.afisareQuery("admisiIF");
        int sz=0;
        for(CandidatIF c:this.candidatiIF){
            sz++;
            if(sz>this.nrIF || c.medieAdmitere()<5.0)
                break;
            System.out.println(c);
        }
    }
    public void respinsiIF() throws IOException
    {
        Audit.afisareQuery("respinsiIF");
        for(CandidatIF c:this.candidatiIF){
            if(c.medieAdmitere()<5.0)
                System.out.println(c);
        }
    }
    public void asteptareIF() throws IOException
    {
        Audit.afisareQuery("asteptareIF");
        int sz=0;
        for(CandidatIF c:this.candidatiIF)
        {
            sz++;
            if(sz>this.nrIF && c.medieAdmitere()>=5.0)
                System.out.println(c);
        }
    }
    public void admisiID() throws IOException
    {
        Audit.afisareQuery("admisiID");
        int sz=0;
        for(CandidatID c:this.candidatiID){
            sz++;
            if(sz>this.nrID || c.medieAdmitere()<5.0)
                break;
            System.out.println(c);
        }
    }
    public void asteptareID() throws IOException
    {
        Audit.afisareQuery("astepareID");
        int sz=0;
        for(CandidatID c:this.candidatiID)
        {
            sz++;
            if(sz>this.nrID && c.medieAdmitere()>=5.0)
                System.out.println(c);
        }
    }
    public void respinsiID() throws IOException
    {
        Audit.afisareQuery("respinsiID");
        for(CandidatID c:this.candidatiID){
            if(c.medieAdmitere()<5.0)
                System.out.println(c);
        }
    }
    public void admisi2FAC() throws IOException
    {
        Audit.afisareQuery("admisi2FAC");
        int sz=0;
        for(Candidat2Fac c:this.candidati2FAC){
            sz++;
            if(sz>this.nr2FAC || c.medieAdmitere()<5.0)
                break;
            System.out.println(c);
        }
    }
    public void asteptare2FAC() throws IOException
    {
        Audit.afisareQuery("asteptare2FAC");
        int sz=0;
        for(Candidat2Fac c:this.candidati2FAC)
        {
            sz++;
            if(sz>this.nr2FAC && c.medieAdmitere()>=5.0)
                System.out.println(c);
        }
    }
    public void respinsi2FAC() throws IOException
    {
        Audit.afisareQuery("respinsi2FAC");
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
        return this.id+","+this.nume+","+this.nrID+","+this.nrIF+","+this.nr2FAC;
    }
}
