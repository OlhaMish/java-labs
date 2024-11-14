package com.olechok.task3;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class CipherFilterWriter extends FilterWriter {
    private final char key;

    public CipherFilterWriter(Writer out, char key) {
        super(out);
        this.key = key;
    }

    @Override
    public void write(int c) throws IOException {
        super.write(c + key);
    }

}
