INSERT INTO "user" (email,first_name,last_name,login,password,phone) VALUES ('mmmm@gmail.com','Florent','Toulmonde','flotou','1234','4444 444 444');
INSERT INTO "user" (email,first_name,last_name,login,password,phone) VALUES ('mmmm@gmail.com','William','Toulmonde','wiltou','1234','4444 444 444');



INSERT INTO sujet (date_creation,description,titre,utilisateur_id) VALUES ('31/12/2023','CJIP : depuis 2016, les entreprises peuvent conclure un accord avec la justice quand elles sont poursuivies pour corruption ou fraude. Bonne idée ?','CJIP : les entreprises doivent-elles pouvoir transiger avec la justice ?',1);
INSERT INTO sujet (date_creation,description,titre,utilisateur_id) VALUES ('7/03/2022','Chaque minute, un million de bouteilles en plastique sont achetées dans le monde. Elles font partie de notre quotidien, mais peut-on s’en passer ?','Peut-on dire au revoir aux bouteilles en plastique ?',2);

INSERT INTO argumentation(argument,avis,date_creation,sujet_id,utilisateur_id)VALUES ('Je suis pour',true,now(),1,1);

INSERT INTO argumentation(argument,avis,date_creation,sujet_id,utilisateur_id)VALUES ('Je suis contre',false,now(),1,2);





