package com.AlsoMe.commons.enums;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public enum ProfessionalEnums {
    LITERATURE(1, "文学/语言", 1),
    ENGINEERING(2, "理学/工学", 2),
    COMPUTER(3, "计算机软硬件/VR/AR", 3),
    ART(4, "艺术类", 4),
    MEDICAL(5, "医学/护理类", 5),
    PHILOSOPHY(6, "法学/哲学", 6),
    ASTRONOMICAL(7, "天文/地理/历史", 7),
    AGRONOMY(8, "农学", 8),
    MBA(9, "管理/MBA", 9),
    ECONOMIC(10, "经济/金融", 10),
    military(12, "军事", 12),
    PEDAGOGY(13, "教育学", 13),
    PSYCHOLOGICAL(14, "心理学", 14),
    OTHERPROFESSIONAL(15, "其它专业", 15);

    private int key;
    private String describe;
    private int value;

    private ProfessionalEnums(int key, String describe, int value) {
        this.key = key;
        this.describe = describe;
        this.value = value;
    }

    public static ProfessionalEnums getManJianType(int code) {
        ProfessionalEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ProfessionalEnums t = var1[var3];
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

    public static List<ProfessionalEnums> getAllList() {
        List<ProfessionalEnums> list = new ArrayList();
        ProfessionalEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ProfessionalEnums se = var1[var3];
            list.add(se);
        }

        return list;
    }

    public static int getValueByKey(int key) {
        int v = 0;
        ProfessionalEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            ProfessionalEnums pt = var2[var4];
            if (key == pt.key) {
                v = pt.value();
                break;
            }
        }

        return v;
    }

    public static String getNameByKey(int key) {
        String name = null;
        ProfessionalEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            ProfessionalEnums pt = var2[var4];
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
