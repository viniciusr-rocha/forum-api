CREATE TABLE tb_role
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(50)                       NOT NULL
);

INSERT INTO tb_role (id, name)
VALUES (1, 'READ_WRITE');