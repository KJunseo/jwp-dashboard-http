package nextstep.jwp.httpserver.domain.response;

import java.util.Map;

import nextstep.jwp.httpserver.domain.Body;
import nextstep.jwp.httpserver.domain.Headers;
import nextstep.jwp.httpserver.domain.HttpVersion;
import nextstep.jwp.httpserver.domain.StatusCode;

public class HttpResponse {
    private StatusLine statusLine;
    private Headers headers;
    private Body body;

    public static class Builder {
        private StatusLine statusLine;
        private Headers headers;
        private Body body;

        public Builder() {
            headers = new Headers();
        }

        public Builder statusCode(StatusCode code) {
            this.statusLine = new StatusLine(code);
            return this;
        }

        public Builder header(String key, String value) {
            this.headers.addHeader(key, value);
            return this;
        }

        public Builder body(Map<String, String> body) {
            this.body = new Body(body);
            return this;
        }

        public HttpResponse build() {
            return new HttpResponse(this);
        }
    }

    private HttpResponse(Builder builder) {
        this.statusLine = builder.statusLine;
        this.headers = builder.headers;
        this.body = builder.body;
    }

    public String statusLine() {
        final HttpVersion httpVersion = statusLine.getHttpVersion();
        final StatusCode statusCode = statusLine.getStatusCode();
        return httpVersion.getVersion() + " " + statusCode.getCode() + " " + statusCode.getStatusText() + " ";
    }

    public String getLocation() {
        Map<String, String> headers = this.headers.getHeaders();
        return headers.get("Location");
    }

    public StatusLine getStatusLine() {
        return statusLine;
    }

    public Headers getHeaders() {
        return headers;
    }

    public Body getBody() {
        return body;
    }
}
