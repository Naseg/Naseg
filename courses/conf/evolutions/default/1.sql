# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table countries (
  country_ID                integer auto_increment not null,
  name                      varchar(255),
  region                    varchar(255),
  citizenship               varchar(255),
  deleted                   tinyint(1) default 0,
  constraint pk_countries primary key (country_ID))
;

create table courses (
  course_ID                 integer auto_increment not null,
  notes                     longtext,
  actual_start_date         datetime,
  institution               varchar(255),
  place                     varchar(255),
  credits                   integer,
  course_name               varchar(255),
  academic_year             integer,
  is_in_manifesto           tinyint(1) default 0,
  is_by_UNITN               tinyint(1) default 0,
  is_paid                   tinyint(1) default 0,
  budgeted_cost             integer,
  actual_cost               integer,
  planned_course_period     varchar(255),
  are_all_marks_defined     tinyint(1) default 0,
  url                       varchar(255),
  is_payment_completed      tinyint(1) default 0,
  deleted                   tinyint(1) default 0,
  professor                 integer,
  constraint pk_courses primary key (course_ID))
;

create table courses_enrollments (
  enrollment_ID             integer auto_increment not null,
  qualification             varchar(255),
  is_finished               tinyint(1) default 0,
  credits                   integer,
  enrolled_at               datetime,
  updated_at                datetime,
  student                   integer not null,
  course                    integer not null,
  constraint pk_courses_enrollments primary key (enrollment_ID))
;

create table funding_institutions (
  funding_institution_ID    integer auto_increment not null,
  name                      varchar(255),
  deleted                   tinyint(1) default 0,
  type                      varchar(255),
  constraint pk_funding_institutions primary key (funding_institution_ID))
;

create table students (
  user_ID                   integer auto_increment not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  full_name                 varchar(255),
  phd_cycle                 varchar(255),
  is_suspended              tinyint(1) default 0,
  course_year               integer,
  admitted_conditionally    tinyint(1) default 0,
  legal_residence           varchar(255),
  current_domicile          varchar(255),
  date_of_birth             datetime,
  place_of_birth            varchar(255),
  office_phone              varchar(255),
  mobile_phone              varchar(255),
  office_working_place      varchar(255),
  locker_number             varchar(255),
  phd_scholarship           tinyint(1) default 0,
  scholarship_type          varchar(255),
  yearly_fee_to_center      integer,
  yearly_fee_to_school      integer,
  has_pc_rights             tinyint(1) default 0,
  pre_doctoral_scholarship  varchar(255),
  months_predoc_scholarship integer,
  year_extension_scholarship varchar(255),
  months                    integer,
  personal_funds_available  integer,
  is_graduated              tinyint(1) default 0,
  graduation_date           datetime,
  commitee_members          varchar(255),
  email                     varchar(255),
  deleted                   tinyint(1) default 0,
  Italian_Taxpayer_Code     integer,
  user                      integer not null,
  university_of_provenance  integer not null,
  university                integer not null,
  funding_institution       integer not null,
  country_of_provenance     integer not null,
  citizenship               integer not null,
  funds_owner               integer not null,
  tutor                     integer not null,
  current_advisor           integer not null,
  constraint pk_students primary key (user_ID))
;

create table supervisors (
  supervisor_ID             integer auto_increment not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  can_be_advisor            tinyint(1) default 0,
  is_active                 tinyint(1) default 0,
  is_internal               tinyint(1) default 0,
  email                     varchar(255),
  deleted                   tinyint(1) default 0,
  user                      integer not null,
  constraint pk_supervisors primary key (supervisor_ID))
;

create table trips (
  trip_ID                   integer auto_increment not null,
  academic_year_id          integer,
  Date_of_request           integer,
  Planned_start_date        datetime,
  Planned_Reason_for_Travel varchar(255),
  status                    varchar(255),
  Planned_end_date          datetime,
  Planned_destination       varchar(255),
  Planned_means_of_transport varchar(255),
  is_stopover_requested     tinyint(1) default 0,
  Reason_for_extraordinary_transport varchar(255),
  Reason_for_stopover       varchar(255),
  type_of_transportation    varchar(255),
  is_approved               tinyint(1) default 0,
  are_personal_funds_used   tinyint(1) default 0,
  personal_funds_amount     integer,
  alternative_fund_1_name   varchar(255),
  alternative_fund_1_manager integer,
  alternative_fund_1_amount integer,
  alternative_fund_2_name   varchar(255),
  alternative_fund_2_amount integer,
  alternative_fund_2_manager integer,
  has_advisor_approved      tinyint(1) default 0,
  foreseen_meals_cost       float,
  foreseen_lodging_cost     float,
  foreseen_transportation_cost float,
  expenses_sustained_before_trip float,
  is_advance_payment_requested tinyint(1) default 0,
  actual_begin_date_time    datetime,
  actual_end_date_time      datetime,
  departure_border_cross_datetime datetime,
  arrival_border_cross_datetime datetime,
  actual_destination        varchar(255),
  current_address           varchar(255),
  advance_payment_received  float,
  requested_payment_method  varchar(255),
  self_declaration_missing_recepits longtext,
  other_declarations        longtext,
  Travel_tickets            longtext,
  personal_veichle_KM_travelled integer,
  personal_veichle_colleagues varchar(255),
  highway_toll_fees         float,
  total_transport_expenses  float,
  total_lodging_expenses    float,
  number_of_nights          integer,
  num_lodging_receipts      integer,
  num_meals_invoices        integer,
  num_days_of_meals         integer,
  total_meal_expenses       float,
  registration_fee          float,
  other_costs_amount        float,
  other_costs_description   integer,
  total_expenses            float,
  created_at                datetime,
  updated_at                datetime,
  reimb_transport_expenses  float,
  date_reim_request_submitted datetime,
  reimb_lodging_expenses    float,
  reimb_extra_costs         float,
  deleted                   tinyint(1) default 0,
  has_coord_approved        tinyint(1) default 0,
  has_fund_1_mgr_approved   tinyint(1) default 0,
  has_fund_2_mgr_approved   tinyint(1) default 0,
  student                   integer not null,
  constraint pk_trips primary key (trip_ID))
;

create table universities (
  university_ID             integer auto_increment not null,
  name_university           varchar(255),
  location                  varchar(255),
  deleted                   tinyint(1) default 0,
  country                   integer,
  constraint pk_universities primary key (university_ID))
;

create table users_credentials (
  user_credential_ID        integer auto_increment not null,
  user_name                 varchar(255),
  password                  varchar(255),
  user_rol                  integer not null,
  constraint pk_users_credentials primary key (user_credential_ID))
;

create table users_roles (
  user_rol_ID               integer auto_increment not null,
  role                      varchar(255),
  deleted                   tinyint(1) default 0,
  constraint pk_users_roles primary key (user_rol_ID))
;

alter table courses add constraint fk_courses_professor_1 foreign key (professor) references supervisors (supervisor_ID) on delete restrict on update restrict;
create index ix_courses_professor_1 on courses (professor);
alter table courses_enrollments add constraint fk_courses_enrollments_student_2 foreign key (student) references students (user_ID) on delete restrict on update restrict;
create index ix_courses_enrollments_student_2 on courses_enrollments (student);
alter table courses_enrollments add constraint fk_courses_enrollments_course_3 foreign key (course) references courses (course_ID) on delete restrict on update restrict;
create index ix_courses_enrollments_course_3 on courses_enrollments (course);
alter table students add constraint fk_students_user_4 foreign key (user) references users_credentials (user_credential_ID) on delete restrict on update restrict;
create index ix_students_user_4 on students (user);
alter table students add constraint fk_students_universityOfProven_5 foreign key (university_of_provenance) references universities (university_ID) on delete restrict on update restrict;
create index ix_students_universityOfProven_5 on students (university_of_provenance);
alter table students add constraint fk_students_university_6 foreign key (university) references universities (university_ID) on delete restrict on update restrict;
create index ix_students_university_6 on students (university);
alter table students add constraint fk_students_fundingInstitution_7 foreign key (funding_institution) references funding_institutions (funding_institution_ID) on delete restrict on update restrict;
create index ix_students_fundingInstitution_7 on students (funding_institution);
alter table students add constraint fk_students_countryOfProvenanc_8 foreign key (country_of_provenance) references countries (country_ID) on delete restrict on update restrict;
create index ix_students_countryOfProvenanc_8 on students (country_of_provenance);
alter table students add constraint fk_students_citizenship_9 foreign key (citizenship) references countries (country_ID) on delete restrict on update restrict;
create index ix_students_citizenship_9 on students (citizenship);
alter table students add constraint fk_students_fundsOwner_10 foreign key (funds_owner) references supervisors (supervisor_ID) on delete restrict on update restrict;
create index ix_students_fundsOwner_10 on students (funds_owner);
alter table students add constraint fk_students_tutor_11 foreign key (tutor) references supervisors (supervisor_ID) on delete restrict on update restrict;
create index ix_students_tutor_11 on students (tutor);
alter table students add constraint fk_students_currentAdvisor_12 foreign key (current_advisor) references supervisors (supervisor_ID) on delete restrict on update restrict;
create index ix_students_currentAdvisor_12 on students (current_advisor);
alter table supervisors add constraint fk_supervisors_user_13 foreign key (user) references users_credentials (user_credential_ID) on delete restrict on update restrict;
create index ix_supervisors_user_13 on supervisors (user);
alter table trips add constraint fk_trips_student_14 foreign key (student) references students (user_ID) on delete restrict on update restrict;
create index ix_trips_student_14 on trips (student);
alter table universities add constraint fk_universities_country_15 foreign key (country) references countries (country_ID) on delete restrict on update restrict;
create index ix_universities_country_15 on universities (country);
alter table users_credentials add constraint fk_users_credentials_userRol_16 foreign key (user_rol) references users_roles (user_rol_ID) on delete restrict on update restrict;
create index ix_users_credentials_userRol_16 on users_credentials (user_rol);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table countries;

drop table courses;

drop table courses_enrollments;

drop table funding_institutions;

drop table students;

drop table supervisors;

drop table trips;

drop table universities;

drop table users_credentials;

drop table users_roles;

SET FOREIGN_KEY_CHECKS=1;

