-------------------------------------------------------------------------------
-- com.bns.et.search.app.data.jpa.entity.UserEntity
-------------------------------------------------------------------------------
CREATE TABLE "user" (
  "id"           NUMBER(38, 0)               NOT NULL PRIMARY KEY,
  "uid"          VARCHAR(256)                NOT NULL UNIQUE,
  "last_updated" TIMESTAMP(2) WITH TIME ZONE NOT NULL,
  "created"      TIMESTAMP(2) WITH TIME ZONE NOT NULL,
  "name"         VARCHAR(256)
);

CREATE SEQUENCE "user_sg"
  MINVALUE 1
  START WITH 1
  INCREMENT BY 50
  NOCACHE;
