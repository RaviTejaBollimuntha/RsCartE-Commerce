--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table WISHLISTDETAILS
--------------------------------------------------------

  CREATE TABLE "WISHLISTDETAILS" ("PRODUCT_ID" NUMBER(10,0), "CUSTOMER_ID" NUMBER(10,0))
REM INSERTING into WISHLISTDETAILS
SET DEFINE OFF;
--------------------------------------------------------
--  Constraints for Table WISHLISTDETAILS
--------------------------------------------------------

  ALTER TABLE "WISHLISTDETAILS" MODIFY ("PRODUCT_ID" NOT NULL ENABLE)
  ALTER TABLE "WISHLISTDETAILS" MODIFY ("CUSTOMER_ID" NOT NULL ENABLE)
