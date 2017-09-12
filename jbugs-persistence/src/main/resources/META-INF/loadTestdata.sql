INSERT INTO USER (ACTIVE, EMAIL, FIRSTNAME, LASTNAME, LOCKVERSION, PASSWORD, PHONENUMBER, USERNAME) VALUES (1, 'admin@msg.ro', 'admin', 'csaba', 1, 'e10adc3949ba59abbe56e057f20f883e', '37476573', 'admin');

INSERT INTO PERMISSION (NAME,DETAIL) VALUES ('permission.managment','add permissions...');
INSERT INTO PERMISSION (NAME,DETAIL) VALUES ('user.managment','detail');
INSERT INTO PERMISSION (NAME,DETAIL) VALUES ('bug.managment','detail');
INSERT INTO PERMISSION (NAME,DETAIL) VALUES ('bug.close','detail');

INSERT INTO ROLE(NAME) VALUES ('role.administrator');
INSERT INTO ROLE(NAME) VALUES ('role.projectmanager');
INSERT INTO ROLE(NAME)VALUES ('role.testmanager');
INSERT INTO ROLE(NAME) VALUES ('role.developer');
INSERT INTO ROLE(NAME) VALUES ('role.tester');
