drop table if exists sms_user_role;

/*==============================================================*/
/* Table: sms_user_role                                         */
/*==============================================================*/
create table sms_user_role
(
   user_id              bigint(20) not null comment '用户ID',
   role_id              bigint(20) not null comment '角色ID'
);

alter table sms_user_role comment '用户角色关系表';