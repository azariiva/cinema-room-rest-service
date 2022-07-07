package cinema;

import cinema.config.CinemaRoomConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@ConfigurationPropertiesScan("cinema.config")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
