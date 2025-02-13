package nextstep.jwp.httpserver.exception;

import nextstep.jwp.httpserver.domain.response.StatusCode;

public class DuplicatedException extends GlobalException {
    public DuplicatedException(String message) {
        super(message, StatusCode.BAD_REQUEST);
    }
}
