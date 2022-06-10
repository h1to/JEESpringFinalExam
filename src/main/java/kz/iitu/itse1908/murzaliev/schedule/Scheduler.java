package kz.iitu.itse1908.murzaliev.schedule;

import kz.iitu.itse1908.murzaliev.configuration.CurrentWeekAndYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    private CurrentWeekAndYear currentWeek;

    @Autowired
    public Scheduler(CurrentWeekAndYear currentWeek) {
        this.currentWeek = currentWeek;
    }

    @Async("threadPoolTaskScheduler")
    @Scheduled(fixedDelayString = "${fixedDelay}", initialDelayString = "${initialDelay}")
    public void changeWeek () {
        int week = currentWeek.getWeek();
        if (week <= 0 || week >= 16) {
            currentWeek.setWeek(1);
        }
        else {
            currentWeek.setWeek(currentWeek.getWeek()+1);
        }
        System.out.println("Week - " + currentWeek.getWeek());
    }

    @Async("threadPoolTaskScheduler")
    @Scheduled(cron = "${cronExpression}")
    public void changeYear () {
        int year = currentWeek.getYear();
        year += 1;
        currentWeek.setYear(year);
        System.out.println("Year - " + currentWeek.getYear());
    }
}
