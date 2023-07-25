package dev.clement.wine.exception;

import org.springframework.http.HttpStatus;

public class WineException extends RuntimeException {

    private static final long serialVersionUID = -4046244778647249855L;

    private final ErrorCode errorCode;
    private final String technicalMessage;
    private final String publicMessage;
    private final HttpStatus httpStatus;
    private final boolean log;

    public WineException(ErrorCode errorCode, String publicMessage, boolean log) {
        super(errorCode.getTechnicalMessage());
        this.errorCode = errorCode;
        this.publicMessage = publicMessage.replaceAll("%s", "");
        this.log = log;
        technicalMessage = errorCode.getTechnicalMessage();
        httpStatus = errorCode.getHttpStatus();
    }

    public WineException(ErrorCode errorCodeEnum) {
        this(errorCodeEnum, errorCodeEnum.getPublicMessage(), true);
    }

    public WineException(ErrorCode errorCodeEnum, boolean log) {
        this(errorCodeEnum, errorCodeEnum.getPublicMessage(), log);
    }

    public WineException(ErrorCode errorCodeEnum, Object... publicMessageArguments) {
        this(errorCodeEnum, errorCodeEnum.getPublicMessage().formatted(publicMessageArguments), true);
    }

    public WineException(String message, HttpStatus status) {
        super(message);
        this.httpStatus = status;
        this.technicalMessage = message;
        this.publicMessage = message;
        this.log = true;
        this.errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public String getTechnicalMessage() {
        return this.technicalMessage;
    }

    public String getPublicMessage() {
        return this.publicMessage;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public boolean isLog() {
        return this.log;
    }

    public String toString() {
        return "WineException(errorCodeEnum=" + this.getErrorCode() + ", technicalMessage=" + this.getTechnicalMessage() + ", publicMessage=" + this.getPublicMessage() + ", httpStatus=" + this.getHttpStatus() + ", log=" + this.isLog() + ")";
    }
}
