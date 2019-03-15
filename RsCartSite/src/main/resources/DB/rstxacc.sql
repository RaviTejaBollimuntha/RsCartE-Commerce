--------------------------------------------------------
--  File created - Monday-February-05-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table RS_TX_ACCOUNT
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."RS_TX_ACCOUNT" 
   (	"ACCNO" NUMBER(16,2), 
	"BALANCE" NUMBER(16,2)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.RS_TX_ACCOUNT
SET DEFINE OFF;
Insert into SYSTEM.RS_TX_ACCOUNT (ACCNO,BALANCE) values (32165498712365,10039164.73);
Insert into SYSTEM.RS_TX_ACCOUNT (ACCNO,BALANCE) values (98745632198745,9960833.29);
--------------------------------------------------------
--  Constraints for Table RS_TX_ACCOUNT
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."RS_TX_ACCOUNT" MODIFY ("ACCNO" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."RS_TX_ACCOUNT" MODIFY ("BALANCE" NOT NULL ENABLE);
