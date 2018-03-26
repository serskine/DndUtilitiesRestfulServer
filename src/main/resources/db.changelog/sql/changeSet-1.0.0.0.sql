-------------------------------------------------------------------------------
-- com.bns.et.search.app.data.jpa.entity.EncounterEntity
-------------------------------------------------------------------------------
CREATE TABLE "encounter" (
  "id"           NUMBER(38, 0)               NOT NULL PRIMARY KEY,
  "last_updated" TIMESTAMP(2) WITH TIME ZONE NOT NULL,
  "created"      TIMESTAMP(2) WITH TIME ZONE NOT NULL,
  "name"         VARCHAR(256)                NOT NULL
);

CREATE SEQUENCE "category_sg"
MINVALUE 1
START WITH 1
INCREMENT BY 50
NOCACHE;

-------------------------------------------------------------------------------
-- com.bns.et.search.app.data.jpa.entity.EncounterEntity
-------------------------------------------------------------------------------
CREATE TABLE "ally" (
  "id"           NUMBER(38, 0)               NOT NULL PRIMARY KEY,
  "last_updated" TIMESTAMP(2) WITH TIME ZONE NOT NULL,
  "created"      TIMESTAMP(2) WITH TIME ZONE NOT NULL,
  "level"        INTEGER                     NOT NULL,
  "encounter"    NUMBER(38, 0) REFERENCES "encounter" ("id")
);

CREATE SEQUENCE "ally_sg"
MINVALUE 1
START WITH 1
INCREMENT BY 50
NOCACHE;


-------------------------------------------------------------------------------
-- com.bns.et.search.app.data.jpa.entity.EncounterEntity
-------------------------------------------------------------------------------
CREATE TABLE "enemy" (
  "id"           NUMBER(36, 2)               NOT NULL PRIMARY KEY,
  "last_updated" TIMESTAMP(2) WITH TIME ZONE NOT NULL,
  "created"      TIMESTAMP(2) WITH TIME ZONE NOT NULL,
  "level"        INTEGER                     NOT NULL,
  "encounter"    NUMBER(38, 0) REFERENCES "encounter" ("id")
);

CREATE SEQUENCE "enemy_sg"
MINVALUE 1
START WITH 1
INCREMENT BY 50
NOCACHE;
