package dev.be.goodgid.util;

import static dev.be.goodgid.common.Constants.SUCCESS_CODE;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ReturnCodeUtils {

    public static String getSuccessCode() {
        return SUCCESS_CODE;
    }

}
