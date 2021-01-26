select rownum, eno,name, department, position_name, salary from(select e.eno, e.name, e.department, p.position_name, s.salary from employee e, position_list p , employee_salary s where e.eno = s.eno and e.position = p.position_no order by s.salary asc) where rownum <= 5;

select * from position_list;

select rownum, eno,name, department, position_name, salary, position from(select e.eno, e.name, e.department, p.position_name, s.salary, e.position from employee e, position_list p , employee_salary s where e.eno = s.eno and e.position = p.position_no order by s.salary) where rownum <= 5
select e.eno, e.name, e.department, e.position, s.salary, p.position_name from 
EMPLOYEE e, EMPLOYEE_SALARY s , position_list p 
where e.eno = s.eno and e.position = p.position_no