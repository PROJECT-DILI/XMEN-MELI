package com.project.xmen.application.Dto;

import lombok.Data;

@Data
public class ResponseRatio {

    private int humans;
    private int mutants;
    private double ratio;

    public int getHumans() {
        return humans;
    }

    public void setHumans(int humans) {
        this.humans = humans;
    }

    public int getMutants() {
        return mutants;
    }

    public void setMutants(int mutants) {
        this.mutants = mutants;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}
