package org.example.sdk.feign;
import org.example.sdk.feign.BearerRsaAuthRequestInterceptor;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FeignConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "feign.authentication", name = "enabled", havingValue = "true")
    public BearerRsaAuthRequestInterceptor bearerRsaAuthRequestInterceptor()  {
        return new BearerRsaAuthRequestInterceptor();
    }

    @Bean
    public ErrorDecoder feignErrorDecoder() {
        return new CustomerFeignErrorDecoder();
    }


    public class CustomerFeignErrorDecoder implements ErrorDecoder {
        @Override
        public Exception decode(String methodKey, Response response) {
            HttpStatus status = HttpStatus.valueOf(response.status());
            String body = null;
            String message = null;
            if (!status.is2xxSuccessful() && response.body() != null && response.body().length() > 0) {
                try {
                    body = IOUtils.toString(response.body().asInputStream(), StandardCharsets.UTF_8.toString());
                } catch (IOException e) {
                    message = e.getMessage();
                }
            }
            FeignException exception = FeignException.errorStatus(methodKey, response);
            throw new RuntimeException(body);
        }
    }
}