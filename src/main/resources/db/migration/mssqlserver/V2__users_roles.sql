create table db.roles(
                      role_id int primary key identity(1,1),
                      role_name nvarchar(50) unique not null
);

create table db.user_login(
                           user_id int primary key identity(1,1),
                           emp_id int null,
                           username nvarchar(50) unique not null,
                           email nvarchar(100) unique not null,
                           password_hash nvarchar(255) not null,
                           is_active bit default 1,
                           last_login_time datetime null,
                           created_at datetime default getdate(),
                           updated_at datetime default getdate(),

                           foreign key (emp_id) references db.employees(emp_id)
);

create table db.user_role(
                          user_id int not null,
                          role_id int not null,
                          primary key (user_id, role_id),
                          foreign key (user_id) references db.user_login(user_id),
                          foreign key (role_id) references db.roles(role_id)
);