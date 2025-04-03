CREATE TABLE Articles (
    article_id INT PRIMARY KEY,
    dealer_id INT,
    type ENUM('electronic','ticket','toy','clothing','other') NOT NULL,
    name VARCHAR(255),
    description VARCHAR(255),
    FOREIGN KEY (dealer_id) REFERENCES Dealers(dealer_id) ON DELETE CASCADE
);
