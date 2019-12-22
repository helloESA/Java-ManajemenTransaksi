/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author MohamadEsa
 */
public class transaksi implements Serializable{
    @TableColumn(name = "#", number = 1)
    private String id_transaksi;
    @TableColumn(name="Waktu Transaksi", number=2)
    private String waktu_trx;
    private String tanggal_trx;
    @TableColumn(name="Kode Produk", number=3)
    private produk produk;
    @TableColumn(name="Keterangan Produk", number=4)
    private String keterangan_produk;
    @TableColumn(name="No Tujuan", number=5)
    private String no_tujuan;
    @TableColumn(name="Harga", number=6)
    private int harga;
    @TableColumn(name="Status Transaksi", number=7)
    private String status_trx;
    @TableColumn(name="Tanggal Bayar", number=8)
    private String tgl_bayar;
    @TableColumn(name="No SN/Voucher", number=9)
    private String no_voucher;
    @TableColumn(name = "Catatan", number = 10)
    private String catatan;

    public String getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getWaktu_trx() {
        return waktu_trx;
    }

    public void setWaktu_trx(String waktu_trx) {
        this.waktu_trx = waktu_trx;
    }

    public String getTanggal_trx() {
        return tanggal_trx;
    }

    public void setTanggal_trx(String tanggal_trx) {
        this.tanggal_trx = tanggal_trx;
    }

    public produk getProduk() {
        return produk;
    }

    public void setProduk(produk produk) {
        this.produk = produk;
    }

    public String getKeterangan_produk() {
        return keterangan_produk;
    }

    public void setKeterangan_produk(String keterangan_produk) {
        this.keterangan_produk = keterangan_produk;
    }

    public String getNo_tujuan() {
        return no_tujuan;
    }

    public void setNo_tujuan(String no_tujuan) {
        this.no_tujuan = no_tujuan;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getStatus_trx() {
        return status_trx;
    }

    public void setStatus_trx(String status_trx) {
        this.status_trx = status_trx;
    }

    public String getTgl_bayar() {
        return tgl_bayar;
    }

    public void setTgl_bayar(String tgl_bayar) {
        this.tgl_bayar = tgl_bayar;
    }

    public String getNo_voucher() {
        return no_voucher;
    }

    public void setNo_voucher(String no_voucher) {
        this.no_voucher = no_voucher;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id_transaksi);
        hash = 13 * hash + Objects.hashCode(this.waktu_trx);
        hash = 13 * hash + Objects.hashCode(this.tanggal_trx);
        hash = 13 * hash + Objects.hashCode(this.produk);
        hash = 13 * hash + Objects.hashCode(this.keterangan_produk);
        hash = 13 * hash + Objects.hashCode(this.no_tujuan);
        hash = 13 * hash + this.harga;
        hash = 13 * hash + Objects.hashCode(this.status_trx);
        hash = 13 * hash + Objects.hashCode(this.tgl_bayar);
        hash = 13 * hash + Objects.hashCode(this.no_voucher);
        hash = 13 * hash + Objects.hashCode(this.catatan);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final transaksi other = (transaksi) obj;
        if (this.harga != other.harga) {
            return false;
        }
        if (!Objects.equals(this.id_transaksi, other.id_transaksi)) {
            return false;
        }
        if (!Objects.equals(this.waktu_trx, other.waktu_trx)) {
            return false;
        }
        if (!Objects.equals(this.tanggal_trx, other.tanggal_trx)) {
            return false;
        }
        if (!Objects.equals(this.keterangan_produk, other.keterangan_produk)) {
            return false;
        }
        if (!Objects.equals(this.no_tujuan, other.no_tujuan)) {
            return false;
        }
        if (!Objects.equals(this.status_trx, other.status_trx)) {
            return false;
        }
        if (!Objects.equals(this.tgl_bayar, other.tgl_bayar)) {
            return false;
        }
        if (!Objects.equals(this.no_voucher, other.no_voucher)) {
            return false;
        }
        if (!Objects.equals(this.catatan, other.catatan)) {
            return false;
        }
        if (!Objects.equals(this.produk, other.produk)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "transaksi{" + "id_transaksi=" + id_transaksi + ", waktu_trx=" + waktu_trx + ", tanggal_trx=" + tanggal_trx + ", kode_produk=" + produk + ", keterangan_produk=" + keterangan_produk + ", no_tujuan=" + no_tujuan + ", harga=" + harga + ", status_trx=" + status_trx + ", tgl_bayar=" + tgl_bayar + ", no_voucher=" + no_voucher + ", catatan=" + catatan + '}';
    }

}
