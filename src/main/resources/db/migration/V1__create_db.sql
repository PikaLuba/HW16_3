CREATE TABLE world.note(
 id Integer PRIMARY KEY AUTO_INCREMENT,
 title VARCHAR(200) NOT NULL unique,
 content VARCHAR(200) NOT NULL
 )