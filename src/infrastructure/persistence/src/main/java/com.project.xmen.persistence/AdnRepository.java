package com.project.xmen.persistence;

import com.project.xmen.domain.AdnEntities;
import com.project.xmen.persistence.configuration.AppConfig;
import com.project.xmen.persistence.mapper.AdnMapper;
import com.project.xmen.persistence.model.AdnInterface;
import com.project.xmen.persistence.model.AdnModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdnRepository implements AdnInterface {

    @Autowired
    private AppConfig appConfig;

    @Override
    public List<AdnModel> list() {

        /*String sql = "SELECT * FROM ADN";

        List<AdnModel> adnModels = appConfig.jdbcTemplate().query(sql, new AdnMapper());

        return adnModels;*/
        return null;
    }

    @Override
    public AdnEntities create(AdnEntities adnEntities) {

        //@formatter:off
        String sql = new StringBuilder().append("INSERT INTO  ")
                .append(" ADN(ADN_STRING, TYPE_ADN) ")
                .append(" VALUES(?, ?)").toString();
        //@formatter:on

        appConfig.jdbcTemplate().update(sql, String.join(",", adnEntities.getAdnString()),adnEntities.getTypeAdn());

        return adnEntities;
    }

    @Override
    public List<AdnEntities> adnExist(String[] adn) {

        String sql = "SELECT * FROM ADN WHERE ADN_STRING = ?";

        List<AdnEntities> adnEntities = appConfig.jdbcTemplate().query(sql, new AdnMapper(), String.join(",", adn));

        return adnEntities;
    }

    @Override
    public List<AdnEntities> countHumans() {

        String sql = "SELECT * FROM ADN WHERE TYPE_ADN = ?";

        List<AdnEntities> adnEntities = appConfig.jdbcTemplate().query(sql, new AdnMapper(),"HUMANO");

        return adnEntities;
    }

    @Override
    public List<AdnEntities> countMutants() {
        String sql = "SELECT * FROM ADN WHERE TYPE_ADN = ?";

        List<AdnEntities> adnEntities = appConfig.jdbcTemplate().query(sql, new AdnMapper(),"MUTANTE");

        return adnEntities;
    }


}
