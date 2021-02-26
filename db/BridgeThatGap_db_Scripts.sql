create & populate table - tech_companies; -- this is the masterlist, not client-list

---
CREATE SEQUENCE emp_id_seq START 101;
create table employees (
	id INTEGER PRIMARY KEY,
	name VARCHAR(50), 
	role VARCHAR(20),
	specialization VARCHAR(30),
	email VARCHAR(60) NOT NULL,
	password VARCHAR(15) NOT NULL
);
insert into employees values (NEXTVAL('emp_id_seq'),'Keisha', 'Consultant', 'Gender Diversity');
insert into employees values (NEXTVAL('emp_id_seq'),'Pat', 'Consultant', 'Racial Diversity');
insert into employees values (NEXTVAL('emp_id_seq'), 'Swathy', 'Consultant', 'Gender and Racial Diversity');
insert into employees values (NEXTVAL('emp_id_seq'), 'Akule', 'Admin', 'Native American Workforce');
---
CREATE SEQUENCE client_id_seq START 101;
create table clients (
	client_id INTEGER PRIMARY KEY,
	client_name VARCHAR(50) NOT NULL, 
	contact_name VARCHAR(50) NOT NULL,
	contact_phone VARCHAR(10),
	contact_email VARCHAR(60) NOT NULL
);
insert into clients values (NEXTVAL('client_id_seq'),'Nassa', 'Max Maximus', '4081234567','maximusm@nassawebb.com');

---
CREATE SEQUENCE interv_id_seq INCREMENT BY 10 START WITH 10;
create table interventions(
	interv_id INTEGER PRIMARY KEY,
	option VARCHAR(100) NOT NULL
);
insert into interventions values (NEXTVAL('interv_id_seq'),'Workshop');
insert into interventions values (NEXTVAL('interv_id_seq'),'Speaker');
insert into interventions values (NEXTVAL('interv_id_seq'),'Social Justice Board Game');
insert into interventions values (NEXTVAL('interv_id_seq'),'DVD');
insert into interventions values (NEXTVAL('interv_id_seq'),'One-on-one sessions');

---
CREATE SEQUENCE consult_id_seq INCREMENT BY 1 START WITH 1;
create table consultations (
	consult_id INTEGER PRIMARY KEY,
	client_id INTEGER NOT NULL,
	emp_id INTEGER NOT NULL,
	interv_id INTEGER NOT NULL,
	start_date DATE,
	end_date DATE,
	status VARCHAR(100) NOT NULL,
	comments VARCHAR(1000)
);
--------SET FOREIGN KEY CONSTRAINTS & REFERENCES for this last table ----------
ALTER TABLE consultations 
ADD CONSTRAINT client_id_const
FOREIGN KEY (client_id) 
REFERENCES clients (client_id);

ALTER TABLE consultations 
ADD CONSTRAINT emp_id_const
FOREIGN KEY (emp_id) 
REFERENCES employees (emp_id);

ALTER TABLE consultations 
ADD CONSTRAINT interv_id_const
FOREIGN KEY (interv_id) 
REFERENCES interventions (interv_id);
----------------
insert into consultations (consult_id, client_id, emp_id, interv_id, start_date, status)
values (NEXTVAL('consult_id_seq'),101, 104, 20,'02/19/2021','BEGIN CONSULTATION');

