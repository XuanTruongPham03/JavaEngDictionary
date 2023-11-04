package Dija.Services.TranslateAPI.BaseSynthesiser.java;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
import Dija.Services.TranslateAPI.GoogleTranslate;

import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public abstract class BaseSynthesiser {
    public BaseSynthesiser() {
    }

    public abstract InputStream getMP3Data(String var1) throws IOException;

    public InputStream getMP3Data(List<String> synthText) throws IOException {
        System.out.println("synthText: " + synthText.toString());
        ExecutorService pool = Executors.newFixedThreadPool(1000);
        Set<Future<InputStream>> set = new LinkedHashSet(synthText.size());
        Iterator var4 = synthText.iterator();

        while(var4.hasNext()) {
            String part = (String)var4.next();
            System.out.println("part each sentence to send: " + part.toString());
            Callable<InputStream> callable = new MP3DataFetcher(part);
            Future<InputStream> future = pool.submit(callable);
            set.add(future);
        }

        List<InputStream> inputStreams = new ArrayList(set.size());
        Iterator var12 = set.iterator();

        while(var12.hasNext()) {
            Future<InputStream> future = (Future)var12.next();

            try {
                inputStreams.add(future.get());
            } catch (ExecutionException var9) {
                Throwable ex = var9.getCause();
                if (ex instanceof IOException) {
                    throw (IOException)ex;
                }
            } catch (InterruptedException var10) {
                Thread.currentThread().interrupt();
            }
        }

        return new SequenceInputStream(Collections.enumeration(inputStreams));
    }

    protected List<String> parseString(String input) {
        return this.parseString(input, new ArrayList());
    }

    private List<String> parseString(String input, List<String> fragments) {
        if (input.length() <= 100) {
            fragments.add(input);
            return fragments;
        } else {
            int lastWord = this.findLastWord(input);
            if (lastWord <= 0) {
                fragments.add(input.substring(0, 100));
                return this.parseString(input.substring(100), fragments);
            } else {
                fragments.add(input.substring(0, lastWord));
                return this.parseString(input.substring(lastWord), fragments);
            }
        }
    }

    private int findLastWord(String input) {
        if (input.length() < 100) {
            return input.length();
        } else {
            int space = -1;

            for(int i = 99; i > 0; --i) {
                char tmp = input.charAt(i);
                if (this.isEndingPunctuation(tmp)) {
                    return i + 1;
                }

                if (space == -1 && tmp == ' ') {
                    space = i;
                }
            }

            if (space > 0) {
                return space;
            } else {
                return -1;
            }
        }
    }

    private boolean isEndingPunctuation(char input) {
        return input == '.' || input == '!' || input == '?' || input == ';' || input == ':' || input == '|';
    }

    public String detectLanguage(String text) throws IOException {
        return GoogleTranslate.detectLanguage(text);
    }

    private class MP3DataFetcher implements Callable<InputStream> {
        private String synthText;

        public MP3DataFetcher(String synthText) {
            this.synthText = synthText;
        }

        public InputStream call() throws IOException {
            return BaseSynthesiser.this.getMP3Data(this.synthText);
        }
    }
}
