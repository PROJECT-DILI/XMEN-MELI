package com.project.xmen.application.Service;

import com.project.xmen.domain.AdnEntities;
import com.project.xmen.persistence.AdnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.project.xmen.application.Dto.ResponseMutan;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

@Service
@Transactional
public class MutanService {

    @Autowired
    private AdnRepository adnRepository;
    AdnEntities adnEntities = new AdnEntities();

    public ResponseEntity<ResponseMutan> isMutant(String[] adn){

        ResponseMutan responseEntity = new ResponseMutan();

        AdnEntities validation = validatiteIfExistsAdn(adn);
        if (validation.getTypeAdn().equals("MUTANTE")){
            responseEntity.setStatus(Boolean.TRUE);
            responseEntity.setDescriptions("Mutante!!");
            return new ResponseEntity<>(responseEntity, HttpStatus.OK);
        }if (validation.getTypeAdn().equals("HUMANO")){
            responseEntity.setStatus(Boolean.FALSE);
            responseEntity.setDescriptions("Humano!!");
            return new ResponseEntity<>(responseEntity, HttpStatus.FORBIDDEN);
        }

        char[][] matriz = new char[adn.length][adn.length];

        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
                matriz[x][y] = adn[x].charAt(y);
            }
        }
        if (oblicua(matriz)|| vertical(matriz)||horizontal(matriz)){
            adnEntities.setAdnString(adn);
            adnEntities.setTypeAdn("MUTANTE");
            adnRepository.create(adnEntities);
            responseEntity.setStatus(Boolean.TRUE);
            responseEntity.setDescriptions("Mutante!!");
            return new ResponseEntity<>(responseEntity, HttpStatus.OK);
        }
        adnEntities.setAdnString(adn);
        adnEntities.setTypeAdn("HUMANO");
        adnRepository.create(adnEntities);
        responseEntity.setStatus(Boolean.FALSE);
        responseEntity.setDescriptions("Humano!!");
        return new ResponseEntity<>(responseEntity, HttpStatus.FORBIDDEN);
    }

    boolean horizontal(char[][] matriz){

        int result = 1;
        System.out.println("Longitud"+matriz.length);
        for (int x=0; x<matriz.length; x++){
            for (int y=0; y < matriz[x].length; y++) {
                if (y>0 && matriz[x][y]==matriz[x][y-1])
                {
                    result ++;
                }else{
                    result = 1;
                }
                if (result>=4) {
                    return true;
                }
            }
            result = 1;
        }

        return false;
    }

    boolean vertical(char[][] matriz){

        int result = 1;
        System.out.println("Longitud"+matriz.length);
        for (int y=0; y<matriz[0].length; y++){
            for (int x=0; x < matriz.length; x++) {
                if (x>0 && matriz[x][y]==matriz[x-1][y])
                {
                    result ++;
                }else{
                    result = 1;
                }
                if (result>=4) {
                    return true;
                }
            }result = 1;
        }
        return false;
    }

    boolean oblicua(char[][] matriz) {

        //ESQUINA SUPERIOR DERECHA
        int result = 1;
        char[][] matrizResponse = new char[matriz.length][matriz.length];
        for (int i = 1 - matriz.length; i < matriz.length; i++){
            for (int x = -min(0, i), y = max(0, i); x < matriz.length && y < matriz.length; x++, y++){
                if (matriz[x][y]==matrizResponse[x][y]){
                    matrizResponse[x][y] = matriz[x][y];
                    result ++;
                }else{
                    result = 1;
                }
                if (result>=4) {
                    return true;
                }
            }
            result = 1;
        }

        //ESQUINA INFERIOR DERECHA
        System.out.println();
        int contador = (matriz.length+matriz.length)-1;
        for (int i = 1-matriz.length; i < matriz.length; i++){
            for (int x = -min(0,i), y = min(5,contador-1); x < matriz.length && y >= 0; x++, y--){
                if (matriz[x][y]==matrizResponse[x][y]){
                    matrizResponse[x][y] = matriz[x][y];
                    result ++;
                }else{
                    result = 1;
                }
                if (result>=4) {
                    return true;
                }
            }
            contador --;
            result = 1;
        }

        return false;
    }

    AdnEntities validatiteIfExistsAdn(String[] adn){

        List<AdnEntities> result = adnRepository.adnExist(adn);
        if (result.size()==0){
            AdnEntities adnEntities = new AdnEntities();
            adnEntities.setTypeAdn("NULL");
            return adnEntities;
        };
        AdnEntities a = result.get(0);
        return a;

    }
}
