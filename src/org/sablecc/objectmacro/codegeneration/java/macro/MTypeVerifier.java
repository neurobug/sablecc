/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public class MTypeVerifier
        extends Macro {

    String field_ParamName;

    final List<Macro> list_TypeVerification;

    final Context TypeVerificationContext = new Context();

    final InternalValue TypeVerificationValue;

    private DSeparator TypeVerificationSeparator;

    private DBeforeFirst TypeVerificationBeforeFirst;

    private DAfterLast TypeVerificationAfterLast;

    private DNone TypeVerificationNone;

    final List<Macro> list_Override;

    final Context OverrideContext = new Context();

    final InternalValue OverrideValue;

    private DSeparator OverrideSeparator;

    private DBeforeFirst OverrideBeforeFirst;

    private DAfterLast OverrideAfterLast;

    private DNone OverrideNone;

    MTypeVerifier(
            String pParamName,
            Macros macros) {

        setMacros(macros);
        setPParamName(pParamName);
        this.list_TypeVerification = new LinkedList<>();
        this.list_Override = new LinkedList<>();

        this.TypeVerificationValue = new InternalValue(
                this.list_TypeVerification, this.TypeVerificationContext);
        this.OverrideValue
                = new InternalValue(this.list_Override, this.OverrideContext);
    }

    private void setPParamName(
            String pParamName) {

        if (pParamName == null) {
            throw ObjectMacroException.parameterNull("ParamName");
        }

        this.field_ParamName = pParamName;
    }

    public void addAllTypeVerification(
            List<Macro> macros) {

        if (macros == null) {
            throw ObjectMacroException.parameterNull("TypeVerification");
        }
        if (this.cacheBuilder != null) {
            throw ObjectMacroException.cannotModify("TypeVerifier");
        }

        int i = 0;

        for (Macro macro : macros) {
            if (macro == null) {
                throw ObjectMacroException.macroNull(i, "TypeVerification");
            }

            if (getMacros() != macro.getMacros()) {
                throw ObjectMacroException.diffMacros();
            }

            verifyTypeTypeVerification(macro);
            this.list_TypeVerification.add(macro);
            this.children.add(macro);
            Macro.cycleDetector.detectCycle(this, macro);

            i++;
        }
    }

    void verifyTypeTypeVerification(
            Macro macro) {

        macro.apply(new InternalsInitializer("TypeVerification") {

            @Override
            void setApplyInternalsInitializer(
                    MApplyInternalsInitializer mApplyInternalsInitializer) {

            }
        });
    }

    public void addTypeVerification(
            MApplyInternalsInitializer macro) {

        if (macro == null) {
            throw ObjectMacroException.parameterNull("TypeVerification");
        }
        if (this.cacheBuilder != null) {
            throw ObjectMacroException.cannotModify("TypeVerifier");
        }

        if (getMacros() != macro.getMacros()) {
            throw ObjectMacroException.diffMacros();
        }

        this.list_TypeVerification.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }

    public void addAllOverride(
            List<Macro> macros) {

        if (macros == null) {
            throw ObjectMacroException.parameterNull("Override");
        }
        if (this.cacheBuilder != null) {
            throw ObjectMacroException.cannotModify("TypeVerifier");
        }

        int i = 0;

        for (Macro macro : macros) {
            if (macro == null) {
                throw ObjectMacroException.macroNull(i, "Override");
            }

            if (getMacros() != macro.getMacros()) {
                throw ObjectMacroException.diffMacros();
            }

            verifyTypeOverride(macro);
            this.list_Override.add(macro);
            this.children.add(macro);
            Macro.cycleDetector.detectCycle(this, macro);

            i++;
        }
    }

    void verifyTypeOverride(
            Macro macro) {

        macro.apply(new InternalsInitializer("Override") {

            @Override
            void setOverride(
                    MOverride mOverride) {

            }
        });
    }

    public void addOverride(
            MOverride macro) {

        if (macro == null) {
            throw ObjectMacroException.parameterNull("Override");
        }
        if (this.cacheBuilder != null) {
            throw ObjectMacroException.cannotModify("TypeVerifier");
        }

        if (getMacros() != macro.getMacros()) {
            throw ObjectMacroException.diffMacros();
        }

        this.list_Override.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }

    String buildParamName() {

        return this.field_ParamName;
    }

    private String buildTypeVerification() {

        StringBuilder sb = new StringBuilder();
        Context local_context = this.TypeVerificationContext;
        List<Macro> macros = this.list_TypeVerification;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if (this.TypeVerificationNone != null) {
            sb.append(this.TypeVerificationNone.apply(i, "", nb_macros));
        }

        for (Macro macro : macros) {
            expansion = macro.build(local_context);

            if (this.TypeVerificationBeforeFirst != null) {
                expansion = this.TypeVerificationBeforeFirst.apply(i, expansion,
                        nb_macros);
            }

            if (this.TypeVerificationAfterLast != null) {
                expansion = this.TypeVerificationAfterLast.apply(i, expansion,
                        nb_macros);
            }

            if (this.TypeVerificationSeparator != null) {
                expansion = this.TypeVerificationSeparator.apply(i, expansion,
                        nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    private String buildOverride() {

        StringBuilder sb = new StringBuilder();
        Context local_context = this.OverrideContext;
        List<Macro> macros = this.list_Override;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if (this.OverrideNone != null) {
            sb.append(this.OverrideNone.apply(i, "", nb_macros));
        }

        for (Macro macro : macros) {
            expansion = macro.build(local_context);

            if (this.OverrideBeforeFirst != null) {
                expansion = this.OverrideBeforeFirst.apply(i, expansion,
                        nb_macros);
            }

            if (this.OverrideAfterLast != null) {
                expansion
                        = this.OverrideAfterLast.apply(i, expansion, nb_macros);
            }

            if (this.OverrideSeparator != null) {
                expansion
                        = this.OverrideSeparator.apply(i, expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    String getParamName() {

        return this.field_ParamName;
    }

    private InternalValue getTypeVerification() {

        return this.TypeVerificationValue;
    }

    private InternalValue getOverride() {

        return this.OverrideValue;
    }

    private void initTypeVerificationInternals(
            Context context) {

        for (Macro macro : this.list_TypeVerification) {
            macro.apply(new InternalsInitializer("TypeVerification") {

                @Override
                void setApplyInternalsInitializer(
                        MApplyInternalsInitializer mApplyInternalsInitializer) {

                    mApplyInternalsInitializer.setParamName(
                            MTypeVerifier.this.TypeVerificationContext,
                            getParamName());
                }
            });
        }
    }

    private void initOverrideInternals(
            Context context) {

        for (Macro macro : this.list_Override) {
            macro.apply(new InternalsInitializer("Override") {

                @Override
                void setOverride(
                        MOverride mOverride) {

                }
            });
        }
    }

    private void initTypeVerificationDirectives() {

    }

    private void initOverrideDirectives() {

    }

    @Override
    void apply(
            InternalsInitializer internalsInitializer) {

        internalsInitializer.setTypeVerifier(this);
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

        initTypeVerificationDirectives();
        initOverrideDirectives();

        initTypeVerificationInternals(null);
        initOverrideInternals(null);

        StringBuilder sb0 = new StringBuilder();

        sb0.append(buildOverride());
        sb0.append(LINE_SEPARATOR);
        sb0.append("void verifyType");
        sb0.append(buildParamName());
        sb0.append(" (Macro macro) ");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("    ");
        indentations.add(sb2.toString());
        sb1.append(buildTypeVerification());
        sb0.append(applyIndent(sb1.toString(),
                indentations.remove(indentations.size() - 1)));
        sb0.append(LINE_SEPARATOR);
        sb0.append("}");

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
