/*
 * FolderExplorer.java
 * belicfr
 */
package jml.compiler;

import jml.internal.Error;

import java.io.File;

public class FolderExplorer {
    private String folderPath;

    public FolderExplorer(String folderPath) {
        this.folderPath = folderPath;
    }

    public void compile() {
        for (File currentFile: this.getFolderFiles()) {
            System.out.println(currentFile.getAbsoluteFile());
            // TODO: call compile method for each file!
        }
    }

    private File[] getFolderFiles() {
        File folder = new File(this.folderPath);
        return folder.listFiles();
    }
}
