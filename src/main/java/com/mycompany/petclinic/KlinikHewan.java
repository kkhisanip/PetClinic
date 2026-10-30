package com.mycompany.petclinic;

import java.util.ArrayList;
import java.util.HashMap;

public class KlinikHewan {
    private String namaKlinik;
    private RuangPeriksa ruangPeriksaUtama;
    private ArrayList<Pasien> daftarPasien;
    private HashMap<String, Owner> dataOwner;

    public KlinikHewan(String namaKlinik) {
        this.namaKlinik = namaKlinik;
        this.ruangPeriksaUtama = new RuangPeriksa("Ruang Periksa Utama", 6);
        this.daftarPasien = new ArrayList<>();
        this.dataOwner = new HashMap<>();
    }

    public void bukaKlinik() {
        System.out.println("\n*** Menginisialisasi sistem " + this.namaKlinik + " ***");
        this.ruangPeriksaUtama.bukaRuangan();
    }

    public void tambahPasien(Pasien p) {
        daftarPasien.add(p);
    }

    public void tambahOwner(Owner o) {
        dataOwner.put(o.getIdOwner(), o);
    }

    public void lihatSemuaPasien() {
        if (daftarPasien.isEmpty()) {
            System.out.println("Belum ada pasien yang tersimpan");
        } else {
            for (int i = 0; i < daftarPasien.size(); i++) {
                System.out.print((i + 1) + ". ");
                daftarPasien.get(i).tampilkanInfo();
                System.out.println();
                daftarPasien.get(i).caraPerawatan();
                daftarPasien.get(i).biayaPenangananLanjut();
                System.out.println();
            }
        }
    }

    public void cariPasien(String nama) throws PasienTidakDitemukanException {
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
        if (!ditemukan) {
            throw new PasienTidakDitemukanException("Gagal: Pasien dengan nama '" 
                    + nama + "' tidak ditemukan di sistem");
        }
    }
    
    public void lihatSemuaOwner() {
        System.out.println("Total Owner Terdaftar: " + dataOwner.size());
        for (Owner o : dataOwner.values()) {
            System.out.println("- ID: " + o.getIdOwner() + " | Nama: " + o.getNama());
        }
    }

    public void cariOwner(String idOwner) {
        if (dataOwner.containsKey(idOwner)) {
            System.out.println("Ditemukan! Nama Owner: " + dataOwner.get(idOwner).getNama());
        } else {
            System.out.println("Owner dengan ID tersebut tidak terdaftar");
        }
    }

    public Owner getOwner(String idOwner) {
        return dataOwner.get(idOwner);
    }

    public Pasien getPasienInt(int index) {
        return daftarPasien.get(index);
    }

    public int getJumlahPasien() {
        return daftarPasien.size();
    }
}
