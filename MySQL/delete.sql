SELECT * FROM cus;
/* 1) country�� USA�� �������� ���� */
SELECT * FROM cus WHERE country = 'USA';
DELETE FROM cus WHERE country = 'USA'; /* SELECT�� Ȯ���ϰ� �״�� ������ ���°� ����. */
SELECT * FROM cus WHERE country = 'USA';
rollback;
SELECT * FROM cus WHERE country = 'USA';

/* 2) country USA�̰� state�� NY�� �ڷḸ ���� */
SELECT * FROM cus;
DELETE FROM cus WHERE country = 'USA' and state = 'NY';

/* 3) customerNumber�� 146���� ���� ���� country �ڷḦ ���� */
SELECT * FROM cus;
SELECT * FROM cus WHERE country = 
	( SELECT a.country from
		( SELECT country FROM cus WHERE customerNumber = '146' ) a
	);
	/* ����Ŭ�� ��� �������� �ϳ��ε� �� �۵������� MySQL��
	 * DML ����� �����Ϸ��� ���̺��� ���������� ���� ���� �� �� ��������.
	 * �׷��� �������� ������ ���������� ���� ��� �Ѵ�.
	 * a�� �ϳ��� ���� ���̺��̶�� �����ϸ� ���ϴ�.
	 */

/* join���� �غ��� */










