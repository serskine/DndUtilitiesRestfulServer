-------------------------------------------------------------------------------
-- com.bns.et.search.app.data.jpa.entity.XpThresholdEntity
-------------------------------------------------------------------------------
CREATE TABLE "xp_threshold" (
  "id"           NUMBER(38, 0)               NOT NULL PRIMARY KEY,
  "uid"          VARCHAR(256)                NOT NULL UNIQUE,
  "last_updated" TIMESTAMP(2) WITH TIME ZONE NOT NULL,
  "created"      TIMESTAMP(2) WITH TIME ZONE NOT NULL,
  "level"        NUMBER(38, 0)               NOT NULL UNIQUE,
  "easy"         NUMBER(38, 0)               NOT NULL,
  "moderate"     NUMBER(38, 0)               NOT NULL,
  "hard"         NUMBER(38, 0)               NOT NULL,
  "deadly"       NUMBER(38, 0)               NOT NULL
);

CREATE SEQUENCE "xp_threshold_sg"
  MINVALUE 1
  START WITH 1
  INCREMENT BY 50
  NOCACHE;
