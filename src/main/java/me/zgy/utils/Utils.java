package me.zgy.utils;

/**
 * Created by Rayee on 2017/12/11.
 */
public class Utils {

    public static String getHost(String address){
        return address.split(":")[0];
    }

    public static int getPort(String address){
        return Integer.valueOf(address.split(":")[1]).intValue();
    }

}
