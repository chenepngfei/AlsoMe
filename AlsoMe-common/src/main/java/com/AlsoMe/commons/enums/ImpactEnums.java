package com.AlsoMe.commons.enums;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public enum ImpactEnums {
    ONE(1, "非常大", 1),
    TWO(2, "比较大", 2),
    THREE(3, "基本没有影响", 3),
    FOR(4, "说不好", 4);

    private int key;
    private String describe;
    private int value;

    private ImpactEnums(int key, String describe, int value) {
        this.key = key;
        this.describe = describe;
        this.value = value;
    }

    public static ImpactEnums getManJianType(int code) {
        ImpactEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ImpactEnums t = var1[var3];
            if (t.key() == code) {
                return t;
            }
        }

        return null;
    }

    public static String getNameByKeys(String keys) {
        String name = "";
        String[] split = keys.split(",");

        for(int i = 0; i < split.length; ++i) {
            name = name + getNameByKey(Integer.valueOf(split[i])) + ",";
        }

        if (StringUtils.isNotBlank(name)) {
            name = name.substring(0, name.length() - 1);
        }

        return name;
    }

    public static List<ImpactEnums> getAllList() {
        List<ImpactEnums> list = new ArrayList();
        ImpactEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ImpactEnums se = var1[var3];
            list.add(se);
        }

        return list;
    }

    public static int getValueByKey(int key) {
        int v = 0;
        ImpactEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            ImpactEnums pt = var2[var4];
            if (key == pt.key) {
                v = pt.value();
                break;
            }
        }

        return v;
    }

    public static String getNameByKey(int key) {
        String name = null;
        ImpactEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            ImpactEnums pt = var2[var4];
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
