package com.gildedrose;

import com.gildedrose.Item;

public class AgedBrie extends Item implements GildedRose {

	public AgedBrie(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateQuality() {
		// TODO Auto-generated method stub
		int increaseAmount=1;
		if(this.quality<50){
			this.quality+=increaseAmount;
		}
		this.sellIn-=1;
	}

}
