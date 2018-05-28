/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public class MApplyInternalsInitializer
        extends Macro {

    final List<Macro> list_RedefinedInternalsSetter;

    final Context RedefinedInternalsSetterContext = new Context();

    final InternalValue RedefinedInternalsSetterValue;

    private DSeparator RedefinedInternalsSetterSeparator;

    private DBeforeFirst RedefinedInternalsSetterBeforeFirst;

    private DAfterLast RedefinedInternalsSetterAfterLast;

    private DNone RedefinedInternalsSetterNone;

    private Map<Context, String> field_ParamName = new LinkedHashMap<>();

    MApplyInternalsInitializer(
            Macros macros) {

        setMacros(macros);
        this.list_RedefinedInternalsSetter = new LinkedList<>();

        this.RedefinedInternalsSetterValue
                = new InternalValue(this.list_RedefinedInternalsSetter,
                        this.RedefinedInternalsSetterContext);
    }

    public void addAllRedefinedInternalsSetter(
            List<Macro> macros) {

        if (macros == null) {
            throw ObjectMacroException
                    .parameterNull("RedefinedInternalsSetter");
        }
        if (this.cacheBuilder != null) {
            throw ObjectMacroException
                    .cannotModify("ApplyInternalsInitializer");
        }

        int i = 0;

        for (Macro macro : macros) {
            if (macro == null) {
                throw ObjectMacroException.macroNull(i,
                        "RedefinedInternalsSetter");
            }

            if (getMacros() != macro.getMacros()) {
                throw ObjectMacroException.diffMacros();
            }

            verifyTypeRedefinedInternalsSetter(macro);
            this.list_RedefinedInternalsSetter.add(macro);
            this.children.add(macro);
            Macro.cycleDetector.detectCycle(this, macro);

            i++;
        }
    }

    void verifyTypeRedefinedInternalsSetter(
            Macro macro) {

        macro.apply(new InternalsInitializer("RedefinedInternalsSetter") {

            @Override
            void setRedefinedInternalsSetter(
                    MRedefinedInternalsSetter mRedefinedInternalsSetter) {

            }
        });
    }

    public void addRedefinedInternalsSetter(
            MRedefinedInternalsSetter macro) {

        if (macro == null) {
            throw ObjectMacroException
                    .parameterNull("RedefinedInternalsSetter");
        }
        if (this.cacheBuilder != null) {
            throw ObjectMacroException
                    .cannotModify("ApplyInternalsInitializer");
        }

        if (getMacros() != macro.getMacros()) {
            throw ObjectMacroException.diffMacros();
        }

        this.list_RedefinedInternalsSetter.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }

    void setParamName(
            Context context,
            String value) {

        if (value == null) {
            throw new RuntimeException("value cannot be null here");
        }

        this.field_ParamName.put(context, value);
    }

    private String buildRedefinedInternalsSetter() {

        StringBuilder sb = new StringBuilder();
        Context local_context = this.RedefinedInternalsSetterContext;
        List<Macro> macros = this.list_RedefinedInternalsSetter;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if (this.RedefinedInternalsSetterNone != null) {
            sb.append(
                    this.RedefinedInternalsSetterNone.apply(i, "", nb_macros));
        }

        for (Macro macro : macros) {
            expansion = macro.build(local_context);

            if (this.RedefinedInternalsSetterBeforeFirst != null) {
                expansion = this.RedefinedInternalsSetterBeforeFirst.apply(i,
                        expansion, nb_macros);
            }

            if (this.RedefinedInternalsSetterAfterLast != null) {
                expansion = this.RedefinedInternalsSetterAfterLast.apply(i,
                        expansion, nb_macros);
            }

            if (this.RedefinedInternalsSetterSeparator != null) {
                expansion = this.RedefinedInternalsSetterSeparator.apply(i,
                        expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    String buildParamName(
            Context context) {

        return this.field_ParamName.get(context);
    }

    private InternalValue getRedefinedInternalsSetter() {

        return this.RedefinedInternalsSetterValue;
    }

    String getParamName(
            Context context) {

        return this.field_ParamName.get(context);
    }

    private void initRedefinedInternalsSetterInternals(
            Context context) {

        for (Macro macro : this.list_RedefinedInternalsSetter) {
            macro.apply(new InternalsInitializer("RedefinedInternalsSetter") {

                @Override
                void setRedefinedInternalsSetter(
                        MRedefinedInternalsSetter mRedefinedInternalsSetter) {

                }
            });
        }
    }

    private void initRedefinedInternalsSetterDirectives() {

        StringBuilder sb1 = new StringBuilder();
        sb1.append(LINE_SEPARATOR);
        sb1.append(LINE_SEPARATOR);
        this.RedefinedInternalsSetterSeparator = new DSeparator(sb1.toString());
        this.RedefinedInternalsSetterValue
                .setSeparator(this.RedefinedInternalsSetterSeparator);
    }

    @Override
    void apply(
            InternalsInitializer internalsInitializer) {

        internalsInitializer.setApplyInternalsInitializer(this);
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

        initRedefinedInternalsSetterDirectives();

        initRedefinedInternalsSetterInternals(context);

        StringBuilder sb0 = new StringBuilder();

        sb0.append("macro.apply(new InternalsInitializer(\"");
        sb0.append(buildParamName(context));
        sb0.append("\")");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("    ");
        indentations.add(sb2.toString());
        sb1.append(buildRedefinedInternalsSetter());
        sb0.append(applyIndent(sb1.toString(),
                indentations.remove(indentations.size() - 1)));
        sb0.append(LINE_SEPARATOR);
        sb0.append("});");

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
