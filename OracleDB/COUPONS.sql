--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table COUPONS
--------------------------------------------------------

  CREATE TABLE "COUPONS" ("COUPONVALUE" VARCHAR2(20))
REM INSERTING into COUPONS
SET DEFINE OFF;
Insert into COUPONS (COUPONVALUE) values ('Rs15p');
--------------------------------------------------------
--  Constraints for Table COUPONS
--------------------------------------------------------

  ALTER TABLE "COUPONS" MODIFY ("COUPONVALUE" NOT NULL ENABLE)
