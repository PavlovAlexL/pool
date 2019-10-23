--liquibase formatted sql
--changeset question_create_sql:1

CREATE TABLE IF NOT EXISTS question (
  id          SERIAL PRIMARY KEY,
  version     INTEGER NOT NULL DEFAULT 1,
  pool_id     INTEGER NOT NULL REFERENCES pool(id),
  text        VARCHAR(50) NOT NULL,
  order_id    INTEGER NOT NULL
);
--rollback drop table question;
