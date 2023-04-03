CREATE TABLE IF NOT EXISTS tb_topic
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    title      VARCHAR(50)  NOT NULL,
    message    VARCHAR(300) NOT NULL,
    status     VARCHAR(20)  NOT NULL,
    created_at DATETIME,
    course_id  BIGINT       NOT NULL,
    user_id    BIGINT       NOT NULL,
    INDEX (id),
    FOREIGN KEY (course_id) REFERENCES tb_course (id),
    FOREIGN KEY (user_id) REFERENCES tb_user (id)
);