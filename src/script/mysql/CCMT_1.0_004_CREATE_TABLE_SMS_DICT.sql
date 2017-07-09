drop table if exists sms_dict;

/*==============================================================*/
/* Table: sms_dict                                              */
/*==============================================================*/
create table sms_dict
(
   id                   bigint(20) not null auto_increment comment '自增ID',
   code                 varchar(50) not null comment '字典代码',
   name                 varchar(100) not null comment '字典名称',
   type_code            varchar(50) not null comment '字典类型代码',
   status               char(1) not null comment '状态，0：禁用，1：启用',
   sort                 int(3) comment '排序',
   remark               varchar(500) comment '备注',
   creator              varchar(50) comment '创建人',
   create_time          datetime comment '创建时间',
   modifier             varchar(50) comment '修改人',
   modify_time          datetime comment '修改时间',
   primary key (id)
);

alter table sms_dict comment '数据字典表';

/*==============================================================*/
/* Index: code_index                                            */
/*==============================================================*/
create index code_index on sms_dict
(
   code
);

/*==============================================================*/
/* Index: type_code_index                                       */
/*==============================================================*/
create index type_code_index on sms_dict
(
   type_code
);
