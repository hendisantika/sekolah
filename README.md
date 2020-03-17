# sekolah

## Cara Membuat Database
1. Create user untuk connect ke database
```
createuser -P registrasiuser
```

2. Create database untuk user tersebut
```
createdb -Oregistrasiuser registrasidb
```

3. Konfigurasi database
```
spring.datasource.url=jdbc:postgresql://localhost:5432/sekolah
spring.datasource.username=adminSekolah
spring.datasource.password=passwordSekolah
```