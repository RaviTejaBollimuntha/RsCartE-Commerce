--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table USER_ROLE
--------------------------------------------------------

  CREATE TABLE "USER_ROLE" ("ROLE_ID" NUMBER(10,0), "USER_ID" NUMBER(10,0))
REM INSERTING into USER_ROLE
SET DEFINE OFF;
Insert into USER_ROLE (ROLE_ID,USER_ID) values (1,1);
Insert into USER_ROLE (ROLE_ID,USER_ID) values (2,2);
Insert into USER_ROLE (ROLE_ID,USER_ID) values (3,3);
Insert into USER_ROLE (ROLE_ID,USER_ID) values (2,4);
Insert into USER_ROLE (ROLE_ID,USER_ID) values (3,4);
Insert into USER_ROLE (ROLE_ID,USER_ID) values (4,5);
--------------------------------------------------------
--  Constraints for Table USER_ROLE
--------------------------------------------------------

  ALTER TABLE "USER_ROLE" MODIFY ("USER_ID" NOT NULL ENABLE)
  ALTER TABLE "USER_ROLE" MODIFY ("ROLE_ID" NOT NULL ENABLE)
