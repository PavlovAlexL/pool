--liquibase formatted sql
--changeset pool_create_sql:1

CREATE TABLE IF NOT EXISTS pool (
  id          SERIAL PRIMARY KEY,
  version     INTEGER NOT NULL DEFAULT 1,
  pool_name   VARCHAR(50) NOT NULL,
  begin_date  DATE NOT NULL DEFAULT CURRENT_DATE,
  end_date    DATE,
  is_Active   BOOLEAN NOT NULL
);
--rollback drop table pool;
