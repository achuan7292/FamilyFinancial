package com.family.domain;

public class Invest {
    private Integer id;

    private String iname;

    private Double ibasic;

    private Float irate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname == null ? null : iname.trim();
    }

    public Double getIbasic() {
        return ibasic;
    }

    public void setIbasic(Double ibasic) {
        this.ibasic = ibasic;
    }

    public Float getIrate() {
        return irate;
    }

    public void setIrate(Float irate) {
        this.irate = irate;
    }
}