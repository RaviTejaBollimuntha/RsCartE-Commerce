--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table REVIEW
--------------------------------------------------------

  CREATE TABLE "REVIEW" ("REVIEW_ID" NUMBER(10,0), "CUSTOMER_ID" NUMBER(10,0), "REVIEWTEXT" VARCHAR2(300), "SUBMITTEDDATE" DATE, "PRODUCT_ID" NUMBER(10,0), "REVIEWTITLE" VARCHAR2(45), "RATING" VARCHAR2(10))
REM INSERTING into REVIEW
SET DEFINE OFF;
Insert into REVIEW (REVIEW_ID,CUSTOMER_ID,REVIEWTEXT,SUBMITTEDDATE,PRODUCT_ID,REVIEWTITLE,RATING) values (100,604,'more back up',to_date('31-JAN-18','DD-MON-RR'),104,'Good mobile','Excellent');
Insert into REVIEW (REVIEW_ID,CUSTOMER_ID,REVIEWTEXT,SUBMITTEDDATE,PRODUCT_ID,REVIEWTITLE,RATING) values (102,604,'Strong mobile',to_date('31-JAN-18','DD-MON-RR'),106,'greate mobile','Very Good');
--------------------------------------------------------
--  DDL for Index PK_REVIEWID
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_REVIEWID" ON "REVIEW" ("REVIEW_ID")
--------------------------------------------------------
--  Constraints for Table REVIEW
--------------------------------------------------------

  ALTER TABLE "REVIEW" MODIFY ("REVIEW_ID" NOT NULL ENABLE)
  ALTER TABLE "REVIEW" MODIFY ("CUSTOMER_ID" NOT NULL ENABLE)
  ALTER TABLE "REVIEW" MODIFY ("REVIEWTEXT" NOT NULL ENABLE)
  ALTER TABLE "REVIEW" MODIFY ("SUBMITTEDDATE" NOT NULL ENABLE)
  ALTER TABLE "REVIEW" MODIFY ("PRODUCT_ID" NOT NULL ENABLE)
  ALTER TABLE "REVIEW" MODIFY ("REVIEWTITLE" NOT NULL ENABLE)
  ALTER TABLE "REVIEW" MODIFY ("RATING" NOT NULL ENABLE)
  ALTER TABLE "REVIEW" ADD CONSTRAINT "PK_REVIEWID" PRIMARY KEY ("REVIEW_ID") ENABLE
