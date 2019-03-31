--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table RSHITCOUNT
--------------------------------------------------------

  CREATE TABLE "RSHITCOUNT" ("HITCOUNT" NUMBER(20,0))
REM INSERTING into RSHITCOUNT
SET DEFINE OFF;
Insert into RSHITCOUNT (HITCOUNT) values (40);
--------------------------------------------------------
--  Constraints for Table RSHITCOUNT
--------------------------------------------------------

  ALTER TABLE "RSHITCOUNT" MODIFY ("HITCOUNT" NOT NULL ENABLE)
