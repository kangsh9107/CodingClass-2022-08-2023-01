/* COMMENT '고객번호를 사용하여 연락처와 지불총액을 inout모드의 파라미터를 사용하여 프로시저 밖에서 확인하시오' */
/* GROUP BY 연습 */
SELECT * FROM classicmodels.customers;
SELECT * FROM classicmodels.payments;
	SELECT sum(p.amount), c.phone
	FROM classicmodels.payments p
	JOIN classicmodels.customers c
	ON p.customernumber = c.customernumber
	where c.customernumber = 103
	group BY c.phone;
	
/* 1) 사원번호와 사원명을 커서를 사용하여 출력 */
SELECT * FROM classicmodels.offices;
SELECT * FROM classicmodels.employees;

DROP PROCEDURE cur_test1;
CREATE PROCEDURE cur_test1()
begin
	DECLARE msg LONGTEXT DEFAULT '';
	DECLARE m_no varchar(50);
	DECLARE m_name varchar(50);
	DECLARE finished INT DEFAULT 0;
	
	DECLARE cur CURSOR for
		SELECT employeeNumber, lastName
		FROM classicmodels.employees;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;
	
	OPEN cur;
	here : loop
		FETCH cur INTO m_no, m_name;
		IF finished = 1 then
			LEAVE here;
		END if;
		SET msg = concat(msg, m_no, '-', m_name, '\n');
	END loop;
	CLOSE cur;
	
	SELECT msg;
end;

CALL cur_test1();

/* 2) 사번을 입력받아 같은 부서 직원의 이름과, 이메일, 직무(jobTitle)을 출력 */
SELECT * FROM classicmodels.offices;
SELECT * FROM classicmodels.employees;

DROP PROCEDURE cur_test2;
CREATE PROCEDURE cur_test2(IN en int)
begin
	DECLARE m_name varchar(30) DEFAULT '';
	DECLARE m_mail varchar(50) DEFAULT '';
	DECLARE m_job varchar(20) DEFAULT '';
	DECLARE finished INT DEFAULT 0;
	DECLARE msg LONGTEXT DEFAULT '';
	
	DECLARE cur CURSOR FOR
		SELECT e1.lastName, e1.email, e1.jobTitle
		FROM classicmodels.employees e1 JOIN classicmodels.employees e2
		ON e1.officeCode = e2.officeCode
		WHERE e2.employeeNumber = en;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;
	
	OPEN cur;
	here : loop
		FETCH cur INTO m_name, m_mail, m_job;
		IF finished = 1 then
			LEAVE here;
		END if;
		SET msg = concat(msg, 'name: '    , m_name, ' // ',
							  'email: '   , m_mail, ' // ',
							  'jobTitle: ', m_job , '\n');
	END loop;
	CLOSE cur;
	
	SELECT msg "employeeInformation";
end;

CALL cur_test2(1002);

/* 3) 고객번호를 입력받아 고객이름, 연락처, 지불액, 우편번호를 출력 */
SELECT * FROM classicmodels.customers;
SELECT * FROM classicmodels.payments;

DROP PROCEDURE cur_test3;
CREATE PROCEDURE cur_test3(IN cn int)
begin
	DECLARE m_name varchar(30) DEFAULT '';
	DECLARE m_phone varchar(30) DEFAULT '';
	DECLARE m_amount INT DEFAULT 0;
	DECLARE m_postalCode varchar(20) DEFAULT '';
	DECLARE finished INT DEFAULT 0;
	DECLARE msg LONGTEXT DEFAULT '';
	
	DECLARE cur CURSOR for
		SELECT c.customerName, c.phone, p.amount, c.postalCode
		FROM classicmodels.customers c JOIN classicmodels.payments p
		ON c.customerNumber = p.customerNumber
		WHERE p.customerNumber = cn;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;
	
	OPEN cur;
	here : loop
		FETCH cur INTO m_name, m_phone, m_amount, m_postalCode;
		IF finished = 1 then
			LEAVE here;
		END if;
		SET msg = concat(msg, 'name: '      , m_name      , ' // ',
							  'phone: '     , m_phone     , ' // ',
							  'amount: '    , m_amount    , ' // ',
							  'postalCode: ', m_postalCode, '\n');
	END loop;
	CLOSE cur;
	
	SELECT msg "customerInformation";
end;

CALL cur_test3(103);

/* 4) 년도를 입력받아 해당 년도에 고객에게 지불된 지불액과, 고객명, 연락처 출력 */
SELECT * FROM classicmodels.customers;
SELECT * FROM classicmodels.payments;

DROP PROCEDURE cur_test4;
CREATE PROCEDURE cur_test4(IN pd int)
begin
	DECLARE m_name varchar(200) DEFAULT '';
	DECLARE m_date varchar(30) DEFAULT 0;
	DECLARE m_amount INT DEFAULT 0;
	DECLARE m_phone varchar(30) DEFAULT '';
	DECLARE finished INT DEFAULT 0;
	DECLARE msg LONGTEXT DEFAULT '';
	
	DECLARE cur CURSOR FOR
		SELECT c.customerName, p.paymentDate, p.amount, c.phone
		FROM classicmodels.customers c JOIN classicmodels.payments p
		ON c.customerNumber = p.customerNumber
		WHERE year(p.paymentDate) = pd;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;
	
	OPEN cur;
	here : loop
		FETCH cur INTO m_name, m_date, m_amount, m_phone;
		IF finished = 1 then
			LEAVE here;
		END if;
		SET msg = concat(msg, 'name: '  , m_name  , ' // ',
							  'date: '  , m_date  , ' // ',
							  'amount: ', m_amount, ' // ',
							  'phone: ' , m_phone , '\n');
	END loop;
	CLOSE cur;
	
	SELECT msg "customerInformation";
end;

CALL cur_test4(2004);

/* 5) 신용한도액(creditLimit)과 지불 총액을 비교하여 신용한도액을
	  초과한 고객의 이름, 신용한도액, 지불총액, 연락처 조회 */
SELECT * FROM classicmodels.customers;
SELECT * FROM classicmodels.payments;

DROP PROCEDURE cur_test5;
CREATE PROCEDURE cur_test5()
begin
	DECLARE m_name varchar(200) DEFAULT '';
	DECLARE m_creditLimit INT DEFAULT 0;
	DECLARE m_total INT DEFAULT 0;
	DECLARE m_phone varchar(30) DEFAULT '';
	DECLARE finished INT DEFAULT 0;
	DECLARE msg LONGTEXT DEFAULT '';
	
	DECLARE cur CURSOR for
		SELECT customerName, creditLimit, sum(amount), phone
		FROM classicmodels.customers c JOIN classicmodels.payments p
		ON c.customerNumber = p.customerNumber
		GROUP BY c.customerNumber;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;
	
	OPEN cur;
	here : loop
		FETCH cur INTO m_name, m_creditLimit, m_total, m_phone;
		IF finished = 1 then
			LEAVE here;
		END if;
		
		IF m_total>m_creditLimit then
			SET msg = concat(msg, 'name: '       , m_name       , ' // ',
								  'creditLimit: ', m_creditLimit, ' // ',
								  'total: '      , m_total      , ' // ',
								  'phone: '      , m_phone      , '\n');
		END if;
	END loop;
	CLOSE cur;
	
	SELECT msg "creditInformation";
end;

CALL cur_test5();










	
		