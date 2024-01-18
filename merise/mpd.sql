CREATE TABLE Etablissement(
   etablissement_id INT,
   etablissement_nom VARCHAR(255),
   PRIMARY KEY(etablissement_id)
);

CREATE TABLE Matiere(
   matiere_id INT,
   matiere_intitule VARCHAR(50),
   matiere_description TEXT,
   matiere_duree INT,
   matiere_coefficient DECIMAL(2,2),
   PRIMARY KEY(matiere_id)
);

CREATE TABLE Departement(
   departement_id INT,
   departement_nom VARCHAR(255),
   etablissement_id INT NOT NULL,
   PRIMARY KEY(departement_id),
   FOREIGN KEY(etablissement_id) REFERENCES Etablissement(etablissement_id)
);

CREATE TABLE Enseignant(
   enseignant_id INT,
   enseignant_matricule VARCHAR(50),
   enseignant_nom VARCHAR(50),
   enseignant_prenom VARCHAR(50),
   enseignant_age INT,
   departement_id INT,
   PRIMARY KEY(enseignant_id),
   FOREIGN KEY(departement_id) REFERENCES Departement(departement_id)
);

CREATE TABLE Classe(
   classe_id INT,
   classe_nom VARCHAR(50),
   classe_niveau VARCHAR(50),
   enseignant_id INT NOT NULL,
   PRIMARY KEY(classe_id),
   FOREIGN KEY(enseignant_id) REFERENCES Enseignant(enseignant_id)
);

CREATE TABLE Eleve(
   eleve_id INT,
   eleve_prenom VARCHAR(50),
   eleve_nom VARCHAR(50),
   eleve_date DATE,
   eleve_mail VARCHAR(100),
   classe_id INT NOT NULL,
   PRIMARY KEY(eleve_id),
   FOREIGN KEY(classe_id) REFERENCES Classe(classe_id)
);

CREATE TABLE Note(
   note_id INT,
   note_valeur DECIMAL(2,2),
   note_commentaire TEXT,
   matiere_id INT NOT NULL,
   eleve_id INT NOT NULL,
   PRIMARY KEY(note_id),
   FOREIGN KEY(matiere_id) REFERENCES Matiere(matiere_id),
   FOREIGN KEY(eleve_id) REFERENCES Eleve(eleve_id)
);

CREATE TABLE Emploi_du_temps(
   edt_id INT,
   edt_date DATETIME,
   classe_id INT NOT NULL,
   matiere_id INT NOT NULL,
   enseignant_id INT NOT NULL,
   PRIMARY KEY(edt_id),
   FOREIGN KEY(classe_id) REFERENCES Classe(classe_id),
   FOREIGN KEY(matiere_id) REFERENCES Matiere(matiere_id),
   FOREIGN KEY(enseignant_id) REFERENCES Enseignant(enseignant_id)
);

CREATE TABLE enseignant_matiere(
   enseignant_id INT,
   matiere_id INT,
   PRIMARY KEY(enseignant_id, matiere_id),
   FOREIGN KEY(enseignant_id) REFERENCES Enseignant(enseignant_id),
   FOREIGN KEY(matiere_id) REFERENCES Matiere(matiere_id)
);

CREATE TABLE Responsable(
   departement_id INT,
   enseignant_id INT,
   PRIMARY KEY(departement_id, enseignant_id),
   FOREIGN KEY(departement_id) REFERENCES Departement(departement_id),
   FOREIGN KEY(enseignant_id) REFERENCES Enseignant(enseignant_id)
);

