create table user_tbl
(
 id integer not null,
 parentid integer not null,
 color varchar(255),
 name varchar(255),
 primary key (id));



INSERT INTO user_tbl (id, parentid, name, color) VALUES (1, 0, 'Warrior', 'red');
INSERT INTO user_tbl (id, parentid, name, color) VALUES (2, 0, 'Wizard', 'green');
INSERT INTO user_tbl (id, parentid, name, color) VALUES (3, 0, 'Priest', 'white');
INSERT INTO user_tbl (id, parentid, name, color) VALUES (4, 0, 'Rogue', 'yellow');
INSERT INTO user_tbl (id, parentid, name, color) VALUES (5, 1, 'Fighter', 'blue');
INSERT INTO user_tbl (id, parentid, name, color) VALUES (6, 1, 'Paladin', 'lighblue');
INSERT INTO user_tbl (id, parentid, name, color) VALUES (7, 1, 'Ranger', 'lighgreen');
INSERT INTO user_tbl (id, parentid, name, color) VALUES (8, 2, 'Mage', 'grey');
INSERT INTO user_tbl (id, parentid, name, color) VALUES (9, 2, 'Specialist wizard', 'lightgrey');
INSERT INTO user_tbl (id, parentid, name, color) VALUES (10,3, 'Cleric', 'red');
INSERT INTO user_tbl (id, parentid, name, color) VALUES (11,3, 'Druid', 'green');
INSERT INTO user_tbl (id, parentid, name, color) VALUES (12,3, 'Priest of specific mythos', 'white');
INSERT INTO user_tbl (id, parentid, name, color) VALUES (13,4, 'Thief', 'yellow');
INSERT INTO user_tbl (id, parentid, name, color) VALUES (14,4, 'Bard', 'blue');
INSERT INTO user_tbl (id, parentid, name, color) VALUES (15,13, 'Assassin', 'lighblue');
