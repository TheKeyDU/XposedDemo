package com.itkey.changeqqbattery;

import android.util.Log;

import android.util.Log;

import org.json.JSONObject;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
/**
 * Created by Administrator on 2020/1/7 11:43
 */

public class MainHook implements IXposedHookLoadPackage {
    String WasHookedApplicationClassName="com.itkey.myapplication.MainActivity";
    String WasHookedApplicationName="com.itkey.myapplication";
    String wasHookedMethod="returnString";
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals(WasHookedApplicationName)) {
            Class clazz = lpparam.classLoader.loadClass(WasHookedApplicationClassName);
            Log.e("XPOSED-duqijian","--------------coming!!!!!!!!!!!!!!!!!!!!");
           XposedHelpers.findAndHookMethod(clazz, wasHookedMethod, new XC_MethodHook() {
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   super.beforeHookedMethod(param);
               }

               @Override
               protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                     param.setResult("fuck you!");
               }
           });
        }
    }

}