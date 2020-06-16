package com.AlsoMe.commons.enums;

import java.util.ArrayList;
import java.util.List;

public enum AddressEnums {
    BJ(1, "北京", 1),
    SH(2, "上海", 2),
    TJ(3, "天津", 3),
    GD(4, "广东", 4),
    HB(5, "湖北", 5),
    HNGXJX(6, "湖南/广西/江西", 6),
    SXSXSD(7, "陕西/山西/山东", 7),
    JSZJAH(8, "江苏/浙江/安徽", 8),
    HBHN(9, "河北/河南", 9),
    GSQHNX(10, "甘肃/青海/宁夏", 10),
    XJNMGXZ(11, "新疆/内蒙古/西藏", 11),
    CQSC(12, "重庆/四川", 12),
    GZYN(13, "贵州/云南", 13),
    FJHN(14, "福建/海南", 14),
    HLJLNJL(15, "黑龙江/辽宁/吉林", 15),
    XGAMTW(16, "香港/澳门/台湾", 16);

    private int key;
    private String describe;
    private int value;

    private AddressEnums(int key, String describe, int value) {
        this.key = key;
        this.describe = describe;
        this.value = value;
    }

    public static AddressEnums getManJianType(int code) {
        AddressEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            AddressEnums t = var1[var3];
            if (t.key() == code) {
                return t;
            }
        }

        return null;
    }

    public static List<AddressEnums> getAllList() {
        List<AddressEnums> list = new ArrayList();
        AddressEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            AddressEnums se = var1[var3];
            list.add(se);
        }

        return list;
    }

    public static int getValueByKey(int key) {
        int v = 0;
        AddressEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            AddressEnums pt = var2[var4];
            if (key == pt.key) {
                v = pt.value();
                break;
            }
        }

        return v;
    }

    public static String getNameByKey(int key) {
        String name = null;
        AddressEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            AddressEnums pt = var2[var4];
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
