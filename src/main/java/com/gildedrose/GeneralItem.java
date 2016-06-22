package com.gildedrose;

import com.gildedrose.Item;

public class GeneralItem extends Item implements GildedRose {

	public GeneralItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateQuality() {
		// TODO Auto-generated method stub
		int decreaseAmount=1;
		if (this.sellIn <= 0)
			decreaseAmount=2;
		if(this.quality-decreaseAmount >=0)
			this.quality-=decreaseAmount;
		this.sellIn-=1;
	}

}
