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
     * The isJmlFilePath function determines whether a given file path is
     * a JML file. It does this by checking that the path is for an actual
     * file and that the filename ends in ".jml".
     *
     * @param pathObject Given path object
     *
     * @return If pathObject is a JML file
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

    /**
     * The isFolderPath function takes a File object as an
     * argument and returns true if the file is a folder,
     * false otherwise.
     *
     * @param pathObject Check if the path is a file or not
     *
     * @return True if pathObject is a directory
     */
    private static boolean isFolderPath(File pathObject) {
        return !pathObject.isFile();
    }
}
