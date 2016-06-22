package com.gildedrose;

import com.gildedrose.Item;

public class BackstagePasses extends Item implements GildedRose {

	public BackstagePasses(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateQuality() {
		// TODO Auto-generated method stub
		int increaseAmount=1;	
		this.sellIn-=1;
		if(this.sellIn<0)
			this.quality=0;
		else if(this.quality<50){
			if(this.sellIn<6)
				increaseAmount=3;
			else if(this.sellIn<10 && this.sellIn>=6)
				increaseAmount=2;
			if(this.quality+increaseAmount<50)
				this.quality+=increaseAmount; 
		}
		
	}

}
