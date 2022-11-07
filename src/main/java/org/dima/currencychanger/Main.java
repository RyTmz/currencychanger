package org.dima.currencychanger;

import org.dima.currencychanger.Entity.Currency;
import org.dima.currencychanger.Repository.CurrencyRepository;
import org.dima.currencychanger.Util.XMLParcer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.Entity;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@Configuration
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Bean
    public ApplicationRunner applicationRunner(CurrencyRepository currencyRepository) {
        return args -> {

//            Currency currency = new Currency("1", "643", "RUB", 1, "Российский рубль", XMLParcer.getActuallyDate());
//            currency.setValue(1.0);
//            currencyRepository.save(currency);
//            currencyRepository.saveAll(XMLParcer.parseXML());
        };
    }
}
