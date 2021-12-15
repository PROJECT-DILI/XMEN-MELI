package com.project.xmen.application.Service;

import com.project.xmen.application.Dto.ResponseRatio;
import com.project.xmen.domain.AdnEntities;
import com.project.xmen.persistence.AdnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StatsService {

    @Autowired
    private AdnRepository adnRepository;

    public ResponseEntity<ResponseRatio> stats (){

        ResponseRatio responseRatio = new ResponseRatio();
        List<AdnEntities> humans = adnRepository.countHumans();
        List<AdnEntities> mutants = adnRepository.countMutants();
        int count_humans = humans.size();
        int count_mutants = mutants.size();
        double ratio = count_humans == 0?0.0:count_mutants/count_humans;


        responseRatio.setHumans(count_humans);
        responseRatio.setMutants(count_mutants);
        responseRatio.setRatio(ratio);

        return new ResponseEntity<>(responseRatio, HttpStatus.OK);
    }

}
