--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CUSTOMERADDRESS
--------------------------------------------------------

  CREATE TABLE "CUSTOMERADDRESS" ("CUSTOMERADDRESS_ID" NUMBER(10,0), "NAME" VARCHAR2(45), "ADDRESS_ID" NUMBER(10,0), "CUSTOMER_ID" NUMBER(10,0))
REM INSERTING into CUSTOMERADDRESS
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index PK_CUSTOMERADDRESSID
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_CUSTOMERADDRESSID" ON "CUSTOMERADDRESS" ("CUSTOMERADDRESS_ID")
--------------------------------------------------------
--  Constraints for Table CUSTOMERADDRESS
--------------------------------------------------------

  ALTER TABLE "CUSTOMERADDRESS" MODIFY ("CUSTOMERADDRESS_ID" NOT NULL ENABLE)
  ALTER TABLE "CUSTOMERADDRESS" MODIFY ("NAME" NOT NULL ENABLE)
  ALTER TABLE "CUSTOMERADDRESS" MODIFY ("ADDRESS_ID" NOT NULL ENABLE)
  ALTER TABLE "CUSTOMERADDRESS" MODIFY ("CUSTOMER_ID" NOT NULL ENABLE)
  ALTER TABLE "CUSTOMERADDRESS" ADD CONSTRAINT "PK_CUSTOMERADDRESSID" PRIMARY KEY ("CUSTOMERADDRESS_ID") ENABLE
