CREATE TABLE Product(
Id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(64) NOT NULL,
numberOfTokens INT);

CREATE TABLE Agreement(
Id INT PRIMARY KEY,
customerId INT NOT NULL,
product.productId INT
);

CREATE TABLE Token(
customerId INT PRIMARY KEY,
productId INT NOT NULL,
signedAgreement timeStamp PRIMARY KEY
);

CREATE TABLE Customer(
Id INT PRIMARY KEY,
firstName VARCHAR(64) NOT NULL,
lastName VARCHAR(64) NOT NULl,
email VARCHAR(64)
);

ALTER TABLE Agreement ADD FOREIGN KEY (product.productId) REFERENCES Product(Id);
ALTER TABLE Agreement ADD FOREIGN KEY (customerId) REFERENCES Customer(Id);
ALTER TABLE Token ADD FOREIGN KEY (customerId) REFERENCES Customer(Id);
ALTER TABLE Token ADD FOREIGN KEY (signedAgreement) REFERENCES Customer(Id);
ALTER TABLE Token ADD FOREIGN KEY (signedAgreement) REFERENCES Product(Id);
ALTER TABLE Token ADD FOREIGN KEY (customerId) REFERENCES Product(Id);



