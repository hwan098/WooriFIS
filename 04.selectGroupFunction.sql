-- 4.selectGroupFunction.sql
-- 그룹함수란? 다수의 행 데이터를 한번에 처리
-- 장점 : 함수 연산시 null 데이터를 함수 내부적으로 사전에 고려해서 null값 보유한 field는 함수 로직 연산시 제외, sql 문장 작업 용이
-- 주의사항 : select 절에는 반드시 group by절에 명시한 컬럼 이외는 함수 사용 없이 검색 불가
-- select deptno, count(comm) from emp; deptno로 인해 에러 발생. 
-- 해결책은?-->  select deptno, count(comm) from emp group by deptno;
/*
1. count() : 개수 확인 함수
2. sum() : 합계 함수
3. avg() : 평균
4. max(), min() : 최대값, 최소값 
*/
 
/* 기본 문법
1. select절
2. from 절
3. where절 

 * 그룹함수시 사용되는 문법
1. select절 : 검색하고자 하는 속성
2. from절	: 검색 table
3. group by 절 : 특정 조건별 그룹화하고자 하는 속성
4. having 절 : 그룹함수 사용시 조건절
5. order by절 : 검색된 데이터를 정렬
*/
use fisa;
-- 1. count() : 개수 확인 함수
-- emp table의 직원이 몇명?


-- ? comm 받는 직원 수만 검색
/*
 * db들은 그룹함수에서 null값은 내부적으로 필터링 해서 null값을 제외한 데이터들로 연산 등 수행
 * */
select comm from emp;
select count(comm) from emp;

-- 2. sum() : 합계 함수
-- ? 모든 사원의 월급여(sal)의 합
select sum(sal) from emp;

-- ? 모든 직원이 받는 comm 합
select sum(comm) from emp;

-- ?  MANAGER인 직원들의  월급여의 합 

select sum(sal)
from emp
where job='MANAGER';

-- ? job 종류 counting[절대 중복 불가 = distinct]
-- 데이터 job 확인
select job from emp;

select count(distinct job) as 직업수
from emp;


-- 3. avg() : 평균
-- ? emp table의 모든 직원들의 급여(sal) 평균 검색
select avg(sal) as 평균급여
from emp;


-- ? 커미션 받는 사원수(count()), 총 커미션 합(sum()), 커미션 평균(avg()) 구하기


-- 4. max(), min() : 최대값, 최소값
-- 숫자, date 타입에 사용 가능

-- 최대 급여, 최소 급여 검색


-- ?최근 입사한 사원의 입사일과, 가장 오래된 사원의 입사일 검색
-- 오라클의 date 즉 날짜를 의미하는 타입도 연산 가능
-- max(), min() 함수 사용해 보기


-- *** 
/* group by절
- 특정 컬럼값을 기준으로 그룹화
	가령, 10번 부서끼리, 20번 부서끼리..
*/

select deptno from emp;

-- 부서별 커미션 받는 사원수 
-- select deptno, count(comm) from emp; 오류
-- 함수를 미 적용하는 컬럼까지 검색시에는 반드시 groub by절에 명시 필수
/*
 * emp ㅌ이블애서 deptno들을 모두가 검색하며, comm이 null인 경우를 제외하고 집계 카운팅
 * 집계된 검색 결과는 하나, deptno는 모두가 거매색
 * 결과는 어떻게 검색?
 * group by절에 명시한 컬럼값만 select절에 함수 사용 없이 검색 가능
 * 
 */
-- select deptno, count(comm) from emp; -->오류
select deptno, count(comm) from emp group by deptno; 

-- deptno 오름차순(asc) 정렬 추가
-- 존재하는 table에서 부서별 그룹핑 후에 부서별 
-- 커미션 개수 파악 후에 부서번호 정렬
select deptno, count(comm) 
from emp 
group by deptno
order by deptno asc; 

select deptno, count(comm) 
from emp 
group by deptno
order by deptno desc; 

-- ? 부서별(group by deptno) (월급여) 평균 구함(avg())(그룹함수 사용시 부서 번호별로 그룹화 작업후 평균 연산)
-- db 별로 함수나 문법이 다를 수도 있다는 것을 인지하고 있을 것
-- 실행순서 : from -> group by -> select 
select deptno as 부서번호, round(avg(sal)) as 평균급여
from emp 
group by deptno;

-- ? 소속 부서별 급여 총액과 평균 급여 검색[deptno 오름차순 정렬]
select deptno as 부서번호, round(sum(sal)) as 급여총액, round(avg(sal)) as 평균급여
from emp 
group by deptno
order by deptno asc;

select deptno as 부서번호, round(sum(sal)) as 급여총액, round(avg(sal)) as 평균급여
from emp 
group by 부서번호
order by deptno asc;

-- ? 소속 부서별 최대 급여와 최소 급여 검색[deptno 오름차순 정렬]
-- 컬럼명 별칭에 여백 포함한 문구를 사용하기 위해서는 쌍따옴표로만 처리
-- 컴럼에 여백 ㅍ포한ㅁ한 문구를 사용하기 위해서는 쌍따옴표로 처리

select deptno as 부서번호, round(max(sal)) as 최대급여, round(min(sal)) as 최소급여
from emp 
group by deptno
order by deptno asc;


-- *** having절 *** [ 조건을 주고 검색하기 ]
-- 그룹함수 사용시 조건문
/*
 * 그룹 함수 사용 전 조건문 적용
 * select절 from절 where절
 * 그룹 함수 사용 후 그룹별 조건
 * select절 from절 group by절 having절
 * 
 * */
-- 1. ? 부서별(group by) 사원의 수(count(*))와 커미션(count(comm)) 받는 사원의 수
-- 집계(그룹) 함수는 null은 자동 제거
select deptno as 부서, count(*) 사원 수, count(comm) 커미션받는 사원수
from emp
group by deptno;

-- 조건 추가
-- 2. ? 부서별 그룹을 지은후(group by deptno), 
-- 부서별(deptno) 평균 급여(avg())가 2000 이상(>=)부서의 번호와 평균 급여 검색 

select deptno as 부서, round(avg(sal))
from emp
group by deptno
having avg(sal) >= 2000;
-- group 함수 문장속 조건문은 having절로 적용
-- 실행 순서 : oracle db : from -> group by -> having -> select

-- mysql에서는 정상실행되는데, oracle에서는 having절에 평균급여 사용불가
select deptno as 부서, round(avg(sal)) as 평균급여
from emp
group by 부서
having 평균급여 >= 2000;

-- oracle
select deptno as 부서, round(avg(sal)) as 평균급여
from emp
group by deptno
having round(avg(sal)) >= 2000;


-- 3. 부서별(group by) 급여중 최대값(max(sal))과 최소값(min(sal))을 구하되 
-- 최대 급여(max(sal))가 2900이상(having  >= )인 부서만 출력
select deptno as 부서, max(sal) as 최대값, min(sal) as 최소값
from emp
group by deptno
having max(sal) >= 2900;

/*
 * 직업 중에서 SALESMAN들의 최대 연봉(max(sal))과 최저 연봉최소값(min(sal))을 구하세요.
 * 
 */
select * from emp;

select job as 직업, max(sal*12) as "최대 연봉", min(sal*12) as "최저 연봉"
from emp
group by job
having job = 'SALESMAN';

SELECT MAX(sal) as 최대연봉, MIN(sal) as 최소연봉
FROM emp
GROUP BY job
HAVING job = 'SALESMAN';

-- "emp" 테이블에 있는 job 중에서,
-- 그 job을 가진 직원들의 월급(sal)의 평균을 내림차순으로 정렬하세요
-- 단, 같은 job을 가진 직원이 3명 이상인 경우에만 고려합니다.
SELECT job
FROM emp
GROUP BY job
HAVING COUNT(*) >= 3
ORDER BY AVG(sal) DESC;

-- 부서별 급여의 평균값을 구하고 평균 급여가 2500 이상인 부서를 출력한다. 이때, 급여의 평균값은 정수로 떨어진다.
SELECT deptno, ROUND(AVG(sal)) as 평균급여
FROM emp
GROUP BY deptno
HAVING AVG(sal) >= 2500;

-- emp 테이블에 있는 사람들 중 근속년수가 40년 이상인 사람들을 구하세요.

select ename, timestampdiff(year, hiredate, now()) + 1 as 근속년수
FROM emp
GROUP BY ename 
HAVING 근속년수 >= 40;

select *
FROM emp
GROUP BY hiredate  
HAVING timestampdiff(year, hiredate, now() + 1 as 근속년수 >= 40;

SELECT *
FROM emp
WHERE sysdate() - emp.hiredate >= 40;

-- 부서별 연봉(comm + sal) 중 평균 연봉이 최대인 부서부터 내림차순으로 출력하시오

select deptno, avg(ifnull(0, comm) + sal*12) as 평균연봉
from emp
GROUP BY deptno
ORDER BY avg(ifnull(0, comm) + sal*12) desc;


-- 부서별 연봉(comm + sal) 중 평균 연봉이 최대인 부서부터 내림차순으로 출력하시오
SELECT deptno,AVG(IFNULL(0, comm) + sal*12) as 평균연봉
FROM emp
GROUP BY deptno
ORDER BY 평균연봉 DESC;
/*
 * -- 연봉이 30000 이상인 사원의 직무
 * -- 1년차 이상, 연봉이 1000 이상인 사람중, 연차별 평균 연봉을 연차별 내림차순으로 정렬하여 출력하라 (지금은 1988년 1월 1일 입니다)
 * --1981-05-02 이후 입사한 사원들 중 부서별 부서 번호, 급여 평균, 최대 급여, 최소 급여 출력 단, 최대 급여가 2000 이상만 출력
 * --부서별 연봉(comm + sal) 중 평균 연봉이 최대인 부서부터 내림차순으로 출력하시오😀
 * -- 부서별 직무별 평균 급여가 1500 넘는 부서별 직무를 오름차순으로 출력하는 쿼리문을 작성하세요.
 * --직무별 최대 급여가 1500 이상이면서 81년 7월 1일 이후 입사자의 최대급여, 최소급여, 직무 출력
 * */

