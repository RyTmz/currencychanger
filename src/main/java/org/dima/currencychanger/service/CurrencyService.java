package org.dima.currencychanger.service;

import org.dima.currencychanger.Entity.Currency;
import org.dima.currencychanger.Repository.CurrencyRepository;
import org.dima.currencychanger.Util.XMLParcer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;


    public CurrencyService(CurrencyRepository currencyRepository){
        this.currencyRepository = currencyRepository;
    }
    public void addAllCurencies(){
        List<Date> localDates = currencyRepository.getLastDate();
        if(checkTable() && currencyRepository.getLastDate().get(0).equals(Date.from(XMLParcer.getActuallyDate().atStartOfDay(ZoneId.systemDefault()).toInstant()))){

        }
        else {
            Currency currency = new Currency("1", "643", "RUB", 1, "Российский рубль", XMLParcer.getActuallyDate());
            currency.setValue(1.0);
            XMLParcer.getAllCurrencies().add(currency);
            currencyRepository.saveAll(XMLParcer.parseXML());
        }
    }

    public boolean checkTable(){
        Optional<Currency> optional =  currencyRepository.findById((long) 1);
        return optional.isPresent();
    }

    public List<Currency> getCurrencyList(){
       return currencyRepository.findAll();
    }

    public Currency findById(Long id){
        Optional<Currency> optional =  currencyRepository.findById(id);
        return optional.get();
    }
}
