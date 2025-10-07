# JualBeliEmas.Kotlin
Program konsol berbasis Kotlin yang mensimulasikan proses jual beli emas menggunakan konsep OOP (class, inheritance, polymorphism) serta penanganan exception.

# 💰 Program Jual Beli Emas (Kotlin)
Proyek ini merupakan implementasi sederhana program **jual beli emas** menggunakan bahasa **Kotlin**.  
Program berjalan di konsol/terminal dan menggunakan **konsep OOP** seperti:
- `class` dan `inheritance`
- `polymorphism`
- `exception handling (fail & exitProcess)`
- kontrol alur menggunakan `if-else`

## ⚙️ Fitur Utama
- Transaksi **beli emas** dengan perhitungan harga, pajak, dan kembalian.
- Transaksi **jual emas** dengan perhitungan pajak dan total uang diterima.
- Validasi **NPWP** untuk menentukan besaran pajak.
- Mekanisme **pengulangan transaksi** dengan logika rekursif.
- Implementasi fungsi `fail()` dan `exitProcess()` sebagai simulasi exception.

## 🧩 Struktur Kode
Semua kode ditulis dalam satu file utama:
**jualbeliemas.kt**

Berisi:
- `class jualbeliemas` → kelas utama
- `class beli` → turunan untuk pembelian emas
- `class jual` → turunan untuk penjualan emas
- `fun fail()` dan `fun exitProcess()` → fungsi exception
- `fun main()` → fungsi utama program

## 🚀 Cara Menjalankan
1. Pastikan Anda sudah menginstal **Kotlin SDK**.
2. Jalankan program melalui terminal:
   kotlinc jualbeliemas.kt -include-runtime -d jualbeliemas.jar
   java -jar jualbeliemas.jar

## 🧠 Catatan
Program ini berjalan interaktif di terminal.
Hanya menggunakan input/output dasar (readLine() dan println()).
Dapat dikembangkan untuk koneksi database atau GUI.
