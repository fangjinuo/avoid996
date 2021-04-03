package com.jn.agileway.web.prediate.impl;

import com.jn.agileway.web.prediate.HttpRequestPredicate;
import com.jn.agileway.web.prediate.HttpRequestPredicateFactory;
import com.jn.agileway.web.prediate.HttpRequestPredicates;
import com.jn.langx.util.Objs;
import com.jn.langx.util.Strings;

import java.util.List;


public class PathMatchPredicateFactory extends HttpRequestPredicateFactory {

    public PathMatchPredicateFactory() {
        setName(HttpRequestPredicates.PREDICATE_TYPE_PATH);
    }

    @Override
    public HttpRequestPredicate get(String configuration) {
        PathMatchPredicate predicate = new PathMatchPredicate();

        if (Strings.isNotBlank(configuration)) {
            List<String> expressions = HttpRequestPredicates.toStringList(configuration, null);
            if (Objs.isNotEmpty(expressions)) {
                String includePatternExpression = expressions.get(0);
                predicate.setIncludePatterns(includePatternExpression);
                if (expressions.size() > 1) {
                    predicate.setExcludePatterns(expressions.get(1));
                }
            }
        }
        return predicate;
    }
}