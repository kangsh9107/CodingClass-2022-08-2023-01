/* 내장 함수 */
USE mydb;
SET @a = 10.1;
SET @b = -10.1;
SELECT abs(@a), abs(@b), ceil(@a), ceil(@b), floor(@a), floor(@b);

SELECT round(12345.123456, 3), round(123456, -3), round(12345.123456, 0);
SELECT round(-12.35, 1);

/********** 숫자 관련 함수 **********/
/* 1) 수량이 1234개이고, 단가가 123.4원 제품의 금액을 계산하고,
		1000원 미만의 금액은 절삭하여 표시. */
SELECT (1234*123.4) AS "금액", floor(1234*123.4) AS "절삭", floor(1234*123.4/1000)*1000 AS "100원 단위 이하 절삭";

/* 2) 12345원의 예금액에 이자율을 25% 적용하여 지급액을 조회.
		단, 원단위 이하, 10원단위 이하는 절상 */
SELECT (12345*0.25) AS "원래", ceil(12345*0.25/100)*100 AS "10원 단위 이하 절상";

/* 3) 12311원의 예금액에 이자율을 11% 적용하여 지급액을 조회.
		단, 원단위 이하, 10원단위 이하는 반올림 */
SELECT (12311*0.11) AS "원래", round(12311*0.11/100)*100 AS "10원 단위 이하 반올림";

/* 4) truncate(n, p): p의 자리에서 버림 */
SELECT truncate(12345.678, 0), truncate(12345.678, 1), truncate(12345.678, 2), truncate(12345.678, -1), truncate(12345.678, -2);

/* 5) pow(x, y) OR power(x, y): x의 y승 */
SELECT power(2, 2);

/* 6) mod(x, y): x를 y로 나눈 나머지 */
SELECT mod(10, 3);

/* 7) greatest(n1, n2, n3, ...): 가장 큰 수 */
SELECT greatest(345, 2, 2, 35, 4,
				68, 6, 78, 3, 53,
				6, -100, 7, 7, 657) AS "가장 큰 수";

/* 8) least(n1, n2, n3, ...): 가장 작은 수 */
SELECT least(345, 2, 2, 35, 4,
				68, 6, 78, 3, 53,
				6, -100, 7, 7, 657) AS "가장 작은 수";

/* 비교연산 */
SET @num = 10;
SELECT @num = 10; /* TRUE 1반환 */
SELECT @num = 50; /* FALSE 0반환 */
SELECT @num := "가"; /* @num에 새로운 값 대입 */
SELECT @num;



/********** 문자 관련 함수 **********/
/* 1) ascii(str): str의 아스키 코드값 */
SELECT ascii('e'); /* 1글자씩만 가능. */
SELECT ascii('-');
SELECT ascii(@k);

/* 2) concat(str1, str2, str3, ...): 문자열 연결 */
SET @k = concat('e','n','t','e','r');
SELECT @k;
SELECT concat('enter', ' ', 'key');

/* 3) insert(str, start, length, newStr): str문자열에서
		start에서 LENGTH길이 만큼의 문자열을 newStr로 바꿈
		첫번째 자리가 1이다. */
SELECT insert('12345', 2, 0, 'abc');

/* 4) left(str, length): str에서 왼쪽부터 LENGTH만큼 추출 */
SELECT 










