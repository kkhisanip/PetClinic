package com.mycompany.petclinic;

public class Pisces extends Pasien implements TindakanLanjut {
    private String tipeAir;

    public Pisces(String nama, String jenis, String gender, String keluhan, int umur, double berat, String tipeAir) throws Exception {
        super(nama, jenis, gender, keluhan, umur, berat);
        this.tipeAir = tipeAir;
    }

    public String getTipeAir() { return this.tipeAir; }
    public void setTipeAir(String tipeAir) { this.tipeAir = tipeAir; }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf(" | Tipe Air: %-15s", this.tipeAir);
    }

    @Override
    public void caraPerawatan() {
        System.out.println("Hewan pisces -> Penanganan pada pasien disesuaikan dengan keluhan yang diajukan dan diagnosis dokter");
    }

    @Override
    public void biayaPenangananLanjut() {
        System.out.println("Biaya -> Tindakan vaksin: Rp 45.000 || Tindakan operasi: Rp 80.000 - Rp 150.000");
    }

    @Override
    public void prosesVaksinasi() {
        System.out.println("VAKSIN -> vaksin aeromonas untuk hewan pisces");
    }

    @Override
    public void prosesOperasi() {
        System.out.println("OPERASI -> operasi pada hewan pisces dilakukan berdasarkan diagnosis");
    }
}