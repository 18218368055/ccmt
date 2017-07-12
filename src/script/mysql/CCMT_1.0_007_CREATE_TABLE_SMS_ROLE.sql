drop table if exists sms_role;

/*==============================================================*/
/* Table: sms_role                                              */
/*==============================================================*/
create table sms_role
(
   id                   bigint(20) not null auto_increment comment '自增ID',
   name                 varchar(50) not null comment '名称',
   parent_id            bigint(20) not null comment '父ID',
   remark               varchar(500) comment '备注',
   status               char(1) not null default '0' comment '状态，0：禁用；1：启用',
   creator              varchar(50) comment '创建人',
   create_time          datetime comment '创建时间',
   modifier             varchar(50) comment '修改人',
   modify_time          datetime comment '修改时间',
   primary key (id)
);

alter table sms_role comment '角色表';

/*==============================================================*/
/* Index: parent_id_index                                       */
/*==============================================================*/
create index parent_id_index on sms_role
(
   parent_id
);