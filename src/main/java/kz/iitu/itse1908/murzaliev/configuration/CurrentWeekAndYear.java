package kz.iitu.itse1908.murzaliev.configuration;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Scope("singleton")
@Component
public class CurrentWeekAndYear {
    private int week;
    private int year;
}
