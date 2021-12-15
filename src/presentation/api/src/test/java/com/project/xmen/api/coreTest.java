package com.project.xmen.api;

import com.project.xmen.application.Dto.ResponseMutan;
import com.project.xmen.application.Dto.ResponseRatio;
import com.project.xmen.application.Service.MutanService;
import com.project.xmen.application.Service.StatsService;
import com.project.xmen.domain.AdnEntities;
import com.project.xmen.persistence.AdnRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class coreTest {


    @InjectMocks
    private MutanService mutanService;
    @InjectMocks
    private StatsService statsService;
    @Mock
    private AdnRepository adnRepository;

    private static final double DELTA = 1e-15;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void isNotMutanTest(){

        Mockito.when(adnRepository.adnExist(Mockito.any())).thenReturn(getAdnEntitiesList());
        Mockito.when(adnRepository.create(Mockito.any())).thenReturn(getAdnEntities());

        String[] adn = {"abcdef","hijklm","nopqrs","tuvwxy","zabcde","fghijk"};
        ResponseEntity<ResponseMutan> responseMutanResponseEntity =  mutanService.isMutant(adn);

        Assert.assertEquals(false, responseMutanResponseEntity.getBody().getStatus());

    }

    @Test
    public void isMutanTest(){

        Mockito.when(adnRepository.adnExist(Mockito.any())).thenReturn(getMutantAdnEntitiesList());
        Mockito.when(adnRepository.create(Mockito.any())).thenReturn(getMutantAdnEntities());

        String[] adn = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};;
        ResponseEntity<ResponseMutan> responseMutanResponseEntity =  mutanService.isMutant(adn);

        Assert.assertEquals(true, responseMutanResponseEntity.getBody().getStatus());

    }

    @Test
    public void stats(){

        Mockito.when(adnRepository.countHumans()).thenReturn(getAdnEntitiesList());
        Mockito.when(adnRepository.countMutants()).thenReturn(getMutantAdnEntitiesList());
        ResponseEntity<ResponseRatio> responseRatioResponseEntity =  statsService.stats();

        Assert.assertEquals(HttpStatus.OK, responseRatioResponseEntity.getStatusCode());
        Assert.assertEquals(1.0, responseRatioResponseEntity.getBody().getRatio(),DELTA);
    }


    private List<AdnEntities> getMutantAdnEntitiesList(){

        List<AdnEntities> list = new ArrayList<>();
        AdnEntities adnEntities = getMutantAdnEntities();


        list.add(adnEntities);
        return list;
    }

    private AdnEntities getMutantAdnEntities(){
        AdnEntities adnEntities = new AdnEntities();

        adnEntities.setId(0);
        adnEntities.setAdnString(new String[] {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
        adnEntities.setTypeAdn("MUTANTE");

        return adnEntities;
    }

    private List<AdnEntities> getAdnEntitiesList(){

        List<AdnEntities> list = new ArrayList<>();
        AdnEntities adnEntities = getAdnEntities();


        list.add(adnEntities);
        return list;
    }

    private AdnEntities getAdnEntities(){
        AdnEntities adnEntities = new AdnEntities();

        adnEntities.setId(0);
        adnEntities.setAdnString(new String[] {"abcdef","hijklm","nopqrs","tuvwxy","zabcde","fghijk"});
        adnEntities.setTypeAdn("HUMANO");

        return adnEntities;
    }
}
