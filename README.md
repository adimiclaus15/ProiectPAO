# Proiect PAO
In cadrul acestui proiect este gestionat procesul de admitere in facultate.
# Descriere sistem
1. Service - clasa de serviciu care mentine o lista de universitati si metode de adaugare/afisare universitati.
2. Universitate - clasa care mentine o lista cu facultatile din cadrul unei universitati si metode de adaugare/afisare facultati.
3. Specializare - clasa care mentine o lista cu specializarile unei facultati si metode de adaugare/afisare specializari.
4. CandidatIF, CandidatID, Candidat2Fac - clase derivate din clasa Candidat care metin informatii despre candidatii care au aplicat la o anumita facultate.
5. Audit - contine metoda afisareQuery care afiseaza in fisierul audit.csv numele interogarii si momentul de tip in care a fost facuta.
6. UniversitateIO, SpecializareIO, FacultateIO, CandidatIFIO, CandidatIDIO,Candidat2FacIO - clase de tip singleton care citesc si salveaza date in fisere de tip csv.
