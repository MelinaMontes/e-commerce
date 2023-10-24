-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS "public"."users";
CREATE TABLE "public"."users" (
  "id" int8 NOT NULL DEFAULT nextval('users_id_seq'::regclass),
  "is_vip" bool NOT NULL,
  "last_name" varchar(255) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "public"."users" OWNER TO "postgres";

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO "public"."users" ("id", "is_vip", "last_name", "name") VALUES (1, 't', 'Gomez', 'Lucia');
INSERT INTO "public"."users" ("id", "is_vip", "last_name", "name") VALUES (2, 'f', 'Gutierrez', 'Marcos');
INSERT INTO "public"."users" ("id", "is_vip", "last_name", "name") VALUES (3, 'f', 'Podesta', 'Paula');
INSERT INTO "public"."users" ("id", "is_vip", "last_name", "name") VALUES (4, 't', 'Filippini', 'Juan Martin');
COMMIT;

-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE "public"."users" ADD CONSTRAINT "users_pkey" PRIMARY KEY ("id");


