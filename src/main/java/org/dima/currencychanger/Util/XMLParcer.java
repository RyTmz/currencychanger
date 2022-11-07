package org.dima.currencychanger.Util;

import org.dima.currencychanger.Entity.Currency;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class XMLParcer {
    private static List<Currency> currencyList = new ArrayList<>();
    private static LocalDate date = null;
    private static String URL = "https://cbr.ru/scripts/XML_daily.asp";
    public static List<Currency> parseXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(URL);
            NodeList valutesElements = document.getDocumentElement().getElementsByTagName("Valute");
            NodeList ValCurs = document.getElementsByTagName("ValCurs");
            date = getDate(ValCurs);
            setCurrencyList(valutesElements, date);
            return currencyList;

        } catch (Exception e) {

        }
        return currencyList;
    }

    private static void setCurrencyList(NodeList nodeList, LocalDate date) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element elem = (Element) node;
            Currency currency = new Currency(elem.getAttribute("ID"), elem.getElementsByTagName("NumCode").item(0).getTextContent(), elem.getElementsByTagName("CharCode").item(0).getTextContent(), Integer.parseInt(elem.getElementsByTagName("Nominal").item(0).getTextContent()), elem.getElementsByTagName("Name").item(0).getTextContent(), date);
            DecimalFormat df = new DecimalFormat();
            DecimalFormatSymbols symbol = new DecimalFormatSymbols();
            symbol.setDecimalSeparator(',');
            symbol.setGroupingSeparator(' ');
            df.setDecimalFormatSymbols(symbol);
            try{
                currency.setValue((Double) df.parse((elem.getElementsByTagName("Value").item(0).getTextContent())));
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            currencyList.add(currency);
        }

    }
   public static List<Currency> getAllCurrencies() {
        return currencyList;
    }

    public static LocalDate getDate(NodeList nodeList){
        Node node = nodeList.item(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) node;
            date = LocalDate.parse((elem.getAttribute("Date")), formatter);
            return LocalDate.parse((elem.getAttribute("Date")), formatter);
        }
        return null;
    }
    public static LocalDate getActuallyDate(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(URL);
            NodeList ValCurs = document.getElementsByTagName("ValCurs");
            date = getDate(ValCurs);
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }
        return date;
    }
}

