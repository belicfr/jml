/*
 * TestCompiler.java
 * belicfr
 */
package test.jml;

import jml.Compiler;

/**
 * [UNIT TEST CLASS]
 *
 * @see jml.Compiler
 * @author belicfr
 */
public class TestCompiler {
    public static void main(String[] args) {
        testWithoutArgument();
        testWithSeveralArguments();
        testWithFolderPath();
        testWithJmlFilePath();
        testWithInvalidPath();
        testWithNotJmlFilePath();
    }

    /**
     * [TEST: Invalid]
     * Call compiler without argument.
     */
    private static void testWithoutArgument() {
        System.out.println("[TEST] testWithoutArgument()");
        Compiler.main(new String[] { });
    }

    /**
     * [TEST: Invalid]
     * Call compiler with several arguments.
     */
    private static void testWithSeveralArguments() {
        System.out.println("[TEST] testWithSeveralArguments()");
        Compiler.main(new String[] {
            "test",
            "test2"
        });
    }

    /**
     * [TEST: Valid]
     * Call compiler with valid folder path.
     */
    private static void testWithFolderPath() {
        System.out.println("[TEST] testWithFolderPath()");
        Compiler.main(new String[] {
            "/Users/jonathan/Documents/Développement/Java/jml/examples"
        });
    }

    /**
     * [TEST: Valid]
     * Call compiler with valid JML file path.
     */
    private static void testWithJmlFilePath() {
        System.out.println("[TEST] testWithJmlFilePath()");
        Compiler.main(new String[] {
            "/Users/jonathan/Documents/Développement/Java/jml/examples/"
          + "test.jml"
        });
    }

    /**
     * [TEST: Invalid]
     * Call compiler with invalid path.
     */
    private static void testWithInvalidPath() {
        System.out.println("[TEST] testWithInvalidPath()");
        Compiler.main(new String[] {
            "/Users/jonathan/Documents/Développement/Java/jml/false-examples"
        });
    }

    private static void testWithNotJmlFilePath() {
        System.out.println("[TEST] testWithNotJmlFilePath()");
        Compiler.main(new String[] {
            "/Users/jonathan/Documents/Développement/Java/jml/.gitignore"
        });
    }
}
