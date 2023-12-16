package com.example.aftasapi.Errors;

public enum ErrorMessageGeneral {
    MISSING_REQUIRED_FIELD("missing required field."),
    RECORD_ALREADY_EXISTS("Record already exist "),
    RECORD_DATE_ALREADY_EXISTS("Record with this date already exist "),
    INTERNAL_SERVER_ERROR("server error"),
    NO_RECORD_FOUND("record with provided id is not found"),;

    private final String errorMessage;

    ErrorMessageGeneral(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
}
