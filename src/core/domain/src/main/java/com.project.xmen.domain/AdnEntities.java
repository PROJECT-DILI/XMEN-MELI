package com.project.xmen.domain;

import lombok.Data;

import java.util.List;

@Data
public class AdnEntities {

    private int Id;
    private String[] AdnString;
    private String TypeAdn;

    public String getTypeAdn() {
        return TypeAdn;
    }

    public void setTypeAdn(String typeAdn) {
        TypeAdn = typeAdn;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String[] getAdnString() {
        return AdnString;
    }

    public void setAdnString(String[] adnString) {
        AdnString = adnString;
    }
}
