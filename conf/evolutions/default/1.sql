# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table master (
  master_id                     serial not null,
  master_name                   varchar(255),
  constraint pk_master primary key (master_id)
);

create table pet (
  pet_id                        serial not null,
  pet_name                      varchar(255),
  master_master_id              integer,
  constraint pk_pet primary key (pet_id)
);

create table pet_role (
  pet_pet_id                    integer not null,
  role_role_name                varchar(255) not null,
  constraint pk_pet_role primary key (pet_pet_id,role_role_name)
);

create table role (
  role_name                     varchar(255) not null,
  is_fixed                      boolean default false not null,
  constraint pk_role primary key (role_name)
);

create index ix_pet_master_master_id on pet (master_master_id);
alter table pet add constraint fk_pet_master_master_id foreign key (master_master_id) references master (master_id) on delete restrict on update restrict;

create index ix_pet_role_pet on pet_role (pet_pet_id);
alter table pet_role add constraint fk_pet_role_pet foreign key (pet_pet_id) references pet (pet_id) on delete restrict on update restrict;

create index ix_pet_role_role on pet_role (role_role_name);
alter table pet_role add constraint fk_pet_role_role foreign key (role_role_name) references role (role_name) on delete restrict on update restrict;


# --- !Downs

alter table if exists pet drop constraint if exists fk_pet_master_master_id;
drop index if exists ix_pet_master_master_id;

alter table if exists pet_role drop constraint if exists fk_pet_role_pet;
drop index if exists ix_pet_role_pet;

alter table if exists pet_role drop constraint if exists fk_pet_role_role;
drop index if exists ix_pet_role_role;

drop table if exists master cascade;

drop table if exists pet cascade;

drop table if exists pet_role cascade;

drop table if exists role cascade;

