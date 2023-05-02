-- 3.selectFunction.sql
/*
   내장 함수 종류
      1. 단일행 함수 - 입력한 행수(row) 만큼 결과 반환
      2. 집계(다중행, 그룹) 함수 - 입력한 행수와 달리 결과값 하나만 반환 
   *cf
      -  참조 변수 없이 함수명만 독립적으로 호출 가능한 구현제들을 함수라고 칭함
      - java에서 class 내부에 모든 기능들이 구현 - 메소드
      : 참조변수명.메소드([..]);
      : class명.메소드([..]);

*/

use fisa;

-- 단일행 함수 : 입력 데이터 수만큼 출력 데이터
/* Mysql Db 자체적인 지원 함수 다수 존재
1. 숫자 함수 MySQL Numeric Functions
2. 문자 함수
3. 날짜 함수 

**/

/*
mysql rdbs 특징
- 오라클 db와 비교
- select 3.5, -3.5, +3.5; 문자으은 특정 table로부터의 검색이 아님
   단순 숫자를 활여ㅛㅇ 가능한 여부만 확인
   oracle의 경우 기본 sysntax 구성
      - select 3.5, -3.5, +3.5 from dual;
      - dummy(쓰레기, 잉여) table - dual
         : dual table은 기본 문법 구성을 위해서 사용
      - oracle은 select시에 from 절 필수

   mysql의 경우 from 절이 없어도 된다.

*/

-- *** [숫자함수] ***
-- 1. 절대값 구하는 함수 : abs()
select 3.5, -3.5, +3.5;
select abs(3.5), abs(-3.5), abs(+3.5);


-- 2. 반올림 구하는 함수 : round(데이터 [, 반올림자릿수])
-- 반올림자릿수 : 소수점을 기준으로 양수는 소수점 이하 자리수 의미
         -- 음수인 경우 정수자릿수 의미

mysql> select round(avg(sal), 1) as 평균급여 from emp;
+----------+
| 평균급여 |
+----------+
|   2073.2 |
+----------+

-- 3. 지정한 자리수 이하 버리는 함수 : trunc()
-- 반올림 미적용
-- truncate(데이터, 소수자릿수)
-- 자릿수 : +(소수점 이하), -(정수 의미)
-- 참고 : 존재하는 table의 데이터만 삭제시 방법 : delete[복원]/truncate[복원불가]

mysql> select truncate(avg(sal), -1) as 평균급여 from emp;
+----------+
| 평균급여 |
+----------+
|     2070 |
+----------+

  
-- 4. 나누고 난 나머지 값 연산 함수 : mod()
-- 모듈러스 연산자, % 표기로 연산, 오라클에선 mod() 함수명 사용

select mod(5, 2)

mysql> select mod(5, 2);
+-----------+
| mod(5, 2) |
+-----------+
|         1 |
+-----------+

-- 5. ? emp table에서 사번(empno)이 홀수인 사원의 이름(ename), 
-- 사번(empno) 검색 
SELECT ename, empno
FROM emp
WHERE mod(empno, 2) != 0;

-- *** [문자함수] ***
/* tip : 영어 대소문자 의미하는 단어들
대문자 : upper
소문자 : lower
철자 : case 
*/
-- 1. 대문자로 변화시키는 함수
-- upper() : 대문자[uppercase]
-- lower() : 소문자[lowercase]


-- 2. ? manager로 job 칼럼과 뜻이 일치되는 사원의 사원명 검색하기 
-- mysql은 데이터값의 대소문자 구분없이 검색 가능
-- 해결책 1 : binary()  대소문자 구분을 위한 함수
select job from emp where job=bianry('manager');

-- 해결책 2 : alter 명령어로 처리
alter table emp change ename ename varchar(20) bianry;



-- 3. 문자열 길이 체크함수 : length()
-- 문자열의 길이를 byte 단위로 반환
-- dept table에 새로운 데이터 저장
/*
   orcle db와의 차이점
   1. length() : 문자열 길이값 반환
   2. lengthb() : 저장된 문자열의 메모리 byte 길이 체크함수

*/
INSERT INTO dept VALUES(50, '교육부', '상암');
COMMIT;

--부서명을ㄹ length()로 검색
SELECT length(dname) from dept;
mysql> +---------------+
    -> | length(dname) |
    -> +---------------+
    -> |            10 |
    -> |             8 |
    -> |             5 |
    -> |            10 |
    -> |             9 |
    -> +---------------+

SELECT dname, char_length(dname) from dept;
+------------+--------------------+
| dname      | char_length(dname) |
+------------+--------------------+
| ACCOUNTING |                 10 |
| RESEARCH   |                  8 |
| SALES      |                  5 |
| OPERATIONS |                 10 |
| 교육부     |                  3 |
+------------+--------------------+
-- 4. 문자열 일부 추출 함수 : substr()
-- 서브스트링 : 하나의 문자열에서 일부 언어 발췌하는 로직의 표현

-- substr(데이터, 시작위치, 추출할 개수)
-- 시작위치 : 1부터 시작

-- 5. ? 년도 구분없이 2월에 입사한 사원(mm = 02)이름, 입사일 검색
-- date 타입에도 substr() 함수 사용 가능
-- 문자열 index 시작 - 1 
use fisa;
select * from emp;

select ename, hiredate
from emp
where substr(hiredate, 6, 2) = 02;


-- 년도만 검색
select substr(hiredate, 1, 4) from emp;
-- 월만 검색
select substr(hiredate, 6, 2) from emp;
-- 일만 검색
select substr(hiredate, 9, 2) from emp;




--7. 문자열 앞뒤의 잉여 여백 제거 함수 : trim()
/*length(trim(' abc ')) 실행 순서
   ' abc ' 문자열에 디비에 생성
   trim() 호출해서 잉여 여백제거
   trim() 결과값으로 length() 실행 */
select char_length(' abc'), char_length(trim(' abc '));  



-- *** [날짜 함수] ***
-- 1. ?어제, 오늘, 내일 날짜 검색 
-- 현재 시스템 날짜에 대한 정보 제공 함수
-- sysdate() & now(): 날짜 시분 초
-- curdate() : 날짜
select sysdate(); -- 2023-05-02 11:19:39
select  now(); -- 2023-05-02 11:20:04
select curdate(); -- 2023-05-02

-- 2.?emp table에서 근무일수 계산하기, 사번과 근무일수 검색
select empno, curdate() - hiredate as 근무일수
from emp;

select empno, datediff(now(), hiredate)
from emp;


-- 3. ? 교육시작 경과일수
-- 4. 문자열 날짜로 변경
-- 순수 문자열을 날짜 형식으로 변환해서 검색
-- str_to_date() 문자열을 날짜 포맷으로 변환
-- datediff() 일자 계산 시 유용한 함수 (첫번째 값- 두번째 값)
select str_to_date('2023 04 18', '%Y %m %d');
select datediff('20230403', now()); 
select datediff(now(), '20230403'); 
/* 
	yy/mm/dd 포멧으로 연산시에는 반드시 to_date() 라는 날짜 포멧으로
	변경하는 함수 필수 
	단순 숫자 형식으로 문자 데이터 연산시 정상 연산 
*/
 




-- 5. 특정 일수 및 개월수 더하는 함수 : ADDATE()
-- 10일 이후 검색 
select sysdate(); 
select adddate(sysdate(), 10);

-- 15분 이후
select sysdate(), adddate(sysdate(), interval 15 minute); 
select sysdate(), adddate(sysdate(), interval 15 day); 
-- 6. ? emp table에서 입사일 이후 3개월 지난 일자 검색

select hiredate from emp;

select adddate(hiredate, interval 3 month)
from emp;

-- 7. 두 날짜 사이의 개월수 검색 : months_between()
-- 오늘(sysdate) 기준으로 2021-09-19
/*
 * dayofyear() : 현재가 속한 해다 년의 1월1일부터의 일자 카운팅 함수
 * dayofmonth() : 해당 달의 지난 일수
 * */
select dayofyear(now());
select dayofyear('20230102');
select dayofyear('20230110');
select dayofyear('20230223');
-- 특정 기준일로 오늘은 며칠차?(기준일 포함할 경우 +1)

-- 8. 오늘을 기준으로 100일은?(오늘이 1일로 계산할 경우 기준일 포함)
select adddate(now(), interval 99 day) as 100일; 

-- emp 직원들의 입사일 기준으로 5개월 후의 일자는?

-- 9. 주어진 날짜를 기준으로 해당 달의 가장 마지막 날짜 : last_day()
select last_day(sysdate());

-- 10. sql + 결과만 보고 함수 기능 도출해보기
/*
 * timestamp : 1970-01-01 0시 0분 0초부터 결과된 초단위의 수
 * timestampdiff() : 둘 이상 시각 비교, 기간을 계산할 때 사용
 * 
 * 주의사항 : 연산은 0값부터 시작, 따라서 최종 결과값에 +1로 유효한 범위 표현
 * */
-- 현재까지 며칠 지났는지
/*
 * 년도인 경우 365일 기준
 * - 연도가 기준인 경우 년도가 변경되면 무조건 1씩 증가시키겠다하는 설정인 경우엔 권장
 * +1 할 때 : 해가 바뀌면 365일이 초과되지 않은 상태에서 1년 add
 * +1인 없는 경우 정확하게 year년 365일로 처리(더 정확한 표현!)
 * 
 * */
select now();

select timestampdiff(day, '2022-05-01', now()) + 1 as 경과일수, curdate() as 오늘;
-- 현재까지 몇 년 지났는지 -> 근무년차 구할 때 주로 사용하는 기법
-- 365일을 넘기면 무조건 1년씩 add
select timestampdiff(year, '2020-05-02', '2021-05-01') + 1 as years,
timestampdiff(year, '2020-05-02', '2021-05-02') + 1 as years,
timestampdiff(year, '2020-05-02', now()) + 1 as years;



-- 12.? 2020년 2월의 마지막 날짜는?
select last_day('2020-02-01');



-- *** [형변환 함수] ***
-- Data type
-- DATETIME : 'YYYY-MM-DD HH:MM:SS'
-- DATE : 'YYYY-MM-DD'
-- TIME : 'HH:MM:SS'
-- CHAR : String
-- SIGNED : Integer(64bit), 부호 사용 가능
-- UNSIGNED : Integer(64bit), 부호 사용 불가
-- BINARY : binary String


-- 1. cast() - 특정 type으로 형변환

-- 숫자를 문자로 변환
select cast(1 as char(10)) as data1;
select char_length(cast(1 as char(10))) as data1;
select char_length(cast(11 as char(10))) as data1;
-- 문자를 숫자로 변환
-- 실수 --> 함수명과 () 사이 여백 적용해서 오류가 발생했었음
select cast(1 as SIGNED) as data1;




-- 2. STR_TO_DATE() : 날짜로 변경 시키는 함수

--  올해 며칠이 지났는지 검색(포멧 yyyy/mm/dd)
-- select sysdate - 20200719; 오류 해결 --> sysdate()
-- select sysdate - '20200719'; 오류
-- oracle db에서 sysdate라는 속성명으로 사용이 가능하지만 
-- mysql는 sysdate() 함수로 사용해야 한다.

select sysdate(); 
select sysdate() - STR_TO_DATE('20220501');

/*
 * 주의사항
 * 함수 사용 시 %Y : 년 / %M : 월 / %d : 일
 *  - % 표기 필수 단,  대소문자 중요
 *  - '2023 04 18'처럼 숫자 형식으로만 구성된 날짜 표현시 월은 %m 표시로 설계
 *  - 'august 10 2022' 처럼 문자가 포함된 날짜 표현시 %M 표시로 설계
 * */

select str_to_date('august 10 2022', '%M %d %Y');
select str_to_date('august 10 2022', '%M %D %Y');
select str_to_date('august 10 2022', '%M %d %Y');
select str_to_date('august 10 2022', '%m %d %Y');

select str_to_date('2023 04 18', '%Y %m %d'); -- 2023-04-18
select str_to_date('2023 04 18', '%Y %M %d'); -- null
-- 3. 문자열로 date타입 검색 가능[데이터값 표현이 유연함]
-- 1980년 12월 17일 입사한 직원명 검색
select ename from emp where hiredate='1980-12-17';

-- 4. to_number(문자열, 변환포멧) : 문자열을 숫자로 변환
-- 어떤 숫자 형식으로 변환가능한지에 대한 명확성 필요한 함수 
-- 1. '20,000'의 데이터에서 '10,000' 산술 연산하기 
-- 힌트 - 9 : 실제 데이터의 유효한 자릿수 숫자 의미(자릿수 채우지 않음)
-- ?
/*
 * 문자를 숫자로 변환해서 연산 시 주의 : cast('20,000) 표현식 연사나값 부적절
 * 해결책 : cast('20,000)
 * */
select cast('20,000' as SIGNED) - cast('10,000' as SIGNED);
select cast('20000' as SIGNED) - cast('10000' as SIGNED);

-- *** 조건식 함수 ***
-- decode()-if or switch문과 같은 함수 ***
-- decode(조건칼럼, 조건값1,  출력데이터1,
--			   조건값2,  출력데이터2,
--				...,
--			   default값) from table명;

--1. deptno 에 따른 출력 데이터
-- 10번 부서는 A로 검색/20번 부서는 B로 검색/그외 무로 검색
select * from dept;

/*
 * mysql db의 조건 문장
 * case
 * 	when 조건식1 then 조건식이 true인 경우 실행
 * 	when 조건식2 then 조건식이 true인 경우 실행
 *  else result
 * end;
 * */
-- 용어 : `(백틱)

select deptno, ename from emp;

select deptno,
	case
		when deptno=10 then 'A'
		when deptno=20 then 'B'
		else '무'
	end as level
from emp;
	

--2. emp table의 연봉(sal) 인상계산
-- job이 ANALYST 5%인상(sal*1.05), SALESMAN 은 10%(sal*1.1) 인상, 
-- MANAGER는 15%(sal*1.15), CLERK 20%(sal*1.2) 인상

select distinct job

select distinct ename, job, sal, 
	case
		when job='ANALYST' then round(sal*1.05)
		when job='SALESMAN' then round(sal*1.1)
		when job='MANAGER' then round(sal*1.15)
		when job='CLERK' then round(sal*1.2)
		else '동결'
	end as 연봉
from emp;



-- 3. 'MANAGER'인 직군은 '갑', 'ANALYST' 직군은 '을', 
-- 나머지는 '병'으로 검색

select distinct job,
	case
		when job='MANAGER' then '갑'
		when job='ANALYST' then '을'
		else '병'
	end as level
from emp;
	




