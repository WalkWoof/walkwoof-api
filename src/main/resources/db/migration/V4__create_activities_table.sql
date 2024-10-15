CREATE TABLE activities
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    pet_id     INT       NOT NULL,
    walker_id  INT       NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time   TIMESTAMP,
    status     ENUM('scheduled', 'in_progress', 'completed') DEFAULT 'scheduled',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (pet_id) REFERENCES pets (id) ON DELETE CASCADE,
    FOREIGN KEY (walker_id) REFERENCES walkers (id) ON DELETE CASCADE
);