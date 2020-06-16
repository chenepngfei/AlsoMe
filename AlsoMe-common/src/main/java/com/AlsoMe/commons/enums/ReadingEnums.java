package com.AlsoMe.commons.enums;


import java.util.ArrayList;
import java.util.List;

public enum ReadingEnums {
    DAYI(1, "大一", 1),
    DAER(2, "大二或大三", 2),
    DASI(3, "大四", 3),
    SHUOSHI(4, "硕士研究生", 4),
    BOSHI(5, "博士研究生", 5);

    private int key;
    private String describe;
    private int value;

    private ReadingEnums(int key, String describe, int value) {
        this.key = key;
        this.describe = describe;
        this.value = value;
    }

    public static ReadingEnums getManJianType(int code) {
        ReadingEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ReadingEnums t = var1[var3];
            if (t.key() == code) {
                return t;
            }
        }

        return null;
    }

    public static List<ReadingEnums> getAllList() {
        List<ReadingEnums> list = new ArrayList();
        ReadingEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ReadingEnums se = var1[var3];
            list.add(se);
        }

        return list;
    }

    public static int getValueByKey(int key) {
        int v = 0;
        ReadingEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            ReadingEnums pt = var2[var4];
            if (key == pt.key) {
                v = pt.value();
                break;
            }
        }

        return v;
    }

    public static String getNameByKey(int key) {
        String name = null;
        ReadingEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            ReadingEnums pt = var2[var4];
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
