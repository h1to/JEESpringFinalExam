package kz.iitu.itse1908.murzaliev.converterAndFormater;

import kz.iitu.itse1908.murzaliev.entity.Degree;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class DegreeFormatter implements Formatter<Degree> {

    @Override
    public Degree parse(String text, Locale locale) throws ParseException {
        if (text != null) {
            String[] attr =text.split(",");
            if (attr.length == 2) {
                Degree degree = new Degree();
                degree.setDegreeId(Long.valueOf(attr[0]));
                degree.setName(attr[1]);
                return degree;
            }
            else {
                return null;
            }
        }
        return null;
    }

    @Override
    public String print(Degree object, Locale locale) {
        if(object == null) {
            return "";
        }
        else {
            return String.format(locale, "%s, %s", object.getDegreeId(), object.getName());
        }
    }
}
