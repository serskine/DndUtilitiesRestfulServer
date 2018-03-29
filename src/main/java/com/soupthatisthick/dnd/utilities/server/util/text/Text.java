package com.soupthatisthick.dnd.utilities.server.util.text;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * Created by Owner on 2/5/2017.
 * Copyright of Stuart Marr Erskine, all rights reserved.
 */

public class Text {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("mm/dd/yyyy");
    public static final String objectString(@Nullable Object obj)
    {
        return (obj==null) ? "null" : quote(obj.toString());
    }
    public static final String toString(String string)
    {
        return (string==null) ? "" : string;
    }
    public static final String quote(String string)
    {
        return "\"" + toString(string) + "\"";
    }
    public static final boolean isBlank(String string)
    {
        return (string==null || string.length()<1);
    }

    public static final String concat(@NotNull String seperator, Collection<String> strings)
    {
        String output = "";
        for(String string : strings)
        {
            output += (output.length()==0) ? string : seperator + string;
        }
        return output;
    }

    public static final String concat(@NotNull String seperator, String... strings)
    {
        String output = "";
        for(String string : strings)
        {
            output += (output.length()==0) ? string : seperator + string;
        }
        return output;
    }

    public static final String concatNoEmpty(@NotNull String seperator, String... strings)
    {
        String output = "";
        for(String string : strings)
        {
            if (string!=null && !string.isEmpty()) {
                output += (output.length() == 0) ? string : seperator + string;
            }
        }
        return output;
    }

    public static final String padString(String padding, int numPads)
    {
        String output = "";
        for(int i=0; i<numPads; i++)
        {
            output += padding;
        }
        return output;
    }

    public static final String fString(@Nullable String input, int fieldSize)
    {
        if (fieldSize<1) return "";
        if (input==null)
        {
            return padString(" ", fieldSize);
        } else if (input.length()<=fieldSize)
        {
            return input + padString(" ", fieldSize-input.length());
        } else {
            return input.substring(0, fieldSize);
        }
    }

    public List<String> lines(@NotNull String input) {
        return Arrays.asList(input.split("\n"));
    }



    /**
     * This method will be used to return a String that will represent a window
     * @param input
     * @param windowSize
     * @return
     */
    public static final String wString(@Nullable String input, @NotNull Dimension windowSize) {
        StringBuilder sb = new StringBuilder();

        final int len = input.length();
        int row = 0;
        int col = 0;
        int i = 0;

        while(row<windowSize.height) {
            boolean advanceLine = false;
            if (i < len) {
                char c = input.charAt(i);
                i++;
                if (c == '\n' || col >= windowSize.width) {
                    advanceLine = true;
                } else {
                    sb.append(c);
                    col++;
                }
            } else {
                advanceLine = true;
            }

            if (advanceLine) {
                sb.append(padString(" ", windowSize.width-col));
                col = 0;
                row++;
            }
        }
        return sb.toString();
    }

    public static final String titleString(
        String text,
        char corner,
        char horizontal,
        char vertical,
        char space,
        int rowLength
    ) {
        String output = "";

        text = (text==null) ? "" : text;

        int spacing = rowLength-text.length()-2;
        int left = spacing/2;
        int right = spacing - left;

        String border = corner + Text.padString(""+horizontal, rowLength-2) + corner;
        String spacer = vertical + Text.padString(""+space, rowLength-2) + vertical;
        String content = vertical + Text.padString(""+space, left) + text + Text.padString(""+space, right) + vertical;

        output += "\n";
        output += border + "\n";
        output += spacer + "\n";
        output += content + "\n";
        output += spacer + "\n";
        output += border + "\n";

        return output;

    }

    public static final String mapOutput(Map<String, String> map)
    {
        int keyWidth = columnWidth(map.keySet());
        int valueWidth = columnWidth(map.values());
        String seperator = " : ";
        String output = "";
        for(String key : map.keySet())
        {
            String value = map.get(key);
            String keyString = fString(toString(key), keyWidth);
            String valueString = fString(toString(value), valueWidth);
            output += keyString + seperator + valueString + "\n";
        }
        return output;
    }

    private static final int columnWidth(Collection<String> info)
    {
        int minWidth = 0;
        for(Object element : info) {
            String value = (element==null) ? "null" : Text.toString(element.toString());
            minWidth = Math.max((value==null) ? 0 : value.length() , minWidth);
        }
        return minWidth;
    }

    public static final String bold(String text)
    {
        return "<b>" + text + "</b>";
    }

    /**
     * Used to get all the words in a search text
     * @param searchText
     * @return
     */
    public static final String[] getWords(String searchText)
    {
        searchText = searchText.toUpperCase().trim();   // Convert to upper case to make case insensitive
        String words[] = searchText.split("\\s+");  // Split on white spaces to get all words that must match something
        return words;
    }

    /**
     * Used to see if the text contains all the specified words in it anywhere
     * @param input
     * @param words
     * @return true if all words are contained within, else it returns false
     */
    public static final boolean containsAllWords(@Nullable String input, @Nullable String[] words)
    {
        if (input==null)
        {
            return false;
        }
        if (words==null || words.length<1)
        {
            return true;
        }
        for(String word : words)
        {
            if (!input.contains(word))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean isNullOrEmpty(@Nullable String text) {
        return ((text==null) || (text.isEmpty()));
    }

    /**
     * Prints out text in table format
     * @param table
     * @return
     */
    public static final String tableString(String[][] table) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        Map<Integer, Integer> columnWidths = new HashMap<>();
        Map<Integer, Integer> rowHeights = new HashMap<>();

        int numRows = table.length;
        int numCols = 0;

        for(int row=0; row<table.length; row++) {
            String[] theRow = table[row];
            numCols = Math.max(0, theRow.length);

            for(int col=0; col<theRow.length; col++) {
                final String cell = theRow[col];
                Dimension dimension = cellSize(cell);
                rowHeights.put(row, Math.max(rowHeights.getOrDefault(row, 0), dimension.height));
                columnWidths.put(col, Math.max(columnWidths.getOrDefault(col, 0), dimension.width));
            }
        }

        String[] rowCells = new String[numRows];
        for(int row=0; row<numRows; row++) {
            String[] colCells = new String[numCols];
            for(int col=0; col<numCols; col++) {
                Dimension dimension = new Dimension();
                dimension.setSize(columnWidths.get(col), rowHeights.get(row));
                colCells[col] = wString(table[row][col], dimension);
            }
            rowCells[row] = appendWindowsHorizontal(colCells);
        }

        String tableCell = appendWindowsVertical(rowCells);

        sb.append(tableCell);

        sb.append("\n");
        return sb.toString();
    }

    public static final Dimension cellSize(@NotNull String cell) {
        Dimension dimension = new Dimension();
        dimension.setSize(numCols(cell), numRows(cell));
        return dimension;
    }

    public static final int numRows(@NotNull String text) {
        int numRows = 1;
        for(int i=0; i<text.length(); i++) {
            if (text.charAt(i) == '\n') {
                numRows++;
            }
        }
        return numRows;
    }

    public static final int numCols(@NotNull String text) {
        int maxWidth = 0;
        int width = 0;
        for(int i=0; i<text.length(); i++) {
            if (text.charAt(i) != '\n') {
                width++;
            } else {
                width = 0;
            }
            maxWidth = Math.max(maxWidth, width);
        }
        return maxWidth;
    }

    public static final String appendWindowsVertical(String... cells) {
        StringBuilder sb = new StringBuilder();
        for(String cell : cells) {
            sb.append(cell);
            sb.append('\n');
        }
        return padCellWindow(sb.toString());
    }

    public static final String appendWindowsHorizontal(String... cells) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, List<String>> linesMap = new HashMap<>();
        Map<Integer, Integer> widthMap = new HashMap<>();

        for(int i=0; i<cells.length; i++) {
            final String cell = cells[i];
            List<String> lines = Arrays.asList(cell.split("\n"));
            linesMap.put(i, lines);
            widthMap.put(i, numCols(cell));
        }

        boolean done;
        do {
            done = true;
            String thisLine = "";

            for(int i=0; i<cells.length; i++) {
                List<String> lines = linesMap.get(i);
                int expectedWidth = widthMap.get(i);
                if (lines==null || lines.isEmpty()) {
                    thisLine += padString(" ", expectedWidth);
                } else {
                    final String field = lines.remove(0);
                    thisLine += fString(field, expectedWidth);
                    done = false;
                }
            }

            if (done != false) {
                sb.append(thisLine);
                sb.append("\n");
            }
        } while(!done);

        return sb.toString();

    }

    public static final String padCellWindow(String cell) {
        final Dimension dimension = cellSize(cell);
        return wString(cell, dimension);
    }

}
