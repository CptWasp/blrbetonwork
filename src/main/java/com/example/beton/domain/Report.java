package com.example.beton.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String reportname;

    private Integer reportcreatecount;
    private Integer reportcreatetotal;
    private Integer reportcreatemencount;

    private Integer reportsalecount;
    private Integer reportsaletotal;


    public Report() {
    }

    public Report(String reportname, Integer reportcreatecount,
                  Integer reportcreatetotal, Integer reportcreatemencount,
                  Integer reportsalecount, Integer reportsaletotal) {
        this.reportname = reportname;
        this.reportcreatecount = reportcreatecount;
        this.reportcreatetotal = reportcreatetotal;
        this.reportcreatemencount = reportcreatemencount;
        this.reportsalecount = reportsalecount;
        this.reportsaletotal = reportsaletotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportname() {
        return reportname;
    }

    public void setReportname(String reportname) {
        this.reportname = reportname;
    }

    public Integer getReportcreatecount() {
        return reportcreatecount;
    }

    public void setReportcreatecount(Integer reportcreatecount) {
        this.reportcreatecount = reportcreatecount;
    }

    public Integer getReportcreatetotal() {
        return reportcreatetotal;
    }

    public void setReportcreatetotal(Integer reportcreatetotal) {
        this.reportcreatetotal = reportcreatetotal;
    }

    public Integer getReportcreatemencount() {
        return reportcreatemencount;
    }

    public void setReportcreatemencount(Integer reportcreatemencount) {
        this.reportcreatemencount = reportcreatemencount;
    }

    public Integer getReportsalecount() {
        return reportsalecount;
    }

    public void setReportsalecount(Integer reportsalecount) {
        this.reportsalecount = reportsalecount;
    }

    public Integer getReportsaletotal() {
        return reportsaletotal;
    }

    public void setReportsaletotal(Integer reportsaletotal) {
        this.reportsaletotal = reportsaletotal;
    }
}
