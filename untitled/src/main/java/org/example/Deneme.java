package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Deneme {


    public static void main(String[] args) {
        System.out.println("Orospu çocuğu Ali");
    }

    System.setProperty("webdriver.chrome.driver","E:\\Tarayıcı İndirmeleri\\chromedriver.exe");
    WebDriver driver=new ChromeDriver();



}
