CREATE TABLE role
(
    id              INT          NOT NULL AUTO_INCREMENT,
    version         INT,
    roleName        VARCHAR(60)  NOT NULL,
    roleDescription VARCHAR(255) NOT NULL,
    createdAt       TIMESTAMP,
    updatedAt       TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE `user`
(
    id         VARCHAR(36)  NOT NULL,
    version    INT,
    email      VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    fullName   VARCHAR(255) NOT NULL,
    phone      VARCHAR(14)  NOT NULL,
    isDelete   TIMESTAMP,
    roleId     INT,
    createdAt  TIMESTAMP,
    updatedAt  TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (roleId) REFERENCES role (id)
);

CREATE TABLE task
(
    id              VARCHAR(36)  NOT NULL,
    version         INT,
    taskName        VARCHAR(255) NOT NULL,
    taskDescription VARCHAR(255) NOT NULL,
    atTime          TIMESTAMP,
    userId          VARCHAR(36)  NOT NULL,
    completed       BOOLEAN,
    createdAt       TIMESTAMP,
    updatedAt       TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (userId) REFERENCES `user` (id)
);

INSERT INTO todoapp.role (version, roleName, roleDescription, createdAt, updatedAt)
VALUES (0, "user", "Read only", "2024-02-27 17:46:43", "2024-02-27 17:46:43");
INSERT INTO todoapp.role (version, roleName, roleDescription, createdAt, updatedAt)
VALUES (0, "admin", "Governor", "2024-02-27 17:46:43", "2024-02-27 17:46:43");

