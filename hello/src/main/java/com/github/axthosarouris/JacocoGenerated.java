package com.github.axthosarouris;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Workaround for ignoring code that cannot be covered
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface JacocoGenerated {

}
