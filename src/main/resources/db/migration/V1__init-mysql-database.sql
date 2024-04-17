
    drop table if exists beer;

    drop table if exists customer;

    create table beer (
        beer_style tinyint not null check (beer_style between 0 and 9),
        price decimal(38,2) not null,
        quantity_in_hand integer,
        version integer,
        create_time datetime(6),
        update_time datetime(6),
        id varchar(36) not null,
        beer_name varchar(40) not null,
        ups varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table customer (
        version integer,
        create_date datetime(6),
        update_date datetime(6),
        id varchar(36) not null,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB;
