
CREATE DATABASE isi_suivi_cours CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


CREATE USER 'isiuser'@'localhost' IDENTIFIED BY 'isipassword';

FLUSH PRIVILEGES;

GRANT ALL PRIVILEGES ON isi_suivi_cours.* TO 'isiuser'@'localhost';

INSERT INTO `isi_suivi_cours`.`moderator`
(`id`,`username`,`password`)
VALUES
( 1055 , 'admin', 'azerty');
