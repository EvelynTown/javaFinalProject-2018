package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import sides.GoodSide;

/**
 * 
 * ºùÂ«ÍŞÅÅĞòº¯Êı²âÊÔÀà
 * 
 * @author TangSiyi
 *
 */

public class GoodSideTest {

	@Test
	public void sortTest() {
		int order[] = { 1, 0, 6, 2, 3, 5, 4 };
		GoodSide goodSide = new GoodSide(order, true);
		goodSide.sortCalabash();

		for (int i = 0; i < 7; i++) {
			assertEquals(goodSide.getCalabashBrothers().get(i).getRank(), i);
		}
	}
}
