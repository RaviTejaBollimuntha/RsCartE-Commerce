--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CUSTOMER
--------------------------------------------------------

  CREATE TABLE "CUSTOMER" ("CUSTOMER_ID" NUMBER(10,0), "FIRST_NAME" VARCHAR2(45) DEFAULT NULL, "LAST_NAME" VARCHAR2(45) DEFAULT NULL, "USER_NAME" VARCHAR2(45), "PASS" VARCHAR2(45), "EMAIL_ADDRESS" VARCHAR2(45), "PHONE_NUMBER" VARCHAR2(45) DEFAULT NULL, "ACTIVE" NUMBER(1,0) DEFAULT 0)
REM INSERTING into CUSTOMER
SET DEFINE OFF;
Insert into CUSTOMER (CUSTOMER_ID,FIRST_NAME,LAST_NAME,USER_NAME,PASS,EMAIL_ADDRESS,PHONE_NUMBER,ACTIVE) values (1,'ravi','teja','raviteja','raviteja','raviteja@gmail.com','9705562280',1);
Insert into CUSTOMER (CUSTOMER_ID,FIRST_NAME,LAST_NAME,USER_NAME,PASS,EMAIL_ADDRESS,PHONE_NUMBER,ACTIVE) values (4,'Jagadeesh','B','jagadeesh','jagadeesh','belagallujagadeesh@gmail.com','8074554870',1);
Insert into CUSTOMER (CUSTOMER_ID,FIRST_NAME,LAST_NAME,USER_NAME,PASS,EMAIL_ADDRESS,PHONE_NUMBER,ACTIVE) values (601,'ravi','B','rtbollimuntha','teja','rtbollimuntha@gmail.com','9515647511',1);
Insert into CUSTOMER (CUSTOMER_ID,FIRST_NAME,LAST_NAME,USER_NAME,PASS,EMAIL_ADDRESS,PHONE_NUMBER,ACTIVE) values (602,'sai','D','sai','sai','sai@gmail.com','9515647512',1);
Insert into CUSTOMER (CUSTOMER_ID,FIRST_NAME,LAST_NAME,USER_NAME,PASS,EMAIL_ADDRESS,PHONE_NUMBER,ACTIVE) values (604,'ram','teja','ram','ram','ram@gmail.com','9515647513',1);
Insert into CUSTOMER (CUSTOMER_ID,FIRST_NAME,LAST_NAME,USER_NAME,PASS,EMAIL_ADDRESS,PHONE_NUMBER,ACTIVE) values (115,'rscart','site','rscartsite','Raviteja@92','rscartsite@gmail.com','9515647514',1);
--------------------------------------------------------
--  DDL for Index SYS_C007022
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007022" ON "CUSTOMER" ("CUSTOMER_ID")
--------------------------------------------------------
--  DDL for Index CUST_UNIQUE
--------------------------------------------------------

  CREATE UNIQUE INDEX "CUST_UNIQUE" ON "CUSTOMER" ("EMAIL_ADDRESS", "PHONE_NUMBER", "USER_NAME")
--------------------------------------------------------
--  Constraints for Table CUSTOMER
--------------------------------------------------------

  ALTER TABLE "CUSTOMER" ADD CONSTRAINT "CUST_UNIQUE" UNIQUE ("EMAIL_ADDRESS", "PHONE_NUMBER", "USER_NAME") ENABLE
  ALTER TABLE "CUSTOMER" MODIFY ("CUSTOMER_ID" NOT NULL ENABLE)
  ALTER TABLE "CUSTOMER" MODIFY ("USER_NAME" NOT NULL ENABLE)
  ALTER TABLE "CUSTOMER" MODIFY ("PASS" NOT NULL ENABLE)
  ALTER TABLE "CUSTOMER" MODIFY ("EMAIL_ADDRESS" NOT NULL ENABLE)
  ALTER TABLE "CUSTOMER" MODIFY ("ACTIVE" NOT NULL ENABLE)
  ALTER TABLE "CUSTOMER" ADD PRIMARY KEY ("CUSTOMER_ID") ENABLE
