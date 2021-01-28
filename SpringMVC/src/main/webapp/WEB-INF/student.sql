--------------------------------------------------------
--  파일이 생성됨 - 목요일-1월-28-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table STUDENT
--------------------------------------------------------

  CREATE TABLE "STUDENT" ("SNO" VARCHAR2(10 BYTE), "NAME" VARCHAR2(30 BYTE), "MAJOR" NUMBER, "SCORE" NUMBER(3,2) DEFAULT 0.00)
REM INSERTING into STUDENT
SET DEFINE OFF;
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('BY6288','김동수',1,3.44);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('XZ4104','김시우',2,4.25);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('UB5061','김준래',3,3.1);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('AJ5374','박셩우',4,1.42);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('NV2207','박병상',5,4.39);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('VN8158','박정현',1,1.87);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('AP5064','서민우',2,1.43);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('WV3171','박성용',3,3.95);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('EK6013','이원구',4,3.71);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('SD8948','정성수',5,3.93);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('TA1750','정희우',1,4.02);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('UP6814','조성수',2,2.73);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('OP4763','주지우',3,1.71);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('QA2041','최승수',4,1.78);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('DU1265','한상오',5,3.86);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('HO7352','이지원',1,3.02);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('PW9945','김희연',2,1.94);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('GR5186','노소정',3,3.28);
Insert into STUDENT (SNO,NAME,MAJOR,SCORE) values ('AY1772','손지해',4,3.57);
--------------------------------------------------------
--  DDL for Index SYS_C007455
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C007455" ON "STUDENT" ("SNO")
--------------------------------------------------------
--  Constraints for Table STUDENT
--------------------------------------------------------

  ALTER TABLE "STUDENT" ADD PRIMARY KEY ("SNO") ENABLE
