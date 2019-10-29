package com.epam.rudy.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import com.epam.rudy.entity.Registrable;

/**
 * Journal helper singleton class
 */
public final class JournalHelper {

    private static final long serialVersionUID = 1L;

    /** Target file to read/write from/to */
    private File destinationFile;

    /**  */
    private static final String JOURNAL_RECORD_DELIMITER = "--------------------------------------------------------------------------\n";

    private File file;

    private JournalHelper() {
        destinationFile = new File(getClass()
            .getClassLoader()
            .getResource("journal.txt")
            .getFile());
        try {
            Files.newBufferedWriter(FileSystems.getDefault().getPath(destinationFile.getPath()) ,
                StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {}
    }

    private static class JournalHelperHolder {
        private static final JournalHelper INSTANCE = new JournalHelper();
    }

    public static JournalHelper getInstance() {
        return JournalHelperHolder.INSTANCE;
    }

    protected Object readObject() {
        return getInstance();
    }

    public void register(Registrable entity) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(destinationFile, true)));
            pw.write(entity.stringifyForRegistering(JOURNAL_RECORD_DELIMITER));
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
