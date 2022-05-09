package com.course.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Describe: MD5Util
 * @Author: tyf
 * @CreateTime: 2022/4/16
 **/
public class MD5Util {

    public static final String salt = "1a2b3c4d";

    public static String md5(String str) {
        return DigestUtils.md5Hex(str);
    }

    /**
     * 将用户输入的md5
     *
     * @param inputPass
     * @return
     */
    public static String inputPassToFormPass(String inputPass) {
        inputPass = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(inputPass);
    }

    /**
     * 将form的FormPassword转换成dbPassword
     *
     * @param formPass
     * @param saltDB
     * @return 加密后的密码
     */
    public static String formPassToDbPass(String formPass, String saltDB) {
        String str = "" + saltDB.charAt(0) + saltDB.charAt(2) + formPass + saltDB.charAt(5) + saltDB.charAt(4);
        return md5(str);
    }

    public static String inputPassToDbPass(String inputPass, String saltDB) {
        String formPass = inputPassToFormPass(inputPass);
        String dbPass = formPassToDbPass(formPass, saltDB);
        return dbPass;
    }


    public static void main(String[] args) {
        System.out.println(inputPassToDbPass("123456", "1a2b3c4d"));
//          System.out.println(inputPassFormPass("123456").toString());
    }


}
