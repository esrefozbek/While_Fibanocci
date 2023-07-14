package org.example.junit.demo;

import org.example.junit.base.AbstractBaseTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import static org.mockito.Mockito.*;


@Slf4j
@Transactional
@Sql("classpath:h2/dml/demo.sql")
@DisplayName("Demo测试类")
class DemoTest extends AbstractBaseTest {

    @Test
    @DisplayName("测试方法")
    void test(){
        Assertions.assertNotNull("not null");
    }

}