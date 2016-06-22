package com.gildedrose;

public class Conjured extends Item implements GildedRose {

	public Conjured(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateQuality() {
		// TODO Auto-generated method stub
		int decreaseAmount=2;
		this.sellIn-=1;
		if(this.sellIn<0)
			decreaseAmount=4;
		if(this.quality-decreaseAmount>=0){
			this.quality-=decreaseAmount;
		}
	}

}
