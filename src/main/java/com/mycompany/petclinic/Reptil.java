package com.mycompany.petclinic;

public class Reptil extends Pasien implements TindakanLanjut {
    private String tipeHabitat;

    public Reptil(String nama, String jenis, String gender, String keluhan, int umur, double berat, String tipeHabitat) throws Exception {
        super(nama, jenis, gender, keluhan, umur, berat);
        this.tipeHabitat = tipeHabitat;
    }

    public String getTipeHabitat() { return this.tipeHabitat; }
    public void setTipeHabitat(String tipeHabitat) { this.tipeHabitat = tipeHabitat; }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf(" | Tipe Habitat: %-15s", this.tipeHabitat);
    }

    @Override
    public void caraPerawatan() {
        System.out.println("Hewan reptil -> Penanganan pada pasien disesuaikan dengan keluhan yang diajukan dan diagnosis dokter");
    }

    @Override
    public void biayaPenangananLanjut() {
        System.out.println("Biaya -> Tindakan vaksin: Tidak ada || Tindakan operasi: Rp 200.000 - Rp 450.000");
    }

    @Override
    public void prosesVaksinasi() {
        System.out.println("VAKSIN -> Tidak ada vaksin untuk hewan reptil");
    }

    @Override
    public void prosesOperasi() {
        System.out.println("OPERASI -> operasi pada hewan reptil dilakukan berdasarkan diagnosis");
    }
}