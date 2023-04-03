package com.latte.utils;

import java.util.ArrayList;
import java.util.List;

public class ObjeectUtils {
    public void localVariableVar() {
        //Jdk10
        //局部变量类型推断  Var
        //示例1:
        var list1 = List.of("Java", "Python", "C");
        var copy1 = List.copyOf(list1);
        System.out.println(list1 == copy1); // true
        //示例2:
        var list2 = new ArrayList<String>();
        var copy2 = List.copyOf(list2);
        System.out.println(list2 == copy2); // false
        //示例1和2代码基本一致，为什么一个为true,一个为false?
    }
}
