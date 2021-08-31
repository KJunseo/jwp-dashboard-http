package nextstep.jwp.httpserver.exception;

import nextstep.jwp.httpserver.domain.response.StatusCode;

public class EntityNotFoundException extends GlobalException {
    public EntityNotFoundException(String message) {
        super(message, StatusCode.BAD_REQUEST);
    }
}
