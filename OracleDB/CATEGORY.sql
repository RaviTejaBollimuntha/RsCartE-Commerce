--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CATEGORY
--------------------------------------------------------

  CREATE TABLE "CATEGORY" ("CATEGORY_ID" NUMBER(10,0), "NAME" VARCHAR2(45), "DESCRIPTION" VARCHAR2(200))
REM INSERTING into CATEGORY
SET DEFINE OFF;
Insert into CATEGORY (CATEGORY_ID,NAME,DESCRIPTION) values (1000125,'Mobiles',null);
Insert into CATEGORY (CATEGORY_ID,NAME,DESCRIPTION) values (1000127,'Movies',null);
Insert into CATEGORY (CATEGORY_ID,NAME,DESCRIPTION) values (1000128,'Games','RsCart offers the most convenient way to buy or sell games online in India');
Insert into CATEGORY (CATEGORY_ID,NAME,DESCRIPTION) values (1000126,'Books',null);
Insert into CATEGORY (CATEGORY_ID,NAME,DESCRIPTION) values (1000129,'Clothes','Clothing (also known as clothes, apparel and attire) is a collective term for items worn on the body.');
Insert into CATEGORY (CATEGORY_ID,NAME,DESCRIPTION) values (1000130,'Home & Furniture','Polos & T-Shirts
Ethnic Wear
Shorts & 3/4ths');
--------------------------------------------------------
--  DDL for Index SYS_C006999
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C006999" ON "CATEGORY" ("CATEGORY_ID")
--------------------------------------------------------
--  Constraints for Table CATEGORY
--------------------------------------------------------

  ALTER TABLE "CATEGORY" MODIFY ("CATEGORY_ID" NOT NULL ENABLE)
  ALTER TABLE "CATEGORY" MODIFY ("NAME" NOT NULL ENABLE)
  ALTER TABLE "CATEGORY" ADD PRIMARY KEY ("CATEGORY_ID") ENABLE
