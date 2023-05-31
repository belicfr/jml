/*
 * Compiler.java
 * belicfr
 */
package jml;

import jml.compiler.FileCompiler;
import jml.compiler.FolderExplorer;
import jml.internal.Error;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;

public class Compiler {
    /**
     * Wrong arguments count error string.
     */
    private static final String ERROR_WRONG_ARGS_COUNT
        = "Wrong arguments count. It must contains only one argument "
        + "(folder/file to compile).";

    /**
     * Path that does not exist error string.
     */
    public static final String ERROR_PATH_NOT_EXISTS
        = "Given path does not exist or is not accessible.";

    /**
     * File is not a JML one error string.
     */
    private static final String ERROR_IS_NOT_JML_FILE
        = "The given file path does not target a JML file.";

    /**
     * Static main method that starts compiling process.
     *
     * @param args Given arguments (only one needed)
     */
    public static void main(String[] args) {
        String path;

        File pathObject;

        FolderExplorer explorer;
        FileCompiler compilerProcess;

        if (args.length == 1) {
            path = args[0];
            pathObject = new File(path);

            if (!pathObject.exists()) {
                Error.print(ERROR_PATH_NOT_EXISTS, Compiler.class);
                return;
            }

            if (isJmlFilePath(pathObject)) {  System.out.println("-> FILE!");
                compilerProcess = new FileCompiler(path);
                compilerProcess.compile();
            } else if (isFolderPath(pathObject)) {  System.out.println("-> FOLDER!");
                explorer = new FolderExplorer(path);
                explorer.compile();
            } else {
                Error.print(ERROR_IS_NOT_JML_FILE, Compiler.class);
            }
        } else {
            Error.print(ERROR_WRONG_ARGS_COUNT, Compiler.class);
        }
    }

    /**
     * Returns if the given path targets a JML file.
     *
     * @param pathObject Given path object
     *
     * @return If the given path targets a file
     */
    private static boolean isJmlFilePath(File pathObject) {
        final String REGEX_JML_FILE_EXTENSION
            = "^(.*).jml$";

        Pattern pathPattern;
        Matcher pathMatcher;

        pathPattern = Pattern.compile(REGEX_JML_FILE_EXTENSION);
        pathMatcher = pathPattern.matcher(pathObject.getName());

        return pathObject.isFile() && pathMatcher.matches();
    }

    private static boolean isFolderPath(File pathObject) {
        return !pathObject.isFile();
    }
}
