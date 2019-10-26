package com.epam.rudy.util;

import java.io.File;

import com.epam.rudy.entity.Registrable;

/**
 * Journal helper singleton class
 */
public final class JournalHelper {

    private static final long serialVersionUID = 1L;

    /**  */
    private static final String JOURNAL_RECORD_DELIMITER = "############################################";

    private File file;

    private JournalHelper() {
        file = null;
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
        entity.stringifyForRegistering(JOURNAL_RECORD_DELIMITER);
        // file write
    }
}
