package org.coursera.sustainableapps.fragment_recyclerview_challenge;

public class ItemInfo {
    public String sOwnerName, sOwnerTel, sCarModel, sCarComp;

    public ItemInfo(String sOwnerName, String sOwnerTel, String sCarModel, String sCarComp) {
        this.sOwnerName = sOwnerName;
        this.sOwnerTel = sOwnerTel;
        this.sCarModel = sCarModel;
        this.sCarComp = sCarComp;
    }

    public String getsOwnerName() {
        return sOwnerName;
    }

    public void setsOwnerName(String sOwnerName) {
        this.sOwnerName = sOwnerName;
    }

    public String getsOwnerTel() {
        return sOwnerTel;
    }

    public void setsOwnerTel(String sOwnerTel) {
        this.sOwnerTel = sOwnerTel;
    }

    public String getsCarModel() {
        return sCarModel;
    }

    public void setsCarModel(String sCarModel) {
        this.sCarModel = sCarModel;
    }

    public String getsCarComp() {
        return sCarComp;
    }

    public void setsCarComp(String sCarComp) {
        this.sCarComp = sCarComp;
    }


}
