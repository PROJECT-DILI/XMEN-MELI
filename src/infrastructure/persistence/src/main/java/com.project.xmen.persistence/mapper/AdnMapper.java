package com.project.xmen.persistence.mapper;

import com.project.xmen.domain.AdnEntities;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdnMapper implements RowMapper<AdnEntities> {

    @Override
    public AdnEntities mapRow(ResultSet rs, int rowNum) throws SQLException {

        var entity = new AdnEntities();

        entity.setId(rs.getInt("ID"));
        //entity.setAdn_string(rs.getString("ADN_STRING"));
        entity.setTypeAdn(rs.getString("TYPE_ADN"));

        return entity;
    }

}
