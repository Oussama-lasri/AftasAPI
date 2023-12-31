package com.example.aftasapi.Errors;

public enum ErrorMessageHunting {
    MISSING_REQUIRED_FIELD("missing required field."),
    RECORD_ALREADY_EXISTS("Record already exist "),
    INTERNAL_SERVER_ERROR("server error"),
    NO_RECORD_FOUND("record with provided id is not found"),
    NO_MEMBER_FOUND("this member code not found"),
    NO_COMPETITION_FOUND("this Competition not found "),
    NO_FISH_FOUND("this Fish not found "),;

    private final String errorMessage;

    ErrorMessageHunting(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
}
