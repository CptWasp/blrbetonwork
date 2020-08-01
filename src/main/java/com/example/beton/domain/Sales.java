package com.example.beton.domain;

import javax.persistence.*;

@Entity
public class Sales {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String saledate;
    private String salename;
    private String saletotal;
    private String salecount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;


    public Sales() {
    }

    public Sales(String saledate, String salename, String saletotal, String salecount, User user) {
        this.author = user;
        this.saledate = saledate;
        this.salename = salename;
        this.saletotal = saletotal;
        this.salecount = salecount;
    }

    public String getAuthorName(){
        return author != null ? author.getUsername() : "Господин без имени";
    }

    public String getSaledate() {
        if(saledate != null) {
            return saledate;
        }else{
            return "дата не указана";
        }
    }

    public void setSaledate(String saledate) {
        this.saledate = saledate;
    }

    public Integer getId() {
        if (id != null) {
            return id;
        } else {
            return 0;
        }
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getSalename() {
        if(salename != null) {
        return salename;
        }else {
           return  "Название не указано";
        }
    }

    public void setSalename(String salename) {

        this.salename = salename;
    }

    public String getSaletotal() {
        if(saletotal != null) {
            return saletotal;
        }else {
            return  "Цена не указано";
        }

    }

    public void setSaletotal(String saletotal) {
        this.saletotal = saletotal;
    }

    public String getSalecount() {

        if(salecount != null) {
            return salecount;
        }else {
            return  "Количество не указано";
        }
    }

    public void setSalecount(String salecount) {
        this.salecount = salecount;
    }
}
