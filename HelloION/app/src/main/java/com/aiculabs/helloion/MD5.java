package com.aiculabs.helloion;

/**
 * {
 "md5": "2f1767dc31e7a8dc68b2c21bf07984ff",
 "original": "ejemplo"
 }
 */
public class MD5 {
    private String md5;
    private String original;

    public MD5(String md5, String original) {
        this.md5 = md5;
        this.original = original;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    @Override
    public String toString() {
        return "MD5{" +
                "md5='" + md5 + '\'' +
                ", original='" + original + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MD5 md51 = (MD5) o;

        if (md5 != null ? !md5.equals(md51.md5) : md51.md5 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return md5 != null ? md5.hashCode() : 0;
    }
}
