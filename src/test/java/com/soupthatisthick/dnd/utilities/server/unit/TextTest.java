package com.soupthatisthick.dnd.utilities.server.unit;

import com.soupthatisthick.dnd.utilities.server.util.text.Text;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class TextTest {

	// Constants ---------------------------------------------------------------------------------------------- Constants

	private static transient final Logger LOG = LoggerFactory.getLogger(TextTest.class);

	// Instance Variables ---------------------------------------------------------------------------- Instance Variables

	// Constructors ---------------------------------------------------------------------------------------- Constructors

	// Public Methods ------------------------------------------------------------------------------------ Public Methods

	private void getMethods() {
		Text.appendWindowsHorizontal("");
		Text.appendWindowsVertical("");
		Text.wString("", new Dimension(0, 0));
		Text.padCellWindow("window");
		Text.numRows("numRows");
		Text.numCols("numCols");
		Text.isBlank("");
		Text.fString("field",5);
		Text.toString(null);
		Text.concat(",", "a", "b", "c");
		Text.concat(",", Arrays.asList("a", "b", "c"));
		Text.padString("x", 5);
		Text.quote("quote");
		Text.titleString("This is a title", '+', '-', '|', ' ', 50);
		Text.bold("bold");
		Text.concatNoEmpty(",", "a", "b", "c");
		Text.containsAllWords("The quick brown fox", new String[] {"quick", "brown"});
		Text.cellSize("cell");
		Text.objectString(new ArrayList<String>());
		Text.tableString(new String[][] {{"r1", "r2", "r3"}, {"a1", "a2", "a3"}});
	}

	@Test
	public void padString() {
		assertEquals("     ", Text.padString(" ", 5));
		assertEquals("xxxxx", Text.padString("x", 5));
		assertEquals("ababab", Text.padString("ab", 3));
	}

	@Test
	public void padCellWindow() {
		final String input = "11111\n222\n333333";
		final String expected = "11111 \n222   \n333333";
		final String observed = Text.padCellWindow(input);

		LOG.debug("{}", observed);
		assertEquals(expected, observed);
	}

	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
