package dev.clement.wine.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    /**
     * APPLICATION
     */
    INTERNAL_SERVER_ERROR(1001, "INTERNAL_SERVER_ERROR", "Une erreur est survenue.", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_DATA_ARGUMENT_ERROR(1002, "BAD_DATA_ARGUMENT_ERROR", "Erreur dans le format des paramètres d'entrée : %s", HttpStatus.BAD_REQUEST),
    NOT_IMPLEMENTED_YET(1003, "NOT_IMPLEMENTED_YET", "%s", HttpStatus.NOT_IMPLEMENTED),
    NOT_FOUND(1004, "RESOURCE NOT FOUND", "%s", HttpStatus.NOT_FOUND);

    private final Integer code;
    private final String technicalMessage;
    private final String publicMessage;
    private final HttpStatus httpStatus;

    ErrorCode(Integer code, String technicalMessage, String publicMessage, HttpStatus httpStatus) {
        this.code = code;
        this.technicalMessage = technicalMessage;
        this.publicMessage = publicMessage;
        this.httpStatus = httpStatus;
    }

    public Integer getCode() {
        return code;
    }

    public String getTechnicalMessage() {
        return technicalMessage;
    }

    public String getPublicMessage() {
        return publicMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
