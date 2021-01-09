package org.coursera.sustainableapps.recyclerviewfragmentchallenge;

public class CarOwner {
    public String owner,tel,car,model;

    public CarOwner(String owner, String tel, String car, String model) {
        this.owner = owner;
        this.tel = tel;
        this.car = car;
        this.model = model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
