package com.gildedrose;

import com.gildedrose.Item;

public class SulfurasNew extends Item implements GildedRose {

	public SulfurasNew(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateQuality() {
		// TODO Auto-generated method stub
		int decreaseAmount=1;
		if(this.quality>10)
			this.quality-=decreaseAmount;
		this.sellIn-=1;
	}

}
