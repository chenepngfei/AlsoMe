package com.AlsoMe.commons.enums;

import java.util.ArrayList;
import java.util.List;

public enum AgeEnums {
    NINETEENBEFORE(1, "19岁及以下", 1),
    TWENTYAFTER(2, "20~21岁", 2),
    TWENTYTWOAFTER(3, "22~23s岁", 3),
    TWENTYFORAFTER(4, "24~25岁", 4),
    TWENTYSIXAFTER(5, "26岁及以上", 5);

    private int key;
    private String describe;
    private int value;

    private AgeEnums(int key, String describe, int value) {
        this.key = key;
        this.describe = describe;
        this.value = value;
    }

    public static AgeEnums getManJianType(int code) {
        AgeEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            AgeEnums t = var1[var3];
            if (t.key() == code) {
                return t;
            }
        }

        return null;
    }

    public static List<AgeEnums> getAllList() {
        List<AgeEnums> list = new ArrayList();
        AgeEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            AgeEnums se = var1[var3];
            list.add(se);
        }

        return list;
    }

    public static int getValueByKey(int key) {
        int v = 0;
        AgeEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            AgeEnums pt = var2[var4];
            if (key == pt.key) {
                v = pt.value();
                break;
            }
        }

        return v;
    }

    public static String getNameByKey(int key) {
        String name = null;
        AgeEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            AgeEnums pt = var2[var4];
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
