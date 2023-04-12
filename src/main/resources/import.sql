INSERT INTO "user" ("role", created_at,email,first_name,last_name,"login","password",phone,enabled) VALUES ('ADMIN',now(),'mmmm@gmail.com','Florent','Toulmonde','flotou','$2a$04$1w4BAdAhhhH3g4EAso8Rp.1y2CyMLRx8MJCtplcEXHyfZEhGoGNlK','4444 444 444',true);
INSERT INTO "user" ("role", created_at,email,first_name,last_name,"login","password",phone,enabled) VALUES ('STUDENT',now(),'mmmm@gmail.com','William','Toulmonde','wiltou','$2a$04$1w4BAdAhhhH3g4EAso8Rp.1y2CyMLRx8MJCtplcEXHyfZEhGoGNlK','4444 444 444',true);
INSERT INTO "user" ("role", created_at,email,first_name,last_name,"login","password",phone,enabled) VALUES ('FORMATEUR',now(),'mmmm@gmail.com','Pacome','Toulmonde','pactou','$2a$04$1w4BAdAhhhH3g4EAso8Rp.1y2CyMLRx8MJCtplcEXHyfZEhGoGNlK','4444 444 444',true);



INSERT INTO sujet (date_creation,description,titre,utilisateur_id) VALUES ('31/12/2023','CJIP : depuis 2016, les entreprises peuvent conclure un accord avec la justice quand elles sont poursuivies pour corruption ou fraude. Bonne idée ?','CJIP : les entreprises doivent-elles pouvoir transiger avec la justice ?',1);
INSERT INTO sujet (date_creation,description,titre,utilisateur_id) VALUES ('7/03/2022','Chaque minute, un million de bouteilles en plastique sont achetées dans le monde. Elles font partie de notre quotidien, mais peut-on s’en passer ?','Peut-on dire au revoir aux bouteilles en plastique ?',1);

INSERT INTO argumentation(argument,avis,date_creation,sujet_id,utilisateur_id)VALUES ('Je suis pour',true,now(),1,1);

INSERT INTO argumentation(argument,avis,date_creation,sujet_id,utilisateur_id)VALUES ('Je suis contre',false,now(),1,2);





