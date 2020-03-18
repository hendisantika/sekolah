# sekolah
MYSCHOOL adalah source code opensource yang dibangun mengunakan Spring Boot 2.2.5.RELEASE version yang terinspirasi dari
MSCHOOL yang dibangun menggunakan Codeigniter 3.1.9 dan Bootstrap 4.0.

MYSCHOOL merupakan pengembangan dari project M-Sekolah. Dengan kata lain, MSCHOOL adalah versi 2.0 dari M-Sekolah dengan Java Spring Boot.

MYSCHOOL merupakan project open source untuk website profile sekolah SD, MI, SMP MTs, MA ataupun SMA dan sederajat untuk menunjang transparasi informasi dan promosi sekolah.

Backend dari Source Code ini dibangun menggunakan template AdminLTE, yaitu template yang sangat umum bagi developer web saat ini.

Selain itu, source code ini juga menggunakan Toast Message untuk menampilkan pesan pada bagian Backend.

Hal itulah yang membuat souce code ini menjadi sangat menarik.

Source Code ini berjalan dengan baik di PaaS (Platform as as Service) seperti Heroku ataupun d VPS (Virtual Private Server) seperti Digital Ocean(DO).
Tinggal upload dan sedikit konfigurasi, semuanya bejalan dengan baik.

Bagaimana mengonlinekannya?

- Order Domain dan Hosting

- Upload Source Code myschool ke hosting

- Buat database di hosting (di sini saya menggunakan PostgreSQL


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
## Cara menjalankan aplikasi
Di sini saya berasumsi bahawa JDK8, maven & PostgreSQL Database sudah terinstal di lokal anda masing-masing.

* Untuk menjalankan aplikasinya cukup ketik perintah di bawah ini d terminal:
```
mvn clean spring-boot:run
```

* Untuk membungkusnya menjadi paket jar anda bisa menggunakan perintah berikut ini:
```
mvn clean package
```

* Untuk menjalankan jar dari paket tsb bisa dengan perintah berikut ini:
```
java -jar sekolah.jar
```
Aplikasi bisa dilihat di Heroku: https://sekolah1.herokuapp.com/

## Contributing
Please see [CONTRIBUTING](CONTRIBUTING.md) for details.

## Listed by *Hendi Santika*
- Email: hendisantika@gmail.com / hendisantika@yahoo.co.id
- Telegram: [@hendisantika34](https://t.me/hendisantika34)

## License

[![CC0](https://i.creativecommons.org/p/zero/1.0/88x31.png)](https://creativecommons.org/publicdomain/zero/1.0/)

To the extent possible under law, [Hendi Santika](https://github.com/hendisantika) has waived all copyright and related or neighboring rights to this work.