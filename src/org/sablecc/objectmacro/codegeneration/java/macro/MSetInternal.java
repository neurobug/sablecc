/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public class MSetInternal
        extends Macro {

    String field_ParamName;

    String field_Context;

    final List<Macro> list_SetParams;

    final Context SetParamsContext = new Context();

    final InternalValue SetParamsValue;

    private DSeparator SetParamsSeparator;

    private DBeforeFirst SetParamsBeforeFirst;

    private DAfterLast SetParamsAfterLast;

    private DNone SetParamsNone;

    private Map<Context, String> field_VarName = new LinkedHashMap<>();

    MSetInternal(
            String pParamName,
            String pContext,
            Macros macros) {

        setMacros(macros);
        setPParamName(pParamName);
        setPContext(pContext);
        this.list_SetParams = new LinkedList<>();

        this.SetParamsValue
                = new InternalValue(this.list_SetParams, this.SetParamsContext);
    }

    private void setPParamName(
            String pParamName) {

        if (pParamName == null) {
            throw ObjectMacroException.parameterNull("ParamName");
        }

        this.field_ParamName = pParamName;
    }

    private void setPContext(
            String pContext) {

        if (pContext == null) {
            throw ObjectMacroException.parameterNull("Context");
        }

        this.field_Context = pContext;
    }

    public void addAllSetParams(
            List<Macro> macros) {

        if (macros == null) {
            throw ObjectMacroException.parameterNull("SetParams");
        }
        if (this.cacheBuilder != null) {
            throw ObjectMacroException.cannotModify("SetInternal");
        }

        int i = 0;

        for (Macro macro : macros) {
            if (macro == null) {
                throw ObjectMacroException.macroNull(i, "SetParams");
            }

            if (getMacros() != macro.getMacros()) {
                throw ObjectMacroException.diffMacros();
            }

            verifyTypeSetParams(macro);
            this.list_SetParams.add(macro);
            this.children.add(macro);
            Macro.cycleDetector.detectCycle(this, macro);

            i++;
        }
    }

    void verifyTypeSetParams(
            Macro macro) {

        macro.apply(new InternalsInitializer("SetParams") {

            @Override
            void setParamRef(
                    MParamRef mParamRef) {

            }

            @Override
            void setStringBuilderBuild(
                    MStringBuilderBuild mStringBuilderBuild) {

            }
        });
    }

    public void addSetParams(
            MParamRef macro) {

        if (macro == null) {
            throw ObjectMacroException.parameterNull("SetParams");
        }
        if (this.cacheBuilder != null) {
            throw ObjectMacroException.cannotModify("SetInternal");
        }

        if (getMacros() != macro.getMacros()) {
            throw ObjectMacroException.diffMacros();
        }

        this.list_SetParams.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }

    public void addSetParams(
            MStringBuilderBuild macro) {

        if (macro == null) {
            throw ObjectMacroException.parameterNull("SetParams");
        }
        if (this.cacheBuilder != null) {
            throw ObjectMacroException.cannotModify("SetInternal");
        }

        if (getMacros() != macro.getMacros()) {
            throw ObjectMacroException.diffMacros();
        }

        this.list_SetParams.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }

    void setVarName(
            Context context,
            String value) {

        if (value == null) {
            throw new RuntimeException("value cannot be null here");
        }

        this.field_VarName.put(context, value);
    }

    String buildParamName() {

        return this.field_ParamName;
    }

    String buildContext() {

        return this.field_Context;
    }

    private String buildSetParams() {

        StringBuilder sb = new StringBuilder();
        Context local_context = this.SetParamsContext;
        List<Macro> macros = this.list_SetParams;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if (this.SetParamsNone != null) {
            sb.append(this.SetParamsNone.apply(i, "", nb_macros));
        }

        for (Macro macro : macros) {
            expansion = macro.build(local_context);

            if (this.SetParamsBeforeFirst != null) {
                expansion = this.SetParamsBeforeFirst.apply(i, expansion,
                        nb_macros);
            }

            if (this.SetParamsAfterLast != null) {
                expansion = this.SetParamsAfterLast.apply(i, expansion,
                        nb_macros);
            }

            if (this.SetParamsSeparator != null) {
                expansion = this.SetParamsSeparator.apply(i, expansion,
                        nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    String buildVarName(
            Context context) {

        return this.field_VarName.get(context);
    }

    String getParamName() {

        return this.field_ParamName;
    }

    String getContext() {

        return this.field_Context;
    }

    private InternalValue getSetParams() {

        return this.SetParamsValue;
    }

    String getVarName(
            Context context) {

        return this.field_VarName.get(context);
    }

    private void initSetParamsInternals(
            Context context) {

        for (Macro macro : this.list_SetParams) {
            macro.apply(new InternalsInitializer("SetParams") {

                @Override
                void setParamRef(
                        MParamRef mParamRef) {

                }

                @Override
                void setStringBuilderBuild(
                        MStringBuilderBuild mStringBuilderBuild) {

                }
            });
        }
    }

    private void initSetParamsDirectives() {

    }

    @Override
    void apply(
            InternalsInitializer internalsInitializer) {

        internalsInitializer.setSetInternal(this);
    }

    @Override
    public String build(
            Context context) {

        CacheBuilder cache_builder = this.cacheBuilders.get(context);

        if (cache_builder == null) {
            cache_builder = new CacheBuilder();
        }
        else if (cache_builder.getExpansion() == null) {
            throw new InternalException("Cycle detection detected lately");
        }
        else {
            return cache_builder.getExpansion();
        }
        this.cacheBuilders.put(context, cache_builder);
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();

        initSetParamsDirectives();

        initSetParamsInternals(context);

        StringBuilder sb0 = new StringBuilder();

        sb0.append("m");
        sb0.append(buildVarName(context));
        sb0.append(".set");
        sb0.append(buildParamName());
        sb0.append("(");
        sb0.append(buildContext());
        sb0.append(", ");
        sb0.append(buildSetParams());
        sb0.append(");");

        cache_builder.setExpansion(sb0.toString());
        return sb0.toString();
    }

    private void setMacros(
            Macros macros) {

        if (macros == null) {
            throw new InternalException("macros cannot be null");
        }

        this.macros = macros;
    }
}
