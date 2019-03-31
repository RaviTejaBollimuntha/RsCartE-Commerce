--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "USERS" ("ID" NUMBER(10,0), "FIRST_NAME" VARCHAR2(45) DEFAULT NULL, "LAST_NAME" VARCHAR2(45) DEFAULT NULL, "NAME" VARCHAR2(45), "PASSWORD" VARCHAR2(200), "EMAIL" VARCHAR2(45), "PHONE_NUMBER" VARCHAR2(45) DEFAULT NULL, "PASSWORD_RESET_TOKEN" VARCHAR2(200))
REM INSERTING into USERS
SET DEFINE OFF;
Insert into USERS (ID,FIRST_NAME,LAST_NAME,NAME,PASSWORD,EMAIL,PHONE_NUMBER,PASSWORD_RESET_TOKEN) values (1,null,null,'Super Admin','$2a$10$p3PHnpoBAnzZiL8mr3gMieMhVVSb585ajC2ZsBB0kwb4KvZKFSdNi','superadmin@gmail.com',null,null);
Insert into USERS (ID,FIRST_NAME,LAST_NAME,NAME,PASSWORD,EMAIL,PHONE_NUMBER,PASSWORD_RESET_TOKEN) values (2,null,null,'Admin','$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS','admin@gmail.com',null,null);
Insert into USERS (ID,FIRST_NAME,LAST_NAME,NAME,PASSWORD,EMAIL,PHONE_NUMBER,PASSWORD_RESET_TOKEN) values (3,null,null,'CMSGuy','$2a$10$/Y0IarSOuH2dz.UOLrZbaus17K6AJF7n15qWr02aWN1MOz5vEKT8y','cms@gmail.com',null,null);
Insert into USERS (ID,FIRST_NAME,LAST_NAME,NAME,PASSWORD,EMAIL,PHONE_NUMBER,PASSWORD_RESET_TOKEN) values (4,null,null,'ravi','$2a$10$UFEPYW7Rx1qZqdHajzOnB.VBR3rvm7OI7uSix4RadfQiNhkZOi2fi','ravi@gmail.com',null,null);
Insert into USERS (ID,FIRST_NAME,LAST_NAME,NAME,PASSWORD,EMAIL,PHONE_NUMBER,PASSWORD_RESET_TOKEN) values (5,null,null,'DemoUser','$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by','user@gmail.com',null,null);
--------------------------------------------------------
--  DDL for Index SYS_C007167
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007167" ON "USERS" ("ID")
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "USERS" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "USERS" MODIFY ("EMAIL" NOT NULL ENABLE)
  ALTER TABLE "USERS" MODIFY ("PASSWORD" NOT NULL ENABLE)
  ALTER TABLE "USERS" MODIFY ("NAME" NOT NULL ENABLE)
  ALTER TABLE "USERS" MODIFY ("ID" NOT NULL ENABLE)
