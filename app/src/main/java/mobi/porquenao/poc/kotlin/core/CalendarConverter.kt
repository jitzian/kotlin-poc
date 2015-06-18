package mobi.porquenao.poc.kotlin.core

import com.raizlabs.android.dbflow.converter.TypeConverter

import java.util.Calendar

@com.raizlabs.android.dbflow.annotation.TypeConverter
public class CalendarConverter : TypeConverter<Long, Calendar>() {

    override fun getDBValue(model: Calendar): Long? {
        return model.getTimeInMillis()
    }

    override fun getModelValue(data: Long?): Calendar {
        val calendar = Calendar.getInstance()
        calendar.setTimeInMillis(data!!)
        return calendar
    }

}
