package com.gildedrose.mysolution;

import org.junit.Test;

import com.gildedrose.AgedBrie;
import com.gildedrose.BackstagePasses;
import com.gildedrose.Conjured;
import com.gildedrose.GeneralItem;
import com.gildedrose.Sulfuras;
import com.gildedrose.SulfurasNew;

import static org.junit.Assert.assertEquals;

public class NewGildedRoseTest {

	@Test
	public void shouldDecreaseQualityTwiceIfSellByDateIsPassed() {
		// given
		GeneralItem generalItem = new GeneralItem("+5 Dexterity Vest", 0, 20);

		// when
		generalItem.updateQuality();
		// then
		assertEquals(-1, generalItem.sellIn);
		assertEquals(18, generalItem.quality);
	}

	@Test
	public void qualityOfItemShouldNotBeNegative() {
		// given
		GeneralItem generalItem = new GeneralItem("+5 Dexterity Vest", 0, 0);
		// when
		generalItem.updateQuality();
		// then
		assertEquals(-1, generalItem.sellIn);
		assertEquals(0, generalItem.quality);
	}

	@Test
	public void shouldIncreaseQualityOf_AgedBrie_OlderItGets() {
		// given
		AgedBrie agedBrie = new AgedBrie("Aged Brie", 2, 0);
		// when
		agedBrie.updateQuality();
		agedBrie.updateQuality();
		agedBrie.updateQuality();
		agedBrie.updateQuality();
		agedBrie.updateQuality();
		agedBrie.updateQuality();
		agedBrie.updateQuality();
		agedBrie.updateQuality();
		agedBrie.updateQuality();
		agedBrie.updateQuality();
		// then
		assertEquals(-8, agedBrie.sellIn);
		assertEquals(10, agedBrie.quality);

	}

	// - The Quality of an item is never more than 50 except "Sulfuras", being a
	// legendary item
	@Test
	public void shouldAllowQualityMoreThan50ForLegendaryItems_Sulfuras() {
		// given
		AgedBrie agedBrie = new AgedBrie("Aged Brie", 2, 50);
		Sulfuras sulfuras = new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80);

		// when
		agedBrie.updateQuality();
		// then
		assertEquals(1, agedBrie.sellIn);
		assertEquals(50, agedBrie.quality);

		sulfuras.updateQuality();
		assertEquals(0, sulfuras.sellIn);
		assertEquals(80, sulfuras.quality);

	}

	@Test
	public void shouldNotIncreaseOrDecreaseLegendaryItemQualityAndItIsNotToBeSold_Sulfuras() {
		// given
		Sulfuras sulfuras = new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80);
		// when
		sulfuras.updateQuality();
		// then
		assertEquals(0, sulfuras.sellIn);
		assertEquals(80, sulfuras.quality);
	}

	// - "Backstage passes", like aged brie, increases in Quality as it's SellIn
	// value approaches; Quality increases by 2 when there are 10 days or less
	// and by 3 when there are 5 days or less but Quality drops to 0 after the
	// concert
	@Test
	public void shouldIncreaseInQualityBy1_IfMoreThan10Days_BackstagePasses() {
		// given
		BackstagePasses backstagePasses = new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 15, 20);
		// when
		backstagePasses.updateQuality();
		// then
		assertEquals(14, backstagePasses.sellIn);
		assertEquals(21, backstagePasses.quality);
	}

	@Test
	public void shouldIncreaseInQualityBy2_IfLessThanOrEqualTo10Days_BackstagePasses() {
		// given
		BackstagePasses backstagePasses= new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 10, 20);
		// when
		backstagePasses.updateQuality();
		// then
		assertEquals(9, backstagePasses.sellIn);
		assertEquals(22, backstagePasses.quality);
	}

	@Test
	public void shouldIncreaseInQualityBy3_IfLessThanOrEqualTo5Days_BackstagePasses() {
		// given
		BackstagePasses backstagePasses=new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 5, 20);
		// when
		backstagePasses.updateQuality();
		// then
		assertEquals(4, backstagePasses.sellIn);
		assertEquals(23, backstagePasses.quality);

	}

	@Test
	public void shouldZeroTheQualityAfterSellInDate_BackstagePasses() {
		// given
		BackstagePasses backstagePasses= new BackstagePasses("Backstage passes to a TAFKAL80ETC concert", 0, 20);
		// when
		backstagePasses.updateQuality();
		// then
		assertEquals(-1, backstagePasses.sellIn);
		assertEquals(0, backstagePasses.quality);
	}

	@Test
	public void shouldDegradeQualityBy2ForConjuredItems() {
		// given
		Conjured conjured= new Conjured("Conjured Mana Cake", -3, 6);
		// when
		conjured.updateQuality();
		// then
		assertEquals(-4, conjured.sellIn);
		assertEquals(2, conjured.quality);
	}

	@Test
	public void shouldNotDecreaseQualityBelow10_ButWillDecreaseByOneForEveryDecInSellIn_Sulfuras_New() {
		// given
		SulfurasNew sulfurasNew= new SulfurasNew("Sulfuras, New Product", 1, 11);
		// when
		sulfurasNew.updateQuality();
		assertEquals(0, sulfurasNew.sellIn);
		assertEquals(10, sulfurasNew.quality);

		sulfurasNew.updateQuality();
		assertEquals(-1, sulfurasNew.sellIn);
		assertEquals(10, sulfurasNew.quality);
		// then
	}

}
