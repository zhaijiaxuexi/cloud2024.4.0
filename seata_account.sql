create table t_account
(
    id      bigint auto_increment comment 'id'
        primary key,
    user_id bigint            null comment '用户id',
    total   decimal           null comment '总额度',
    used    decimal           null comment '已用账户余额',
    residue decimal default 0 null comment '剩余可用额度'
)
    charset = utf8mb3;

create table undo_log
(
    branch_id     bigint       not null comment 'branch transaction id',
    xid           varchar(128) not null comment 'global transaction id',
    context       varchar(128) not null comment 'undo_log context,such as serialization',
    rollback_info longblob     not null comment 'rollback info',
    log_status    int          not null comment '0:normal,1:defense',
    log_created   datetime(6)  not null comment 'create datetime',
    log_modified  datetime(6)  not null comment 'modify datetime',
    constraint ux_undo_log
        unique (xid, branch_id)
);


