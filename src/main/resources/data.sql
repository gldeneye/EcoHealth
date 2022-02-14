INSERT INTO CUSTOMER(persNo, password, firstName, lastName) VALUES ('720327-5933', 'password123', 'Ronald', 'McDonald');
INSERT INTO CUSTOMER(persNo, password, firstName, lastName)  VALUES ('720327-5934', 'password123', 'Robyn', 'Doyle');
INSERT INTO CUSTOMER(persNo, password, firstName, lastName)  VALUES ('720327-5935', 'password123', 'Niklas', 'Sandberg');
INSERT INTO CUSTOMER(persNo, password, firstName, lastName)  VALUES ('720327-5936', 'password123', 'Niklas', 'Sandberg');

INSERT INTO Product(name, numberOfTokens) VALUES ('Mortgage', 5000);
INSERT INTO Product(name, numberOfTokens) VALUES ('BufferSavings', 1000);
INSERT INTO Product(name, numberOfTokens) VALUES ('ChildrensSavings', 2000);
INSERT INTO Product(name, numberOfTokens) VALUES ('PensionsSavings', 2000);
INSERT INTO Product(name, numberOfTokens) VALUES ('Insurance', 1500);

--Ronald Test
INSERT INTO Agreement(CustomerId, productId, agreementSignedDate, agreementSignedTime) VALUES (1, 1, '2022-01-01','10:00:00');
INSERT INTO Agreement(CustomerId, productId, agreementSignedDate, agreementSignedTime) VALUES (1, 2, '2022-01-10','10:00:00');
INSERT INTO Agreement(CustomerId, productId, agreementSignedDate, agreementSignedTime) VALUES (1, 3, '2022-01-10','10:00:00');
INSERT INTO Agreement(CustomerId, productId, agreementSignedDate, agreementSignedTime) VALUES (1, 4, '2022-01-10','10:00:00');
INSERT INTO Agreement(CustomerId, productId, agreementSignedDate, agreementSignedTime) VALUES (1, 5, '2022-01-10','10:00:00');

INSERT INTO Agreement(CustomerId, productId, agreementSignedDate, agreementSignedTime) VALUES (2, 2, '2022-01-01','10:00:00');
INSERT INTO Agreement(CustomerId, productId, agreementSignedDate, agreementSignedTime) VALUES (3, 2, '2022-01-01','10:00:00');

INSERT INTO MaritalStatus(Name) VALUES ('Single');
INSERT INTO MaritalStatus(Name) VALUES ('Sambo');
INSERT INTO MaritalStatus(Name) VALUES ('Married');
INSERT INTO Accommodation(Name) VALUES ('Hyres');
INSERT INTO Accommodation(Name) VALUES ('Ägande');

INSERT INTO CustomerInfo(CustomerId, MaritalStatusID, Children, AccommodationId) VALUES (1, 1, 0, 1);
INSERT INTO CustomerInfo(CustomerId, MaritalStatusID, Children, AccommodationId) VALUES (2, 2, 1, 1);
INSERT INTO CustomerInfo(CustomerId, MaritalStatusID, Children, AccommodationId) VALUES (3, 2, 0, 2);