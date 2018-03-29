-------------------------------------------------------------------------------
-- com.bns.et.search.app.data.jpa.entity.CrEntity
-------------------------------------------------------------------------------
CREATE TABLE "cr" (
  "id"           NUMBER(38, 0)               NOT NULL PRIMARY KEY,
  "last_updated" TIMESTAMP(2) WITH TIME ZONE NOT NULL,
  "created"      TIMESTAMP(2) WITH TIME ZONE NOT NULL,
  "cr"           NUMBER(36, 2)               NOT NULL UNIQUE,
  "xp"           NUMBER(38, 0)               NOT NULL UNIQUE
);

CREATE SEQUENCE "xp_threshold_sg"
  MINVALUE 1
  START WITH 1
  INCREMENT BY 50
  NOCACHE;