
CREATE DATABASE isi_suivi_cours CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


CREATE USER 'isi_suivi_cours'@'localhost' IDENTIFIED BY 'isipassword';

FLUSH PRIVILEGES;

GRANT ALL PRIVILEGES ON isi_suivi_cours.* TO 'isiuser'@'localhost';

