package mobi.porquenao.poc.kotlin.core;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

public class ItemRepository {

    private ItemRepository() {}

    public static List<Item> getAll() {
        return new Select().from(Item.class).where().orderBy(false, Item_Table.UPDATED_AT).queryList();
    }

}
