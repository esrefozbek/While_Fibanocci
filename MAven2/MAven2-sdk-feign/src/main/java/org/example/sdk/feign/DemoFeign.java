package org.example.sdk.feign;

import org.example.sdk.feign.FeignConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
@FeignClient(name = "name", path = "path", url = "url", fallbackFactory = ProcessDefinitionFeign.HystrixClientFallbackFactory.class, configuration = FeignConfiguration.class)
public interface DemoFeign {

    @ResponseBody
    @PostMapping(value = "/demo/{key}", produces = {MediaType.APPLICATION_JSON_VALUE})
    String demo(@PathVariable("key") String key, @RequestBody Object dto) ;


    @Slf4j
    @Component
    class HystrixClientFallbackFactory implements FallbackFactory<DemoFeign> {

        @Override
        public DemoFeign create(final Throwable e) {
            return new DemoFeign() {
                @Override
                public String demo(@PathVariable("key") String key, @RequestBody Object dto){
                    log.error("HystrixClientFallbackFactory.demo", e);
                    return null;
                }
            };
        }
    }
}


