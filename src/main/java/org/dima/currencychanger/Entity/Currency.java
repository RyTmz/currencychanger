package org.dima.currencychanger.Entity;




import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "currency")
public class Currency {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;
    @Column(name = "name")
    private String name;

    @Column(name = "valute_id")
    private String valuteId;

    @Column(name = "num_code")
    private String numCode;

    @Column(name = "char_code")
    private String charCode;

    @Column(name = "nominal")
    private int nominal;

    @Column(name = "value")
    private double value;

    @Column(name = "Date")
    private LocalDate date;

    public String getValuteId() {
        return valuteId;
    }

    public void setValuteId(String valuteId) {
        this.valuteId = valuteId;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Currency() {
    }

    public Currency(String valuteId, String numCode, String charCode, int nominal, String name, LocalDate date) {
        this.valuteId = valuteId;
        this.charCode = charCode;
        this.numCode = numCode;
        this.nominal = nominal;
        this.name = name;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id='" + id + '\'' +
                "valuteId='" + valuteId + '\'' +
                ", name='" + name + '\'' +
                ", valuteId=" + valuteId +
                ", numCode='" + numCode + '\'' +
                ", charCode='" + charCode + '\'' +
                ", nominal=" + nominal +
                ", value=" + value +
                ", date=" + date +
                '}';
    }
}
