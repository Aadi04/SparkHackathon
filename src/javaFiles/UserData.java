package javaFiles;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserData
{
    private final StringProperty day;
    private final StringProperty bedTime;
    private final StringProperty timeWokeUp;
    private final StringProperty totalHoursOfSleep;

    public UserData(String day, String bedTime, String timeWokeUp, String totaHoursOfSleep)
    {
        this.day = new SimpleStringProperty(day);
        this.bedTime = new SimpleStringProperty(bedTime);
        this.timeWokeUp = new SimpleStringProperty(timeWokeUp);
        this.totalHoursOfSleep = new SimpleStringProperty(totaHoursOfSleep);
    }

    public String getDay()
    {
        return day.get();
    }

    public StringProperty dayProperty()
    {
        return day;
    }

    public void setDay(String day)
    {
        this.day.set(day);
    }

    public String getBedTime()
    {
        return bedTime.get();
    }

    public StringProperty bedTimeProperty()
    {
        return bedTime;
    }

    public void setBedTime(String bedTime)
    {
        this.bedTime.set(bedTime);
    }

    public String getTimeWokeUp()
    {
        return timeWokeUp.get();
    }

    public StringProperty timeWokeUpProperty()
    {
        return timeWokeUp;
    }

    public void setTimeWokeUp(String timeWokeUp)
    {
        this.timeWokeUp.set(timeWokeUp);
    }

    public String getTotalHoursOfSleep()
    {
        return totalHoursOfSleep.get();
    }

    public StringProperty totalHoursOfSleepProperty()
    {
        return totalHoursOfSleep;
    }

    public void setTotalHoursOfSleep(String totalHoursOfSleep)
    {
        this.totalHoursOfSleep.set(totalHoursOfSleep);
    }


}
