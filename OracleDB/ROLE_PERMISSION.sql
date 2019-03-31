--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ROLE_PERMISSION
--------------------------------------------------------

  CREATE TABLE "ROLE_PERMISSION" ("ROLE_ID" NUMBER(10,0), "PERMISSION_ID" NUMBER(10,0))
REM INSERTING into ROLE_PERMISSION
SET DEFINE OFF;
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (1,1);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (1,2);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (1,3);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (1,4);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (1,5);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (1,6);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (1,7);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (1,8);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (1,9);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (2,1);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (2,2);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (2,3);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (2,4);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (2,5);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (2,9);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (3,1);
Insert into ROLE_PERMISSION (ROLE_ID,PERMISSION_ID) values (3,2);
--------------------------------------------------------
--  Constraints for Table ROLE_PERMISSION
--------------------------------------------------------

  ALTER TABLE "ROLE_PERMISSION" MODIFY ("PERMISSION_ID" NOT NULL ENABLE)
  ALTER TABLE "ROLE_PERMISSION" MODIFY ("ROLE_ID" NOT NULL ENABLE)
