package com.mycompany.petclinic;

public class Unggas extends Pasien implements TindakanLanjut {
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
    
    @Override
    public void biayaPenangananLanjut() {
        System.out.println("Biaya -> Tindakan vaksin: Rp 10.000 - Rp 150.000 || Tindakan operasi: Rp 200.000 - Rp 2.000.000");
    }

    @Override
    public void prosesVaksinasi() {
        System.out.println("VAKSIN -> Vaksin Newcastle Disease diberikan pada hewan unggas.");
    }

    @Override
    public void prosesOperasi() {
        System.out.println("OPERASI -> Operasi yang dilakukan pada mamalia telah selesai ditindak.");
    }
}