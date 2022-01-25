package com.gess.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Swipe {
    public static void main(String[] args) {
        cmd();
    }

    public static void cmd(){
        try {
            while (true){
                Random r = new Random();
                Integer i = r.nextInt(10);
                System.out.println(i);
                Thread.sleep(i * 1000);
                Runtime.getRuntime().exec("adb shell input swipe 200 800 200 300");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
