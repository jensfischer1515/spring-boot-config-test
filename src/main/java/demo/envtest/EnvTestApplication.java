package demo.envtest;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(EnvTestApplication.EnvTestProperties.class)
@RequiredArgsConstructor
public class EnvTestApplication implements ApplicationRunner {

    private final EnvTestProperties envTestProperties;

    public static void main(String[] args) {
        SpringApplication.run(EnvTestApplication.class, args).close();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.warn("{}", envTestProperties);
    }

    @Data
    @Validated
    @ConfigurationProperties(prefix = "env.test-prefix")
    public static class EnvTestProperties {

        @Length(min = 1, max = 20)
        private String name;

        @NotNull
        private Container container;

        @Data
        public static class Container {

            @Length(min = 1, max = 20)
            private String singleValue;

            @NotEmpty
            private List<String> multiValue;
        }
    }
}
