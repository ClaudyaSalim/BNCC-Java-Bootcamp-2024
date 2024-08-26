# BNCC-Java-Bootcamp-2024

## Cara Download Project
### 1. Dengan Git
1. Download git di https://git-scm.com/downloads dan install aplikasinya
2. Sign up ke www.github.com
3. Ketik command berikut di **terminal / command prompt**
   1. Buat setup Git pertama kali dengan akun Github
      ```
      git config --global user.name “Username”
      git config --global user.email “Email”
      ```
      > Username = nama akun Github kalian, Email = email yang kalian pakai untuk Github
   2. Buat download project Bootcamp
      ```
      git clone https://github.com/ClaudyaSalim/BNCC-Java-Bootcamp-2024.git
      ```
4. Masuk ke folder **BNCC-Java-Bootcamp-2024** dan buka projectnya
5. Kalau ada update berikutnya, tinggal ketik **git pull**
   > Pastikan saat kalian ketik "git pull", kalian berada di folder BNCC-Java-Bootcamp-2024
   
   ![image](https://github.com/user-attachments/assets/fc0e6e1a-b5ac-4f46-82de-b225bd9198b2)

   ![image](https://github.com/user-attachments/assets/d5108867-4c64-42bb-bf10-1900a44d54d0)


### 2. Download ZIP
Cukup dengan klik tombol **Code -> Download ZIP**, tapi di update berikutnya kalian harus **download lagi**


## Cara Buka Project (1)
1. Buka workspace Eclipse dari folder project tersebut (**BNCC-Java-Bootcamp-2024**)
2. Klik **File -> Open Projects from File System**
3. Sesuaikan **Import Source** dengan workspace yang dibuka dengan klik **Directory**
4. Pastikan folder project yang ditemukan **dicentang semua**
5. Klik **Finish**


## Cara Buka Project (2)
1. Buka workspace Eclipse dari folder project tersebut (**BNCC-Java-Bootcamp-2024**)
2. Klik **File -> Import... -> General -> Existing Projects into Workspace**
3. Sesuaikan **Root Directory** dengan workspace yang dibuka dengan klik **Browse**
4. Pastikan folder project yang ditemukan **dicentang semua**
5. Klik **Finish**


## Khusus Project Pertemuan 5-7
1. Ikuti tahapan guideline instalasi JavaFX (dari awal jika belum install) **https://bit.ly/GuidelineInstalasiSoftwareJavaFx**
2. Setelah buka project, klik kanan di folder projectnya
3. Pilih **Build Path -> Configure Build Path -> tab Libraries -> klik ModulePath -> klik Add Library -> pilih User Library -> tambahkan library JavaFX yang sudah kalian buat sebelumnya**
4. Jika **belum** buat library JavaFX, silakan ikut cara instalasi bagian **D. Create User Library** dan lakukan step 3
5. Khusus project **Pertemuan 6**, klik **Add External JARs** dan pilih file **.jar dari JFXtras** yang kalian download di **PPT Pertemuan 5 & 6**
   > Harusnya bentuk librariesnya akan seperti ini
   
   ![image](https://github.com/user-attachments/assets/2265a208-f72b-43f1-9a08-ebfb4685625b)
   
6. Khusus project **Pertemuan 7**, klik **Add External JARs** dan pilih file **.jar untuk MySQL Connector** yang kalian download di **PPT Pertemuan 7**
7. Klik **Apply and Close**


### Notes tambahan untuk Pertemuan 7
- Kalian harus menyalakan XAMPP setiap kali sebelum run.
- Kalian harus buat database dengan struktur yang sama (tabel untuk menu, atributnya ada id, nama, kategori, harga).
- Kalian harus setting detail database nya di file Database.java sesuai dengan detail XAMPP dan database yang kalian buat.


## Link PPT
PPT Pertemuan 1: https://www.figma.com/deck/fUA2k2ZzoB1mY5hTd30bZF/Pertemuan-1?node-id=1-59

PPT Pertemuan 2: https://www.figma.com/deck/poebgcon9qUEYtcJx3iTGc/Pertemuan-2?node-id=1-12

PPT Pertemuan 3: https://www.figma.com/deck/zIgxKPvmTVVXXrf7HvZX5f/Pertemuan-3?node-id=1-10

PPT Pertemuan 4: https://www.figma.com/deck/MO1qF39MRZ9qgwkRG4f5AK/Pertemuan-4?node-id=1-62

PPT Pertemuan 5 & 6: https://www.figma.com/deck/C3DRwRfcnQNVew05xje6Fh/Pertemuan-5-%26-6?node-id=4-10

PPT Pertemuan 7: https://www.figma.com/deck/f1naizLftBeda238jrZZuL/Pertemuan-7?node-id=1-62
