package com.soupthatisthick.dnd.utilities.server.util.logger;


import com.soupthatisthick.dnd.utilities.server.util.text.Text;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;

@SuppressWarnings({"SameParameterValue", "WeakerAccess", "unused"})
public class Logger {

    private static final org.slf4j.Logger ILOG = LoggerFactory.getLogger("Main logger");
    public static final Logger LOG = new Logger();

    public class CodeSpot
    {
        public final StackTraceElement stackTraceElement;
        public final int height;

        public CodeSpot(StackTraceElement stackTraceElement, int height)
        {
            this.stackTraceElement = stackTraceElement;
            this.height = height;
        }

        @Override
        public String toString()
        {
            return "(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") ";
        }

    }

    private String tabString(int height)
    {
        return Text.padString(".", height);
    }

    private CodeSpot getCodeSpot(int depth)
    {
        try {
            throw new Exception();
        } catch (Exception e)
        {
            StackTraceElement topElement = e.getStackTrace()[depth+1];
            return new CodeSpot(topElement, e.getStackTrace().length - (depth+1));
        }
    }

    private String getTag(CodeSpot element)
    {
        return element.toString();
    }

    public final void debug(String text, Object... args)
    {
        debugInternal(text, 1, args);
    }


    private void debugInternal(String text, int depth, Object... args)
    {
        CodeSpot src = getCodeSpot(depth+1);
        String TAG = getTag(src);
        ILOG.info(TAG + text, args);
    }

    public final void error(String text, @Nullable Throwable e, Object... args)
    {
        errorInternal(text, 1, e, args);
    }

    private void errorInternal(String text, int depth, @Nullable Throwable e, Object... args)
    {
        CodeSpot src = getCodeSpot(depth+1);
        String TAG = getTag(src);
        ILOG.error(TAG + text, e);
    }

    public final void info(String text, Object... args)
    {
        infoInternal(text, 1, args);
    }

    private void infoInternal(String text, int depth, Object... args)
    {
        CodeSpot src = getCodeSpot(depth+1);
        String TAG = getTag(src);
        ILOG.info(TAG + text, args);
    }

    public final void warning(String text, Object... args)
    {
        warningInternal(text, 1, args);
    }

    private void warningInternal(String text, int depth, Object... args)
    {
        CodeSpot src = getCodeSpot(depth+1);
        String TAG = getTag(src);
        ILOG.warn(TAG + text, args);
    }

    /**
     * Excluding the depth of this function it will log the two code spots previous to it on the stack track.
     * IE. The previous scope to the scope containing the call of this method will be displayed in the logs.
     * This is useful for determining where a particular method was called from.
     */
    public final CodeSpot getPreviousCodeSpot()
    {
        return getCodeSpot(2);
    }

    public final void logCodeTransition()
    {
        LOG.debug(getCodeSpot(2) + " => " + getCodeSpot(1));
    }

    private String stackTraceString(int depth)
    {
        StringBuilder output = new StringBuilder();
        try {
            throw new RuntimeException("");
        } catch (Exception e) {
            StackTraceElement[] elements = e.getStackTrace();

            int sourceWidth = 0, methodWidth = 0;

            for(int i=depth+1; i<elements.length; i++) {
                CodeSpot codeSpot = new CodeSpot(elements[i], i);
                sourceWidth = Math.max(sourceWidth, codeSpot.toString().length());
                methodWidth = Math.max(sourceWidth, (codeSpot.stackTraceElement.getMethodName() + "()").length());
            }
            sourceWidth++;
            methodWidth++;

            // print the data
            for(int i=depth+1; i<elements.length; i++)
            {
                CodeSpot codeSpot = new CodeSpot(elements[i], i);
                output.append(Text.fString(codeSpot.toString(), sourceWidth)).append(": ").append(Text.fString(codeSpot.stackTraceElement.getMethodName() + "()", methodWidth)).append("\n");
            }
        }
        return output.toString();
    }

    /**
     * This will log the stack trace up to the stack level value below
     * the calling of this method. By calling this method with a depth of 0 you will
     * include everything up to but excluding the call to this method.
     * @param depth determines how far down the stack trace our source method is
     */
    private void logStackTrace(int depth)
    {
        LOG.infoInternal(stackTraceString(depth+1), depth+1);
    }

    /**
     * This will log the stack trace up to the point of calling this method but not including this method.
     */
    public final void logStackTrace()
    {
        logStackTrace(1);
    }


    public final void title(String text)
    {
        title(text, 1);
    }

    private void title(String text, int depth)
    {
        title(text, 80, depth+1);
    }

    private void title(String text, int rowLength, int depth)
    {
        LOG.infoInternal(Text.titleString(text,'*', '=', '|', ' ', rowLength), depth+1);
    }

}
