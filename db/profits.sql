CREATE TABLE Profits (
    profit_id INT PRIMARY KEY,
    customer_id INT,
    purchase_id INT,
    sale_id INT,
    purchase_price DECIMAL(10,2),
    sale_price DECIMAL(10,2),
    profit DECIMAL(10,2),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id) ON DELETE CASCADE,
    FOREIGN KEY (purchase_id) REFERENCES Costs(purchase_id) ON DELETE CASCADE,
    FOREIGN KEY (sale_id) REFERENCES Sales(sale_id) ON DELETE CASCADE
);
