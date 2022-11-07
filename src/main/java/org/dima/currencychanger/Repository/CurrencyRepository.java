package org.dima.currencychanger.Repository;

import org.dima.currencychanger.Entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Long> {
   @Query(value = "SELECT max(Currency.date) FROM Currency",
           nativeQuery = true)
   List<Date> getLastDate();

}
