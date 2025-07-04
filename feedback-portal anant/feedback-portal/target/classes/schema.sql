-- If you prefer to create the table manually instead of letting JPA auto‑create it,
-- run this once against your MySQL instance and set spring.jpa.hibernate.ddl-auto=none
CREATE TABLE IF NOT EXISTS feedbacks(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    course_id VARCHAR(100) NOT NULL,
    rating INT NOT NULL,
    comment TEXT
);
