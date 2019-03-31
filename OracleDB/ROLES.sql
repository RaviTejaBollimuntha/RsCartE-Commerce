--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ROLES
--------------------------------------------------------

  CREATE TABLE "ROLES" ("ID" NUMBER(10,0), "NAME" VARCHAR2(45), "DESCRIPTION" VARCHAR2(200))
REM INSERTING into ROLES
SET DEFINE OFF;
Insert into ROLES (ID,NAME,DESCRIPTION) values (1,'ROLE_SUPER_ADMIN',null);
Insert into ROLES (ID,NAME,DESCRIPTION) values (2,'ROLE_ADMIN',null);
Insert into ROLES (ID,NAME,DESCRIPTION) values (3,'ROLE_CMS_ADMIN',null);
Insert into ROLES (ID,NAME,DESCRIPTION) values (4,'ROLE_USER',null);
--------------------------------------------------------
--  DDL for Index SYS_C007157
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007157" ON "ROLES" ("ID")
--------------------------------------------------------
--  Constraints for Table ROLES
--------------------------------------------------------

  ALTER TABLE "ROLES" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "ROLES" MODIFY ("NAME" NOT NULL ENABLE)
  ALTER TABLE "ROLES" MODIFY ("ID" NOT NULL ENABLE)
