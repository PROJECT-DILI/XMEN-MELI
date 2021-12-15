package com.project.xmen.api.controller;


import com.project.xmen.application.Dto.ResponseMutan;
import com.project.xmen.application.Dto.ResponseRatio;
import com.project.xmen.application.Service.MutanService;
import com.project.xmen.application.Service.StatsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "projectXmen", tags = {"projectXmen"})
@RestController
@RequestMapping("/v1/projectXmen")
public class controller {

    @Autowired
    private MutanService mutantsService;
    @Autowired
    private StatsService statsService;

    @PostMapping("mutant")
    @ApiOperation(nickname = "Mutantes", value = "Api que valida si el ADN es de un Mutante o un Humano")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mutante!!"),
            @ApiResponse(code = 403, message = "Humano!!")
    })
    public ResponseEntity<ResponseMutan> IsMutant(@Valid @RequestBody XmenModel request, BindingResult bindingResult) {
        if (bindingResult.hasErrors() || request.getAdn().length <= 3) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return mutantsService.isMutant(request.getAdn());
    }

    @GetMapping("stats")
    @ApiOperation(nickname = "Estadistica", value = "End Point para validar el total de humanos, total de mutantes y su proporción correspondiente.")
    public ResponseEntity<ResponseRatio> getStats() {
        return statsService.stats();
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

}
