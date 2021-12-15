package com.project.xmen.api;

import com.project.xmen.api.controller.XmenModel;
import com.project.xmen.api.controller.controller;
import com.project.xmen.application.Dto.ResponseMutan;
import com.project.xmen.application.Service.MutanService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class apiTest {

    @Mock
    private MutanService mutanService;

    @InjectMocks
    private controller xmenController;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void isMutantBadRequestTest() {
        XmenModel xmenModel = new XmenModel();
        BindingResult bindingResult = Mockito.mock(BindingResult.class);
        String [] adn = {};
        xmenModel.setAdn(adn);
        ResponseEntity<ResponseMutan> response = xmenController.IsMutant(xmenModel,bindingResult);

        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void isMutantSuccessTest() {
        XmenModel xmenModel = new XmenModel();
        BindingResult bindingResult = Mockito.mock(BindingResult.class);
        String [] adn = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        xmenModel.setAdn(adn);

        Mockito.when(mutanService.isMutant(xmenModel.getAdn())).thenReturn(new ResponseEntity<>(null, HttpStatus.OK));
        ResponseEntity<ResponseMutan> response = xmenController.IsMutant(xmenModel, bindingResult);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

}
