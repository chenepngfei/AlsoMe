package com.AlsoMe.commons.enums;


import java.util.ArrayList;
import java.util.List;

public enum DegreeEnums {
    ZHUANKE(1, "大专", 1),
    BENKE(2, "本科", 2),
    SHUOSHI(3, "硕士", 3),
    BOSHI(4, "博士", 4),
    BOHOU(5, "博后", 5);

    private int key;
    private String describe;
    private int value;

    private DegreeEnums(int key, String describe, int value) {
        this.key = key;
        this.describe = describe;
        this.value = value;
    }

    public static DegreeEnums getManJianType(int code) {
        DegreeEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            DegreeEnums t = var1[var3];
            if (t.key() == code) {
                return t;
            }
        }

        return null;
    }

    public static List<DegreeEnums> getAllList() {
        List<DegreeEnums> list = new ArrayList();
        DegreeEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            DegreeEnums se = var1[var3];
            list.add(se);
        }

        return list;
    }

    public static int getValueByKey(int key) {
        int v = 0;
        DegreeEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            DegreeEnums pt = var2[var4];
            if (key == pt.key) {
                v = pt.value();
                break;
            }
        }

        return v;
    }

    public static String getNameByKey(int key) {
        String name = null;
        DegreeEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            DegreeEnums pt = var2[var4];
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
