create table if not exists logs
(
    id
    integer
    primary
    key
    autoincrement,
    log
    text,
    createdAt
    text
    default
    current_timestamp
)