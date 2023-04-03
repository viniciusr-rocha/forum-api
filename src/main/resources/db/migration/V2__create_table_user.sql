CREATE TABLE IF NOT EXISTS tb_user
(
    id    BIGINT PRIMARY KEY AUTO_INCREMENT,
    name  VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    INDEX (id)
);

INSERT INTO tb_user
VALUES (1, 'Kotlin', 'kotlin@email.com');