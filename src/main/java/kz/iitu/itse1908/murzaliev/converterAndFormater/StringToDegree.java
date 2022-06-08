package kz.iitu.itse1908.murzaliev.converterAndFormater;

import kz.iitu.itse1908.murzaliev.entity.Degree;
import org.springframework.core.convert.converter.Converter;

public class StringToDegree implements Converter<String, Degree> {

    @Override
    public Degree convert(String source) {
        String[] attr = source.split(",");
        return new Degree(Long.valueOf(attr[0]),attr[1]);
    }
}
