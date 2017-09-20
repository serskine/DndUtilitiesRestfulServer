package com.soupthatisthick.dnd.utilities.server.util.podam;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;

import static com.soupthatisthick.dnd.utilities.server.util.logger.Logger.LOG;
import static com.soupthatisthick.dnd.utilities.server.util.text.Text.isBlank;
import static org.apache.commons.lang.CharEncoding.UTF_8;

public class ResourceUtil {

    // Constants ----------------------------------------------------------------- Constants //

    // Instance Variables ----------------------------------------------- Instance Variables //

    private static final String ERROR_MSG_RESOURCE_PATH_BLANK = "Unable to read resource, resource name cannot be empty";
    private static final String TEMP_FILENAME_PREFIX = "jvmTempFile_";

    // Constructors ----------------------------------------------------------- Constructors //

    private ResourceUtil() {

    }


    // Public Methods ------------------------------------------------------- Public Methods //

    public static URL getUrl(String resourcePath) {
        if (isBlank(resourcePath)) {
            throw new IllegalArgumentException(ERROR_MSG_RESOURCE_PATH_BLANK);
        }

        return ResourceUtil.class.getResource(resourcePath);
    }

    public static String getPath(String resourcePath) {
        return getUrl(resourcePath).getPath();
    }

    public static File getAsFile(String resourcePath) {
        return new File(getUrl(resourcePath).getPath());
    }

    public static File copyResourceToTempFile(String resourcePath) {
        LOG.debug("Copying resource [" + resourcePath + "] into temporary file.");

        if (isBlank(resourcePath)) {
            throw new IllegalArgumentException(ERROR_MSG_RESOURCE_PATH_BLANK);
        }

        File file;
        try {
            file = File.createTempFile(TEMP_FILENAME_PREFIX, null);
        } catch (IOException e) {
            LOG.error("Unable to create temp file on filesystem, check that you have write access.", e);
            throw new RuntimeException("Unable to create temp file on filesystem, check that you have write access.");
        }

        LOG.debug(String.format("Reading resource [%s] and writing to temporary file: %s.", resourcePath, file.getAbsolutePath()));

        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        pipeResourceIntoBufferedOutputStream(resourcePath, bufferedOutputStream);

        IOUtils.closeQuietly(bufferedOutputStream);
        IOUtils.closeQuietly(fileOutputStream);

        return file;

    }

    public static String readResourceIntoString(String resourcePath) throws UnsupportedEncodingException {
        LOG.debug("Copying resource [" + resourcePath + "] into memory (String).");

        if (isBlank(resourcePath)) {
            throw new IllegalArgumentException(ERROR_MSG_RESOURCE_PATH_BLANK);
        }

        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);

        pipeResourceIntoBufferedWriter(resourcePath, bufferedWriter);

        IOUtils.closeQuietly(bufferedWriter);
        IOUtils.closeQuietly(stringWriter);

        return stringWriter.toString();
    }

    public static BufferedReader readResourceIntoBufferedReader(String resourcePath) throws UnsupportedEncodingException {
        InputStream resourceInputStream = readResourceIntoInputStream(resourcePath);
        InputStreamReader inputStreamReader = new InputStreamReader(resourceInputStream, UTF_8);
        return new BufferedReader(inputStreamReader);
    }

    public static BufferedInputStream readResourceIntoBufferedInputStream(String resourcePath) {
        InputStream resourceInputStream = readResourceIntoInputStream(resourcePath);
        return new BufferedInputStream(resourceInputStream);
    }

    public static void pipeResourceIntoBufferedWriter(String resourcePath, BufferedWriter bufferedWriter) throws UnsupportedEncodingException {
        BufferedReader bufferedReader = readResourceIntoBufferedReader(resourcePath);

        try {
            pipe(bufferedReader, bufferedWriter);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException("Exception occurred while piping input into output.", e);
        } finally {
            IOUtils.closeQuietly(bufferedReader);
        }
    }

    public static void pipeResourceIntoBufferedOutputStream(String resourcePath, BufferedOutputStream bufferedOutputStream) {
        BufferedInputStream bufferedInputStream = readResourceIntoBufferedInputStream(resourcePath);

        try {
            pipe(bufferedInputStream, bufferedOutputStream);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException("Exception occurred while piping input into output.", e);
        } finally {
            IOUtils.closeQuietly(bufferedInputStream);
        }
    }

    public static InputStream readResourceIntoInputStream(String resourcePath) {
        if (isBlank(resourcePath)) {
            throw new IllegalArgumentException(ERROR_MSG_RESOURCE_PATH_BLANK);
        }

        InputStream resourceInputStream = ResourceUtil.class.getResourceAsStream(resourcePath);

        if (resourceInputStream == null) {
            String errorMessage = "Unable to read resource into input stream, please check that resource exists.";
            LOG.warning(String.format("%s: %s", errorMessage, resourcePath));
            throw new IllegalArgumentException(errorMessage);
        }

        return resourceInputStream;
    }


    // Protected Methods ------------------------------------------------- Protected Methods //

    // Private methods ----------------------------------------------------- Private methods //

    private static void pipe(BufferedReader input, BufferedWriter output) throws IOException {
        int character;
        while((character = input.read()) != -1) {
            output.write(character);
        }
        output.flush();
    }

    private static void pipe(BufferedInputStream input, BufferedOutputStream output) throws IOException {
        int character;
        while ((character = input.read()) != -1) {
            output.write(character);
        }
        output.flush();
    }

    // Getters & Setters ------------------------------------------------- Getters & Setters //

} // End of class











