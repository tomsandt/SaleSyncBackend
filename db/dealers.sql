CREATE TABLE Dealers (
    dealer_id INT PRIMARY KEY,
    type ENUM('private','commercial') NOT NULL,
    name VARCHAR(255),
    street VARCHAR(255),
    zipCode CHAR(5),
    city VARCHAR(255),
    eMail VARCHAR(255),
    phone VARCHAR(255)
);
