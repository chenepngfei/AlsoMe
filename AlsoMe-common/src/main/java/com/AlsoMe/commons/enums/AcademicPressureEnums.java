package com.AlsoMe.commons.enums;


import java.util.ArrayList;
import java.util.List;

public enum AcademicPressureEnums {
    YB(1, "100分及以上(超负荷)", 6),
    JS(2, "90-99分", 5),
    BS(3, "80~90分", 4),
    LS(4, "60~80分", 3),
    WSA(5, "50~60分", 2),
    WSB(6, "50分以下", 1);

    private int key;
    private String describe;
    private int value;

    private AcademicPressureEnums(int key, String describe, int value) {
        this.key = key;
        this.describe = describe;
        this.value = value;
    }

    public static AcademicPressureEnums getManJianType(int code) {
        AcademicPressureEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            AcademicPressureEnums t = var1[var3];
            if (t.key() == code) {
                return t;
            }
        }

        return null;
    }

    public static List<AcademicPressureEnums> getAllList() {
        List<AcademicPressureEnums> list = new ArrayList();
        AcademicPressureEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            AcademicPressureEnums se = var1[var3];
            list.add(se);
        }

        return list;
    }

    public static int getValueByKey(int key) {
        int v = 0;
        AcademicPressureEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            AcademicPressureEnums pt = var2[var4];
            if (key == pt.key) {
                v = pt.value();
                break;
            }
        }

        return v;
    }

    public static String getNameByKey(int key) {
        String name = null;
        AcademicPressureEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            AcademicPressureEnums pt = var2[var4];
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
