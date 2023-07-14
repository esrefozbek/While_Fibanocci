package org.example.sdk.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Util;

public class BearerRsaAuthRequestInterceptor implements RequestInterceptor {

    public BearerRsaAuthRequestInterceptor() {
    }


    public void apply(RequestTemplate template) {
        try {
            template.header("Authorization", new String[]{"Bearer token"});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
