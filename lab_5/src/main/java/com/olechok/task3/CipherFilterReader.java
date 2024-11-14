package com.olechok.task3;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CipherFilterReader extends FilterReader {
    private final char key;

    public CipherFilterReader(Reader in, char key) {
        super(in);
        this.key = key;
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1) ? c : (c - key);
    }
}
