package com.gildedrose;

import java.util.ArrayList;

public class TexttestFixture {

	public static void main(String[] args) {
		System.out.println("OMGHAI!");

		ArrayList<GildedRose> items = new ArrayList<GildedRose>();
		items.add(new GeneralItem("+5 Dexterity Vest", 10, 20));
		items.add(new AgedBrie("Aged Brie", 2, 0)); //
		items.add(new GeneralItem("Elixir of the Mongoose", 5, 7));
		items.add(new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80)); //
		items.add(new Sulfuras("Sulfuras, Hand of Ragnaros", -1, 80));
		items.add(new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 10, 49));
		items.add(new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 5, 49));
		// this conjured item does not work properly yet
		items.add(new SulfurasNew("Sulfuras New", -5, 20));
		items.add(new Conjured("Conjured Mana Cake", 3, 6));

		int days = 2;
		if (args.length > 0) {
			days = Integer.parseInt(args[0]) + 1;
		}

		for (int i = 0; i < days; i++) {
			System.out.println("-------- day " + i + " --------");
			System.out.println("name, sellIn, quality");
			for (GildedRose item : items) {
				System.out.println(item);
				item.updateQuality();
			}
			System.out.println();
		}
	}

}
