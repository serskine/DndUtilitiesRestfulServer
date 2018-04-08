-------------------------------------------------------------------------------
-- com.bns.et.search.app.data.jpa.entity.TopicEntity
-------------------------------------------------------------------------------
CREATE TABLE "topic" (
  "id"           NUMBER(38, 0)               NOT NULL PRIMARY KEY,
  "uid"          VARCHAR(256)                NOT NULL UNIQUE,
  "last_updated" TIMESTAMP(2) WITH TIME ZONE NOT NULL,
  "created"      TIMESTAMP(2) WITH TIME ZONE NOT NULL,
  "name"         VARCHAR(256),
  "clientUid"    VARCHAR(256)
);

CREATE SEQUENCE "topic_sg"
  MINVALUE 1
  START WITH 1
  INCREMENT BY 50
  NOCACHE;

-------------------------------------------------------------------------------
-- com.bns.et.search.app.data.jpa.entity.SubscriptionEntity
-------------------------------------------------------------------------------
CREATE TABLE "subscription" (
  "id"           NUMBER(38, 0)               NOT NULL PRIMARY KEY,
  "uid"          VARCHAR(256)                NOT NULL UNIQUE,
  "last_updated" TIMESTAMP(2) WITH TIME ZONE NOT NULL,
  "created"      TIMESTAMP(2) WITH TIME ZONE NOT NULL,
  "topicUid"     VARCHAR(256),
  "clientUrl"    VARCHAR(256)
);

CREATE SEQUENCE "subscription_sg"
  MINVALUE 1
  START WITH 1
  INCREMENT BY 50
  NOCACHE;