/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author MohamadEsa
 */
public class numberField implements Serializable{
    private String awalan="";
    private int panjangField;
    private String namaField;
    private String namaTabel;

    public String getAwalan() {
        return awalan;
    }

    public void setAwalan(String awalan) {
        this.awalan = awalan;
    }

    public int getPanjangField() {
        return panjangField;
    }

    public void setPanjangField(int panjangField) {
        this.panjangField = panjangField;
    }

    public String getNamaField() {
        return namaField;
    }

    public void setNamaField(String namaField) {
        this.namaField = namaField;
    }

    public String getNamaTabel() {
        return namaTabel;
    }

    public void setNamaTabel(String namaTabel) {
        this.namaTabel = namaTabel;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.awalan);
        hash = 89 * hash + this.panjangField;
        hash = 89 * hash + Objects.hashCode(this.namaField);
        hash = 89 * hash + Objects.hashCode(this.namaTabel);
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
        final numberField other = (numberField) obj;
        if (this.panjangField != other.panjangField) {
            return false;
        }
        if (!Objects.equals(this.awalan, other.awalan)) {
            return false;
        }
        if (!Objects.equals(this.namaField, other.namaField)) {
            return false;
        }
        if (!Objects.equals(this.namaTabel, other.namaTabel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "numberField{" + "awalan=" + awalan + ", panjangField=" + panjangField + ", namaField=" + namaField + ", namaTabel=" + namaTabel + '}';
    }
}
