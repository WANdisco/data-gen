create table table1 (
  column1 int,
  column2 int,
  column3 int,
  column4 string,
  column5 string,
  column6 string,
  column7 int,
  column8 int,
  dt string --unixtime with ms 13 chars
);

create table table2 (
  column1 string,
  column2 string,
  column3 string,
  column4 string, --values: Unknown,Location_33101,Location_30453
  column5 string,
  column6 string,
  dt string --unixtime with ms 13 chars
);


add jar /home/alexp/yogesh/hive-udf/target/nexr-hive-udf-0.2-SNAPSHOT.jar;
CREATE TEMPORARY FUNCTION nvl AS 'com.nexr.platform.hive.udf.GenericUDFNVL';
CREATE TEMPORARY FUNCTION decode AS 'com.nexr.platform.hive.udf.GenericUDFDecode';
CREATE TEMPORARY FUNCTION nvl2 AS 'com.nexr.platform.hive.udf.GenericUDFNVL2';
CREATE TEMPORARY FUNCTION str_to_date AS 'com.nexr.platform.hive.udf.UDFStrToDate';
CREATE TEMPORARY FUNCTION date_format AS 'com.nexr.platform.hive.udf.UDFDateFormat';
CREATE TEMPORARY FUNCTION to_char AS 'com.nexr.platform.hive.udf.UDFToChar';
CREATE TEMPORARY FUNCTION instr4 AS 'com.nexr.platform.hive.udf.GenericUDFInstr';
CREATE TEMPORARY FUNCTION chr AS 'com.nexr.platform.hive.udf.UDFChr';
CREATE TEMPORARY FUNCTION last_day AS 'com.nexr.platform.hive.udf.UDFLastDay';
CREATE TEMPORARY FUNCTION greatest AS 'com.nexr.platform.hive.udf.GenericUDFGreatest';
CREATE TEMPORARY FUNCTION to_number AS 'com.nexr.platform.hive.udf.GenericUDFToNumber';
CREATE TEMPORARY FUNCTION trunc AS 'com.nexr.platform.hive.udf.GenericUDFTrunc';
CREATE TEMPORARY FUNCTION rank AS 'com.nexr.platform.hive.udf.GenericUDFRank';
CREATE TEMPORARY FUNCTION row_number AS 'com.nexr.platform.hive.udf.GenericUDFRowNumber';
CREATE TEMPORARY FUNCTION sysdate AS 'com.nexr.platform.hive.udf.UDFSysDate';
CREATE TEMPORARY FUNCTION populate AS 'com.nexr.platform.hive.udf.GenericUDTFPopulate';
CREATE TEMPORARY FUNCTION dedup AS 'com.nexr.platform.hive.udf.GenericUDAFDedup';
CREATE TEMPORARY FUNCTION lnnvl AS 'com.nexr.platform.hive.udf.GenericUDFLnnvl';
CREATE TEMPORARY FUNCTION substr AS 'com.nexr.platform.hive.udf.UDFSubstrForOracle';

 
SELECT
  sum(COLUMN1) as C1,
  round(( sum(COLUMN7) )/decode(( sum(COLUMN1) ),0,1,( sum(COLUMN1) )),4),
  round((( sum(COLUMN8) )/ decode(( sum(COLUMN1) ),0,1,( sum(COLUMN1) )) ) * 100 ,4),
  COLUMN4,
  COLUMN5,
  COLUMN6,
  avg(( COLUMN2 )),
  avg(( COLUMN3 )) FROM
  TABLE1
WHERE
  DT  =  '1373221800000'
GROUP BY
  COLUMN4,
  COLUMN5,
  COLUMN6;


SELECT
  sum(COLUMN1) as C1,
  round(( sum(COLUMN7) )/decode(( sum(COLUMN1) ),0,1,( sum(COLUMN1) )),4),
  round((( sum(COLUMN8) )/ decode(( sum(COLUMN1) ),0,1,( sum(COLUMN1) )) ) * 100 ,4),
  sum(COLUMN8) as C4,
  COLUMN4,
  COLUMN5,
  COLUMN6
FROM
  TABLE1
WHERE
  DT  =  '1373221800000'
GROUP BY
  COLUMN4,
  COLUMN5,
  COLUMN6
HAVING
  sum(COLUMN1)  <>  0;


SELECT
  count(distinct ( COLUMN4 )),
  COLUMN5,
  COLUMN6
FROM
  TABLE1
WHERE
  DT  =  '1373221800000'
GROUP BY
  COLUMN5,
  COLUMN6;

SELECT
  count(distinct COLUMN1),
  COLUMN4,
  COLUMN5,
  COLUMN6
FROM
  TABLE2
WHERE
   COLUMN4  IN  ('Unknown','Location_33101','Location_30453')
   AND DT  =  '1373221800000'
GROUP BY
  COLUMN4,
  COLUMN5,
  COLUMN6;
