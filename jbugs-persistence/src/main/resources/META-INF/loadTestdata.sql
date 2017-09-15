INSERT INTO USER (ACTIVE, EMAIL, FIRSTNAME, LASTNAME, LOCKVERSION, PASSWORD, PHONENUMBER, USERNAME) VALUES (1, 'admin@msg.ro', 'admin', 'csaba', 1, 'e10adc3949ba59abbe56e057f20f883e', '37476573', 'admin');

INSERT INTO USER (ACTIVE, EMAIL, FIRSTNAME, LASTNAME, LOCKVERSION, PASSWORD, PHONENUMBER, USERNAME) VALUES (2, 'abdmin@msg.ro', 'szabi', 'ashd', 1, 'e10adc3949ba59abbe56e057f20f883e', '37476573', 'balazs');
INSERT INTO USER (ACTIVE, EMAIL, FIRSTNAME, LASTNAME, LOCKVERSION, PASSWORD, PHONENUMBER, USERNAME) VALUES (3, 'adcmin@msg.ro', 'gyuri', 'csfdgsaba', 1, 'e10adc3949ba59abbe56e057f20f883e', '37476573', 'attila');
INSERT INTO USER (ACTIVE, EMAIL, FIRSTNAME, LASTNAME, LOCKVERSION, PASSWORD, PHONENUMBER, USERNAME) VALUES (4, 'admdin@msg.ro', 'tomszelek', 'csdfgaba', 1, 'e10adc3949ba59abbe56e057f20f883e', '37476573', 'attila2');
INSERT INTO USER (ACTIVE, EMAIL, FIRSTNAME, LASTNAME, LOCKVERSION, PASSWORD, PHONENUMBER, USERNAME) VALUES (5, 'admcin@msg.ro', 'ggggg', 'csdfggaba', 1, 'e10adc3949ba59abbe56e057f20f883e', '37476573', 'szabi');
INSERT INTO USER (ACTIVE, EMAIL, FIRSTNAME, LASTNAME, LOCKVERSION, PASSWORD, PHONENUMBER, USERNAME) VALUES (1, 'peter@msg.ro', 'admin2', 'peter', 1, MD5('admin'), '37476573', 'admin2');


INSERT INTO PERMISSION (NAME,LOCKVERSION,DETAIL) VALUES ('permission.management',1,'add permissions...');
INSERT INTO PERMISSION (NAME,LOCKVERSION,DETAIL) VALUES ('user.management',1,'detail');
INSERT INTO PERMISSION (NAME,LOCKVERSION,DETAIL) VALUES ('bug.management',1,'detail');
INSERT INTO PERMISSION (NAME,LOCKVERSION,DETAIL) VALUES ('bug.close',1,'detail');

INSERT INTO ROLE(LOCKVERSION,NAME) VALUES (1,'role.administrator');
INSERT INTO ROLE(LOCKVERSION,NAME) VALUES (1,'role.projectmanager');
INSERT INTO ROLE(LOCKVERSION,NAME)VALUES (1,'role.testmanager');
INSERT INTO ROLE(LOCKVERSION,NAME) VALUES (1,'role.developer');
INSERT INTO ROLE(LOCKVERSION,NAME) VALUES (1,'role.tester');

INSERT INTO BUG (ID, ASSIGNED, AUTHOR, DESCRIPTION, FIXEDIN, LOCKVERSION, SEVERITY, STATUS, TARGETDATE, TITLE, VERSION) VALUES (1, 2, 1, 'sdfasdfsa', 'dsdfad', 1, 'dsfsdf', 1, 'dsafsad', 'Buggy', 'asdsad');
INSERT INTO BUG (ID, ASSIGNED_ID, AUTHOR_ID, DESCRIPTION, FIXEDIN, LOCKVERSION, SEVERITY, STATUS, TARGETDATE, TITLE, VERSION) VALUES (7, 1, 1, 'sdfasdfsa', '1.3', 1, 'Medium', 1, 'dsafsad', 'Buggy', '1.2.3');
INSERT INTO BUG (ID, ASSIGNED_ID, AUTHOR_ID, DESCRIPTION, FIXEDIN, LOCKVERSION, SEVERITY, STATUS, TARGETDATE, TITLE, VERSION) VALUES (9, 2, 1, 'leiras', '6.5', 1, 'High', 1, 'dsafsad', 'aBuggy', '4.3');
INSERT INTO BUG (ID, ASSIGNED_ID, AUTHOR_ID, DESCRIPTION, FIXEDIN, LOCKVERSION, SEVERITY, STATUS, TARGETDATE, TITLE, VERSION) VALUES (1, 1, 1, 'asdfasdfsa', '3.3', 1, 'dsfsdf', 1, 'dsafsad', 'nemBug', '1');


INSERT INTO USER_ROLE VALUES (1, 1);
INSERT INTO USER_ROLE VALUES (1, 5);
INSERT INTO ROLE_PERMISSION VALUES (1, 1);
INSERT INTO ROLE_PERMISSION VALUES (1, 2);
INSERT INTO ROLE_PERMISSION VALUES (1, 3);
INSERT INTO ROLE_PERMISSION VALUES (1, 4);
INSERT INTO ROLE_PERMISSION VALUES (5, 4);

