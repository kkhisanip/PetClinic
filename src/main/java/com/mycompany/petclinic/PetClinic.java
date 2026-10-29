package com.mycompany.petclinic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PetClinic {

    public static void cariPasien(String nama, ArrayList<Pasien> daftarPasien) throws PasienTidakDitemukanException {
        System.out.println("Mencari pasien dengan Nama: " + nama);
        boolean ditemukan = false;
        for (int i = 0; i < daftarPasien.size(); i++) {
            if (daftarPasien.get(i).getNama().equalsIgnoreCase(nama)) {
                System.out.print("- Ditemukan: ");
                daftarPasien.get(i).tampilkanInfo();
                System.out.println();
                ditemukan = true;
            }
        }
        if (!ditemukan)
            throw new PasienTidakDitemukanException("Gagal: Pasien dengan nama '" + nama + "' tidak ditemukan di sistem!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Pasien> daftarPasien = new ArrayList<>();
        HashMap<String, String> dataOwner = new HashMap<>();

        try {
            daftarPasien.add(new Mamalia("Shasha", "Anjing Poodle", "Betina", "Flu ringan", 12, 4.5, "Bulu berlapis tunggal"));
            daftarPasien.add(new Reptil("Dyo", "Kura-kura Darat", "Jantan", "Cakang sedikit retak", 24, 7.3, "Terestrial"));
            daftarPasien.add(new Unggas("Shone", "Angsa Putih", "Jantan", "Paruh tergores", 8, 2.4, "Tidak bisa terbang"));
            daftarPasien.add(new Pisces("Noe", "Ikan Arwana", "Betina", "Sirip terluka", 5, 0.9, "Air Tawar"));
            
            dataOwner.put("OWN-001", "Jennifer Huh");
            dataOwner.put("OWN-002", "Lee Wonhee");
            dataOwner.put("OWN-003", "Megan Skiendiel");
            dataOwner.put("OWN-004", "Yihani");
        } catch (Exception e) {
            System.out.println("Gagal inisialisasi data awal: " + e.getMessage());
        }

        boolean isRunning = true;

        System.out.println("==============================");
        System.out.println(" Selamat Datang di Pet Clinic ");
        System.out.println("==============================");

        while (isRunning) {
            System.out.println("\nMenu Utama");
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Lihat Daftar Pasien");
            System.out.println("3. Cari Pasien (Demo Custom Exception)");
            System.out.println("4. Manajemen Owner (Demo HashMap)");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu (1-5): ");

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
                            daftarPasien.add(new Mamalia(namaHewan, jenisHewan, genderHewan, keluhanHewan, umurHewan, beratHewan, tipeBulu));
                        } else if (kategori == 2) {
                            System.out.print("Masukan Tipe Habitat: ");
                            String tipeHabitat = scanner.nextLine();
                            daftarPasien.add(new Reptil(namaHewan, jenisHewan, genderHewan, keluhanHewan, umurHewan, beratHewan, tipeHabitat));
                        } else if (kategori == 3) {
                            System.out.print("Masukan Tipe Terbang: ");
                            String tipeTerbang = scanner.nextLine();
                            daftarPasien.add(new Unggas(namaHewan, jenisHewan, genderHewan, keluhanHewan, umurHewan, beratHewan, tipeTerbang));
                        } else if (kategori == 4) {
                            System.out.print("Masukan Tipe Air: ");
                            String tipeAir = scanner.nextLine();
                            daftarPasien.add(new Pisces(namaHewan, jenisHewan, genderHewan, keluhanHewan, umurHewan, beratHewan, tipeAir));
                        } else {
                            System.out.println("Kategori hewan tidak valid!");
                        }
                        System.out.println("Sukses, pasien berhasil ditambahkan! (Total Pasien: " + daftarPasien.size() + ")");
                    }

                    case 2 -> {
                        System.out.println("\n-- Daftar Pasien di Pet Clinic --");
                        if (daftarPasien.isEmpty()) {
                            System.out.println("Belum ada pasien yang tersimpan");
                        } else {
                            for (int i = 0; i < daftarPasien.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                daftarPasien.get(i).tampilkanInfo();
                                System.out.println();
                                daftarPasien.get(i).caraPerawatan();
                                daftarPasien.get(i).biayaPenangananLanjut();
                                
                                if (daftarPasien.get(i) instanceof TindakanLanjut tindakan) {
                                    tindakan.prosesVaksinasi();
                                    tindakan.prosesOperasi();
                                }
                                System.out.println();
                            }
                        }
                        System.out.println("\n* Total Pasien Terdaftar (ArrayList size): " + daftarPasien.size());
                    }

                    case 3 -> {
                        System.out.println("\n-- Fitur Cari Pasien (Custom Exception) --");
                        System.out.print("Masukkan Nama Pasien yang dicari: ");
                        String kataKunci = scanner.nextLine();

                        try {
                            cariPasien(kataKunci, daftarPasien);
                        } catch (PasienTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        } finally {
                            System.out.println("-> Sesi pencarian selesai dieksekusi.");
                        }
                    }

                    case 4 -> {
                        System.out.println("\n-- Manajemen Owner (HashMap) --");
                        System.out.println("1. Tambah Owner Baru");
                        System.out.println("2. Cari Owner via ID");
                        System.out.println("3. Tampilkan Semua Owner");
                        System.out.print("Pilih menu (1-3): ");
                        int menuOwner = scanner.nextInt();
                        scanner.nextLine();

                        if (menuOwner == 1) {
                            System.out.print("Masukkan ID Owner (sebagai Key): ");
                            String idKey = scanner.nextLine();
                            System.out.print("Masukkan Nama Owner (sebagai Value): ");
                            String namaVal = scanner.nextLine();
                            dataOwner.put(idKey, namaVal);
                            System.out.println("Berhasil menambahkan data owner!");
                        } else if (menuOwner == 2) {
                            System.out.print("Masukkan ID yang dicari: ");
                            String searchId = scanner.nextLine();
                            if (dataOwner.containsKey(searchId)) {
                                System.out.println("Ditemukan! Nama Owner: " + dataOwner.get(searchId));
                            } else {
                                System.out.println("Owner dengan ID tersebut tidak terdaftar.");
                            }
                        } else if (menuOwner == 3) {
                            System.out.println("Total Owner Terdaftar: " + dataOwner.size());
                            for (String keyId : dataOwner.keySet()) {
                                System.out.println("- ID: " + keyId + " | Nama: " + dataOwner.get(keyId));
                            }
                        } else {
                            System.out.println("Pilihan menu tidak valid.");
                        }
                    }

                    case 5 -> {
                        System.out.println("Terima kasih telah berobat di Pet Clinic");
                        isRunning = false;
                    }

                    default -> System.out.println("Pilihan tidak valid, silahkan tekan angka 1-5.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR INPUT] Input harus berupa angka valid!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("\n[ERROR SISTEM] Terjadi kesalahan: " + e.getMessage());
            } finally {
                System.out.println("-> Blok Finally: Siklus menu sistem berjalan normal.\n");
            }
        }

        scanner.close();
    }
}