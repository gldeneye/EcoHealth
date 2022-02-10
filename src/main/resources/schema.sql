CREATE TABLE Customer(
Id INT PRIMARY KEY AUTO_INCREMENT,
persNo VARCHAR(13) UNIQUE NOT NULL,
password VARCHAR(40) NOT NULL,
firstName VARCHAR(64) NOT NULL,
lastName VARCHAR(64) NOT NULL,
email VARCHAR(64)
);

CREATE TABLE Product(
Id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(64) NOT NULL,
numberOfTokens INT
);

CREATE TABLE Agreement(
Id INT AUTO_INCREMENT PRIMARY KEY,
customerId INT,
productId INT,
agreementSignedDate DATE,
agreementSignedTime TIME
);

CREATE TABLE CustomerInfo(
Id INT AUTO_INCREMENT PRIMARY KEY,
customerId INT,
maritalStatus VARCHAR(50),
children BIT,
accommodation VARCHAR(50)
);

ALTER TABLE Agreement ADD FOREIGN KEY (customerId) REFERENCES Customer(Id);
ALTER TABLE Agreement ADD FOREIGN KEY (productId) REFERENCES Product(Id);

ALTER TABLE CustomerInfo ADD FOREIGN KEY (customerId) REFERENCES Customer(Id);



