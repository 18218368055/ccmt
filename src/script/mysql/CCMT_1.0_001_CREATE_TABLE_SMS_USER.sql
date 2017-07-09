drop table if exists sms_user;

/*==============================================================*/
/* Table: sms_user                                              */
/*==============================================================*/
create table sms_user
(
   id                   bigint(20) not null auto_increment comment '自增ID',
   username             varchar(50) not null comment '用户名',
   password             varchar(128) not null comment '密码',
   name                 varchar(50) not null comment '名称',
   sex                  char(1) default '0' comment '性别，0：男；1：女',
   birthday             date comment '生日',
   creator              varchar(50) comment '创建人',
   create_time          datetime comment '创建时间',
   modifier             varchar(50) comment '修改人',
   modify_time          datetime comment '修改时间',
   status               char(1) not null default '0' comment '状态，0：禁用；1：启用',
   primary key (id)
);

alter table sms_user comment '用户表';