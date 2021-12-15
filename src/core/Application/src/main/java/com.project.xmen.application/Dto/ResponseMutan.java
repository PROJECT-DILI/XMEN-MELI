package com.project.xmen.application.Dto;

import lombok.Data;

@Data
public class ResponseMutan {

    private Boolean Status;
    private String Descriptions;

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public String getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(String descriptions) {
        Descriptions = descriptions;
    }
}
