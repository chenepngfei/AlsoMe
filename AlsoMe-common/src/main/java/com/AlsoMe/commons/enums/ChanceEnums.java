package com.AlsoMe.commons.enums;


import java.util.ArrayList;
import java.util.List;

public enum ChanceEnums {
    VARYLIKE(1, "没有/偶尔有", 1),
    PREFERLIKE(2, "有时有", 2),
    GENERAL(3, "经常有", 3),
    NOLIKE(4, "总是如此", 4);

    private int key;
    private String describe;
    private int value;

    private ChanceEnums(int key, String describe, int value) {
        this.key = key;
        this.describe = describe;
        this.value = value;
    }

    public static ChanceEnums getManJianType(int code) {
        ChanceEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ChanceEnums t = var1[var3];
            if (t.key() == code) {
                return t;
            }
        }

        return null;
    }

    public static List<ChanceEnums> getAllList() {
        List<ChanceEnums> list = new ArrayList();
        ChanceEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ChanceEnums se = var1[var3];
            list.add(se);
        }

        return list;
    }

    public static int getValueByKey(int key) {
        int v = 0;
        ChanceEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            ChanceEnums pt = var2[var4];
            if (key == pt.key) {
                v = pt.value();
                break;
            }
        }

        return v;
    }

    public static String getNameByKey(int key) {
        String name = null;
        ChanceEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            ChanceEnums pt = var2[var4];
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
