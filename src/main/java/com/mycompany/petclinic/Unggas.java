package com.mycompany.petclinic;

public class Unggas extends Pasien {
    private String tipeTerbang;

    public Unggas(String nama, String jenis, String gender, String keluhan, int umur, double berat, String tipeTerbang) {
        super(nama, jenis, gender, keluhan, umur, berat);
        this.tipeTerbang = tipeTerbang;
    }

    public String getTipeTerbang() {
        return this.tipeTerbang;
    }

    public void setTipeTerbang(String tipeTerbang) {
        this.tipeTerbang = tipeTerbang;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf(" | Tipe Terbang: %-15s", this.tipeTerbang);
    }

    @Override
    public void caraPerawatan() {
        System.out.println("Hewan unggas -> Penanganan pada pasien disesuaikan dengan keluhan yang diajukan dan diagnosis dokter.");
    }
}