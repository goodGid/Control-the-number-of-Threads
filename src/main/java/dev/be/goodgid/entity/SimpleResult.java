package dev.be.goodgid.entity;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import lombok.Data;

@Data
public class SimpleResult {
    private Integer totalCnt;
    private AtomicInteger successCnt;
    private AtomicInteger exceptionCnt;
    private AtomicInteger errorCnt;
    private AtomicInteger skipCnt;
    private Set<String> skipDetailInfo;
    private Map<String, String> errorDetailInfo;
    private Map<String, String> exceptionDetailInfo;

    public SimpleResult(Integer totalCnt) {
        this.totalCnt = totalCnt;
        successCnt = new AtomicInteger();
        exceptionCnt = new AtomicInteger();
        errorCnt = new AtomicInteger();
        skipCnt = new AtomicInteger();

        skipDetailInfo = Sets.newHashSet();
        errorDetailInfo = Maps.newHashMap();
        exceptionDetailInfo = Maps.newHashMap();
    }

    public SimpleResult() {
        this(0);
    }

}
