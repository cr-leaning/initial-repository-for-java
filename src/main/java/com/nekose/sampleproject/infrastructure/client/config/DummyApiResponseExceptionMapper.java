package com.nekose.sampleproject.infrastructure.client.config;

import com.nekose.sampleproject.exception.ApiClientException;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;
import org.springframework.http.HttpStatus;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.Objects;

public class DummyApiResponseExceptionMapper implements ResponseExceptionMapper<ApiClientException> {
    @Override
    public boolean handles(int statusCode, MultivaluedMap<String, Object> headers) {
        return statusCode == 404  // Not Found
                || statusCode == 409; // Conflict
    }

    @Override
    public ApiClientException toThrowable(Response response) {
        switch(response.getStatus()) {
            case 404:
            case 409:
                return new ApiClientException(Objects.requireNonNull(HttpStatus.resolve(response.getStatus())), null, "test");
        }
        return null;
    }

}
