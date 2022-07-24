package moneytransfer.models;

public class TransferSuccessResponse {
    private String operationId;

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public TransferSuccessResponse(String operationId) {
        this.operationId = operationId;
    }
}
