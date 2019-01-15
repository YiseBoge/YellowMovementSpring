
    create table posts (
       post_id bigint not null auto_increment,
        category varchar(255) not null,
        content varchar(255) not null,
        date_string varchar(255),
        image varchar(50) default NULL,
        posted_date datetime,
        title varchar(255) not null,
        primary key (post_id)
    ) engine=InnoDB

    create table users (
       user_id bigint not null auto_increment,
        date_string varchar(255),
        email varchar(255),
        joining_date datetime,
        name varchar(255),
        password varchar(255),
        role varchar(10) default 'USER',
        sex varchar(255),
        primary key (user_id)
    ) engine=InnoDB
    create table blogs (
       blog_id bigint not null auto_increment,
        blogged_date datetime,
        content varchar(255) not null,
        date_string varchar(255),
        image varchar(50) default NULL,
        title varchar(255) not null,
        blogger_user_id bigint,
        primary key (blog_id)
    ) engine=InnoDB

    create table posts (
       post_id bigint not null auto_increment,
        category varchar(255) not null,
        content varchar(255) not null,
        date_string varchar(255),
        image varchar(50) default NULL,
        posted_date datetime,
        title varchar(255) not null,
        primary key (post_id)
    ) engine=InnoDB

    create table users (
       user_id bigint not null auto_increment,
        date_string varchar(255),
        email varchar(255),
        joining_date datetime,
        name varchar(255),
        password varchar(255),
        role varchar(10) default 'USER',
        sex varchar(255),
        primary key (user_id)
    ) engine=InnoDB

    alter table users 
       add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)

    alter table blogs 
       add constraint FK9b8vkbu11uvcdjguqmnuy3ox9 
       foreign key (blogger_user_id) 
       references users (user_id)
