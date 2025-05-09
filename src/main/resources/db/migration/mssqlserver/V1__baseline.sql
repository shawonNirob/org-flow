
create table employees(
                             emp_id int primary key,
                             name varchar(100),
                             department_id int,
                             salary decimal(10,2),
                             hire_date date,
                             version int not null default 1,
                             created_at datetime default getdate(),
                             updated_at datetime default getdate()
);

create table departments(
                               department_id int primary key,
                               department_name varchar(100)
);

create table projects(
                            project_id int primary key,
                            project_name varchar(100),
                            starting_date date,
                            end_date date
);

create table employee_projects(
                                     emp_id int,
                                     project_id int,
                                     role varchar(50),
                                     primary key (emp_id, project_id),
                                     foreign key (emp_id) references db.employees(emp_id),
                                     foreign key (project_id) references db.projects(project_id)
);

create table audit_employees(
                                   log_id int identity(1, 1) primary key,
                                   emp_id int,
                                   name nvarchar(100),
                                   department_id int,
                                   salary decimal(10,2),
                                   hire_date date,
                                   version int,
                                   created_at datetime,
                                   updated_at datetime,
                                   audit_time datetime default getdate()
);