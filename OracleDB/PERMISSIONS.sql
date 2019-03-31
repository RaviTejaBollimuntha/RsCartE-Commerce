--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PERMISSIONS
--------------------------------------------------------

  CREATE TABLE "PERMISSIONS" ("ID" NUMBER(10,0), "NAME" VARCHAR2(45), "DESCRIPTION" VARCHAR2(200))
REM INSERTING into PERMISSIONS
SET DEFINE OFF;
Insert into PERMISSIONS (ID,NAME,DESCRIPTION) values (1,'MANAGE_CATEGORIES',null);
Insert into PERMISSIONS (ID,NAME,DESCRIPTION) values (2,'MANAGE_PRODUCTS',null);
Insert into PERMISSIONS (ID,NAME,DESCRIPTION) values (3,'MANAGE_ORDERS',null);
Insert into PERMISSIONS (ID,NAME,DESCRIPTION) values (4,'MANAGE_CUSTOMERS',null);
Insert into PERMISSIONS (ID,NAME,DESCRIPTION) values (5,'MANAGE_PAYMENT_SYSTEMS',null);
Insert into PERMISSIONS (ID,NAME,DESCRIPTION) values (6,'MANAGE_USERS',null);
Insert into PERMISSIONS (ID,NAME,DESCRIPTION) values (7,'MANAGE_ROLES',null);
Insert into PERMISSIONS (ID,NAME,DESCRIPTION) values (8,'MANAGE_PERMISSIONS',null);
Insert into PERMISSIONS (ID,NAME,DESCRIPTION) values (9,'MANAGE_SETTINGS',null);
--------------------------------------------------------
--  DDL for Index SYS_C007154
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007154" ON "PERMISSIONS" ("ID")
--------------------------------------------------------
--  Constraints for Table PERMISSIONS
--------------------------------------------------------

  ALTER TABLE "PERMISSIONS" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "PERMISSIONS" MODIFY ("NAME" NOT NULL ENABLE)
  ALTER TABLE "PERMISSIONS" MODIFY ("ID" NOT NULL ENABLE)
