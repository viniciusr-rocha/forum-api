CREATE TABLE tb_user_role
(
    id      BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    user_id BIGINT                            NOT NULL,
    role_id BIGINT                            NOT NULL,
    FOREIGN KEY (user_id) REFERENCES tb_user (id),
    FOREIGN KEY (role_id) REFERENCES tb_role (id)
);

INSERT INTO tb_user_role(id, user_id, role_id)
VALUES (1, 1, 1);