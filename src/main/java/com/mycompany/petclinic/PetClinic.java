package com.mycompany.petclinic;

import java.util.Scanner;

public class PetClinic {

    public static void cariPasien(String nama, Pasien[] daftarPasien, int jumlahPasien, boolean berdasarkanNama) {
        System.out.println("Mencari pasien dengan Nama: " + nama);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahPasien; i++) {
            if (daftarPasien[i].getNama().equalsIgnoreCase(nama)) {
                System.out.print("- Ditemukan: ");
                daftarPasien[i].tampilkanInfo();
                System.out.println();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("- Tidak ditemukan.");
    }

    public static void cariPasien(String jenis, Pasien[] daftarPasien, int jumlahPasien) {
        System.out.println("Mencari pasien dengan Jenis: " + jenis);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahPasien; i++) {
            if (daftarPasien[i].getJenis().equalsIgnoreCase(jenis)) {
                System.out.print("- Ditemukan: ");
                daftarPasien[i].tampilkanInfo();
                System.out.println();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("- Tidak ditemukan.");
    }
    
    public static void prosesPerawatan(Pasien hewan){
        System.out.print(hewan.getNama() + " -> ");
        hewan.caraPerawatan();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pasien[] daftarPasien = new Pasien[10];

        int jumlahPasien = 0;
        boolean isRunning = true;

        System.out.println("==============================");
        System.out.println(" Selamat Datang di Pet Clinic ");
        System.out.println("==============================");

        while (isRunning) {
            System.out.println("\nMenu Utama");
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Lihat Daftar Pasien");
            System.out.println("3. Cari Pasien");
            System.out.println("4. Proses Perawatan Pasien");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlahPasien < daftarPasien.length) {
                        System.out.println("\n-- Pilih Kategori Hewan --");
                        System.out.println("1. Mamalia");
                        System.out.println("2. Reptil");
                        System.out.println("3. Unggas");
                        System.out.println("4. Pisces");
                        System.out.print("Pilih (1-4): ");

                        int kategori = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print(" Masukan Nama Hewan: ");
                        String namaHewan = scanner.nextLine();

                        System.out.print(" Masukan Jenis Hewan: ");
                        String jenisHewan = scanner.nextLine();

                        System.out.print(" Masukan Gender Hewan: ");
                        String genderHewan = scanner.nextLine();

                        System.out.print(" Masukan Keluhan Hewan: ");
                        String keluhanHewan = scanner.nextLine();

                        System.out.print(" Masukan Umur Hewan: ");
                        int umurHewan = scanner.nextInt();

                        System.out.print(" Masukan Berat Hewan: ");
                        double beratHewan = scanner.nextDouble();
                        scanner.nextLine();

                        if (kategori == 1) {
                            System.out.print("Masukan Tipe Bulu: ");
                            String tipeBulu = scanner.nextLine();
                            daftarPasien[jumlahPasien] = new Mamalia(namaHewan, jenisHewan, genderHewan, keluhanHewan, umurHewan, beratHewan, tipeBulu);
                        } else if (kategori == 2) {
                            System.out.print("Masukan Tipe Habitat: ");
                            String tipeHabitat = scanner.nextLine();
                            daftarPasien[jumlahPasien] = new Reptil(namaHewan, jenisHewan, genderHewan, keluhanHewan, umurHewan, beratHewan, tipeHabitat);
                        } else if (kategori == 3) {
                            System.out.print("Masukan Tipe Terbang: ");
                            String tipeTerbang = scanner.nextLine();
                            daftarPasien[jumlahPasien] = new Unggas(namaHewan, jenisHewan, genderHewan, keluhanHewan, umurHewan, beratHewan, tipeTerbang);
                        } else if (kategori == 4) {
                            System.out.print("Masukan Tipe Air: ");
                            String tipeAir = scanner.nextLine();
                            daftarPasien[jumlahPasien] = new Pisces(namaHewan, jenisHewan, genderHewan, keluhanHewan, umurHewan, beratHewan, tipeAir);
                        }
                        jumlahPasien++;

                        System.out.println("sukses, pasien berhasil ditambahkan");
                    } else {
                        System.out.println("maaf, kapasitas ruang rawat penuh:");
                    }
                    break;

                case 2:
                    System.out.println("\n-- Daftar Pasien di Pet Clinic --");
                    if (jumlahPasien == 0) {
                        System.out.println("Belum ada pasien yang tersimpan");
                    } else {
                        for (int i = 0; i < jumlahPasien; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarPasien[i].tampilkanInfo();
                            System.out.println();
                            daftarPasien[i].caraPerawatan();
                        }
                    }

                    System.out.println("\n* Total Pasien yang Terdaftar: " + Pasien.totalPasienBerhasilDibuat);

                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                    break;

                case 3:
                    System.out.println("\n-- Fitur Cari Pasien --");
                    System.out.println("1. Cari berdasarkan Nama");
                    System.out.println("2. Cari berdasarkan Jenis");
                    System.out.print("Pilih (1/2): ");
                    int modeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (modeCari == 1) {
                        System.out.print("Masukkan Nama Pasien: ");
                        String kataKunci = scanner.nextLine();
                        cariPasien(kataKunci, daftarPasien, jumlahPasien, true);
                    } else if (modeCari == 2) {
                        System.out.print("Masukkan Jenis Hewan: ");
                        String kataKunci = scanner.nextLine();
                        cariPasien(kataKunci, daftarPasien, jumlahPasien);
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                    break;

                case 4:
                    System.out.println("\n-- Proses Perawatan Pasien --");
                    if (jumlahPasien == 0) {
                        System.out.println("Belum ada pasien yang tersimpan.");
                    } else {
                        for (int i = 0; i < jumlahPasien; i++) {
                            prosesPerawatan(daftarPasien[i]);
                        }
                    }
                    System.out.print("Tekan Enter untuk melanjutkan...");
                    scanner.nextLine();
                    break;
                
                case 5:
                    System.out.println("Terima kasih telah berobat di Pet Clinic");
                    isRunning = false;
                    break;

                default:
                    System.out.println("pilihan tidak valid, silahkan tekan angka 1-5.");
                    break;
            }
        }
        scanner.close();
    }
}