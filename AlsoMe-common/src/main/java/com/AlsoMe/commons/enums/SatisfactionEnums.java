package com.AlsoMe.commons.enums;


import java.util.ArrayList;
import java.util.List;

public enum SatisfactionEnums {
    VARYLIKE(1, "非常喜欢", 1),
    PREFERLIKE(2, "比较喜欢", 2),
    GENERAL(3, "一般吧", 3),
    NOLIKE(4, "不太喜欢", 4),
    NOTLIKE(5, "说不好", 5);

    private int key;
    private String describe;
    private int value;

    private SatisfactionEnums(int key, String describe, int value) {
        this.key = key;
        this.describe = describe;
        this.value = value;
    }

    public static SatisfactionEnums getManJianType(int code) {
        SatisfactionEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            SatisfactionEnums t = var1[var3];
            if (t.key() == code) {
                return t;
            }
        }

        return null;
    }

    public static List<SatisfactionEnums> getAllList() {
        List<SatisfactionEnums> list = new ArrayList();
        SatisfactionEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            SatisfactionEnums se = var1[var3];
            list.add(se);
        }

        return list;
    }

    public static int getValueByKey(int key) {
        int v = 0;
        SatisfactionEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            SatisfactionEnums pt = var2[var4];
            if (key == pt.key) {
                v = pt.value();
                break;
            }
        }

        return v;
    }

    public static String getNameByKey(int key) {
        String name = null;
        SatisfactionEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            SatisfactionEnums pt = var2[var4];
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
