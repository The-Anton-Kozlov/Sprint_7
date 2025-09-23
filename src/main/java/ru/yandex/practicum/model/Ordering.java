package ru.yandex.practicum.model;

import java.util.List;

public class Ordering {
        private String firstName = "Игорь";
        private String lastName = "Муравьёв";
        private String address = "Москва, ул. Ленина, д.15, кв.1";
        private int metroStation = 2;
        private String phone = "8 900 999 99 99";
        private String rentTime = "1";
        private String deliveryDate = "2025-10-10";
        private String comment = "Пожалуйста без опозданий";
        private List<String> color;

        public Ordering(List<String> color){
            this.color = color;
        }
        public Ordering() {}

    public int getMetroStation() {
            return metroStation;
    }
    public void setMetroStation(int metroStation) {
        this.metroStation = metroStation;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getRentTime() {
        return rentTime;
    }
    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }
    public String getDeliveryDate() {
        return deliveryDate;
    }
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public List<String> getColor() {
        return color;
    }
    public void setColor(List<String> color) {
        this.color = color;
    }
}
