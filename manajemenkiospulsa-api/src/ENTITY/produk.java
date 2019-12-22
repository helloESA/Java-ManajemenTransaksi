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
public class produk implements Serializable{
    @TableColumn(name = "#", number = 1)
    private String id;
    @TableColumn(name = "Kode Produk", number = 2, size = 10)
    private String kode_produk;
    @TableColumn(name = "Provider", number = 3, size = 25)
    private String provider;
    @TableColumn(name = "Keterangan", number = 4, size = 25)
    private String keterangan_produk;
    @TableColumn(name = "Harga Jual", number = 5, size = 15)
    private int harga_jual;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKode_produk() {
        return kode_produk;
    }

    public void setKode_produk(String kode_produk) {
        this.kode_produk = kode_produk;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getKeterangan_produk() {
        return keterangan_produk;
    }

    public void setKeterangan_produk(String keterangan_produk) {
        this.keterangan_produk = keterangan_produk;
    }

    public int getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(int harga_jual) {
        this.harga_jual = harga_jual;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.kode_produk);
        hash = 41 * hash + Objects.hashCode(this.provider);
        hash = 41 * hash + Objects.hashCode(this.keterangan_produk);
        hash = 41 * hash + this.harga_jual;
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
        final produk other = (produk) obj;
        if (this.harga_jual != other.harga_jual) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.kode_produk, other.kode_produk)) {
            return false;
        }
        if (!Objects.equals(this.provider, other.provider)) {
            return false;
        }
        if (!Objects.equals(this.keterangan_produk, other.keterangan_produk)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "produk{" + "id=" + id + ", kode_produk=" + kode_produk + ", provider=" + provider + ", keterangan_produk=" + keterangan_produk +", harga_jual=" + harga_jual + '}';
    }
}
