CREATE TABLE "Hesap" (
 "hesapNo" SERIAL,
 "kullaniciAdi" VARCHAR(15) NOT NULL,
 "sifre" VARCHAR(20) NOT NULL,
 "ad" VARCHAR(20) NOT NULL,
 "soyad" VARCHAR(20) NOT NULL,
 "cinsiyet" VARCHAR(5) NOT NULL,
 CONSTRAINT "hesapPK" PRIMARY KEY("hesapNo"),
 CONSTRAINT "hesapAD" UNIQUE("kullaniciAdi")
);

CREATE TABLE "Sogutucu" (
 "sogutucuNo" SERIAL,
 "hesapNo" INTEGER NOT NULL,
 "sogutucuDurumu" InTEGER NOT NULL,
 "sicaklik" REAL NOT NULL,
 CONSTRAINT "sogutucuPK" PRIMARY KEY("sogutucuNo"),
 CONSTRAINT "sogutucuFK" FOREIGN KEY("hesapNo") REFERENCES "Hesap"("hesapNo")
);


INSERT INTO "Hesap"
("kullaniciAdi", "sifre","ad","soyad","cinsiyet")
VALUES
('purple', 'jh07','Mina','Esin','Kadin');

INSERT INTO "Hesap"
("kullaniciAdi", "sifre","ad","soyad","cinsiyet")
VALUES
('red', 'xsa568','Tuncay','Demir','Erkek');

INSERT INTO "Hesap"
("kullaniciAdi", "sifre","ad","soyad","cinsiyet")
VALUES
('blue', 'asd12','Melissa','Uzun','Kadin');

INSERT INTO "Hesap"
("kullaniciAdi", "sifre","ad","soyad","cinsiyet")
VALUES
('black', '1234','Emre','Kosan','Erkek');

INSERT INTO "Hesap"
("kullaniciAdi", "sifre","ad","soyad","cinsiyet")
VALUES
('yellow', '546','Cenk','Okta','Erkek');

INSERT INTO "Hesap"
("kullaniciAdi", "sifre","ad","soyad","cinsiyet")
VALUES
('white', 'h1564','Selin','Raz','Kadin');



INSERT INTO "Sogutucu"
("hesapNo","sogutucuDurumu", "sicaklik")
VALUES
('1','1','21');

INSERT INTO "Sogutucu"
("hesapNo","sogutucuDurumu", "sicaklik")
VALUES
('2','0','23.4');

INSERT INTO "Sogutucu"
("hesapNo","sogutucuDurumu", "sicaklik")
VALUES
('3','1','22.2');

INSERT INTO "Sogutucu"
("hesapNo","sogutucuDurumu", "sicaklik")
VALUES
('4','1','20');

INSERT INTO "Sogutucu"
("hesapNo","sogutucuDurumu", "sicaklik")
VALUES
('5','0','24.9');

INSERT INTO "Sogutucu"
("hesapNo","sogutucuDurumu", "sicaklik")
VALUES
('6','0','21.8');
