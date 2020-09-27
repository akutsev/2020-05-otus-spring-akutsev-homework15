drop table if exists cities;
drop table if exists attractions;

create table cities (
  id identity not null,
  name varchar(250) not null,
  is_on_seaside boolean not null,
  primary key (id)
);

create table attractions (
  id identity not null,
  name varchar(250) not null,
  city_id bigint not null,
  is_available_for_children boolean not null,
  primary key (id)
);