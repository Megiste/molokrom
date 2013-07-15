
 # --- !Ups

 
INSERT INTO place VALUES (1,'Route de Vaulion');
INSERT INTO place VALUES (2,'Place du bourg gauche');
INSERT INTO place VALUES (3,'Place du bourg droite');
INSERT INTO place VALUES (4,'Croy');

INSERT INTO status (place_id,state,name,dte_upd) VALUES (1,'G','init',CURRENT_TIMESTAMP);
INSERT INTO status (place_id,state,name,dte_upd) VALUES (2,'R','init',CURRENT_TIMESTAMP);
INSERT INTO status (place_id,state,name,dte_upd) VALUES (3,'R','init',CURRENT_TIMESTAMP);
INSERT INTO status (place_id,state,name,dte_upd) VALUES (4,'G','init',CURRENT_TIMESTAMP);

commit;


# --- !Downs

