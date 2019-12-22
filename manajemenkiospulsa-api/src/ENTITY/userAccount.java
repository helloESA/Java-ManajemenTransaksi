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
public class userAccount implements Serializable{
    @TableColumn(name="Id Akun", number=1, size=5)
    private String id_akun;
    @TableColumn(name="Nama Asli", number=2, size=30)
    private String nama_asli;
    @TableColumn(name="Jenis Kelamin", number=3, size=5)
    private String jenis_kelamin;
    @TableColumn(name="Nama Akun", number=4, size=20)
    private String nama_akun;
    private String password;
    @TableColumn(name="Bagian", number=5, size=15)
    private String bagian;
    @TableColumn(name="Alamat", number=6, size=20)
    private String alamat;
    @TableColumn(name="No Telepon", number=7, size=10)
    private String no_telp;

    public String getId_akun() {
        return id_akun;
    }

    public void setId_akun(String id_akun) {
        this.id_akun = id_akun;
    }

    public String getNama_asli() {
        return nama_asli;
    }

    public void setNama_asli(String nama_asli) {
        this.nama_asli = nama_asli;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNama_akun() {
        return nama_akun;
    }

    public void setNama_akun(String nama_akun) {
        this.nama_akun = nama_akun;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBagian() {
        return bagian;
    }

    public void setBagian(String bagian) {
        this.bagian = bagian;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id_akun);
        hash = 59 * hash + Objects.hashCode(this.nama_asli);
        hash = 59 * hash + Objects.hashCode(this.jenis_kelamin);
        hash = 59 * hash + Objects.hashCode(this.nama_akun);
        hash = 59 * hash + Objects.hashCode(this.password);
        hash = 59 * hash + Objects.hashCode(this.bagian);
        hash = 59 * hash + Objects.hashCode(this.alamat);
        hash = 59 * hash + Objects.hashCode(this.no_telp);
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
        final userAccount other = (userAccount) obj;
        if (!Objects.equals(this.id_akun, other.id_akun)) {
            return false;
        }
        if (!Objects.equals(this.nama_asli, other.nama_asli)) {
            return false;
        }
        if (!Objects.equals(this.jenis_kelamin, other.jenis_kelamin)) {
            return false;
        }
        if (!Objects.equals(this.nama_akun, other.nama_akun)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.bagian, other.bagian)) {
            return false;
        }
        if (!Objects.equals(this.alamat, other.alamat)) {
            return false;
        }
        if (!Objects.equals(this.no_telp, other.no_telp)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "userAccount{" + "id_akun=" + id_akun + ", nama_asli=" + nama_asli + ", jenis_kelamin=" + jenis_kelamin + ", nama_akun=" + nama_akun + ", password=" + password + ", bagian=" + bagian + ", alamat=" + alamat + ", no_telp=" + no_telp + '}';
    }
           
}
