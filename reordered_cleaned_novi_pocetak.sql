CREATE TABLE FakultetOblast (
                                fakultet_id INT NOT NULL,
                                oblast_f_id INT NOT NULL,
                                CONSTRAINT FakultetOblast_pk PRIMARY KEY (fakultet_id, oblast_f_id),
                                CONSTRAINT FakultetOblast_Fakultet FOREIGN KEY (fakultet_id)
REFERENCES Fakultet(fakultet_id),
                                CONSTRAINT FakultetOblast_OblastFakulteta FOREIGN KEY (oblast_f_id)
REFERENCES OblastFakulteta(oblast_f_id)
);

CREATE TABLE Kurs (
                      kurs_id INT NOT NULL,
                      valuta_id INT NOT NULL,
                      datum_promene DATE NOT NULL,
                      konverzija DECIMAL(10,5) NOT NULL,
                      CONSTRAINT Kurs_pk PRIMARY KEY (kurs_id),
                      CONSTRAINT Kurs_Valuta FOREIGN KEY (valuta_id)
REFERENCES Valuta(valuta_id)
);

CREATE TABLE Placanje (
                          placanje_id INT NOT NULL,
                          klijent_id INT NOT NULL,
                          seansa_id INT NOT NULL,
                          svrha_placanja varchar(20) NOT NULL,
                          rata INT NOT NULL,
                          nacin_placanja VARCHAR(10) NOT NULL,
                          uplaceni_iznos DECIMAL(8,2) NOT NULL,
                          valuta_id INT NOT NULL,
                          provizija DECIMAL(5,2) NOT NULL,
                          CONSTRAINT Placanje_pk PRIMARY KEY (placanje_id),
                          CONSTRAINT Placanje_Klijent FOREIGN KEY (klijent_id)
REFERENCES Klijent(klijent_id),
                          CONSTRAINT Placanje_Seansa FOREIGN KEY (seansa_id)
REFERENCES Seansa(seansa_id),
                          CONSTRAINT Placanje_Valuta FOREIGN KEY (valuta_id)
REFERENCES Valuta(valuta_id)
);

CREATE TABLE Prijava (
                         prijava_id INT NOT NULL,
                         klijent_id INT NOT NULL,
                         psihoterapeut_id INT NOT NULL,
                         isao_ranije BOOLEAN NOT NULL,
                         problem TEXT NOT NULL,
                         CONSTRAINT Prijava_pk PRIMARY KEY (prijava_id),
                         CONSTRAINT Prijava_Klijent FOREIGN KEY (klijent_id)
REFERENCES Klijent(klijent_id),
                         CONSTRAINT Prijava_Psihoterapeut FOREIGN KEY (psihoterapeut_id)
REFERENCES Psihoterapeut(psihoterapeut_id)
);

CREATE TABLE PromenaCeneSeanse (
                                   cena_id INT NOT NULL,
                                   seansa_id INT NOT NULL,
                                   datum_promene DATE NOT NULL,
                                   nova_cena DECIMAL(5,2) NOT NULL,
                                   CONSTRAINT PromenaCeneSeanse_pk PRIMARY KEY (cena_id),
                                   CONSTRAINT PromenaCeneSeanse_Seansa FOREIGN KEY (seansa_id)
REFERENCES Seansa(seansa_id)
);

CREATE TABLE PsihoterapeutOblastP (
                                      psihoterapeut_id INT NOT NULL,
                                      oblast_p_id INT NOT NULL,
                                      CONSTRAINT PsihoterapeutOblastP_pk PRIMARY KEY (psihoterapeut_id, oblast_p_id),
                                      CONSTRAINT PsihoterapeutOblastP_Psihoterapeut FOREIGN KEY (psihoterapeut_id)
REFERENCES Psihoterapeut(psihoterapeut_id),
                                      CONSTRAINT PsihoterapeutOblastP_OblastPsihoterapije FOREIGN KEY (oblast_p_id)
REFERENCES OblastPsihoterapije(oblast_ps_id)
);

CREATE TABLE RezultatTesta (
                               seansa_id INT NOT NULL,
                               krajnji_rezultat INT NOT NULL,
                               CONSTRAINT RezultatTesta_pk PRIMARY KEY (seansa_id),
                               CONSTRAINT RezultatTesta_Seansa FOREIGN KEY (seansa_id)
REFERENCES Seansa(seansa_id)
);

CREATE TABLE Sertifikat (
                            sertifikat_id INT NOT NULL,
                            datum_sertifikacije DATE NOT NULL,
                            psihoterapeut_id INT NOT NULL,
                            oblast_ps_id INT NOT NULL,
                            CONSTRAINT Sertifikat_pk PRIMARY KEY (sertifikat_id),
                            CONSTRAINT Sertifikat_Psihoterapeut FOREIGN KEY (psihoterapeut_id)
REFERENCES Psihoterapeut(psihoterapeut_id),
                            CONSTRAINT Sertifikat_OblastPsihoterapije FOREIGN KEY (oblast_ps_id)
REFERENCES OblastPsihoterapije(oblast_ps_id)
);

CREATE TABLE Supervizija (
                             supervizija_id INT NOT NULL,
                             kandidat_id INT NOT NULL,
                             psihoterapeut_id INT NOT NULL,
                             datum_od DATE NOT NULL,
                             datum_do DATE NULL,
                             CONSTRAINT Supervizija_pk PRIMARY KEY (supervizija_id),
                             CONSTRAINT Supervizija_Kandidat FOREIGN KEY (kandidat_id)
REFERENCES Kandidat(kandidat_id),
                             CONSTRAINT Supervizija_Psihoterapeut FOREIGN KEY (psihoterapeut_id)
REFERENCES Psihoterapeut(psihoterapeut_id)
);

CREATE TABLE ObjavljivanjePodataka (
    objavljivanje_id INT NOT NULL,
    seansa_id INT NOT NULL,
    datum_objavljivanja DATE NOT NULL,
    kome_objavljeno varchar(100) NOT NULL,
    razlog_id INT NOT NULL,
    zakonska_osnova varchar(100) NULL,
    CONSTRAINT ObjavljivanjePodataka_pk PRIMARY KEY (objavljivanje_id),
    CONSTRAINT ObjavljivanjePodataka_Seansa FOREIGN KEY (seansa_id)
        REFERENCES Seansa(seansa_id),
    CONSTRAINT ObjavljivanjePodataka_Razlog FOREIGN KEY (razlog_id)
        REFERENCES RazlogObjavljivanja(razlog_id)
);

-- tables



















































-- Add table for reasons for publishing session data


-- Add table for publishing session data


-- End of repaired schema