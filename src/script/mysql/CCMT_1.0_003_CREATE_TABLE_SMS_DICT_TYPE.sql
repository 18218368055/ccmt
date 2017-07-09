drop table if exists sms_dict_type;

/*==============================================================*/
/* Table: sms_dict_type                                         */
/*==============================================================*/
create table sms_dict_type
(
   id                   bigint(20) not null auto_increment comment '自增ID',
   type_code            varchar(50) not null comment '字典类型代码',
   type_name            varchar(100) not null comment '字典类型名称',
   status               char(1) not null default '0' comment '状态，0：禁用；1：启用',
   remark               varchar(500) comment '备注',
   creator              varchar(50) comment '创建人',
   create_time          datetime comment '创建时间',
   modifier             varchar(50) comment '修改人',
   modify_time          datetime comment '修改时间',
   primary key (id)
);

alter table sms_dict_type comment '数据字典类型表';

/*==============================================================*/
/* Index: type_code_unique_index                                */
/*==============================================================*/
create unique index type_code_unique_index on sms_dict_type
(
   type_code
);
