package moneytransfer.models;

public class ConfirmOperation {
    private String operationId;

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public ConfirmOperation(String operationId, String verificationCode) {
        this.operationId = operationId;
        this.verificationCode = verificationCode;
    }

    private String verificationCode;
}
