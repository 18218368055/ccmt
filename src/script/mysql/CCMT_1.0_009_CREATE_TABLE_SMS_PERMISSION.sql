drop table if exists sms_permission;

/*==============================================================*/
/* Table: sms_permission                                        */
/*==============================================================*/
create table sms_permission
(
   id                   bigint(20) not null auto_increment comment '自增ID',
   name                 varchar(50) not null comment '名称',
   code                 varchar(200) not null comment '权限代码',
   parent_id            bigint(20) not null comment '父ID',
   url                  varchar(500) comment 'url',
   remark               varchar(500) comment '备注',
   status               char(1) not null default '0' comment '状态，0：禁用；1：启用',
   creator              varchar(50) comment '创建人',
   create_time          datetime comment '创建时间',
   modifier             varchar(50) comment '修改人',
   modify_time          datetime comment '修改时间',
   primary key (id)
);

alter table sms_permission comment '权限表';

/*==============================================================*/
/* Index: parent_id_index                                       */
/*==============================================================*/
create index parent_id_index on sms_permission
(
   parent_id
);

/*==============================================================*/
/* Index: code_unique_index                                     */
/*==============================================================*/
create unique index code_unique_index on sms_permission
(
   code
);