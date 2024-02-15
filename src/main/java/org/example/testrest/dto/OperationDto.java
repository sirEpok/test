package org.example.testrest.dto;

import jakarta.validation.constraints.NotNull;

public class OperationDto {
    @NotNull
    String valletId;
    String operationType;
    double amount;

    public OperationDto(String valletId, String operationType, double amount) {
        this.valletId = valletId;
        this.operationType = operationType;
        this.amount = amount;
    }

    public String getValletId() {
        return valletId;
    }
    public void setValletId(String valletId) {
        this.valletId = valletId;
    }
    public String getOperationType() {
        return operationType;
    }
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
