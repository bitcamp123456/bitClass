CREATE TABLE 일자별매출 (
	일자		VARCHAR(10),
	매출액	NUMBER
);

INSERT INTO 일자별매출 VALUES ('2015.11.01',1000);
INSERT INTO 일자별매출 VALUES ('2015.11.02',1000);
INSERT INTO 일자별매출 VALUES ('2015.11.03',1000);
INSERT INTO 일자별매출 VALUES ('2015.11.04',1000);
INSERT INTO 일자별매출 VALUES ('2015.11.05',1000);
INSERT INTO 일자별매출 VALUES ('2015.11.06',1000);
INSERT INTO 일자별매출 VALUES ('2015.11.07',1000);
INSERT INTO 일자별매출 VALUES ('2015.11.08',1000);
INSERT INTO 일자별매출 VALUES ('2015.11.09',1000);
INSERT INTO 일자별매출 VALUES ('2015.11.10',1000);

select *
from 일자별매출;

select B.일자, sum(B.매출액)
from 일자별매출 A, 일자별매출 B
where A.일자 >= B.일자
group by B.일자;