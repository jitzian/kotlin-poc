package mobi.porquenao.poc.kotlin.core

import com.raizlabs.android.dbflow.annotation.Database

Database(name = AppDatabase.NAME, version = AppDatabase.VERSION, generatedClassSeparator = "_")
public object AppDatabase {
    public val NAME: String = "app"
    public val VERSION: Int = 1
}
