--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ADDRESS
--------------------------------------------------------

  CREATE TABLE "ADDRESS" ("ADDRESS_ID" NUMBER(10,0), "FULLNAME" VARCHAR2(45), "ADDRESS_1" VARCHAR2(200), "ADDRESS_2" VARCHAR2(45), "CITY" VARCHAR2(30), "ZIP" VARCHAR2(45), "STATE" VARCHAR2(45), "CUSTOMER_ID" NUMBER(10,0), "COUNTRY" VARCHAR2(40))
REM INSERTING into ADDRESS
SET DEFINE OFF;
Insert into ADDRESS (ADDRESS_ID,FULLNAME,ADDRESS_1,ADDRESS_2,CITY,ZIP,STATE,CUSTOMER_ID,COUNTRY) values (384735,'Ravi Teja','SR Nagar','SR nagar','hyd','500038','TS',1,'India');
Insert into ADDRESS (ADDRESS_ID,FULLNAME,ADDRESS_1,ADDRESS_2,CITY,ZIP,STATE,CUSTOMER_ID,COUNTRY) values (671094,'Jagadeesh','Mgh-35,Ameerpet','Sathyam hall','Addanki','500037','Andhra Pradesh',4,'India');
Insert into ADDRESS (ADDRESS_ID,FULLNAME,ADDRESS_1,ADDRESS_2,CITY,ZIP,STATE,CUSTOMER_ID,COUNTRY) values (125460126,'ram','4-54/1,Athota','nadhiveylugu','Belampalli','522307','Andhra Pradesh',604,'India');
Insert into ADDRESS (ADDRESS_ID,FULLNAME,ADDRESS_1,ADDRESS_2,CITY,ZIP,STATE,CUSTOMER_ID,COUNTRY) values (73384921,'teja','4-54,Athota','nadhiveylugu','Tenali','522306','Andhra Pradesh',601,'India');
--------------------------------------------------------
--  DDL for Index PK_ADDRESSID
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_ADDRESSID" ON "ADDRESS" ("ADDRESS_ID")
--------------------------------------------------------
--  Constraints for Table ADDRESS
--------------------------------------------------------

  ALTER TABLE "ADDRESS" MODIFY ("ADDRESS_ID" NOT NULL ENABLE)
  ALTER TABLE "ADDRESS" MODIFY ("FULLNAME" NOT NULL ENABLE)
  ALTER TABLE "ADDRESS" MODIFY ("ADDRESS_1" NOT NULL ENABLE)
  ALTER TABLE "ADDRESS" MODIFY ("ADDRESS_2" NOT NULL ENABLE)
  ALTER TABLE "ADDRESS" MODIFY ("CITY" NOT NULL ENABLE)
  ALTER TABLE "ADDRESS" MODIFY ("ZIP" NOT NULL ENABLE)
  ALTER TABLE "ADDRESS" MODIFY ("STATE" NOT NULL ENABLE)
  ALTER TABLE "ADDRESS" MODIFY ("CUSTOMER_ID" NOT NULL ENABLE)
  ALTER TABLE "ADDRESS" ADD CONSTRAINT "PK_ADDRESSID" PRIMARY KEY ("ADDRESS_ID") ENABLE
  ALTER TABLE "ADDRESS" MODIFY ("COUNTRY" NOT NULL ENABLE)
