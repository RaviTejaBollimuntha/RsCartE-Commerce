--------------------------------------------------------
--  File created - Monday-February-05-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table COUPONS
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."COUPONS" 
   (	"COUPONVALUE" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.COUPONS
SET DEFINE OFF;
Insert into SYSTEM.COUPONS (COUPONVALUE) values ('Rs15p');
--------------------------------------------------------
--  Constraints for Table COUPONS
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."COUPONS" MODIFY ("COUPONVALUE" NOT NULL ENABLE);
