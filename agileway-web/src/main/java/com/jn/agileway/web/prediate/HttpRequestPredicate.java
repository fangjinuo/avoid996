package com.jn.agileway.web.prediate;

import com.jn.agileway.web.servlet.RR;
import com.jn.langx.util.function.Predicate;


public interface HttpRequestPredicate extends Predicate<RR> {
    @Override
    boolean test(RR holder);
}