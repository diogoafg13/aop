package com.dgtech.kbeh.notifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotifyKBEH{
    //Class<? extends NotifyKBEHType> type();
    String type();
}
