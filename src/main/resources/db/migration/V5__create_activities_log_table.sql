-- V2__Create_activities_log_table.sql
CREATE TABLE activities_log
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    activity_id INT           NOT NULL,
    latitude    DECIMAL(9, 6) NOT NULL,
    longitude   DECIMAL(9, 6) NOT NULL,
    recorded_at TIMESTAMP     NOT NULL,
    FOREIGN KEY (activity_id) REFERENCES activities (id) ON DELETE CASCADE
);
