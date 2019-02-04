package com.rampatra.misc;

/**
 * Created by IntelliJ IDEA.
 * User: rampatra
 * Date: 2/26/15
 * Time: 4:16 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BotTesting {
    public static void main(String args[]) throws MalformedURLException {
        final URL myURL = new URL("http://localhost:8080/ifb.html");
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        Long start = System.currentTimeMillis();

        for (int i = 0; i <= 50; i++) {
            executorService.execute(new Runnable() {

                @Override
                public void run() {

                    try {
                        HttpURLConnection myURLConnection = (HttpURLConnection) myURL.openConnection();

                        myURLConnection.setRequestProperty("x-msisdn", "919871296875");
                        myURLConnection.setRequestProperty("x-rat", "1");
                        myURLConnection.setRequestProperty("X-Forwarded-For", "171.48.0.1");
                        String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36 " + Math.random();
                        myURLConnection.setRequestProperty("user-agent", userAgent);
                        myURLConnection.setRequestMethod("GET");
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
                        String line;
                        StringBuffer content = new StringBuffer("");


                        bufferedReader.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        Long diff = System.currentTimeMillis() - start;
        System.out.println("Difference: " + diff + "ms");
        executorService.shutdown();
    }
}
