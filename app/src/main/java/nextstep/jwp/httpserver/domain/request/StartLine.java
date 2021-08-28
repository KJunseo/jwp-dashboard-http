package nextstep.jwp.httpserver.domain.request;

import nextstep.jwp.httpserver.domain.HttpMethod;
import nextstep.jwp.httpserver.domain.HttpVersion;

public class StartLine {
    private final static String SEPARATOR = " ";

    private final HttpMethod httpMethod;
    private final String requestTarget;
    private final HttpVersion httpVersion;

    public StartLine(HttpMethod httpMethod, String requestTarget, HttpVersion httpVersion) {
        this.httpMethod = httpMethod;
        this.requestTarget = requestTarget;
        this.httpVersion = httpVersion;
    }

    public static StartLine from(String line) {
        String[] piece = line.split(SEPARATOR);
        return new StartLine(HttpMethod.valueOf(piece[0]), piece[1], HttpVersion.version(piece[2]));
    }

    public boolean isPost() {
        return HttpMethod.POST == httpMethod;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getRequestTarget() {
        return requestTarget;
    }

    public HttpVersion getHttpVersion() {
        return httpVersion;
    }
}
