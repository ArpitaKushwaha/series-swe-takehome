package com.gildedrose;

public class AgedBrie implements CategoryItem {

    private final Item item;
    public AgedBrie(Item item) {
        this.item = item;
    }
    @Override
    public void updateState() {
        decreaseSellByDayValueByOne();
        if (sellByDayValueIsOverZero()) {
            increaseQualityBy(increasingValueOverZeroDaysToSell());
        } else {
            increaseQualityBy(increasingValueForZeroOrLessDaysToSell());
        }
    }

    private void decreaseSellByDayValueByOne() {
        item.sellIn -= 1;
    }

    private void increaseQualityBy(int qualityValue) {
        item.quality += qualityValue;
    }

    public int increasingValueOverZeroDaysToSell() {
        return 1;
    }

    private boolean sellByDayValueIsOverZero() {
        return item.sellIn >= 0;
    }

    private int increasingValueForZeroOrLessDaysToSell() {
        return increasingValueOverZeroDaysToSell() * 2;
    }
}
