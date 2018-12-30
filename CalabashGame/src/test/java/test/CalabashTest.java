package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import creatures.Calabash;

/**
 * 
 * ºùÂ«ÍŞÃ¶¾Ù²âÊÔÀà
 * 
 * @author TangSiyi
 *
 */
public class CalabashTest {

	@Test
	public void calabashTest() {
		Calabash dawa = new Calabash(0, true);
		assertEquals("´óÍŞ", dawa.getRankName());
		
		Calabash erwa = new Calabash(1, true);
		assertEquals("¶şÍŞ", erwa.getRankName());
		
		Calabash qiwa = new Calabash(6, true);
		assertEquals("ÆßÍŞ", qiwa.getRankName());
	}
}
