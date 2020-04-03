# Proiect PAO - Admitere

Proiectul are ca scop gestionarea admiterii in cadrul unei facultati.
Este format din urmatoarele clase:
 - Service - contine o lista cu toate universitatile + metodele adaugareUniversitate, getUniversitate, afisareUniversitati.
 - Universitate - contine o lista cu toate facultatile dintr-o universitate + metodele adaugareFacultate si afisareFacultati.
 - Facultate - contine o lista cu specializarile din cadrul unei facultati + metodele adaugareSpecializare si afisareSpecializari.
 - Specializare - contine liste cu candidatii sortati in ordinea mediei de admitere + metode de adaugare candidat si afisare candidati admisi/in asteptare/respinsi pentru fiecare forma de invatamant(invatamant cu frecventa, invatamant la distanta, candidati la a 2-a facultate).
 - Candidat - contine numele,cnp-ul unui candidat + metoda de calculare a mediei care se va suprascrie in clasele derivate: CandindatIF, CandidatID, Candidat2FAC.