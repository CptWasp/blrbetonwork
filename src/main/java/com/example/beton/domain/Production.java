package com.example.beton.domain;

import javax.persistence.*;

@Entity
public class Production {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String productdate;
    private String prodname;
    private String prodcount;
    private String mencount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;


    public Production() {
    }

    public Production(String productdate, String prodname, String prodcount, String mencount, User user) {
        this.author = user;
        this.productdate = productdate;
        this.prodname = prodname;
        this.prodcount = prodcount;
        this.mencount = mencount;
    }

    public String getAuthorName(){
        return author != null ? author.getUsername() : "Господин без имени";
    }

    public Integer getId() {
        if(id != null) {
            return id;
        }else{
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

    public String getProductdate() {
        if(productdate != null) {
            return productdate;
        }else {
            return  "Дата не указана";
        }
    }

    public void setProductdate(String productdate) {
        this.productdate = productdate;
    }

    public String getProdname() {
        if(prodname != null) {
            return prodname;
        }else {
            return  "Не указано название товара";
        }
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public String getProdcount() {
        if(prodcount != null) {
            return prodcount;
        }else {
            return  "Не указано количество";
        }
    }

    public void setProdcount(String prodcount) {
        this.prodcount = prodcount;
    }

    public String getMencount() {
        if(mencount != null) {
            return mencount;
        }else {
            return  "Не указано количество";
        }
    }

    public void setMencount(String mencount) {
        this.mencount = mencount;
    }


}
