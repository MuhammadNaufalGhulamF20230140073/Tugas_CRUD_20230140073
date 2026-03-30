TAMPILAN WEB
<img width="1915" height="977" alt="image" src="https://github.com/user-attachments/assets/cea40dda-97e4-41b0-b4f9-c9b24961a884" />
DB
<img width="1918" height="952" alt="image" src="https://github.com/user-attachments/assets/212970ed-7946-4a48-8178-dbf7e8d7ae50" />


🚀 KTP Management API Documentation
Base URL: http://localhost:8080

🛠️ Daftar Endpoint (Methods)
1. ➕ Tambah Data KTP Baru (POST)
Endpoint: /ktp

Fungsi: Menambahkan data KTP penduduk baru ke database.

Request Body (JSON):

```JSON
{
  "nomorKtp": "3201010101900001",
  "namaLengkap": "Budi Santoso",
  "alamat": "Jl. Merdeka No. 45, Jakarta",
  "tanggalLahir": "1990-01-01",
  "jenisKelamin": "Laki-laki"
}
Respon Sukses (201 Created):

JSON
{
  "id": 1,
  "nomorKtp": "3201010101900001",
  "namaLengkap": "Budi Santoso",
  "alamat": "Jl. Merdeka No. 45, Jakarta",
  "tanggalLahir": "1990-01-01",
  "jenisKelamin": "Laki-laki"
}
```
2. 📖 Melihat Seluruh Data KTP (GET)
Endpoint: /ktp

Fungsi: Mengambil dan menampilkan semua data KTP yang ada di database.

Respon Sukses (200 OK):

```JSON
[
  {
    "id": 1,
    "nomorKtp": "3201010101900001",
    "namaLengkap": "Budi Santoso",
    "alamat": "Jl. Merdeka No. 45, Jakarta",
    "tanggalLahir": "1990-01-01",
    "jenisKelamin": "Laki-laki"
  },
  {
    "id": 2,
    "nomorKtp": "3201020202950002",
    "namaLengkap": "Siti Aminah",
    "alamat": "Jl. Mawar No. 12, Bandung",
    "tanggalLahir": "1995-02-02",
    "jenisKelamin": "Perempuan"
  }
]
```
3. 📖 Melihat Data KTP Spesifik (GET)
Endpoint: /ktp/{id}  (Contoh: /ktp/1) Fungsi: Mengambil detail satu data KTP berdasarkan ID-nya (berguna saat menekan tombol Edit di frontend).

Respon Sukses (200 OK):

```JSON
{
  "id": 1,
  "nomorKtp": "3201010101900001",
  "namaLengkap": "Budi Santoso",
  "alamat": "Jl. Merdeka No. 45, Jakarta",
  "tanggalLahir": "1990-01-01",
  "jenisKelamin": "Laki-laki"
}
```
4. ✏️ Edit / Update Data KTP (PUT)
Endpoint: /ktp/{id}  (Contoh: /ktp/1) Fungsi: Memperbarui data KTP penduduk yang sudah ada berdasarkan ID.

Request Body (JSON):

```JSON
{
  "nomorKtp": "3201010101900001",
  "namaLengkap": "Budi Santoso Updated",
  "alamat": "Jl. Jendral Sudirman No. 99, Jakarta",
  "tanggalLahir": "1990-01-01",
  "jenisKelamin": "Laki-laki"
}
Respon Sukses (200 OK):

JSON
{
  "id": 1,
  "nomorKtp": "3201010101900001",
  "namaLengkap": "Budi Santoso Updated",
  "alamat": "Jl. Jendral Sudirman No. 99, Jakarta",
  "tanggalLahir": "1990-01-01",
  "jenisKelamin": "Laki-laki"
}

```
5. 🗑️ Hapus Data KTP (DELETE)
Endpoint: /ktp/{id}  (Contoh: /ktp/1) Fungsi: Menghapus data KTP penduduk dari database secara permanen.

Respon Sukses (200 OK):
```
Data KTP berhasil dihapus!
