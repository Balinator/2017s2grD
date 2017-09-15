INSERT INTO USER (ACTIVE, EMAIL, FIRSTNAME, LASTNAME, LOCKVERSION, PASSWORD, PHONENUMBER, USERNAME) VALUES (1, 'admin@msg.ro', 'admin', 'csaba', 1, 'e10adc3949ba59abbe56e057f20f883e', '37476573', 'admin');

INSERT INTO PERMISSION (NAME,DETAIL) VALUES ('permission.management','add permissions...');
INSERT INTO PERMISSION (NAME,DETAIL) VALUES ('user.management','detail');
INSERT INTO PERMISSION (NAME,DETAIL) VALUES ('bug.management','detail');
INSERT INTO PERMISSION (NAME,DETAIL) VALUES ('bug.close','detail');

INSERT INTO ROLE(NAME) VALUES ('role.administrator');
INSERT INTO ROLE(NAME) VALUES ('role.projectmanager');
INSERT INTO ROLE(NAME)VALUES ('role.testmanager');
INSERT INTO ROLE(NAME) VALUES ('role.developer');
INSERT INTO ROLE(NAME) VALUES ('role.tester');
INSERT INTO BUG (ID, ASSIGNED, AUTHOR, DESCRIPTION, FIXEDIN, LOCKVERSION, SEVERITY, STATUS, TARGETDATE, TITLE, VERSION) VALUES (1, 2, 1, 'sdfasdfsa', 'dsdfad', 1, 'dsfsdf', 1, 'dsafsad', 'Buggy', 'asdsad');

INSERT INTO ROLE_PERMISSION(idrole, idpermission) VALUES (1,1)
INSERT INTO ROLE_PERMISSION(idrole, idpermission) VALUES (1,2)
INSERT INTO ROLE_PERMISSION(idrole, idpermission) VALUES (1,3)
INSERT INTO ROLE_PERMISSION(idrole, idpermission) VALUES (5,4)