/*
 * FileCompiler.java
 * belicfr
 */
package jml.compiler;

import jml.Compiler;
import jml.internal.Error;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileCompiler {
    /**
     * I/O error string.
     */
    private static final String ERROR_IO
        = "I/O error occured.";

    /**
     * No one "jml.template" tag in the JML file.
     */
    private static final String ERROR_NO_ONE_JML_TEMPLATE_TAG
        = "There is not any <jml.template> tag.";

    /**
     * Current file path.
     */
    private final String filePath;

    public FileCompiler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Compile current JML file.
     */
    public void compile() {
        File jmlFile;

        Document jml;

        Element jmlTemplateTag;

        jmlFile = new File(this.filePath);

        try {
            jml = Jsoup.parse(jmlFile);

            if (jml.getElementsByTag("jml.template").isEmpty()) {
                Error.print(ERROR_NO_ONE_JML_TEMPLATE_TAG, FileCompiler.class);
                return;
            }

            jmlTemplateTag = jml.getElementsByTag("jml.template").get(0);
        } catch (IOException e) {
            Error.print(ERROR_IO, FileCompiler.class);
        }

        /*
         * TODO:
         *  - read html
         *  - copy base.html for each compilation
         *  - custom base.html copy with given information
         *    in JML file
         *  - create class for each JML tag
         */
    }
}
