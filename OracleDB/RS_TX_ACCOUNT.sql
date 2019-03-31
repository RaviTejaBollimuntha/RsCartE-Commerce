--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table RS_TX_ACCOUNT
--------------------------------------------------------

  CREATE TABLE "RS_TX_ACCOUNT" ("ACCNO" NUMBER(16,2), "BALANCE" NUMBER(16,2))
REM INSERTING into RS_TX_ACCOUNT
SET DEFINE OFF;
Insert into RS_TX_ACCOUNT (ACCNO,BALANCE) values (32165498712365,10284409.73);
Insert into RS_TX_ACCOUNT (ACCNO,BALANCE) values (98745632198745,9715588.29);
--------------------------------------------------------
--  Constraints for Table RS_TX_ACCOUNT
--------------------------------------------------------

  ALTER TABLE "RS_TX_ACCOUNT" MODIFY ("BALANCE" NOT NULL ENABLE)
  ALTER TABLE "RS_TX_ACCOUNT" MODIFY ("ACCNO" NOT NULL ENABLE)
