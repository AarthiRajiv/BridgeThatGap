--- create & populate table - tech_companies; -- this is the master-list, not client-list

---
CREATE TABLE "BridgeThatGap".employees (
	emp_id SERIAL PRIMARY KEY,
	"name" varchar(100) NULL,
	"role" varchar(20) NULL,
	specialization varchar(50),
	email varchar(60) NOT NULL,
	"password" varchar(128) NOT NULL
);
insert into employees values (DEFAULT,'Keisha Noah', 'consultant', 'Gender Diversity','nkeisha@btg.com','password');
insert into employees values (DEFAULT,'Pat Padilla', 'consultant', 'Race','ppat@btg.com','password');
insert into employees values (DEFAULT, 'Swathy Mohan', 'consultant', 'Gender and Disabilities','mswathy@btg.com','password');
insert into employees values (DEFAULT, 'Akule Amitola', 'admin', 'Native American Workforce','aakule@btg.com','password');

---
CREATE TABLE "BridgeThatGap".clients (
	client_id SERIAL PRIMARY KEY,
	client_name varchar(100) NOT NULL,
	contact_name varchar(100) NOT NULL,
	contact_phone varchar(10) NULL,
	contact_email varchar(60) NOT NULL
);
insert into clients values (DEFAULT,'Naassa', 'Max Maximus', '4081234567','maximusm@nassawebb.com');

---
CREATE TABLE "BridgeThatGap".interventions (
	interv_id SERIAL PRIMARY KEY,
	"option" varchar(100) NOT NULL
);
insert into interventions values (DEFAULT,'Workshop');
insert into interventions values (DEFAULT,'Speaker');
insert into interventions values (DEFAULT,'Social Justice Board Game');
insert into interventions values (DEFAULT,'DVD');
insert into interventions values (DEFAULT,'One-on-one sessions');

---
CREATE TABLE "BridgeThatGap".consultations (
	consult_id SERIAL PRIMARY KEY,
	client_id INTEGER NOT NULL,
	emp_id INTEGER NOT NULL,
	interv_id INTEGER NOT NULL,
	start_date date NULL,
	end_date date NULL,
	status varchar(100) NOT NULL,
	"comments" varchar(1000) NULL,
	goal varchar(100) NULL,	
	CONSTRAINT fk_client_id FOREIGN KEY (client_id) REFERENCES clients (client_id),
	CONSTRAINT fk_emp_id FOREIGN KEY (emp_id) REFERENCES employees (emp_id),
	CONSTRAINT fk_interv_id FOREIGN KEY (interv_id) REFERENCES interventions (interv_id)	
);

----------------
insert into consultations (consult_id, client_id, emp_id, interv_id, start_date, status, goal)
values (DEFAULT, 1, 1, 3,'02/19/2021','Begin Consultation', 'Gender diversity');

insert into consultations (consult_id, client_id, emp_id, interv_id, start_date, status, goal)
values (DEFAULT, 1, 2, 1,'02/26/2021','Ongoing, waiting on upper management', 'Racial gaps');