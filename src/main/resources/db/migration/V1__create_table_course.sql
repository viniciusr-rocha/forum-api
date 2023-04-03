CREATE TABLE IF NOT EXISTS tb_course
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(50) NOT NULL,
    category VARCHAR(50) NOT NULL,
    INDEX (id)
);

INSERT INTO tb_course
VALUES (1, 'Kotlin', 'PROGRAMACAO');