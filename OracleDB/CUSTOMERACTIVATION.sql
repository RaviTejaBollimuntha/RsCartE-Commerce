--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CUSTOMERACTIVATION
--------------------------------------------------------

  CREATE TABLE "CUSTOMERACTIVATION" ("TOKEN" VARCHAR2(255), "EXPIRY_DATE" TIMESTAMP (6), "CUSTOMER_ID" NUMBER(11,0))
REM INSERTING into CUSTOMERACTIVATION
SET DEFINE OFF;
--------------------------------------------------------
--  Constraints for Table CUSTOMERACTIVATION
--------------------------------------------------------

  ALTER TABLE "CUSTOMERACTIVATION" MODIFY ("CUSTOMER_ID" NOT NULL ENABLE)
  ALTER TABLE "CUSTOMERACTIVATION" MODIFY ("EXPIRY_DATE" NOT NULL ENABLE)
  ALTER TABLE "CUSTOMERACTIVATION" MODIFY ("TOKEN" NOT NULL ENABLE)
