--liquibase formatted sql
--changeset gabriel:1
--comment: boards table create


CREATE TABLE IF NOT EXISTS usuario(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(150) NOT NULL
)ENGINE=InnoDB;

--rollback DROP TABLE BOARDS