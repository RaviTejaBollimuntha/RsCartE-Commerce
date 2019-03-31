--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table EMAILRESETTOKEN
--------------------------------------------------------

  CREATE TABLE "EMAILRESETTOKEN" ("TOKEN" VARCHAR2(255), "EXPIRY_DATE" TIMESTAMP (6), "CUSTOMER_ID" NUMBER(11,0), "EMAIL" VARCHAR2(255))
REM INSERTING into EMAILRESETTOKEN
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index EMAIL_UNIQUE
--------------------------------------------------------

  CREATE UNIQUE INDEX "EMAIL_UNIQUE" ON "EMAILRESETTOKEN" ("EMAIL")
--------------------------------------------------------
--  Constraints for Table EMAILRESETTOKEN
--------------------------------------------------------

  ALTER TABLE "EMAILRESETTOKEN" ADD CONSTRAINT "EMAIL_UNIQUE" UNIQUE ("EMAIL") ENABLE
  ALTER TABLE "EMAILRESETTOKEN" MODIFY ("EMAIL" NOT NULL ENABLE)
  ALTER TABLE "EMAILRESETTOKEN" MODIFY ("CUSTOMER_ID" NOT NULL ENABLE)
  ALTER TABLE "EMAILRESETTOKEN" MODIFY ("EXPIRY_DATE" NOT NULL ENABLE)
  ALTER TABLE "EMAILRESETTOKEN" MODIFY ("TOKEN" NOT NULL ENABLE)
