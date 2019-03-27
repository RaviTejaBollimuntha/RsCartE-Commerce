--------------------------------------------------------
--  File created - Monday-February-05-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PRODUCT
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."PRODUCT" 
   (	"PRODUCT_ID" NUMBER(10,0), 
	"NAME" VARCHAR2(45 BYTE), 
	"FEATURED" NUMBER, 
	"PRICE" NUMBER(10,0), 
	"AVAILABLE" NUMBER, 
	"CATEGORY_ID" NUMBER(10,0), 
	"DESCRIPTION" VARCHAR2(200 BYTE), 
	"SUBCATEGORY_ID" NUMBER(10,0), 
	"MANUFACTURER" VARCHAR2(45 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.PRODUCT
SET DEFINE OFF;
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (100,'iPhone 6 16GB',1,40000,1,1000125,'With a beautiful finish and a light weight, the Apple iPhone 6 is stylish and comfortable to carry.',1000100,'Apple');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (101,'iPhone 6 32GB',1,40000,1,1000125,'iPhone 6 32GB',1000100,'Apple');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (102,'iPhone 6 64GB',1,50000,1,1000125,'iPhone 6 64GB',1000100,'Apple');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (103,'iPhone 5 64GB',1,50000,1,1000125,'iPhone 6 64GB',1000100,'Apple');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (104,'iPhone 5 32GB',1,45000,1,1000125,'iPhone 6 32GB',1000100,'Apple');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (105,'iPhone 5 16GB',0,35000,1,1000125,'iPhone 6 16GB',1000100,'Apple');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (106,'Motorola Moto E',1,7000,1,1000125,'Motorola Moto E',1000101,'Motorola');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (107,'Motorola Moto G',0,10000,1,1000125,'Motorola Moto G',1000101,'Motorola');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (108,'Motorola Moto G2',1,13000,1,1000125,'Motorola Moto G2',1000101,'Motorola');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (110,'Motorola Moto X2',1,35000,1,1000125,'Motorola Moto X2',1000101,'Motorola');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (111,'Sony Xperia M2 Black',1,40000,1,1000125,'Sony Xperia M2 Black',1000115,'Sony');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (112,'Sony Xperia M2 Silver',1,45000,1,1000125,'Sony Xperia M2 Silver',1000115,'Sony');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (113,'Sony Xperia M2 White',1,45000,1,1000125,'Sony Xperia M2 White',1000115,'Sony');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (114,'Sony Xperia M2 Gold',1,40000,1,1000125,'Sony Xperia M2 Gold',1000115,'Sony');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (115,'Sony Xperia White',1,30000,1,1000125,'Sony Xperia White',1000115,'Sony');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (117,'Blackberry 1',0,20000,0,1000125,'Blackberry 1',1000106,'Blackberry');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (116,'Sony Xperia Black',1,35000,1,1000125,'Sony Xperia Black',1000115,'Sony');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (118,'Blackberry 2',0,30000,0,1000125,'Blackberry 2',1000106,'Blackberry');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (119,'Blackberry 3',0,40000,0,1000125,'Blackberry 3',1000106,'Blackberry');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (120,'Blackberry 4',0,50000,0,1000125,'Blackberry 4',1000106,'Blackberry');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (121,'Immortals of Meluha',1,135,1,1000126,'Immortals of Meluha',1000101,'Meluha');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (122,'Immortals of Meluha - Secret of Nagas',1,135,1,1000126,'Immortals of Meluha - Secret of Nagas',1000101,'Meluha');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (123,'Immortals of Meluha - Oath of Vayuputras',1,135,1,1000126,'Immortals of Meluha - Oath of Vayuputras',1000101,'Meluha');
Insert into SYSTEM.PRODUCT (PRODUCT_ID,NAME,FEATURED,PRICE,AVAILABLE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER) values (124,'World of Warcraft - Rise of the Horde',1,450,1,1000126,'World of Warcraft - Rise of the Horde',1000101,'Warcraft');
--------------------------------------------------------
--  DDL for Index PK_PID
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."PK_PID" ON "SYSTEM"."PRODUCT" ("PRODUCT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table PRODUCT
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."PRODUCT" ADD CONSTRAINT "PK_PID" PRIMARY KEY ("PRODUCT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "SYSTEM"."PRODUCT" MODIFY ("MANUFACTURER" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."PRODUCT" MODIFY ("SUBCATEGORY_ID" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."PRODUCT" MODIFY ("DESCRIPTION" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."PRODUCT" MODIFY ("CATEGORY_ID" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."PRODUCT" MODIFY ("AVAILABLE" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."PRODUCT" MODIFY ("PRICE" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."PRODUCT" MODIFY ("FEATURED" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."PRODUCT" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."PRODUCT" MODIFY ("PRODUCT_ID" NOT NULL ENABLE);