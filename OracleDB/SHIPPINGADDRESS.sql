--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table SHIPPINGADDRESS
--------------------------------------------------------

  CREATE TABLE "SHIPPINGADDRESS" ("SHIPPING_ID" NUMBER(10,0), "ADDRESS_1" VARCHAR2(200), "ADDRESS_2" VARCHAR2(45), "CITY" VARCHAR2(30), "ZIP" VARCHAR2(45), "STATE" VARCHAR2(45), "FULLNAME" VARCHAR2(45), "CUSTOMER_ID" NUMBER(10,0), "COUNTRY" VARCHAR2(40))
REM INSERTING into SHIPPINGADDRESS
SET DEFINE OFF;
Insert into SHIPPINGADDRESS (SHIPPING_ID,ADDRESS_1,ADDRESS_2,CITY,ZIP,STATE,FULLNAME,CUSTOMER_ID,COUNTRY) values (368249,'SR Nagar','SR nagar','hyd','500038','TS','Ravi Teja',1,'India');
Insert into SHIPPINGADDRESS (SHIPPING_ID,ADDRESS_1,ADDRESS_2,CITY,ZIP,STATE,FULLNAME,CUSTOMER_ID,COUNTRY) values (1784995,'Mgh-35,Ameerpet','Sathyam hall','Addanki','500037','Andhra Pradesh','Jagadeesh',4,'India');
Insert into SHIPPINGADDRESS (SHIPPING_ID,ADDRESS_1,ADDRESS_2,CITY,ZIP,STATE,FULLNAME,CUSTOMER_ID,COUNTRY) values (211647978,'4-50,Athota','nadhiveylugu','Tenali','522306','Andhra Pradesh','ram',604,'India');
Insert into SHIPPINGADDRESS (SHIPPING_ID,ADDRESS_1,ADDRESS_2,CITY,ZIP,STATE,FULLNAME,CUSTOMER_ID,COUNTRY) values (338326,'SR Nagar phase-1','SR nagar','hyd','500038','TS','Ravi Teja',1,'India');
Insert into SHIPPINGADDRESS (SHIPPING_ID,ADDRESS_1,ADDRESS_2,CITY,ZIP,STATE,FULLNAME,CUSTOMER_ID,COUNTRY) values (165037943,'4-54,Athota','nadhiveylugu','Tenali','522306','Andhra Pradesh','sai',602,'India');
Insert into SHIPPINGADDRESS (SHIPPING_ID,ADDRESS_1,ADDRESS_2,CITY,ZIP,STATE,FULLNAME,CUSTOMER_ID,COUNTRY) values (290560413,'4-54,Athota','nadhiveylugu','Tenali','522306','Andhra Pradesh','ram',604,'India');
Insert into SHIPPINGADDRESS (SHIPPING_ID,ADDRESS_1,ADDRESS_2,CITY,ZIP,STATE,FULLNAME,CUSTOMER_ID,COUNTRY) values (237456865,'1234-3,NZ','NZ','Amur','522306','Andhra Pradesh','RAM',604,'India');
Insert into SHIPPINGADDRESS (SHIPPING_ID,ADDRESS_1,ADDRESS_2,CITY,ZIP,STATE,FULLNAME,CUSTOMER_ID,COUNTRY) values (102378254,'1234-3,NZ','NZ','Adoni','522306','Andhra Pradesh','RAM',604,'India');
Insert into SHIPPINGADDRESS (SHIPPING_ID,ADDRESS_1,ADDRESS_2,CITY,ZIP,STATE,FULLNAME,CUSTOMER_ID,COUNTRY) values (202627629,'1234-3,NZ','NZ','Addanki','522306','Andhra Pradesh','RAM',604,'India');
--------------------------------------------------------
--  DDL for Index PK_SHIPPINGID
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_SHIPPINGID" ON "SHIPPINGADDRESS" ("SHIPPING_ID")
--------------------------------------------------------
--  Constraints for Table SHIPPINGADDRESS
--------------------------------------------------------

  ALTER TABLE "SHIPPINGADDRESS" MODIFY ("SHIPPING_ID" NOT NULL ENABLE)
  ALTER TABLE "SHIPPINGADDRESS" MODIFY ("ADDRESS_1" NOT NULL ENABLE)
  ALTER TABLE "SHIPPINGADDRESS" MODIFY ("ADDRESS_2" NOT NULL ENABLE)
  ALTER TABLE "SHIPPINGADDRESS" MODIFY ("CITY" NOT NULL ENABLE)
  ALTER TABLE "SHIPPINGADDRESS" MODIFY ("ZIP" NOT NULL ENABLE)
  ALTER TABLE "SHIPPINGADDRESS" MODIFY ("STATE" NOT NULL ENABLE)
  ALTER TABLE "SHIPPINGADDRESS" MODIFY ("FULLNAME" NOT NULL ENABLE)
  ALTER TABLE "SHIPPINGADDRESS" MODIFY ("CUSTOMER_ID" NOT NULL ENABLE)
  ALTER TABLE "SHIPPINGADDRESS" ADD CONSTRAINT "PK_SHIPPINGID" PRIMARY KEY ("SHIPPING_ID") ENABLE
  ALTER TABLE "SHIPPINGADDRESS" MODIFY ("COUNTRY" NOT NULL ENABLE)
