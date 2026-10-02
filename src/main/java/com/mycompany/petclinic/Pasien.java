package com.mycompany.petclinic;

public class Pasien {
    private String nama;
    private String jenis;
    private String gender;
    private String keluhan;
    private int umur;
    private double berat;
    
    public static int totalPasienBerhasilDibuat = 0;
    
    public Pasien(String nama, String jenis, String gender,  String keluhan, int umur, double berat) {
        this.nama = nama;
        this.jenis = jenis;
        this.gender = gender;
        this.keluhan = keluhan;
        this.umur = umur;
        this.berat = berat;
        
        totalPasienBerhasilDibuat++;
    }
    
    public String getNama() {
        return this.nama;
    }
    
    public String getJenis() {
        return this.jenis;
    }
    
    public String getGender() {
        return this.gender;
    }
    
    public String getKeluhan() {
        return this.keluhan;
    }
    
    public int getUmur() {
        return this.umur;
    }
    
    public double getBerat() {
        return this.berat;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }
    
    public void setUmur(int umur) {
        if (umur >= 0) {
            this.umur = umur;
        } else {
            System.out.println("Umur tidak valid.");
            this.umur = 0;
        }
    }
    
    public void setBerat(double berat) {
        if (berat > 0.0) {
            this.berat = berat;
        } else {
            System.out.println("Berat badan tidak valid.");
            this.berat = 1.0;
        }
    }
    
    public void tampilkanInfo() {
        System.out.printf("Nama: %s | Jenis: %s | Gender: %s | Keluhan: %s "
                + "| Umur: %d bln | Berat: %3.1f kg",
                this.nama, this.jenis, this.gender, this.keluhan, this.umur, this.berat);
    }
    
    public void caraPerawatan() {
        System.out.println("Pasien akan mendapatkan pemeriksaan dan perawatan sesuai prosedur klinik hewan");
    }
}
