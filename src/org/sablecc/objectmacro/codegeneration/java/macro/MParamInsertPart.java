/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public class MParamInsertPart
        extends Macro {

    String field_ParamName;

    String field_IndexBuilder;

    final List<Macro> list_ContextArg;

    final Context ContextArgContext = new Context();

    final InternalValue ContextArgValue;

    private DSeparator ContextArgSeparator;

    private DBeforeFirst ContextArgBeforeFirst;

    private DAfterLast ContextArgAfterLast;

    private DNone ContextArgNone;

    MParamInsertPart(
            String pParamName,
            String pIndexBuilder,
            Macros macros) {

        setMacros(macros);
        setPParamName(pParamName);
        setPIndexBuilder(pIndexBuilder);
        this.list_ContextArg = new LinkedList<>();

        this.ContextArgValue = new InternalValue(this.list_ContextArg,
                this.ContextArgContext);
    }

    private void setPParamName(
            String pParamName) {

        if (pParamName == null) {
            throw ObjectMacroException.parameterNull("ParamName");
        }

        this.field_ParamName = pParamName;
    }

    private void setPIndexBuilder(
            String pIndexBuilder) {

        if (pIndexBuilder == null) {
            throw ObjectMacroException.parameterNull("IndexBuilder");
        }

        this.field_IndexBuilder = pIndexBuilder;
    }

    public void addAllContextArg(
            List<Macro> macros) {

        if (macros == null) {
            throw ObjectMacroException.parameterNull("ContextArg");
        }
        if (this.cacheBuilder != null) {
            throw ObjectMacroException.cannotModify("ParamInsertPart");
        }

        int i = 0;

        for (Macro macro : macros) {
            if (macro == null) {
                throw ObjectMacroException.macroNull(i, "ContextArg");
            }

            if (getMacros() != macro.getMacros()) {
                throw ObjectMacroException.diffMacros();
            }

            verifyTypeContextArg(macro);
            this.list_ContextArg.add(macro);
            this.children.add(macro);
            Macro.cycleDetector.detectCycle(this, macro);

            i++;
        }
    }

    void verifyTypeContextArg(
            Macro macro) {

        macro.apply(new InternalsInitializer("ContextArg") {

            @Override
            void setContextArg(
                    MContextArg mContextArg) {

            }
        });
    }

    public void addContextArg(
            MContextArg macro) {

        if (macro == null) {
            throw ObjectMacroException.parameterNull("ContextArg");
        }
        if (this.cacheBuilder != null) {
            throw ObjectMacroException.cannotModify("ParamInsertPart");
        }

        if (getMacros() != macro.getMacros()) {
            throw ObjectMacroException.diffMacros();
        }

        this.list_ContextArg.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }

    String buildParamName() {

        return this.field_ParamName;
    }

    String buildIndexBuilder() {

        return this.field_IndexBuilder;
    }

    private String buildContextArg() {

        StringBuilder sb = new StringBuilder();
        Context local_context = this.ContextArgContext;
        List<Macro> macros = this.list_ContextArg;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if (this.ContextArgNone != null) {
            sb.append(this.ContextArgNone.apply(i, "", nb_macros));
        }

        for (Macro macro : macros) {
            expansion = macro.build(local_context);

            if (this.ContextArgBeforeFirst != null) {
                expansion = this.ContextArgBeforeFirst.apply(i, expansion,
                        nb_macros);
            }

            if (this.ContextArgAfterLast != null) {
                expansion = this.ContextArgAfterLast.apply(i, expansion,
                        nb_macros);
            }

            if (this.ContextArgSeparator != null) {
                expansion = this.ContextArgSeparator.apply(i, expansion,
                        nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    String getParamName() {

        return this.field_ParamName;
    }

    String getIndexBuilder() {

        return this.field_IndexBuilder;
    }

    private InternalValue getContextArg() {

        return this.ContextArgValue;
    }

    private void initContextArgInternals(
            Context context) {

        for (Macro macro : this.list_ContextArg) {
            macro.apply(new InternalsInitializer("ContextArg") {

                @Override
                void setContextArg(
                        MContextArg mContextArg) {

                }
            });
        }
    }

    private void initContextArgDirectives() {

    }

    @Override
    void apply(
            InternalsInitializer internalsInitializer) {

        internalsInitializer.setParamInsertPart(this);
    }

    @Override
    public String build() {

        CacheBuilder cache_builder = this.cacheBuilder;

        if (cache_builder == null) {
            cache_builder = new CacheBuilder();
        }
        else if (cache_builder.getExpansion() == null) {
            throw new InternalException("Cycle detection detected lately");
        }
        else {
            return cache_builder.getExpansion();
        }
        this.cacheBuilder = cache_builder;
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();

        initContextArgDirectives();

        initContextArgInternals(null);

        StringBuilder sb0 = new StringBuilder();

        sb0.append("sb");
        sb0.append(buildIndexBuilder());
        sb0.append(".append(build");
        sb0.append(buildParamName());
        sb0.append("(");
        sb0.append(buildContextArg());
        sb0.append("));");

        cache_builder.setExpansion(sb0.toString());
        return sb0.toString();
    }

    @Override
    String build(
            Context context) {

        return build();
    }

    private void setMacros(
            Macros macros) {

        if (macros == null) {
            throw new InternalException("macros cannot be null");
        }

        this.macros = macros;
    }
}
