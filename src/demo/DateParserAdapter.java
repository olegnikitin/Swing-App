package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParserAdapter {

    private final SimpleDateFormat simpleDateFormat;

    public DateParserAdapter(String pattern) {
        this.simpleDateFormat = new SimpleDateFormat(pattern);
    }

    public Date toDate(String date) {
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public String dateAsString(Date date) {
        return simpleDateFormat.format(date);
    }
}
