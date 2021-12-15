package com.project.xmen.persistence.model;


import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

public class AdnModel {

    @Id
    @Column(name = "`ID`")
    private Integer id;

    @Column(name = "ADN_STRING")
    private String[] adn_string;

    @Column(name = "TYPE_ADN")
    private String type_adn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String[] getAdn_string() {
        return adn_string;
    }

    public void setAdn_string(String[] adn_string) {
        this.adn_string = adn_string;
    }

    public String getType_adn() {
        return type_adn;
    }

    public void setType_adn(String type_adn) {
        this.type_adn = type_adn;
    }

}
