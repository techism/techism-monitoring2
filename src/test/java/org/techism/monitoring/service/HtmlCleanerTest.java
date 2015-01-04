package org.techism.monitoring.service;

import static org.junit.Assert.assertEquals;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class) 
public class HtmlCleanerTest {
	
	@Test
	public void test_cleanComments() {
		String beforeCleanup = "<html><head></head><body><div><!-- comment1 --><p>bar<!-- comment2 --></div></body></html>";
		String afterCleanup = "<div> <p>bar</p></div>";

		String cleanedHtml = getCleanedHtml(beforeCleanup);

		assertEquals(afterCleanup, cleanedHtml.replace("\n", ""));
	}

	@Test
	public void test_cleanImages() {
		String beforeCleanup = "<html><head></head><body><div><img src=\"smiley.gif\" alt=\"Smiley face\" height=\"42\" width=\"42\"></div></body></html>";
		String afterCleanup = "<div></div>";

		String cleanedHtml = getCleanedHtml(beforeCleanup);

		assertEquals(afterCleanup, cleanedHtml);
	}

	private String getCleanedHtml(String beforeCleanup) {
		Document doc = Jsoup.parse(beforeCleanup);

		HtmlCleaner cleaner = new HtmlCleaner();
		String cleanedHtml = cleaner.cleanHtml(doc,
				"http://www.opensourcetreffen.de/?file=start");

		return cleanedHtml.replace("\n", "");
	}

}
