package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class CategoryItemImpl {

    public final static Map<String, CategoryItem> ITEM_TYPES_LIST = new HashMap<>();
    public final static String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public final static String BRIE = "Aged Brie";
    public final static String BACKSTAGE_PASSES_ITEM = "Backstage passes to a TAFKAL80ETC concert";

    public CategoryItemImpl(Item item) {
        ITEM_TYPES_LIST.put(SULFURAS, new Sulfuras());
        ITEM_TYPES_LIST.put(BRIE, new AgedBrie(item));
        ITEM_TYPES_LIST.put(BACKSTAGE_PASSES_ITEM, new BackstagePassesItem(item));
    }

    public CategoryItem findCategoryItem(Item item) {
        if (isStandardItem(item)) {
            return new StandardItem(item);
        }
        return ITEM_TYPES_LIST.get(item.name);
    }

    public boolean isStandardItem(Item item) {
        return !ITEM_TYPES_LIST.keySet().contains(item.name);
    }
}
