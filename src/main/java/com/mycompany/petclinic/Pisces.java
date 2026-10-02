package com.mycompany.petclinic;

public class Pisces extends Pasien {
    private String tipeAir;

    public Pisces(String nama, String jenis, String gender, String keluhan, int umur, double berat, String tipeAir) {
        super(nama, jenis, gender, keluhan, umur, berat);
        this.tipeAir = tipeAir;
    }

    public String getTipeAir() {
        return this.tipeAir;
    }

    public void setTipeAir(String tipeAir) {
        this.tipeAir = tipeAir;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf(" | Tipe Air: %-15s", this.tipeAir);
    }

    @Override
    public void caraPerawatan() {
        System.out.println("Hewan pisces -> Penanganan pada pasien disesuaikan dengan keluhan yang diajukan dan diagnosis dokter.");
    }
}