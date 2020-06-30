package com.AlsoMe.commons.enums;


import java.util.ArrayList;
import java.util.List;

public enum ChanceFanEnums {
    VARYLIKE(1, "没有/偶尔有", 4),
    PREFERLIKE(2, "有时有", 3),
    GENERAL(3, "经常有", 2),
    NOLIKE(4, "总是如此", 1);

    private int key;
    private String describe;
    private int value;

    private ChanceFanEnums(int key, String describe, int value) {
        this.key = key;
        this.describe = describe;
        this.value = value;
    }

    public static ChanceFanEnums getManJianType(int code) {
        ChanceFanEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ChanceFanEnums t = var1[var3];
            if (t.key() == code) {
                return t;
            }
        }

        return null;
    }

    public static List<ChanceFanEnums> getAllList() {
        List<ChanceFanEnums> list = new ArrayList();
        ChanceFanEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ChanceFanEnums se = var1[var3];
            list.add(se);
        }

        return list;
    }

    public static int getValueByKey(int key) {
        int v = 0;
        ChanceFanEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            ChanceFanEnums pt = var2[var4];
            if (key == pt.key) {
                v = pt.value();
                break;
            }
        }

        return v;
    }

    public static String getNameByKey(int key) {
        String name = null;
        ChanceFanEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            ChanceFanEnums pt = var2[var4];
            if (key == pt.key) {
                name = pt.describe;
                break;
            }
        }

        return name;
    }

    public int value() {
        return this.value;
    }

    public String describe() {
        return this.describe;
    }

    public int key() {
        return this.key;
    }
}
