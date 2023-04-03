INSERT INTO "user" (email,first_name,last_name,login,password,phone) VALUES ('mmmm@gmail.com','Florent','Toulmonde','flotou','1234','4444 444 444');
INSERT INTO "user" (email,first_name,last_name,login,password,phone) VALUES ('mmmm@gmail.com','William','Toulmonde','wiltou','1234','4444 444 444');



INSERT INTO sujet (date_creation,description,titre,made_by_id) VALUES (now(),'Bonjour à tous je suis contre','Avoir congé',0);
INSERT INTO sujet (date_creation,description,titre,made_by_id) VALUES (now(),'Bonjour à tous je suis contre','Manger du foie gras',1);

INSERT INTO argumentation(argument,avis,date_creation,auteur_id)VALUES ('Je suis pour',true,now(),1);





