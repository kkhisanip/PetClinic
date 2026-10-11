package com.mycompany.petclinic;

public class Mamalia extends Pasien implements TindakanLanjut {
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
    
    @Override
    public void biayaPenangananLanjut() {
        System.out.println("Biaya -> Tindakan vaksin: Rp 35.000 - Rp 450.000 || Tindakan operasi: Rp 250.000 - Rp 4.500.000");
    }

    @Override
    public void prosesVaksinasi() {
        System.out.println("VAKSIN -> Vaksin rabies berhasil diberikan pada hewan mamalia.");
    }

    @Override
    public void prosesOperasi() {
        System.out.println("OPERASI -> Operasi yang dilakukan pada mamalia telah selesai ditindak.");
    }
}
