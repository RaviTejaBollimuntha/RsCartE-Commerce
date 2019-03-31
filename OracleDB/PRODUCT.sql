--------------------------------------------------------
--  File created - Sunday-March-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PRODUCT
--------------------------------------------------------

  CREATE TABLE "PRODUCT" ("PRODUCT_ID" NUMBER(10,0), "NAME" VARCHAR2(45), "PRICE" NUMBER(10,0), "CATEGORY_ID" NUMBER(10,0), "DESCRIPTION" VARCHAR2(200), "SUBCATEGORY_ID" NUMBER(10,0), "MANUFACTURER" VARCHAR2(45), "CREATED_ON" DATE, "FEATURED" NUMBER(10,0), "AVAILABLE" NUMBER(10,0))
REM INSERTING into PRODUCT
SET DEFINE OFF;
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (100,'iPhone 6 16GB',40000,1000125,' iPhone 6 is comfortable to carry ',1000100,'Apple',to_date('19-MAR-19','DD-MON-RR'),1,125);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (101,'iPhone 6 32GB',40000,1000125,'iPhone 6 32GB',1000100,'Apple',to_date('01-MAR-19','DD-MON-RR'),0,455);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (102,'iPhone 6 64GB',50000,1000125,'iPhone 6 64GB',1000100,'Apple',to_date('02-MAR-19','DD-MON-RR'),1,125);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (103,'iPhone 5 64GB',50000,1000125,'iPhone 6 64GB',1000100,'Apple',to_date('03-MAR-19','DD-MON-RR'),0,489);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (104,'iPhone 5 32GB',45000,1000125,'iPhone 6 32GB',1000100,'Apple',to_date('04-MAR-19','DD-MON-RR'),1,45846);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (105,'iPhone 5 16GB',35000,1000125,'iPhone 6 16GB',1000100,'Apple',to_date('05-MAR-19','DD-MON-RR'),1,785);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (106,'Motorola Moto E',7000,1000125,'Motorola Moto E',1000101,'Motorola',to_date('06-MAR-19','DD-MON-RR'),1,45);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (107,'Motorola Moto G',10000,1000125,'Motorola Moto G',1000101,'Motorola',to_date('22-MAR-19','DD-MON-RR'),1,85);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (108,'Motorola Moto G2',13000,1000125,'Motorola Moto G2',1000101,'Motorola',to_date('08-MAR-19','DD-MON-RR'),1,93);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (110,'Motorola Moto X2',35000,1000125,'Motorola Moto X2',1000101,'Motorola',to_date('09-MAR-19','DD-MON-RR'),0,78);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (111,'Sony Xperia M2 Black',40000,1000125,'Sony Xperia M2 Black',1000115,'Sony',to_date('19-MAR-10','DD-MON-RR'),1,89);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (112,'Sony Xperia M2 Silver',45000,1000125,'Sony Xperia M2 Silver',1000115,'Sony',to_date('12-MAR-19','DD-MON-RR'),0,453);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (113,'Sony Xperia M2 White',45000,1000125,'Sony Xperia M2 White',1000115,'Sony',to_date('19-MAR-19','DD-MON-RR'),1,789);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (114,'Sony Xperia M2 Gold',40000,1000125,'Sony Xperia M2 Gold',1000115,'Sony',to_date('19-MAR-19','DD-MON-RR'),1,255);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (115,'Sony Xperia White',30000,1000125,'Sony Xperia White',1000115,'Sony',to_date('14-MAR-19','DD-MON-RR'),1,4775);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (117,'Blackberry 1',20000,1000125,'Blackberry 1',1000106,'Blackberry',to_date('22-MAR-19','DD-MON-RR'),1,7553);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (116,'Sony Xperia Black',35000,1000125,'Sony Xperia Black',1000115,'Sony',to_date('01-MAR-19','DD-MON-RR'),1,753);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (118,'Blackberry 2',30000,1000125,'Blackberry  phone',1000106,'Blackberry',to_date('21-MAR-19','DD-MON-RR'),1,789);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (119,'Blackberry 3',40000,1000125,'Blackberry 3',1000106,'Blackberry',to_date('21-MAR-19','DD-MON-RR'),1,369);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (120,'Blackberry 4',50000,1000125,'Blackberry 4',1000106,'Blackberry',to_date('21-MAR-19','DD-MON-RR'),0,752);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (121,'Immortals of Meluha',135,1000126,'Immortals of Meluha',1000101,'Meluha',to_date('14-MAR-19','DD-MON-RR'),1,912);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (122,'Immortals of Meluha - Secret of Nagas',135,1000126,'Immortals of Meluha - Secret of Nagas',1000101,'Meluha',to_date('01-MAR-19','DD-MON-RR'),1,753);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (123,'Immortals of Meluha - Oath of Vayuputras',135,1000126,'Immortals of Meluha - Oath of Vayuputras',1000101,'Meluha',to_date('01-MAR-17','DD-MON-RR'),1,951);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (124,'World of Warcraft - Rise of the Horde',500,1000126,'World of Warcraft - Rise of the Horde',1000101,'Warcraft',to_date('01-MAR-19','DD-MON-RR'),1,264);
Insert into PRODUCT (PRODUCT_ID,NAME,PRICE,CATEGORY_ID,DESCRIPTION,SUBCATEGORY_ID,MANUFACTURER,CREATED_ON,FEATURED,AVAILABLE) values (126,'Captain Marvel (2019)  Telugu Dubbed Movie ',600,1000127,'Carol Danvers as she becomes one of the universe�s most powerful heroes when Earth is caught in the middle of a galactic war between two alien races. ',1000107,'Marvel ',to_date('30-MAR-19','DD-MON-RR'),1,20);
--------------------------------------------------------
--  DDL for Index PK_PID
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_PID" ON "PRODUCT" ("PRODUCT_ID")
--------------------------------------------------------
--  Constraints for Table PRODUCT
--------------------------------------------------------

  ALTER TABLE "PRODUCT" MODIFY ("PRODUCT_ID" NOT NULL ENABLE)
  ALTER TABLE "PRODUCT" MODIFY ("NAME" NOT NULL ENABLE)
  ALTER TABLE "PRODUCT" MODIFY ("PRICE" NOT NULL ENABLE)
  ALTER TABLE "PRODUCT" MODIFY ("CATEGORY_ID" NOT NULL ENABLE)
  ALTER TABLE "PRODUCT" MODIFY ("DESCRIPTION" NOT NULL ENABLE)
  ALTER TABLE "PRODUCT" MODIFY ("SUBCATEGORY_ID" NOT NULL ENABLE)
  ALTER TABLE "PRODUCT" MODIFY ("MANUFACTURER" NOT NULL ENABLE)
  ALTER TABLE "PRODUCT" ADD CONSTRAINT "PK_PID" PRIMARY KEY ("PRODUCT_ID") ENABLE
