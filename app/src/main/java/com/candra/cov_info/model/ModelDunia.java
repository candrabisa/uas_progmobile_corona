package com.candra.cov_info.model;

import com.google.gson.annotations.SerializedName;

public class ModelDunia {
    @SerializedName("last_update")
    private String updateTerakhir;
    @SerializedName("confirmed")
    private Terkonfirmasi terkonfirmasi;
    @SerializedName("deaths")
    private Meninggal meninggal;
    @SerializedName("recovered")
    private Sembuh sembuh;

    public ModelDunia(String updateTerakhir, Terkonfirmasi terkonfirmasi, Meninggal meninggal, Sembuh sembuh) {
        this.updateTerakhir = updateTerakhir;
        this.terkonfirmasi = terkonfirmasi;
        this.meninggal = meninggal;
        this.sembuh = sembuh;
    }

    public String getUpdateTerakhir() {
        return updateTerakhir;
    }

    public void setUpdateTerakhir(String updateTerakhir) {
        this.updateTerakhir = updateTerakhir;
    }

    public Terkonfirmasi getTerkonfirmasi() {
        return terkonfirmasi;
    }

    public void setTerkonfirmasi(Terkonfirmasi terkonfirmasi) {
        this.terkonfirmasi = terkonfirmasi;
    }

    public Meninggal getMeninggal() {
        return meninggal;
    }

    public void setMeninggal(Meninggal meninggal) {
        this.meninggal = meninggal;
    }

    public Sembuh getSembuh() {
        return sembuh;
    }

    public void setSembuh(Sembuh sembuh) {
        this.sembuh = sembuh;
    }

//    Class

    public class Meninggal{
        @SerializedName("value")
        private int value;
        @SerializedName("detail")
        private String detail;

        public Meninggal(int value, String detail){
            this.value = value;
            this.detail = detail;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }

    public class Sembuh{
        @SerializedName("value")
        private int value;
        @SerializedName("detail")
        private String detail;

        public Sembuh(int value, String detail){
            this.value = value;
            this.detail = detail;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
    public class Terkonfirmasi{
        @SerializedName("value")
        private int value;
        @SerializedName("detail")
        private String detail;

        public Terkonfirmasi(int value, String detail){
            this.value = value;
            this.detail = detail;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
}
