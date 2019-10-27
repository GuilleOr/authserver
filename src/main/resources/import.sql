INSERT INTO permission(ID, CREATION_DATE, LAST_UPDATE, UUID, ACTIVE, DESCRIPTION, NAME,LEVEL) VALUES('1','2019-06-29 00:00:00','2019-06-29 00:00:00','1', 1, 'Permiso de prueba', 'CREATE_CLIENT','ADMINISTRATOR');
INSERT INTO role (ID, CREATION_DATE, LAST_UPDATE, UUID, ACTIVE, DESCRIPTION, NAME, NORMALIZED_NAME, LEVEL) values (1,'2019-06-29 00:00:00','2019-06-29 00:00:00','1', 1, 'Adminstrator profile','ADMINISTRATOR', 'administrator','ADMINISTRATOR');
INSERT INTO role_permission(ROLE_ID, PERMISSION_ID) VALUES (1,1);
INSERT INTO document_type(ID, CREATION_DATE, LAST_UPDATE, UUID, ACTIVE,NAME, COUNTRY_ID) VALUES('1','2019-06-29 00:00:00','2019-06-29 00:00:00','21', 1, 'DNI','AR_ar');
INSERT INTO user (id,creation_date, last_update , uuid, active , bad_login, email, last_login, locked, name, password, phone, user_type, username,document_number, document_type_id) VALUES (1,'2019-06-29 00:00:00','2019-06-29 00:00:00','1', 1,0,'seebogado@gmail.com','2019-06-29 00:00:00',0, 'Sebastian Emanuel Enrique Bogado','$2a$10$sLb/CR/c5o3pa89UwOZYz.c.AuTpJ7FPpuVB3kVrLrDpTxe5PYRWq','54 9 1162961073','PERSON','sbogado','38256096', 1);
INSERT INTO user_role(USER_ID, ROLE_ID) VALUES (1,1);
