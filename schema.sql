CREATE TABLE Product(
Id INT AUTO_INCREMENT NOT NULL,
name VARCHAR(64) NOT NULL,
numberOfTokens INT NOT NULL);

CREATE TABLE Agreement(
Id INT NOT NULL,
customerId INT NOT NULL,
product.productId
);

CREATE TABLE Token(
customer.id INT NOT NULL,
signedAgreement timeStamp NOT NULL
);

CREATE TABLE Customer(
customerId NOT NULL,
firstName VARCHAR(64) NOT NULL,
lastName VARCHAR(64) NOT NULl,
email VARCHAR(64)
);

ALTER TABLE Product ADD FOREIGN KEY (product.productId) REFERENCES Product(Id)
ALTER TABLE Customer ADD FOREIGN KEY (customerId) REFERENCES Customer(Id)
ALTER TABLE token ADD FOREIGN KEY (customerId) REFERENCES Customer(Id)
ALTER TABLE Product ADD FOREIGN KEY () REFERENCES Customer(Id)



