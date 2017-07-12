drop table if exists sms_role_permission;

/*==============================================================*/
/* Table: sms_role_permission                                   */
/*==============================================================*/
create table sms_role_permission
(
   role_id              bigint(20) not null comment '角色ID',
   permission_id        bigint(20) not null comment '权限ID'
);

alter table sms_role_permission comment '角色权限关系表';
