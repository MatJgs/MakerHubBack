INSERT INTO "user" ("role", created_at,email,first_name,last_name,"login","password",phone,enabled) VALUES ('ADMIN',now(),'mmmm@gmail.com','Admin','Istrateur','admin','$2a$04$1w4BAdAhhhH3g4EAso8Rp.1y2CyMLRx8MJCtplcEXHyfZEhGoGNlK','4444 444 444',true);
INSERT INTO "user" ("role", created_at,email,first_name,last_name,"login","password",phone,enabled) VALUES ('STUDENT',now(),'mmmm@gmail.com','Etu','Diant','student','$2a$04$1w4BAdAhhhH3g4EAso8Rp.1y2CyMLRx8MJCtplcEXHyfZEhGoGNlK','4444 444 444',true);
INSERT INTO "user" ("role", created_at,email,first_name,last_name,"login","password",phone,enabled) VALUES ('FORMATEUR',now(),'mmmm@gmail.com','Form','Ateur','form','$2a$04$1w4BAdAhhhH3g4EAso8Rp.1y2CyMLRx8MJCtplcEXHyfZEhGoGNlK','4444 444 444',true);
INSERT INTO "user" ("role", created_at,email,first_name,last_name,"login","password",phone,enabled) VALUES ('FORMATEUR',now(),'mmmm@gmail.com','Jean','Neymar','jeaney','$2a$04$1w4BAdAhhhH3g4EAso8Rp.1y2CyMLRx8MJCtplcEXHyfZEhGoGNlK','4444 444 444',true);
INSERT INTO "user" ("role", created_at,email,first_name,last_name,"login","password",phone,enabled) VALUES ('TECHNOBEL',now(),'mmmm@gmail.com','Pacome','Toulmonde','pactou','$2a$04$1w4BAdAhhhH3g4EAso8Rp.1y2CyMLRx8MJCtplcEXHyfZEhGoGNlK','4444 444 444',true);



INSERT INTO sujet (created_at,titre,description,utilisateur_id,enabled,hidden) VALUES ('31/12/2022','CJIP: les entreprises ','CJIP : depuis 2016, les entreprises peuvent conclure un accord avec la justice quand elles sont poursuivies pour corruption ou fraude. Bonne idée ?',2,false,true);
INSERT INTO sujet (created_at,titre,description,utilisateur_id,enabled,hidden) VALUES ('7/03/2022','Peut-on dire au revoir aux bouteilles en plastique ?','Chaque minute, un million de bouteilles en plastique sont achetées dans le monde. Elles font partie de notre quotidien, mais peut-on s’en passer ?',1,false,false);
INSERT INTO sujet (created_at,titre,description,utilisateur_id,enabled,hidden) VALUES ('7/03/2022','La retraite plus tôt','Peut-on dire au revoir aux bouteilles en plastique ?',1,true,false);

INSERT INTO argumentation(argument,avis,date_creation,sujet_id,utilisateur_id)VALUES ('C’est une bonne idée parce que voilà',true,now(),1,3);

INSERT INTO argumentation(argument,avis,date_creation,sujet_id,utilisateur_id)VALUES ('Je pense qu’on peut s’en séparer',true,now(),3,4);





