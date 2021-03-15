package com.oheia.design.builder;

public class Demo {
    public static void main(String[] args) {
        MIlkTea mIlkTea = new MIlkTea.Builder("波霸奶茶")
                .setIce(true)
                .setSize("大杯")
                .build();
        MIlkTea mIlkTea2 = new MIlkTea.Builder("柠檬绿茶")
                .setIce(false)
                .setSize("小杯")
                .build();
        System.out.println("milkTea" + mIlkTea.toString());
        System.out.println("mIlkTea2" + mIlkTea2.toString());
    }
}
