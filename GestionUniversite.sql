drop database GestionUniversite;
create database GestionUniversite;
use GestionUniversite;

/*-- creation des tables et leurs cles */

/* -- profeseur */

create table professeur(
Id_prof varchar(60) primary key,
Matricule_prof varchar(60),
Nom_prof varchar(40),
Prenom_prof varchar(40),
Sexe_prof varchar(59),
Tel_prof varchar(40),
Email_prof varchar(80),
Adresse_prof varchar(120),
NumrefProf varchar(120),
DateNaissance_prof varchar(120),
professionprof varchar(120),
Etat_prof varchar(120),
DateInscription_prof varchar(70),
 urlphoto varchar(300),
 urldoc varchar(300)
);

/* -- utilisateur*/


/*   Options*/
create table options(
Id_Opt varchar(20) primary key,
Nom_Opt varchar (30),
Dateenreg varchar(30)
);

/* -- Paiement*/
	create table Paiment(codepc varchar(20) primary key,Id_Opt varchar(20),fraisInscription double,fraisDentres double,fraisSession double,Dateenreg varchar(50));
  alter table Paiment add constraint paiement foreign key (Id_Opt) references Options(Id_Opt);
/* -- Ancien paiement */
  create table AncienPaiment(codepc varchar(20),Id_Opt varchar(20),fraisInscription double,fraisDentres double,fraisSession double,Dateenreg varchar(50),dateenregmodif varchar(50));
  alter table AncienPaiment add constraint AncienPaiment foreign key (codepc) references Paiment(codepc);

  
/*-- Niveaux */

create table Niveaux  (
  codeniv int primary key,
  Niveau varchar(60)
  );

  /*-- Sessionx */

create table Sessionx  (
  codesession int primary key,
  NomSession varchar(60)
  );

/*  -- Vacations */

  create table Vacations  (
    codevacation int primary key,
    NomVacation varchar(60)
    );

/* -- Cours */
    
    create table cours(
Id_Cours varchar(20) primary key,
Id_Opt varchar(20),
codeniv int,
codesession int,
Nom_Cours varchar (100),
Dateenreg varchar(30)
);

alter table Cours add constraint opt_fk_f foreign key (Id_Opt) references Options(Id_Opt);
alter table Cours add constraint niv_fk_f foreign key (codeniv) references Niveaux(codeniv);
alter table Cours add constraint ses_fk_f foreign key (codesession) references Sessionx(codesession);

/* -- Etudiants */



create table Etudiant(Id_Etud varchar(20) primary key ,Nom_Etud varchar(20),Prenom_Etud varchar(20),sexe varchar(10),
								datNaiss varchar(90), nif varchar(40), adresse varchar(70),email varchar(70),phone varchar(35),
								nomResponsable varchar(25),numeroRefference varchar(35),
								NomVacation varchar(30), Id_Opt varchar(20),datEnregistr varchar(50), promotion varchar(30),codeniv int,urlphoto varchar(300) );
alter table Etudiant add constraint etumopt_fk foreign key (Id_Opt) references options(Id_Opt);
alter table Etudiant add constraint nivetud foreign key (codeniv) references Niveaux(codeniv);


/* -- NiveauEtudiant*/
create table NivoEtudiants(codenietud varchar(10) primary key,Id_Etud varchar(20),codeniv int);
alter table NivoEtudiants add constraint nivcous foreign key (codeniv) references Niveaux(codeniv);
  alter table NivoEtudiants add constraint nivetu foreign key (Id_Etud) references Etudiant(Id_Etud);


create table ComptePaiment(CodeCompte varchar(30)  primary key,Id_Opt varchar(20),Id_Etud varchar(20),fraisInscription double,fraisDentres double,fraisSession double,solde double,Dateenreg varchar(50));
alter table ComptePaiment add constraint ComptePaiment foreign key (Id_Opt) references Options(Id_Opt);
alter table ComptePaiment add constraint compteetu foreign key (Id_Etud) references Etudiant(Id_Etud);

			create table TransacrionsEtudiants(codedepot varchar(30) primary key ,CodeCompte varchar(30),montant double,Dateenreg varchar(60));
     alter table TransacrionsEtudiants add constraint Transetu foreign key (CodeCompte) references ComptePaiment(CodeCompte);

Select sum(FraisInscription+fraisDentres+FraisSession) as solde from ComptePaiment  where Id_Etud='Eu';
	
/* -- Palmares */

create table palmares
(
 Codepalmares varchar(30) primary key,
 Id_Opt varchar(20),
 Id_Cours varchar(20),
 NomVacation varchar(30),
 Coeficienttotal int,
 Promotion varchar(50),
 Datepalmares varchar(100)
);

Select P.codepc, O.Nom_Opt, P.FraisInscription,P.fraisDentres, P. FraisSession, P.dateenregmodif from AncienPaiment P,Options O 

  
alter table palmares add constraint palmopt_fk foreign key (Id_Opt) references Options(Id_Opt);
alter table palmares add constraint palmcours_fk foreign key (Id_Cours) references cours(Id_Cours);

/* -- Evaluations  */
create table EvaluationsNormal
(
codeEvaluationsNormal varchar(30) primary key,
Codepalmares varchar(30),
TypesNormal varchar(10),
DescriptionsNormal varchar(60),
CoeficientNormal int,
DateEvaluationsNormal varchar(100)
);


alter table EvaluationsNormal add constraint evalpalm_fk foreign key (Codepalmares) references palmares(Codepalmares);
/* -- Notes  */
create table NotesNormal(
  codenotnormal varchar(30) primary key,
  codeEvaluationsNormal varchar(30),
  Id_Etud varchar(20),
  notenormal double,
  Dateenregnormal varchar(100)
  );

  alter table NotesNormal add constraint notesevaln_fk foreign key (codeEvaluationsNormal) references EvaluationsNormal(codeEvaluationsNormal);
  alter table NotesNormal add constraint noteetu_fk foreign key (Id_Etud) references Etudiant(Id_Etud);

  /* -- EvaluationsReprise  */
create table EvaluationsReprise
(
codeEvaluationsReprise varchar(30) primary key,
Codepalmares varchar(30),
SerieRepises varchar(10),
TypeReprise varchar(60),
CoeficientEvaluationsReprise int,
DateEvaluationsReprise varchar(100)
);

alter table EvaluationsReprise add constraint evalrpalm_fk foreign key (Codepalmares) references palmares(Codepalmares);

/* -- Notes  */
create table NotesReprises(
  codenotreprise varchar(30) primary key,
  codeEvaluationsReprise varchar(30),
  Id_Etud varchar(20),
  notereprise float,
  Dateenregreprise varchar(100)
  );

  alter table NotesReprises add constraint notesevalre_fk foreign key (codeEvaluationsReprise) references EvaluationsReprise(codeEvaluationsReprise);
  alter table NotesReprises add constraint noteretu_fk foreign key (Id_Etud) references Etudiant(Id_Etud);

/* -- Coursselectionnes */

create table CoursSelects(
codecs varchar(10) primary key ,
Id_prof varchar(60),
Id_Cours varchar(20),
Vacations varchar(30)
);
alter table CoursSelects add constraint courcs_fk_f foreign key (Id_prof) references professeur(Id_prof);
alter table CoursSelects add constraint courcs_fk_cs foreign key (Id_Cours) references cours(Id_Cours);

/* -- personne*/

CREATE TABLE  personne (
  `code` varchar(15) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(40) NOT NULL,
  `sexe` varchar(10) DEFAULT NULL,
  `nif` varchar(15) DEFAULT NULL,
  `adresse` varchar(100) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `dateNaissance` varchar(70),
  `Statut` varchar(20) DEFAULT NULL,
  `urlphoto` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`code`)
);


/*  employe*/
CREATE TABLE employe (
  `code` varchar(15) NOT NULL,
  `fonction` varchar(20) DEFAULT NULL,
  `salaire` float NOT NULL,
  `DateEmbauche` date DEFAULT NULL,
  `urldoc` varchar(300) DEFAULT NULL,
  KEY `FK_code` (`code`),
  CONSTRAINT `FK_code` FOREIGN KEY (`code`) REFERENCES `personne` (`code`)
) ;


/* -- utilisateur*/
CREATE TABLE  utilisateur (
  `code` varchar(15) NOT NULL,
  `nomUtilisateur` varchar(50) NOT NULL primary key,
  `MotPasse` varchar(20) NOT NULL,
  `etat` smallint(3) NOT NULL ,
  Dateenreg varchar(65),
   CONSTRAINT `FK_coode` FOREIGN KEY (`code`) REFERENCES `personne` (`code`)
);

create table connexion(
`code` varchar(15) NOT NULL,
`nommachine` varchar(100) NOT NULL,
`Dateenreg` varchar(65),
 CONSTRAINT `FK_cooconex` FOREIGN KEY (`code`) REFERENCES `personne` (`code`)
);

/* -- Insertion  */




/* -- Insertion Niveau */

insert into  Niveaux values
('1','Niveau 1'),
('2','Niveau 2'),
('3','Niveau 3'),
('4','Niveau 4'),
('5','Niveau 5');


/* -- Insertion Sessionx */

insert into Sessionx values 
('1','Session 1'),
('2','Session 2');


/* -- Insertion Vacations */

insert into  Vacations values
('1','Matin'),
('2','Median'),
('3','Soir'),
('4','Week-End');

/* -- Insertion Options */

insert into options values ('1','Sciences Informatique','2022/04/04'),
('2','Sciences Comptables','2022/04/04'),
('3','Genie Electronique','2022/04/04'),
('4','Genie Civil','2022/04/04'),
('5','Sciences Education','2022/04/04');
/*-- Insertion Cours  */
UPDATE notesnormal SET  Id_Etud='Etud-4664' where Id_Etud='Etud-4227';
insert into cours values 
('1','1','1','1','Java','2022/04/04'),
('2','1','1','1','Mysql','2022/04/04'),
('3','1','1','2','Sgbd','2022/04/04'),
('4','1','1','1','Reseaux','2022/04/04'),
('26','1','1','1','Statisques 1','2022/04/04'),
('27','2','1','1','probabilite 1','2022/04/04'),
('28','1','2','1','Word','2022/04/04'),
('5','2','1','1','Statisques 1','2022/04/04'),
('6','2','1','1','Macro Economie','2022/04/04'),
('7','2','1','2','Micro Economie','2022/04/04'),
('8','2','1','2','Statisques 2','2022/04/04'),
('9','2','1','1','Droit des Affaires','2022/04/04'),
('10','2','1','1','Math Financier','2022/04/04'),
('11','3','1','1','Analyse Numerique','2022/04/04'),
('12','3','1','1','Circuit Electriques','2022/04/04'),
('13','3','1','1','Mecaniques des fluides','2022/04/04'),
('14','3','1','1','Mecaniques des materiaux','2022/04/04'),
('15','3','1','1','Mecaniques du solide','2022/04/04'),
('16','4','1','1','Vibrations','2022/04/04'),
('17','4','1','1',' Metallurgies','2022/04/04'),
('18','4','1','1',' Beton Arme','2022/04/04'),
('19','4','1','1',' Routes','2022/04/04'),
('20','4','1','1',' Dessin','2022/04/04'),
('21','5','1','1',' Biologie','2022/04/04'),
('22','5','1','1',' Administration','2022/04/04'),
('23','5','1','2',' Philosophie','2022/04/04'),
('24','5','1','2',' Mathematique','2022/04/04'),
('25','5','1','1',' langues Vivantes','2022/04/04');


/* -- Insertion Etudiant  */

insert into etudiant values 
('161','cear','michel','Median','1','1','2022'),
('111','marc','mendel','Median','1','1','2022'),
('121','paul','keke','Median','1','1','2022'),
('131','peter','steeve','Median','1','1','2022'),
('141','samus','ala','Median','1','1','2022'),
('151','bibi','jean','Median','1','1','2022'),
('1611','lelly','lolo','Median','1','1','2022'),
('1111','dada','sasa','Median','1','1','2022'),
('1211','paul','deno','Median','1','1','2022'),
('1311','peter','jp','Median','1','1','2022'),
('1411','bebous','venven','Median','1','1','2022'),
('1511','mama','toto','Median','1','1','2022'),
('1612','andre','michel','Median','1','1','2022'),
('1112','marc0','mendela','Median','1','1','2022'),
('1212','paula','keko','Median','1','1','2022'),
('1312','peterson','stol','Median','1','1','2022'),
('1412','saul','luffy','Median','1','1','2022'),
('1512','naruto','pierre','Median','1','1','2022');


/*   -- Insertion Palmares  

insert into palmares values
 ('pam23','1','1','Median','100','2017','2022'),
 ('pam13','1','1','Matin','100','2017','2022');
*/
/*   -- Insertion EvaluationsNormal   

insert into EvaluationsNormal values 
('1','pam23','Intra','Examen','40','2022'),
('2','pam23','Final','Examen','40','2022');
*/
/*   -- Insertion EvaluationsReprise   

insert into EvaluationsReprise values 
('1','pam23','1','Examen','100','2022'),
('2','pam23','2','Examen','100','2022');
*/
/*  -- Insertion Notes  

 insert into NotesNormal values('no123','2','1','25','2022'),
('no1263','1','2','15','2022'),
('no129','2','3','45','2022'),
('no153','1','4','24','2022'),
('no1223','1','1','25','2022'),
('no12623','1','2','35','2022'),
('no1229','2','3','25','2022'),
('no1523','1','4','14','2022');

*/
select E.Id_Etud,E.Nom_Etud,E.Prenom_Etud,N.note from etudiant E, Notes N, palmares P where P.Id_Cours='1';

select sum(CoeficientNormal) as nombre from EvaluationsNormal natural join palmares where codepalmares='Palm-439809';

select Nom_Cours from cours natural join palmares where codepalmares='Palm-439809';
select Nom_Opt from options natural join palmares where codepalmares='Palm-439809';
select codeEvaluationsNormal from EvaluationsNormal where codepalmares='Palm-439809' and TypesNormal='Intra'  and DescriptionsNormal='Examen';
select E.Id_Etud,E.Nom_Etud,E.Prenom_Etud,N.notenormal from etudiant E,palmares P,EvaluationsNormal V, NotesNormal N where V.codeEvaluationsNormal='EvNor-615172';


--
 select  E.Id_Etud,E.Nom_Etud,E.Prenom_Etud ,D.CoeficientNormal,
 from etudiant E,Palmares P, EvaluationsNormal D 
 where E.promotion=P.promotion and  E.NomVacation=P.NomVacation  and E.Id_Opt=P.Id_Opt 
 and P.codepalmares=D.codepalmares and D.codeEvaluationsNormal='EvNor-615172';
--
 Select notenormal from NotesNormal natural join Etudiant where Id_Etud='11' and codeEvaluationsNormal='EvNor-615172';
 Select codenotnormal from NotesNormal natural join Etudiant where Id_Etud='11' and codeEvaluationsNormal='EvNor-615172';
-- requete pou rechercher information evaluation
select E.codeEvaluationsNormal ,O.Nom_Opt,C.Nom_Cours,S.NomSession,N.Niveau,P.promotion,V.NomVacation,
E.Codepalmares,E.TypesNormal,E.DescriptionsNormal,E.CoeficientNormal,
from Options O,Cours C, Sessionx S , Niveaux N ,palmares P , Vacations V,EvaluationsNormal E where
O.Id_Opt=C.Id_Opt and  N.codeniv=C.codeniv and  S.codesession=C.codesession
 and C.Id_Cours=P.Id_Cours and V.NomVacation=P.NomVacation  and P.codepalmares=E.codepalmares 

-- requete poum konnen nombre de colonne palmaresse
select count(*) as nombre from EvaluationsNormal where codepalmares='Palm-439809';
-- requete poum pran chan yo 
select notenormal from NotesNormal natural join EvaluationsNormal  where codepalmares='Palm-439809' and TypesNormal='Final' 
and  DescriptionsNormal='Examen'  and Id_Etud='4';





select E.Id_Etud,E.Nom_Etud,E.Prenom_Etud from Etudiant E,Palmares P 
where E.promotion=P.promotion and  E.NomVacation=P.NomVacation  and E.Id_Opt=P.Id_Opt 
 and codepalmares='Palm-439809' and E.Id_Etud='111';


select codepalmares from palmares where Id_Opt='1' and Id_Cours='1' and promotion='2022' and NomVacation='Median';

select C.Nom_Cours from cours C , options O,Etudiant E 
 where C.Id_Opt=O.Id_Opt and O.Id_Opt=E.Id_Opt and Id_Etud='11';


select O.Nom_Opt,C.Nom_Cours,P.NomVacation,P.Promotion,S.NomSession,N.Niveau
from Options O,Cours C,palmares P,Sessionx S,Niveaux N 
where O.Id_Opt=P.Id_Opt and N.codeniv=C.codeniv and S.codesession=C.codesession  
and C.Id_Cours=P.Id_Cours and P.codepalmares='Palm-439809';


-- bulletin 
select Id_Cours,Nom_Cours from cours natural Etudiant where Id_Opt='1'  and codeniv='1' and codesession='1' and Id_Etud='111';

select codepalmares from palmares  where   NomVacation='Median' and promotion='2022' and Id_Opt='1'  and Id_Cours='1';

select notenormal from NotesNormal natural join EvaluationsNormal  where codepalmares='Palm-439809' and TypesNormal='Final' 
and  DescriptionsNormal='Examen'  and Id_Etud='111';
26
12
18
44
69
65
25
21
34
10
10
5
10
20
10
20
10
10
10
20
30
49
49
35
70

select Sum(N.notenormal)  from NotesNormal N,Cours C,etudiant E,Palmares P,EvaluationsNormal S  where
 N.codeEvaluationsNormal=S.codeEvaluationsNormal and  S.codepalmares= P.codepalmares and   C.Id_Cours=P.Id_Cours  and 
 P.NomVacation=E.NomVacation and 
   C.codeniv='1' and C.codesession='1' and P.Id_Opt='Options-9828'  and E.Id_Etud='Etud-4664'

select O.Nom_Opt,P.NomVacation,P.Promotion,S.NomSession,N.Niveau,E.Nom_Etud,E.Prenom_Etud,
 C.codeniv , C.codesession , P.Id_Opt
from Options O,Cours C,palmares P,Sessionx S,Niveaux N ,Etudiant E
where O.Id_Opt=P.Id_Opt and N.codeniv=C.codeniv and S.codesession=C.codesession  
and C.Id_Cours=P.Id_Cours and p.Id_Opt=E.Id_Opt and P.codepalmares='Palm-jfjj'  and E.Id_Etud='111';

--
select Id_Cours from Cours natural join options where Nom_Opt='Sciences Informatique' and Nom_Cours='Biologie'

select SUM(N.notenormal) as nombre  from NotesNormal N,Cours C,etudiant E,Palmares P,EvaluationsNormal S  where
 N.codeEvaluationsNormal=S.codeEvaluationsNormal and  S.codepalmares= P.codepalmares and   C.Id_Cours=P.Id_Cours  and 
   C.codeniv='1' and C.codesession='1' and P.Id_Opt='Options-9828'  and E.Id_Etud='Etud-4664';

select count(*) as nombre from cours  where Id_Opt='1'  and codeniv='1' and codesession='1';


select O.Nom_Opt,E.NomVacation,E.Promotion,S.NomSession,N.Niveau,E.Nom_Etud,E.Prenom_Etud,
 N.codeniv , S.codesession , O.Id_Opt
from Options O,Cours C,Sessionx S,Niveaux N ,Etudiant E
where  N.codeniv=C.codeniv and S.codesession=C.codesession  
and   C.codeniv='1' and C.codesession='1' and  C.Id_Opt=O.Id_Opt  
 and O.Id_Opt=E.Id_Opt and E.Id_Etud='111' group by codeniv,codesession;


Select code, nom, prenom, sexe, nif, adresse, telephone, email, dateNaissance, statut, fonction, salaire from personne natural join employe where code='LaKe-18965';

SELECT C.Nom_Cours,Cs.Vacations,O.Nom_Opt  from CoursSelects Cs, Cours C,options O
where O.Id_Opt=C.Id_Opt and C.Id_Cours=Cs.Id_Cours and Cs.codecs='Cs-2217887';