
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
 
 

# --- !Downs
 
DROP TABLE place;
DROP TABLE status;
DROP SEQUENCE status_id_seq;