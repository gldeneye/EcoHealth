CREATE TABLE Product(
Id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(64) NOT NULL,
numberOfTokens INT);

CREATE TABLE Agreement(
Id INT AUTO_INCREMENT PRIMARY KEY,
customerId String NOT NULL FOREIGN KEY REFERENCES Customer(Id),
productId INT FOREIGN KEY REFERENCES Product(Id)
);

CREATE TABLE Token(
id INT AUTO_INCREMENT PRIMARY KEY,
customerId INT FOREIGN KEY REFERENCES Customer(Id),
productId INT NOT NULL FOREIGN KEY REFERENCES Product(Id),
signedAgreement timeStamp
);

CREATE TABLE Customer(
Id INT auto_increment PRIMARY KEY,
persNo varchar(13),
password varchar(20),
firstName VARCHAR(64) NOT NULL,
lastName VARCHAR(64) NOT NULl,
email VARCHAR(64)
);