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



	@Test
	public void padString() {
		assertEquals("     ", Text.padString(" ", 5));
		assertEquals("xxxxx", Text.padString("x", 5));
		assertEquals("ababab", Text.padString("ab", 3));
	}

	@Test
	public void tableString() {
		final String[][] table1 = new String[][] {
				{"1.1", "1.2", "1.3"},
				{"2.1   ", "2.2", "2.3  "},
				{"3.1", "3.2   ", "3.3"}
		};
		final String[][] table2 = new String[][] {
				{"AAA", "BBBB", "CCCCC"},
				{"DDD", "EEEE", "FFFFF"},
				{"GGG", "HHHH", "IIIII"}
		};

		LOG.debug("{}", Text.tableString(table1, "H1", "H2", "H3"));
		LOG.debug("{}", Text.tableString(table2, "H1", "H2", "H3"));
	}



	// Protected Methods ------------------------------------------------------------------------------ Protected Methods

	// Private Methods ---------------------------------------------------------------------------------- Private Methods

	// Getters & Setters ------------------------------------------------------------------------------ Getters & Setters

} // end of class
