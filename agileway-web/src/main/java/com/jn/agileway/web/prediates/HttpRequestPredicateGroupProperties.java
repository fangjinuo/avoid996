package com.jn.agileway.web.prediates;

import com.jn.langx.util.Objs;

import java.util.List;

public class HttpRequestPredicateGroupProperties {

    private List<String> methods;

    /**
     * @see PathMatchPredicateFactory
     * <p>
     * 可选类型：String[], Collection<String>, Map<String,String>,PathPatternExpressions
     */
    private Object path = new PathPatternExpressions("/**");

    public Object getPath() {
        return path;
    }

    public void setPath(Object path) {
        this.path = path;
    }

    public List<String> getMethods() {
        return methods;
    }

    public void setMethods(List<String> methods) {
        if (Objs.isNotEmpty(methods)) {
            this.methods = methods;
        }
    }
}
