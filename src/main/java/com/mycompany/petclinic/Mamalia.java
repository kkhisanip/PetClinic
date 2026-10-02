package com.mycompany.petclinic;

public class Mamalia extends Pasien {
    private String tipeBulu;
    
    public Mamalia(String nama, String jenis, String gender, String keluhan, int umur, double berat, String tipeBulu) {
        super(nama, jenis, gender, keluhan, umur, berat);
        this.tipeBulu = tipeBulu;
    }

    public String getTipeBulu() {
        return this.tipeBulu;
    }

    public void setTipeBulu(String tipeBulu) {
        this.tipeBulu = tipeBulu;
    }
    
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.printf(" | Tipe Bulu: %-15s", this.tipeBulu);
    }
    
    @Override
    public void caraPerawatan() {
        System.out.println("Hewan mamalia -> Penanganan pada pasien disesuaikan dengan keluhan yang diajukan dan diagnosis dokter.");
    }
}
