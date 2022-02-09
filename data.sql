INSERT INTO PRODUCT(name, numberOfTokens) VALUES ('Mortgage', 3);
INSERT INTO PRODUCT(name, numberOfTokens) VALUES ('childrensSavings', 2);
INSERT INTO PRODUCT(name, numberOfTokens) VALUES ('pensionsSavings', 2);
INSERT INTO PRODUCT(name, numberOfTokens) VALUES ('insurance', 1);

INSERT INTO AGREEMENT(Id, customerId, productId) VALUES (1, '720327-5933', 1);
INSERT INTO AGREEMENT(Id, customerId, productId) VALUES (1, '720327-5933', 2);
INSERT INTO AGREEMENT(Id, customerId, productId) VALUES (1, '720327-5933', 4);
INSERT INTO AGREEMENT(Id, customerId, productId) VALUES (1, '720327-5934', 2);
INSERT INTO AGREEMENT(Id, customerId, productId) VALUES (1, '720327-5934', 3);
INSERT INTO AGREEMENT(Id, customerId, productId) VALUES (1, '720327-5934', 4);

INSERT INTO TOKEN(customerId, productId, signedAgreement) VALUES ('720327-5933', 1, '2022-01-05 05:00:00');
INSERT INTO CUSTOMER(customerId, firstName, lastName, maritalStatus, children, typeOfLiving) VALUES ('720327-5933', 'Ronald', 'McDonald', 3, true, 2);

