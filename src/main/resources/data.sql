INSERT INTO CUSTOMER(persNo, password, firstName, lastName) VALUES ('720327-5933', 'password123', 'Ronald', 'McDonald');
INSERT INTO CUSTOMER(persNo, password, firstName, lastName)  VALUES ('720327-5934', 'password123', 'Robyn', 'Doyle');
INSERT INTO CUSTOMER(persNo, password, firstName, lastName)  VALUES ('720327-5935', 'password123', 'Niklas', 'Sandberg');
INSERT INTO CUSTOMER(persNo, password, firstName, lastName)  VALUES ('720327-5936', 'password123', 'Niklas', 'Sandberg');

INSERT INTO Product(name, numberOfTokens) VALUES ('Mortgage', 5);
INSERT INTO Product(name, numberOfTokens) VALUES ('ChildrensSavings', 2);
INSERT INTO Product(name, numberOfTokens) VALUES ('PensionsSavings', 2);
INSERT INTO Product(name, numberOfTokens) VALUES ('Insurance', 1);

INSERT INTO Agreement(customerId, productId, agreementSignedDate, agreementSignedTime) VALUES (1, 1, '2022-01-01','10:00:00');
INSERT INTO Agreement(customerId, productId, agreementSignedDate, agreementSignedTime) VALUES (2, 2, '2022-01-01','10:00:00');
INSERT INTO Agreement(customerId, productId, agreementSignedDate, agreementSignedTime) VALUES (3, 2, '2022-01-01','10:00:00');

INSERT INTO CustomerInfo(customerId, maritalStatus, children, accommodation) VALUES (1, 'Single', 0, 'Rental');
