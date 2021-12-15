package com.project.xmen.persistence.model;

import com.project.xmen.domain.AdnEntities;

import java.util.List;

public interface AdnInterface {

    List<AdnModel> list();

    AdnEntities create(AdnEntities adnEntities);

    List<AdnEntities> adnExist(String[] adn);

    List<AdnEntities> countHumans();

    List<AdnEntities> countMutants();

}
