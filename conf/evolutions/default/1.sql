# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table event (
  event_id                      bigint auto_increment not null,
  event_name                    varchar(255) not null,
  event_desc                    varchar(255) not null,
  event_date_time               datetime(6) not null,
  constraint pk_event primary key (event_id)
);

create table event_details (
  event_details_id              bigint auto_increment not null,
  register_time                 datetime(6) not null,
  time                          varchar(255) not null,
  qr_id                         varchar(255) not null,
  event_event_id                bigint not null,
  user_user_id                  bigint not null,
  constraint pk_event_details primary key (event_details_id)
);

create table qr (
  uuid                          varchar(255) not null,
  browser_tok                   varchar(255),
  constraint pk_qr primary key (uuid)
);

create table user (
  user_id                       bigint auto_increment not null,
  f_name                        varchar(255) not null,
  l_name                        varchar(255) not null,
  e_mail                        varchar(255) not null,
  password                      varchar(255) not null,
  auth_token                    varchar(255),
  constraint pk_user primary key (user_id)
);

alter table event_details add constraint fk_event_details_event_event_id foreign key (event_event_id) references event (event_id) on delete restrict on update restrict;
create index ix_event_details_event_event_id on event_details (event_event_id);

alter table event_details add constraint fk_event_details_user_user_id foreign key (user_user_id) references user (user_id) on delete restrict on update restrict;
create index ix_event_details_user_user_id on event_details (user_user_id);


# --- !Downs

alter table event_details drop foreign key fk_event_details_event_event_id;
drop index ix_event_details_event_event_id on event_details;

alter table event_details drop foreign key fk_event_details_user_user_id;
drop index ix_event_details_user_user_id on event_details;

drop table if exists event;

drop table if exists event_details;

drop table if exists qr;

drop table if exists user;

