package Servicii;

import Entitati.*;

import java.io.*;
import java.util.Iterator;

public class UniversitateIO
{
    private static UniversitateIO inst=null;
    private UniversitateIO() {}
    public static UniversitateIO getInst()
    {
        if(inst==null)
            inst=new UniversitateIO();
        return inst;
    }
    public void citesteUniversitati(String fisier, Service s) throws IOException
    {
        BufferedReader br=new BufferedReader(new FileReader(fisier));
        String line="";
        while((line=br.readLine())!=null)
        {
            String[] a=line.split(",");
            Universitate u=new Universitate(Integer.parseInt(a[0]),a[1],a[2]);
            s.adaugareUniversitate(u);
        }
        br.close();
    }
    public void salveazaUniversitati(String fisier,Service s) throws IOException
    {
        BufferedWriter br=new BufferedWriter(new FileWriter(fisier));
        Iterator<Universitate> it=s.getListaUniversitati();
        while (it.hasNext())
        {
            br.write(it.next().toString());
            br.newLine();
        }
        br.close();
    }
}
