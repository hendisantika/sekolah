# sekolah

MYSCHOOL adalah source code opensource yang dibangun mengunakan Spring Boot 3.3.1 version yang terinspirasi dari MSCHOOL
yang dibangun menggunakan Codeigniter 3.1.9 dan Bootstrap 4.0.

MYSCHOOL merupakan pengembangan dari project M-Sekolah. Dengan kata lain, MSCHOOL adalah versi 2.0 dari M-Sekolah dengan Java Spring Boot.

MYSCHOOL merupakan project open source untuk website profile sekolah SD, MI, SMP MTs, MA ataupun SMA dan sederajat untuk menunjang transparasi informasi dan promosi sekolah.

Backend dari Source Code ini dibangun menggunakan template AdminLTE, yaitu template yang sangat umum bagi developer web saat ini.

Selain itu, source code ini juga menggunakan Toast Message untuk menampilkan pesan pada bagian Backend.

Hal itulah yang membuat source code ini menjadi sangat menarik.

Source Code ini berjalan dengan baik di PaaS (Platform as as Service) seperti Heroku ataupun d VPS (Virtual Private
Server) seperti Digital Ocean (DO). Tinggal upload dan sedikit konfigurasi, semuanya bejalan dengan baik.

Bagaimana mengonline-kannya?

- Order Domain dan Hosting

- Upload Source Code myschool ke hosting

- Buat database di hosting (di sini saya menggunakan PostgreSQL)

Jika Anda mengalami kesulitan saat mengonlinekannya, Anda dapat meminta bantuan pihak hosting untuk membantu Anda mengonlinekannya.

Modul dan Fitur:

1. Dashboard (Unique Visitors Counter)

2. Manajemen artikel

3. Manajemen data siswa/santri

4. Manajemen data guru/asatidz

5. Manajemen data user

6. Manajemen agenda kegiatan

7. Manajemen pengumuman

8. Manajemen file materi pembelajaran

9. Manajemen data guru

10. Manajemen gallery photo

11. Manajemen pesan masuk (inbox)

12. Manajemen komentar

13. Sosial media share artikel

14. Nested Comments

15. SEO URL Friendly

## Cara Membuat Database

1. Create user untuk connect ke database

```
createuser -P adminSekolah
```

2. Create database untuk user tersebut

```
createdb -OadminSekolah sekolah
```

Cara install uuid-ossp module, anda harus CREATE EXTENSION statement seperti berikut ini:

```
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
```

3. Konfigurasi database

```
spring.datasource.url=jdbc:postgresql://localhost:5432/sekolah
spring.datasource.username=adminSekolah
spring.datasource.password=passwordSekolah
```

### Cara menjalankan Postgres Database via Docker

```
docker run --rm \
--name=sekolah \
-e POSTGRES_DB=sekolah \
-e POSTGRES_USER=adminSekolah \
-e POSTGRES_PASSWORD=passwordSekolah \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-v "$PWD/sekolah-data:/var/lib/postgresql/data" \
-p 5432:5432 \
postgres:15
```

### Cara konek ke Postgres Database via Docker

```shell
psql -h localhost -p 5432 -U adminSekolah -W sekolah

docker exec -it sekolah psql -U adminSekolah -W sekolah

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
```

## Cara menjalankan aplikasi

Ada 2 opsi untuk menjalankan aplikasi ini, via Docker atau via Docker-compose

### Menjalankan aplikasi via Docker

Di sini saya berasumsi bahawa JDK8, maven & PostgreSQL Database sudah terinstal di lokal anda masing-masing.

- Untuk menjalankan aplikasinya cukup ketik perintah di bawah ini d terminal:

```shell
mvn clean spring-boot:run
```

- Untuk membungkusnya menjadi paket jar anda bisa menggunakan perintah berikut ini:

```
mvn clean package
```

- Untuk menjalankan jar dari paket tsb bisa dengan perintah berikut ini:

```
java -jar sekolah.jar
```

Aplikasi bisa dilihat di Heroku: https://sekolah1.herokuapp.com/ adminnya di https://sekolah1.herokuapp.com/admin

### Menjalankan aplikasi via Docker-Compose

Build image untuk menjalankan container

```shell
docker-compose -f <docker compose file.yml> build
```

jalankan container dari image yang telah dibuat

```shell
docker-compose -f <docker compose file.yml> up
```

setiap kali ada perubahan pada konfigurasi file di aplikasi seperti

_from_

```shell
spring.datasource.url=jdbc:postgresql://localhost:5432/sekolah
```

_to_

```shell
spring.datasource.url=jdbc:postgresql://db:5432/sekolah
```

perlu untuk melakukan _build_ ulang

```shell
docker-compose -f <docker compose file.yml> build [service_app_defined_on_docker_compose_file: ex: app or db]
```

#### Cara konek ke Postgres Database monitor (PgAdmin) via Docker

Jika kamu menjalankan aplikasi via _Docker Compose_, maka kamu bisa ikuti langkah ini untuk dapat melakukan monitor data pada database dengan PgAdmin via browser

```shell
http://localhost:3000/
```

login dengan email dan password yg telah ditetapkan do file docker-compose-dev/yml

```shell
PGADMIN_DEFAULT_EMAIL: sekolah@mail.com
PGADMIN_DEFAULT_PASSWORD: sekolah_password
```

kemudian pada _Quick Links_ pilih _Add New Server_. Pada tab _General_ isikan _Name_ dengan service name yang telah di tetapkan di docker-compose file (ex. db).
Pindah ke tab _Connection_ isikan _Host name / address_ dengan _IP internal_ docker untuk service DB

```shell
docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' <container name of service, ex. sekolah_db>
```

kolom _Username_ & _Password_ isikan dengan yang telah ditetapkan di docker-compose file

```shell
POSTGRES_USER=sekolah
POSTGRES_PASSWORD=sekolah_password
```

selesai dan _Save_, selanjutnya akan muncul database yang telah terkoneksi

## Contributing

Please see [CONTRIBUTING](CONTRIBUTING.md) for details.

## Listed by _Hendi Santika_

- Email: hendisantika@gmail.com / hendisantika@yahoo.co.id
- Telegram: [@hendisantika34](https://t.me/hendisantika34)
- Linktree: https://linktr.ee/hendisantika

## License

[![CC0](https://i.creativecommons.org/p/zero/1.0/88x31.png)](https://creativecommons.org/publicdomain/zero/1.0/)

To the extent possible under law, [Hendi Santika](https://github.com/hendisantika) has waived all copyright and related or neighboring rights to this work.
