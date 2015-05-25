package mobi.porquenao.poc.kotlin.core;

import com.raizlabs.android.dbflow.converter.TypeConverter;

import java.util.Calendar;

@com.raizlabs.android.dbflow.annotation.TypeConverter
public class CalendarConverter extends TypeConverter<Long, Calendar> {

    @Override
    public Long getDBValue(Calendar model) {
        return model.getTimeInMillis();
    }

    @Override
    public Calendar getModelValue(Long data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(data);
        return calendar;
    }

}
