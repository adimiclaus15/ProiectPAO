# Proiect PAO
In cadrul acestui proiect este gestionat procesul de admitere in facultate.
# Descriere sistem
1. Service - clasa de serviciu care mentine o lista de universitati si metode de adaugare/afisare universitati.
2. Universitate - clasa care mentine o lista cu facultatile din cadrul unei universitati si metode de adaugare/afisare facultati.
3. Facultate - clasa care mentine o lista cu specializarile unei facultati si metode de adaugare/afisare specializari.
4. Specializare - clasa care mentine liste sortate cu candidatii care au aplicat la o anumita specializare si metode de adaugare/afisare candidati.
5. CandidatIF, CandidatID, Candidat2Fac - clase derivate din clasa Candidat care metin informatii despre candidatii care au aplicat la o anumita specializare.
6. Audit - clasa care contine metoda afisareQuery ce afiseaza in fisierul audit.csv numele interogarii si momentul de timp in care a fost facuta.
7. UniversitateIO, SpecializareIO, FacultateIO, CandidatIFIO, CandidatIDIO,Candidat2FacIO - clase de tip singleton care citesc si salveaza date in fisere de tip csv. Fisierele csv se afla in folderul data.
