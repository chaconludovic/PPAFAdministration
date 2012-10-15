DROP ALL OBJECTS;

CREATE TABLE role (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	role_name varchar(255) NOT NULL,
	PRIMARY KEY (id),
	constraint role_unique_1 unique (role_name)
);

CREATE TABLE roleMembre (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	role varchar(255) NOT NULL,
	PRIMARY KEY (id),
	constraint rolemembre_unique_1 unique (role)
);

CREATE TABLE membrePPAF (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	nom varchar(255) NOT NULL,
	prenom varchar(255) NOT NULL,
	numeroTelephone1 varchar(255)  NULL,
	numeroTelephone2 varchar(255)  NULL,
	email varchar(255) NULL,
	actif bool NOT NULL,
	note TEXT NULL,
	rue varchar(255)  NULL,
	ville varchar(255)  NULL,
	codePostal varchar(255)  NULL,
	infoSuppl TEXT  NULL,
	roleMembre_id INTEGER(10) NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT FK_MEMBREPPAF_ROLEMEMBRE FOREIGN KEY (roleMembre_id) REFERENCES roleMembre (id)
);


CREATE TABLE utilisateur (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	login varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	email varchar(255) NOT NULL, 
	rue varchar(255) NULL,
	ville varchar(255) NULL,
	codePostal varchar(255) NULL,
	infoSuppl TEXT  NULL,
	membrePPAF_id INTEGER(10) NULL,
	enabled bool NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT FK_UTILISATEUR_MEMBREPPAF FOREIGN KEY (membrePPAF_id) REFERENCES membrePPAF (id)
 );


 CREATE TABLE utilisateur_role (
    utilisateur_id INTEGER(10) not null,
    role_id INTEGER(10) not null,
    constraint utilisateur_role_fk_1 foreign key (utilisateur_id) references utilisateur,
    constraint utilisateur_role_fk_2 foreign key (role_id) references role,
    primary key (utilisateur_id, role_id)
);


CREATE TABLE item (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	nom varchar(255) NOT NULL,
	reference varchar(255) NOT NULL,
	note TEXT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE contact (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	nom varchar(255) NOT NULL,
	prenom varchar(255) NOT NULL,
	numeroTelephone1 varchar(255)  NULL,
	numeroTelephone2 varchar(255)  NULL,
	email varchar(255) NOT NULL,
	actif bool NOT NULL,
	note TEXT NULL,
	rue varchar(255)  NULL,
	ville varchar(255)  NULL,
	codePostal varchar(255)  NULL,
	infoSuppl TEXT  NULL,
	PRIMARY KEY (id)
);

CREATE TABLE suiviContact (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	date DATE NOT NULL,
	dateProchainAppel DATE NULL,
	note TEXT NULL,
	contact_id INTEGER(10) NOT NULL,
	membrePPAF_id INTEGER(10) NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT FK_SUIVICONTACT_CONTACT FOREIGN KEY (contact_id) REFERENCES contact (id),
	CONSTRAINT FK_SUIVICONTACT_MEMBREPPAF FOREIGN KEY (membrePPAF_id) REFERENCES membrePPAF (id)
);

CREATE TABLE lieuDeDepot (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	nom varchar(255) NOT NULL,
	numeroTelephone1 varchar(255)  NULL,
	numeroTelephone2 varchar(255)  NULL,
	rue varchar(255)  NULL,
	ville varchar(255)  NULL,
	codePostal varchar(255)  NULL,
	infoSuppl TEXT  NULL,
	type varchar(255)  NULL,
	PRIMARY KEY (id)
);

CREATE TABLE suiviDuLieuDeDepot (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	date DATE NOT NULL,
	note TEXT NULL,
	membrePPAF_id INTEGER(10) NOT NULL,
	lieuDeDepot_id INTEGER(10) NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT FK_SUIVIDULIEUDEDEPOT_LIEUDEDEPOT FOREIGN KEY (lieuDeDepot_id) REFERENCES lieuDeDepot (id),
	CONSTRAINT FK_SUIVIDULIEUDEDEPOT_MEMBREPPAF FOREIGN KEY (membrePPAF_id) REFERENCES membrePPAF (id)
);                
                  
CREATE TABLE lieuDeStockage (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	nom varchar(255) NOT NULL,
	membrePPAFResponsable_id INTEGER(10) NOT NULL,
	rue varchar(255)  NULL,
	ville varchar(255)  NULL,
	codePostal varchar(255)  NULL,
	infoSuppl TEXT  NULL,
	note TEXT NULL,
	PRIMARY KEY (id),
	CONSTRAINT FK_LIEUDESTOCKAGE_MEMBREPPAF FOREIGN KEY (membrePPAFResponsable_id) REFERENCES membrePPAF (id)
);                
                  
CREATE TABLE itemLieuDeStockage (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	date DATE NOT NULL,
	quantiteEntre INTEGER(10) NOT NULL,
	quantiteSortie INTEGER(10) NOT NULL,
	item_id INTEGER(10) NOT NULL,
	lieuDeStockage_id INTEGER(10) NOT NULL,
	note TEXT NULL,
	PRIMARY KEY (id),
	CONSTRAINT FK_ITEMLIEUDESTOCKAGE_LIEUSTOCKAGE FOREIGN KEY (lieuDeStockage_id) REFERENCES lieuDeStockage (id),
	CONSTRAINT FK_ITEMLIEUDESTOCKAGE_ITEM FOREIGN KEY (item_id) REFERENCES item (id)
);                
                  
CREATE TABLE vente (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	date DATE NOT NULL,
	dateDEncaissement DATE NULL,
	quantite INTEGER(10) NOT NULL,
	prixTotal DOUBLE NOT NULL,
	fraisDePort DOUBLE NULL,
	numeroDeFacture varchar(255) NULL,
	modeDeReglement varchar(255) NULL,
	informationReglement varchar(255) NULL,
	note TEXT NULL,
	item_id INTEGER(10) NOT NULL,
	contact_id INTEGER(10) NULL,
	lieuDeDepot_id INTEGER(10) NULL,
	membrePPAF_id INTEGER(10) NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT FK_VENTE_ITEM FOREIGN KEY (item_id) REFERENCES item (id),
	CONSTRAINT FK_VENTE_CONTACT FOREIGN KEY (contact_id) REFERENCES contact (id),
	CONSTRAINT FK_VENTE_LIEUDEDEPOT FOREIGN KEY (lieuDeDepot_id) REFERENCES lieuDeDepot (id),
	CONSTRAINT FK_VENTE_MEMBREPPAF FOREIGN KEY (membrePPAF_id) REFERENCES membrePPAF (id)
);

CREATE TABLE frais (
	id INTEGER(10) NOT NULL AUTO_INCREMENT,
	montant DOUBLE NOT NULL,
	date DATE NOT NULL,
	modeDeReglement varchar(255) NULL,
	informationReglement varchar(255) NULL,
	membrePPAF_id INTEGER(10) NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT FK_FRAIS_MEMBREPPAF FOREIGN KEY (membrePPAF_id) REFERENCES membrePPAF (id)
);

INSERT INTO ROLE(ID, ROLE_NAME) VALUES (1, 'ROLE_ADMIN');
INSERT INTO ROLE(ID, ROLE_NAME) VALUES (2, 'ROLE_USER');
INSERT INTO ROLEMEMBRE(ID, ROLE) VALUES (1, 'Administrateur');
INSERT INTO ROLEMEMBRE(ID, ROLE) VALUES (2, 'Gestionnaire');
INSERT INTO MEMBREPPAF(ID, NOM, PRENOM, NUMEROTELEPHONE1, NUMEROTELEPHONE2, EMAIL, ACTIF, NOTE, RUE, VILLE, CODEPOSTAL, INFOSUPPL, ROLEMEMBRE_ID) VALUES (1, 'Chacon', 'Adrien', '06 77 134 134', '', '', FALSE, '', '7 rue mary cassatt', 'le mesnil théribus', '', '', 1);
INSERT INTO UTILISATEUR(ID, LOGIN, PASSWORD, EMAIL, RUE, VILLE, CODEPOSTAL, INFOSUPPL, MEMBREPPAF_ID, ENABLED) VALUES (1, 'admin', 'admin', 'admin@example.com', null, null, null, null, null, TRUE);
INSERT INTO UTILISATEUR_ROLE(UTILISATEUR_ID, ROLE_ID) VALUES (1, 1);
