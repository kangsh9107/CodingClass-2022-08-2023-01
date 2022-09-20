/* ���� �Լ� */
USE mydb;
SET @a = 10.1;
SET @b = -10.1;
SELECT abs(@a), abs(@b), ceil(@a), ceil(@b), floor(@a), floor(@b);

SELECT round(12345.123456, 3), round(123456, -3), round(12345.123456, 0);
SELECT round(-12.35, 1);

/********** ���� ���� �Լ� **********/
/* 1) ������ 1234���̰�, �ܰ��� 123.4�� ��ǰ�� �ݾ��� ����ϰ�,
		1000�� �̸��� �ݾ��� �����Ͽ� ǥ��. */
SELECT (1234*123.4) AS "�ݾ�", floor(1234*123.4) AS "����", floor(1234*123.4/1000)*1000 AS "100�� ���� ���� ����";

/* 2) 12345���� ���ݾ׿� �������� 25% �����Ͽ� ���޾��� ��ȸ.
		��, ������ ����, 10������ ���ϴ� ���� */
SELECT (12345*0.25) AS "����", ceil(12345*0.25/100)*100 AS "10�� ���� ���� ����";

/* 3) 12311���� ���ݾ׿� �������� 11% �����Ͽ� ���޾��� ��ȸ.
		��, ������ ����, 10������ ���ϴ� �ݿø� */
SELECT (12311*0.11) AS "����", round(12311*0.11/100)*100 AS "10�� ���� ���� �ݿø�";

/* 4) truncate(n, p): p�� �ڸ����� ���� */
SELECT truncate(12345.678, 0), truncate(12345.678, 1), truncate(12345.678, 2), truncate(12345.678, -1), truncate(12345.678, -2);

/* 5) pow(x, y) OR power(x, y): x�� y�� */
SELECT power(2, 2);

/* 6) mod(x, y): x�� y�� ���� ������ */
SELECT mod(10, 3);

/* 7) greatest(n1, n2, n3, ...): ���� ū �� */
SELECT greatest(345, 2, 2, 35, 4,
				68, 6, 78, 3, 53,
				6, -100, 7, 7, 657) AS "���� ū ��";

/* 8) least(n1, n2, n3, ...): ���� ���� �� */
SELECT least(345, 2, 2, 35, 4,
				68, 6, 78, 3, 53,
				6, -100, 7, 7, 657) AS "���� ���� ��";

/* �񱳿��� */
SET @num = 10;
SELECT @num = 10; /* TRUE 1��ȯ */
SELECT @num = 50; /* FALSE 0��ȯ */
SELECT @num := "��"; /* @num�� ���ο� �� ���� */
SELECT @num;



/********** ���� ���� �Լ� **********/
/* 1) ascii(str): str�� �ƽ�Ű �ڵ尪 */
SELECT ascii('e'); /* 1���ھ��� ����. */
SELECT ascii('-');
SELECT ascii(@k);

/* 2) concat(str1, str2, str3, ...): ���ڿ� ���� */
SET @k = concat('e','n','t','e','r');
SELECT @k;
SELECT concat('enter', ' ', 'key');

/* 3) insert(str, start, length, newStr): str���ڿ�����
		start���� LENGTH���� ��ŭ�� ���ڿ��� newStr�� �ٲ�
		ù��° �ڸ��� 1�̴�. */
SELECT insert('12345', 2, 0, 'abc');

/* 4) left(str, length): str���� ���ʺ��� LENGTH��ŭ ���� */
SELECT 










