package com.mycompany.petclinic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PetClinic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KlinikHewan klinikMyVet = new KlinikHewan("Pet Clinic - MyVet");

        klinikMyVet.bukaKlinik();

        try {
            klinikMyVet.tambahPasien(new Mamalia("shasha", "anjing poodle", "betina", "flu ringan", 12, 4.5, "bulu tunggal"));
            klinikMyVet.tambahPasien(new Reptil("dyo", "kura-kura darat", "jantan", "cakang sedikit retak", 24, 7.3, "terestrial"));
            klinikMyVet.tambahPasien(new Unggas("shone", "angsa putih", "jantan", "paruh tergores", 8, 2.4, "tidak bisa terbang"));
            klinikMyVet.tambahPasien(new Pisces("noe", "ikan arwana", "betina", "sirip terluka", 5, 0.9, "air tawar"));

            klinikMyVet.tambahOwner(new Owner("ow-1", "jennifer huh"));
            klinikMyVet.tambahOwner(new Owner("ow-2", "lee wonhee"));
            klinikMyVet.tambahOwner(new Owner("ow-3", "megan skiendiel"));
            klinikMyVet.tambahOwner(new Owner("ow-4", "yihani"));
        } catch (Exception e) {
            System.out.println("Gagal inisialisasi data awal: " + e.getMessage());
        }

        boolean isRunning = true;

        System.out.println("=====================================");
        System.out.println(" Selamat Datang di Pet Clinic - MyVet ");
        System.out.println("=====================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Lihat Daftar Pasien");
            System.out.println("3. Cari Pasien (Custom Exception)");
            System.out.println("4. Manajemen Owner");
            System.out.println("5. Simulasi Perawatan (Demo Association)");
            System.out.println("6. Keluar");
            System.out.print("Pilih: ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> {
                        System.out.println("\n-- Pilih Kategori Hewan --");
                        System.out.println("1. Mamalia");
                        System.out.println("2. Reptil");
                        System.out.println("3. Unggas");
                        System.out.println("4. Pisces");
                        System.out.print("Pilih: ");
                        int kategori = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Nama Hewan: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Jenis Hewan: ");
                        String jenis = scanner.nextLine();
                        System.out.print("Masukkan Gender Hewan: ");
                        String gender = scanner.nextLine();
                        System.out.print("Masukkan Keluhan Hewan: ");
                        String keluhan = scanner.nextLine();
                        System.out.print("Masukkan Umur Hewan: ");
                        int umur = scanner.nextInt();
                        System.out.print("Masukkan Berat Hewan: ");
                        double berat = scanner.nextDouble();
                        scanner.nextLine();

                        if (kategori == 1) {
                            System.out.print("Masukkan Tipe Bulu: ");
                            klinikMyVet.tambahPasien(new Mamalia(nama, jenis, gender, keluhan, umur, berat, scanner.nextLine()));
                        } else if (kategori == 2) {
                            System.out.print("Masukkan Tipe Habitat: ");
                            klinikMyVet.tambahPasien(new Reptil(nama, jenis, gender, keluhan, umur, berat, scanner.nextLine()));
                        } else if (kategori == 3) {
                            System.out.print("Masukkan Tipe Terbang: ");
                            klinikMyVet.tambahPasien(new Unggas(nama, jenis, gender, keluhan, umur, berat, scanner.nextLine()));
                        } else if (kategori == 4) {
                            System.out.print("Masukkan Tipe Air: ");
                            klinikMyVet.tambahPasien(new Pisces(nama, jenis, gender, keluhan, umur, berat, scanner.nextLine()));
                        } else {
                            System.out.println("Kategori hewan tidak valid");
                        }
                        System.out.println("Sukses, pasien berhasil ditambahkan (Total Pasien: " + klinikMyVet.getJumlahPasien() + ")");
                    }

                    case 2 -> {
                        System.out.println("\n-- Daftar Pasien di Pet Clinic - MyVet --");
                        klinikMyVet.lihatSemuaPasien();
                    }

                    case 3 -> {
                        System.out.println("\n-- Fitur Cari Pasien (Custom Exception) --");
                        System.out.print("Masukkan Nama Pasien yang dicari: ");
                        String kataKunci = scanner.nextLine();

                        try {
                            klinikMyVet.cariPasien(kataKunci);
                        } catch (PasienTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        }
                    }

                    case 4 -> {
                        System.out.println("\n-- Manajemen Owner --");
                        System.out.println("1. Tambah Owner");
                        System.out.println("2. Cari Owner");
                        System.out.println("3. Lihat Semua");
                        System.out.print("Pilih: ");
                        int menuOwner = scanner.nextInt();
                        scanner.nextLine();

                        if (menuOwner == 1) {
                            System.out.print("Masukkan ID Owner: ");
                            String id = scanner.nextLine();
                            System.out.print("Masukkan Nama Owner: ");
                            String nama = scanner.nextLine();
                            klinikMyVet.tambahOwner(new Owner(id, nama));
                            System.out.println("Berhasil menambahkan owner");
                        } else if (menuOwner == 2) {
                            System.out.print("ID Owner yg dicari: ");
                            klinikMyVet.cariOwner(scanner.nextLine());
                        } else if (menuOwner == 3) {
                            klinikMyVet.lihatSemuaOwner();
                        } else {
                            System.out.println("Pilihan tidak valid");
                        }
                    }

                    case 5 -> {
                        System.out.println("\n-- Simulasi Perawatan (Asosiasi) --");
                        System.out.print("Masukkan ID Owner Pemilik: ");
                        String inputId = scanner.nextLine();
                        Owner owner = klinikMyVet.getOwner(inputId);

                        if (owner == null) {
                            System.out.println("Gagal: Owner belum terdaftar");
                        } else if (klinikMyVet.getJumlahPasien() == 0) {
                            System.out.println("Gagal: Belum ada pasien hewan di klinik");
                        } else {
                            klinikMyVet.lihatSemuaPasien();
                            System.out.print("Pilih (1-" + klinikMyVet.getJumlahPasien() + "): ");
                            int noPasien = scanner.nextInt() - 1;
                            scanner.nextLine();

                            if (noPasien >= 0 && noPasien < klinikMyVet.getJumlahPasien()) {
                                Pasien pasienTerpilih = klinikMyVet.getPasienInt(noPasien);
                                TransaksiPerawatan.prosesPerawatan(owner, pasienTerpilih);
                            } else {
                                System.out.println("Nomor pasien tidak valid");
                            }
                        }
                    }

                    case 6 -> {
                        System.out.println("Terima kasih telah menggunakan Pet Clinic - MyVet");
                        isRunning = false;
                    }

                    default -> System.out.println("Pilihan tidak valid, silahkan tekan angka 1-6");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR INPUT] Input harus berupa angka valid");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("\n[ERROR SISTEM] Terjadi kesalahan: " + e.getMessage());
            } finally {
                System.out.println("-> Siklus menu sistem berjalan normal\n");
            }
        }

        scanner.close();
    }
}