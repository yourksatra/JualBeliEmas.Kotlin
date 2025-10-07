import kotlin.system.exitProcess
import kotlin.test.fail
//Class Utama Program Polimorfisme
open class jualbeliemas{
    open fun transaksi(jumlah: Float, NPWP: String){
    }
}
//fungsi exeption throw fail
fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}
//fungsi exeption exitprocess
fun exitProcess(status: Int): Nothing {
    throw RuntimeException("System.exit returned normally, TerimaKasih.")
    System.exit(status)
}
//Class transaksi beli dengan visibility modifier internal
//serta merupakan Inheritance dari Class utama jualbeliemas
internal class beli(): jualbeliemas(){
    override fun transaksi(jumlah: Float, NPWP: String) {
        var harga: Int = 850000
        val hrg_beli: Int
        val pajak: Int
        val pjk = arrayListOf<Double>(0.45 , 0.9)
        val i: Int
        val bsran_pajak: Double
        val total: Int
        hrg_beli = (harga * jumlah).toInt()
//Percabangan if else untuk menghitung pajak NPWP
        if (NPWP == "Y" || NPWP == "y"){
            i = 0
            bsran_pajak = (pjk[i]/100).toDouble()
        }else{
            i = 1
            bsran_pajak = (pjk[i]/100).toDouble()
        }
//Operasi perhitungan Pajak
        pajak = (hrg_beli*bsran_pajak).toInt()
        total = hrg_beli + pajak
//Output Nota
        println("\t---------------------------------------")
        println("\t           Nota Transaksi              ")
        println("\t---------------------------------------")
        println("\t Harga Beli             : Rp. $harga /g")
        println("\t Jumlah Pembelian       : $jumlah g")
        println("\t Total Harga Beli       : Rp. $hrg_beli")
        println("\t Besaran Pajak(%)       : "+pjk[i])
        println("\t Pajak                  : Rp. $pajak")
        println("\t Total Pembelian        : Rp. $total")
//Input pembayaran serta output kembalian
        print("\t Pembayaran             : Rp. ")
        val bayar = readLine()?.toInt()
        val kembalian = bayar?.minus(total)
        println("\t Kembalian              : Rp. $kembalian")
    }
}
//Class transaksi jual dengan visibility modifier internal
//serta merupakan Inheritance dari class utama jualbeliemas
internal class jual() : jualbeliemas() {
    override fun transaksi(jumlah: Float, NPWP: String) {
        val harga = 900000
        val pjk = arrayListOf(1.5, 3.0)
        val i: Int
        val bsran_pajak: Double
        val hrg_jual = (harga * jumlah).toInt()
        val pajak: Int
        val total_diterima: Int

        // Percabangan untuk menghitung pajak NPWP
        if (NPWP == "Y" || NPWP == "y") {
            i = 0
        } else {
            i = 1
        }
        bsran_pajak = pjk[i] / 100.0

        // Operasi perhitungan Pajak
        pajak = (hrg_jual * bsran_pajak).toInt()
        total_diterima = hrg_jual - pajak

        // Output Nota
        println("\t---------------------------------------")
        println("\t           Nota Penjualan              ")
        println("\t---------------------------------------")
        println("\t Harga Jual             : Rp. $harga /g")
        println("\t Jumlah Emas Dijual     : $jumlah g")
        println("\t Total Nilai Jual       : Rp. $hrg_jual")
        println("\t Besaran Pajak(%)       : ${pjk[i]}")
        println("\t Pajak Penjualan        : Rp. $pajak")
        println("\t Total Uang Diterima    : Rp. $total_diterima")

        // Konfirmasi penerimaan uang
        print("\t Apakah uang sudah diterima? (Y/T): ")
        val konfirmasi = readLine().toString()

        if (konfirmasi.equals("Y", ignoreCase = true)) {
            println("\t Transaksi penjualan berhasil. Terima kasih!")
        } else {
            println("\t Transaksi dibatalkan.")
        }
    }
}

//fungsi utama
fun main() {
//variabel untuk memanggil class beli dan jual
    val alpa = beli()
    val beta = jual()
//Tampilan utama Program
        println("\t---------------------------------------")
        println("\t        Program Jual Beli Emas         ")
        println("\t---------------------------------------")
        println("\t Daftar Transaksi : ")
        println("\t     [1] Beli Emas")
        println("\t     [2] Jual Emas")
        println("\t---------------------------------------")
        println("\t     Beli Emas Min(0,05g) Max(80g)     ")
        println("\t     Jual Emas Min(1g)   Max(100g)     ")
        println("\t---------------------------------------")
        print("\t Pilih Transaksi                  : ")
        val pilih = readLine()?.toInt()
//control flow percabangan if else if untuk pilihan transaksi
//if 1 untuk pembelian emas
        if (pilih == 1){
            print("\t Apakah Anda Mempunya NPWP? (Y/T) : ")
            val npwp = readLine().toString()
            print("\t Jumlah(g)                        : ")
            val jmlh_emas = readLine()?.toFloat()
//Inputan Jumlah emas yang dibeli(g)
// Percabangan untuk pengecekan jumlah emas
            if (jmlh_emas != null) {
                if (jmlh_emas >= 0.05 && jmlh_emas <= 80.0){
//pemanggilan variabel turunan fungsi beli serta inputan parameter
                    alpa.transaksi(jmlh_emas, npwp)
                }else{
//didalam else ini terdapat fail exception
                    val s = fail("Pembelian Emas Tidak Diterima")
                    println("\t $s")
                }
            }else{
//didalam else ini terdapat fail exception
                val s = fail("Pembelian Emas Tidak Diterima")
                println("\t $s")
            }
//if 2 untuk penjualan emas
        }else if (pilih == 2){
            print("\t Apakah Anda Mempunya NPWP? (Y/T) : ")
            val npwp = readLine().toString()
            print("\t Jumlah(g)                        : ")
            val jmlh_emas = readLine()?.toFloat()
//Inputan Jumlah emas yang dijual(g)
// Percabangan untuk pengecekan jumlah emas
            if (jmlh_emas != null) {
                if (jmlh_emas >= 1.0 && jmlh_emas <= 100.0){
//pemanggilan variabel turunan fungsi jual serta inputan parameter
                    beta.transaksi(jmlh_emas, npwp)
                }else{
//didalam else ini terdapat fail exception
                    val s = fail("Penjualan Emas Tidak Diterima")
                    println("\t $s")
                }
            }else {
//didalam else ini terdapat fail exception
                val s = fail("Penjualan Emas Tidak Diterima")
                println("\t $s")
            }
        }else{
//Pernyataan untuk mengulang jika salah dalam memilih transaksi
            println("\t Daftar Transaksi Tidak Ada")
            print("\t Apakah Ingin Mengulang? (Y/T) : ")
            val ulang = readLine().toString()
            if (ulang == "y" || ulang == "Y"){
//Jika syarat terpenuhi maka akan memulai kembali main fungsi
                return main()
            }
        }
//Pernyataan transaksi selesai dan saran untuk mengulang
        println("\t---------------------------------------")
        println("\t          Transaksi Selesai            ")
        println("\t---------------------------------------")
        print("\t Apakah Anda Ingin Mengulang? (Y/T) : ")
        val loop = readLine().toString()
        if (loop == "y" || loop == "Y"){
//Jika syarat terpenuhi maka akan memulai kembali main fungsi
            return main()
        }
//Jika syarat tidak terpenuhi maka akan menjalankan exitProcess
    else
        exitProcess(999)
}