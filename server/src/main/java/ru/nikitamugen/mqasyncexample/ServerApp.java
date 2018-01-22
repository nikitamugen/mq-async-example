package ru.nikitamugen.mqasyncexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.nikitamugen.mqasyncexample.model.EmptyKey;
import ru.nikitamugen.mqasyncexample.model.ImDictionary;

@SpringBootApplication
public class ServerApp {

    @Bean
    public ImDictionary<String, String> words() {
        return new EmptyKey<>();
    }

	public static void main(String[] args) {
	    SpringApplication.run(ServerApp.class, args);
	}
}
