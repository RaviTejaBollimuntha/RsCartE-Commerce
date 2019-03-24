--------------------------------------------------------
--  File created - Monday-February-05-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table RATING
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."RATING" 
   (	"RATING_ID" NUMBER(10,0), 
	"RATING" VARCHAR2(10 BYTE), 
	"REVIEW_ID" NUMBER(10,0), 
	"PRODUCT_ID" NUMBER(10,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.RATING
SET DEFINE OFF;
--------------------------------------------------------
--  Constraints for Table RATING
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."RATING" MODIFY ("PRODUCT_ID" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."RATING" MODIFY ("REVIEW_ID" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."RATING" MODIFY ("RATING" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."RATING" MODIFY ("RATING_ID" NOT NULL ENABLE);
