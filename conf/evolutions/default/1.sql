# Place and status schema
 
# --- !Ups

CREATE SEQUENCE status_id_seq;
CREATE TABLE place (
    id integer NOT NULL,
    label varchar(255)
);

CREATE TABLE status (
    id integer NOT NULL DEFAULT nextval('status_id_seq'),
    place_id integer NOT NULL,
    state varchar(1),
    name varchar(255),
    dte_upd timestamp
);
 
 
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
 
DROP TABLE place;
DROP TABLE status;
DROP SEQUENCE status_id_seq;