--------------------------------------------------------
--  File created - Monday-February-05-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table REVIEW
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."REVIEW" 
   (	"REVIEW_ID" NUMBER(10,0), 
	"CUSTOMER_ID" NUMBER(10,0), 
	"REVIEWTEXT" VARCHAR2(300 BYTE), 
	"SUBMITTEDDATE" DATE, 
	"PRODUCT_ID" NUMBER(10,0), 
	"REVIEWTITLE" VARCHAR2(45 BYTE), 
	"RATING" VARCHAR2(10 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.REVIEW
SET DEFINE OFF;
Insert into SYSTEM.REVIEW (REVIEW_ID,CUSTOMER_ID,REVIEWTEXT,SUBMITTEDDATE,PRODUCT_ID,REVIEWTITLE,RATING) values (100,604,'more back up',to_date('31-JAN-18','DD-MON-RR'),104,'Good mobile','Excellent');
Insert into SYSTEM.REVIEW (REVIEW_ID,CUSTOMER_ID,REVIEWTEXT,SUBMITTEDDATE,PRODUCT_ID,REVIEWTITLE,RATING) values (102,604,'Strong mobile',to_date('31-JAN-18','DD-MON-RR'),106,'greate mobile','Very Good');
--------------------------------------------------------
--  DDL for Index PK_REVIEWID
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."PK_REVIEWID" ON "SYSTEM"."REVIEW" ("REVIEW_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table REVIEW
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."REVIEW" ADD CONSTRAINT "PK_REVIEWID" PRIMARY KEY ("REVIEW_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "SYSTEM"."REVIEW" MODIFY ("RATING" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."REVIEW" MODIFY ("REVIEWTITLE" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."REVIEW" MODIFY ("PRODUCT_ID" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."REVIEW" MODIFY ("SUBMITTEDDATE" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."REVIEW" MODIFY ("REVIEWTEXT" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."REVIEW" MODIFY ("CUSTOMER_ID" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."REVIEW" MODIFY ("REVIEW_ID" NOT NULL ENABLE);