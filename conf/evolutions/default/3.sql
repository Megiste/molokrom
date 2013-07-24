
 # --- !Ups

 
INSERT INTO place VALUES (5,'Le fochau');
INSERT INTO place VALUES (6,'Envy');

INSERT INTO status (place_id,state,name,dte_upd) VALUES (5,'G','init',CURRENT_TIMESTAMP - 10);
INSERT INTO status (place_id,state,name,dte_upd) VALUES (6,'R','init',CURRENT_TIMESTAMP - 10);

commit;


# --- !Downs

