CREATE TABLE Sales (
    sale_id INT PRIMARY KEY,
    customer_id INT,
    article_id INT,
    sale_status ENUM('returned','other') NOT NULL,
    amount INT,
    date DATE,
    price DECIMAL(10,2),
    shipping DECIMAL(10,2),
    fee DECIMAL(10,2),
    tax DECIMAL(10,2),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id) ON DELETE CASCADE,
    FOREIGN KEY (article_id) REFERENCES Articles(article_id) ON DELETE CASCADE
);
