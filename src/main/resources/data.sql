-- ----------------------------
-- Table structure for users
-- ----------------------------
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
INSERT INTO "public"."users" ("id", "is_vip", "last_name", "name") VALUES (1, 't', 'Gomez', 'Lucia');
INSERT INTO "public"."users" ("id", "is_vip", "last_name", "name") VALUES (2, 'f', 'Gutierrez', 'Marcos');
INSERT INTO "public"."users" ("id", "is_vip", "last_name", "name") VALUES (3, 'f', 'Podesta', 'Paula');
INSERT INTO "public"."users" ("id", "is_vip", "last_name", "name") VALUES (4, 't', 'Filippini', 'Juan Martin');

-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE "public"."users" ADD CONSTRAINT "users_pkey" PRIMARY KEY ("id");

CREATE TABLE "public"."products" (
  "product_id" int4 NOT NULL DEFAULT nextval('products_product_id_seq'::regclass),
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "price" numeric(19,2),
  "unit_price" numeric(19,2)
)
;
ALTER TABLE "public"."products" OWNER TO "postgres";

-- ----------------------------
-- Records of products
-- ----------------------------

INSERT INTO "public"."products" ("product_id", "description", "name", "unit_price") VALUES (1, 'Freidora multiuso', 'AirFrier', 3000.00);
INSERT INTO "public"."products" ("product_id", "description", "name", "unit_price") VALUES (2, 'Aspiradora robot 3000', 'Robotina',5000.00);
INSERT INTO "public"."products" ("product_id", "description", "name", "unit_price") VALUES (3, 'Tv Fullcanal', 'Smart TV pro', 10000.00);
INSERT INTO "public"."products" ("product_id", "description", "name", "unit_price") VALUES (4, 'Super celular', 'Telefono inteligente',8000.00);

-- ----------------------------
-- Primary Key structure for table products
-- ----------------------------
ALTER TABLE "public"."products" ADD CONSTRAINT "products_pkey" PRIMARY KEY ("product_id");


