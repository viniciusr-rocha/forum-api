CREATE TABLE IF NOT EXISTS tb_answer
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    message    VARCHAR(300) NOT NULL,
    created_at DATETIME     NOT NULL,
    topic_id   BIGINT       NOT NULL,
    user_id    BIGINT       NOT NULL,
    is_solved  BOOLEAN      NOT NULL,
    INDEX (id),
    FOREIGN KEY (topic_id) REFERENCES tb_topic (id),
    FOREIGN KEY (user_id) REFERENCES tb_user (id)
);