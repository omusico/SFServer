/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miaoyou.platform.server.utils;

import java.math.BigDecimal;

/**
 *
 * @author huiqi
 */
public class Arith {

    //榛樿闄ゆ硶杩愮畻绮惧害
    private static final int DEF_DIV_SCALE = 10;

    //杩欎釜绫讳笉鑳藉疄渚嬪寲
    private Arith() {
    }

    public static float add(float v1, float v2) {
        BigDecimal b1 = new BigDecimal("" + v1);
        BigDecimal b2 = new BigDecimal("" + v2);
        return b1.add(b2).floatValue();
    }

    public static float sub(float v1, float v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2).setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    public static float mul(float v1, float v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).floatValue();
    }

    public static float div(float v1, float v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    public static float div(float v1, float v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).floatValue();
    }

     /**
    * 鎻愪緵绮剧‘鐨勫姞娉曡繍绠椼��
    * @param v1 琚姞鏁�
    * @param v2 鍔犳暟
    * @return 涓や釜鍙傛暟鐨勫拰
    */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal("" + v1);
        BigDecimal b2 = new BigDecimal("" + v2);
        return b1.add(b2).doubleValue();
    }

    /**
      * 鎻愪緵绮剧‘鐨勫噺娉曡繍绠椼��
      * @param v1 琚噺鏁�
      * @param v2 鍑忔暟
      * @return 涓や釜鍙傛暟鐨勫樊
      */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2).doubleValue();
    }

    /**
      * 鎻愪緵绮剧‘鐨勪箻娉曡繍绠椼��
      * @param v1 琚箻鏁�
      * @param v2 涔樻暟
      * @return 涓や釜鍙傛暟鐨勭Н
      */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).doubleValue();
    }

    /**
      * 鎻愪緵锛堢浉瀵癸級绮剧‘鐨勯櫎娉曡繍绠楋紝褰撳彂鐢熼櫎涓嶅敖鐨勬儏鍐垫椂锛岀簿纭埌
      * 灏忔暟鐐逛互鍚�10浣嶏紝浠ュ悗鐨勬暟瀛楀洓鑸嶄簲鍏ャ��
      * @param v1 琚櫎鏁�
      * @param v2 闄ゆ暟
      * @return 涓や釜鍙傛暟鐨勫晢
      */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
      * 鎻愪緵锛堢浉瀵癸級绮剧‘鐨勯櫎娉曡繍绠椼�傚綋鍙戠敓闄や笉灏界殑鎯呭喌鏃讹紝鐢眘cale鍙傛暟鎸�
      * 瀹氱簿搴︼紝浠ュ悗鐨勬暟瀛楀洓鑸嶄簲鍏ャ��
      * @param v1 琚櫎鏁�
      * @param v2 闄ゆ暟
      * @param scale 琛ㄧず琛ㄧず闇�瑕佺簿纭埌灏忔暟鐐逛互鍚庡嚑浣嶃��
      * @return 涓や釜鍙傛暟鐨勫晢
      */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 鍥涜垗浜斿叆鍒板皬鏁扮偣鍚巗cale浣�
     * @param v
     * @param scale
     * @return 
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static float round(float v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    public static double decimalPrice(float v) {
        return new BigDecimal(Float.toString(v)).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    public static float decimal(float v, int num) {
        return new BigDecimal(Float.toString(v)).setScale(num, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    public static double decimalPrice(double v) {
        return new BigDecimal(Double.toString(v)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double decimal(double v, int num) {
        return new BigDecimal(Double.toString(v)).setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double decimalSinglePriceFromHuanSuanlv(double huansuanlv, double totalPrice) {
        return decimal(totalPrice / Math.round(1 / huansuanlv), 2);
    }

    public static double decimalSinglePriceFromHuanSuanlv(float huansuanlv, double totalPrice) {
        return decimal(totalPrice / Math.round(1 / huansuanlv), 2);
    }
};
