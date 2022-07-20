package com.study.demo;

import javax.script.*;

public class JSEngineDemo {

    /**
     * eval 方法传递语言绑定对象，当前eval生效
     * 不改变默认语言绑定对象
     * @throws ScriptException
     */
    public void customerBinding() throws ScriptException {
        ScriptEngine engine = getJavaScriptEngine();
        Bindings bindings = new SimpleBindings();
        bindings.put("id", "123");
        engine.eval("println('hello '+ id);", bindings);
    }

    public void defaultBinding() throws ScriptException {
        ScriptEngine engine = getJavaScriptEngine();
        engine.put("id", "123");
        engine.eval("var msg = 'Hello!' + id;");
        engine.eval("println(msg)");
        Object obj = engine.get("msg");
        System.out.println(obj);
    }

    private ScriptEngine getJavaScriptEngine() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByExtension("JavaScript");
        if (engine == null) {
            throw new RuntimeException("找不到js语言 执行引擎。");
        }
        return engine;
    }
}
