package com.sahha.app.util;

import org.aspectj.lang.JoinPoint;

public class AspectUtil {

    public static String getClassName(JoinPoint joinPoint) {
        return joinPoint.getSignature().getDeclaringTypeName();
    }

    public static String getMethodName(JoinPoint joinPoint) {
        return joinPoint.getSignature().toShortString();
    }


    public static StringBuilder getMethodArgs(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        StringBuilder argsString = new StringBuilder();
        for (Object arg : args) {
            if (arg != null) {
                argsString.append(arg).append(", ");
            }
        }
        if (!argsString.isEmpty()) {
            argsString.setLength(argsString.length() - 2);
        }
        return argsString;
    }

    private AspectUtil() {
    }
}