package com.AlsoMe.commons.enums;


import java.util.ArrayList;
import java.util.List;

public enum PressureSourceEnums {
    ONE(1, "学业太重", 1),
    TWO(2, "时间太紧张", 2),
    THREE(3, "导师/老师压力", 2),
    FOUR(4, "父母期待", 3),
    FIVE(5, "未来就业", 4),
    SIX(6, "学历能力跟不上", 5),
    SEVEN(7, "疫情影响", 6),
    EIGHT(8, "能否考试通过", 7),
    NINE(9, "能否拿到学位", 8),
    TEN(10, "其他", 9);

    private int key;
    private String describe;
    private int value;

    private PressureSourceEnums(int key, String describe, int value) {
        this.key = key;
        this.describe = describe;
        this.value = value;
    }

    public static PressureSourceEnums getManJianType(int code) {
        PressureSourceEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            PressureSourceEnums t = var1[var3];
            if (t.key() == code) {
                return t;
            }
        }

        return null;
    }

    public static List<PressureSourceEnums> getAllList() {
        List<PressureSourceEnums> list = new ArrayList();
        PressureSourceEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            PressureSourceEnums se = var1[var3];
            list.add(se);
        }

        return list;
    }

    public static int getValueByKey(int key) {
        int v = 0;
        PressureSourceEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            PressureSourceEnums pt = var2[var4];
            if (key == pt.key) {
                v = pt.value();
                break;
            }
        }

        return v;
    }

    public static String getNameByKey(int key) {
        String name = null;
        PressureSourceEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            PressureSourceEnums pt = var2[var4];
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
