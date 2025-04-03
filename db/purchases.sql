CREATE TABLE Purchases (
    purchase_id INT PRIMARY KEY,
    article_id INT,
    type ENUM('license','packaging','product','other') NOT NULL,
    cost_status ENUM('delivered','other') NOT NULL,
    amount INT,
    date DATE,
    net_price DECIMAL(10,2),
    shipping DECIMAL(10,2),
    tax DECIMAL(10,2),
    FOREIGN KEY (article_id) REFERENCES Articles(article_id) ON DELETE CASCADE
);
