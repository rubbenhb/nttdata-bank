INSERT INTO CUSTOMERS(first_name, last_name, doc_type, nro_doc, client_type, direction, gender, state) VALUES('RUBEN', 'HOLGUINO', '1', 66161392, 1, 'JIRAOLES', 'MALE', 1);
INSERT INTO CUSTOMERS(first_name, last_name, doc_type, nro_doc, client_type, direction, gender, state) VALUES('CESIA', 'DELGADO', '1', 73618291, 1, 'LA CAÑADA', 'FEMALE', 1);
INSERT INTO CUSTOMERS(first_name, last_name, doc_type, nro_doc, client_type, direction, gender, state) VALUES('JESUS', 'URQUIZO', '1', 60458298, 1, 'VIVA EL PERU', 'MALE', 1);
INSERT INTO CUSTOMERS(first_name, last_name, doc_type, nro_doc, client_type, direction, gender, state) VALUES('CONSORCIO RAMONES', NULL, '2', 12479419160, 2, 'AV. LA MARINA', NULL, 1);
INSERT INTO CUSTOMERS(first_name, last_name, doc_type, nro_doc, client_type, direction, gender, state) VALUES('REPRESENTACIONES CAMILA', NULL, '2', 12333419185, 2, 'TORREONES', NULL, 1);

INSERT INTO CTAS(TYPE_PRODUCT, DATE_CREATION, DATE_CLOSE, STATE) VALUES('CREDIT', '2020-09-15', null, 'active');
INSERT INTO CTAS(TYPE_PRODUCT, DATE_CREATION, DATE_CLOSE, STATE) VALUES('CARD', '2020-09-10', null, 'active');

INSERT INTO SIGNERS(relation, product,type_product,state,customer,cta)values('TITULAR', 2,'CREDIT','ACTIVE',1,1);
INSERT INTO SIGNERS(relation, product,type_product,state,customer,cta)values('TITULAR', 2,'CARD','ACTIVE',3,2);
