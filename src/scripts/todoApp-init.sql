DROP
DATABASE IF EXISTS todoapp;
DROP
USER IF EXISTS `vermillion`@`%`;
CREATE
DATABASE IF NOT EXISTS todoapp CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE
USER IF NOT EXISTS `vermillion`@`%` IDENTIFIED WITH mysql_native_password BY '041002';
GRANT
SELECT,
INSERT
,
UPDATE,
DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
CREATE
ROUTINE, ALTER ROUTINE
, EVENT, TRIGGER ON `matrix_spring`.* TO `vermillion`@`%`;