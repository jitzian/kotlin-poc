package mobi.porquenao.poc.kotlin.core;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION, generatedClassSeparator = "_")
public class AppDatabase {

    public static final String NAME = "app";
    public static final int VERSION = 1;

}
