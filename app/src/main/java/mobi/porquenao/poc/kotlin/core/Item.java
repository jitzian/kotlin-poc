package mobi.porquenao.poc.kotlin.core;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Calendar;

@Table(tableName = "items", databaseName = AppDatabase.NAME)
public class Item extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column(name = "id")
    protected long mId;

    @Column(name = "updated_at")
    protected Calendar mUpdatedAt = Calendar.getInstance();

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public Calendar getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(Calendar updatedAt) {
        mUpdatedAt = updatedAt;
    }

}
