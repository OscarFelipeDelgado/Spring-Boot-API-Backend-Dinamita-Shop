package com.dinamita.dinamitademo.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.lang.Enum;


@Entity
@Table(name = "orders")
public class orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// nos ayuda a que nuestro ID se vaya autoincrementando
    @Column(name = "id")
    private int id;

    @Column(name = "order_number")
    private String order_number;

    @Column(name = "user_id")
    private int user_id;
/*
    @Column(name = "status")
    private Enum status;
*/
    @Column(name = "grand_total")
    private double grand_total;

    @Column(name = "item_count")
    private int item_count;

    @Column(name = "is_paid")
    private int is_paid;
/*
    @Column(name = "payment_method")
    private Enum payment_method;
*/
    @Column(name = "shipping_fullname")
    private String shipping_fullname;

    /*
    @Column(name = "shipping_address")
    private String shipping_address;

    @Column(name = "shipping_city")
    private String shipping_city;

    @Column(name = "shipping_state")
    private String shipping_state;

    @Column(name = "shipping_zipcode")
    private String shipping_zipcode;

    @Column(name = "shipping_phone")
    private String shipping_phone;

    @Column(name = "billing_fullname")
    private String billing_fullname;

    @Column(name = "billing_address")
    private String billing_address;

    @Column(name = "billing_city")
    private String billing_city;

    @Column(name = "billing_state")
    private String billing_state;

    @Column(name = "billing_zipcode")
    private String billing_zipcode;

    @Column(name = "billing_phone")
    private String billing_phone;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;
*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
/*
    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }
*/
    public double getGrand_total() {
        return grand_total;
    }

    public void setGrand_total(double grand_total) {
        this.grand_total = grand_total;
    }

    public int getItem_count() {
        return item_count;
    }

    public void setItem_count(int item_count) {
        this.item_count = item_count;
    }

    public int getIs_paid() {
        return is_paid;
    }

    public void setIs_paid(int is_paid) {
        this.is_paid = is_paid;
    }
/*
    public Enum getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(Enum payment_method) {
        this.payment_method = payment_method;
    }
*/
    public String getShipping_fullname() {
        return shipping_fullname;
    }

    public void setShipping_fullname(String shipping_fullname) {
        this.shipping_fullname = shipping_fullname;
    }

    /*
    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    public String getShipping_city() {
        return shipping_city;
    }

    public void setShipping_city(String shipping_city) {
        this.shipping_city = shipping_city;
    }

    public String getShipping_state() {
        return shipping_state;
    }

    public void setShipping_state(String shipping_state) {
        this.shipping_state = shipping_state;
    }

    public String getShipping_zipcode() {
        return shipping_zipcode;
    }

    public void setShipping_zipcode(String shipping_zipcode) {
        this.shipping_zipcode = shipping_zipcode;
    }

    public String getShipping_phone() {
        return shipping_phone;
    }

    public void setShipping_phone(String shipping_phone) {
        this.shipping_phone = shipping_phone;
    }

    public String getBilling_fullname() {
        return billing_fullname;
    }

    public void setBilling_fullname(String billing_fullname) {
        this.billing_fullname = billing_fullname;
    }

    public String getBilling_address() {
        return billing_address;
    }

    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }

    public String getBilling_city() {
        return billing_city;
    }

    public void setBilling_city(String billing_city) {
        this.billing_city = billing_city;
    }

    public String getBilling_state() {
        return billing_state;
    }

    public void setBilling_state(String billing_state) {
        this.billing_state = billing_state;
    }

    public String getBilling_zipcode() {
        return billing_zipcode;
    }

    public void setBilling_zipcode(String billing_zipcode) {
        this.billing_zipcode = billing_zipcode;
    }

    public String getBilling_phone() {
        return billing_phone;
    }

    public void setBilling_phone(String billing_phone) {
        this.billing_phone = billing_phone;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
    */
}
