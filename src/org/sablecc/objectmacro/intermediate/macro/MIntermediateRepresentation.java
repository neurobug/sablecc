/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.intermediate.macro;

import java.util.*;

public class MIntermediateRepresentation
        extends Macro {

    final List<Macro> list_DefinedMacros;

    final Context DefinedMacrosContext = new Context();

    final InternalValue DefinedMacrosValue;

    private DSeparator DefinedMacrosSeparator;

    private DBeforeFirst DefinedMacrosBeforeFirst;

    private DAfterLast DefinedMacrosAfterLast;

    private DNone DefinedMacrosNone;

    final List<Macro> list_VersionDefinition;

    final Context VersionDefinitionContext = new Context();

    final InternalValue VersionDefinitionValue;

    private DSeparator VersionDefinitionSeparator;

    private DBeforeFirst VersionDefinitionBeforeFirst;

    private DAfterLast VersionDefinitionAfterLast;

    private DNone VersionDefinitionNone;

    MIntermediateRepresentation(
            Macros macros) {

        setMacros(macros);
        this.list_DefinedMacros = new LinkedList<>();
        this.list_VersionDefinition = new LinkedList<>();

        this.DefinedMacrosValue = new InternalValue(this.list_DefinedMacros,
                this.DefinedMacrosContext);
        this.VersionDefinitionValue = new InternalValue(
                this.list_VersionDefinition, this.VersionDefinitionContext);
    }

    public void addAllDefinedMacros(
            List<Macro> macros) {

        if (macros == null) {
            throw ObjectMacroException.parameterNull("DefinedMacros");
        }
        if (this.cacheBuilder != null) {
            throw ObjectMacroException
                    .cannotModify("IntermediateRepresentation");
        }

        int i = 0;

        for (Macro macro : macros) {
            if (macro == null) {
                throw ObjectMacroException.macroNull(i, "DefinedMacros");
            }

            if (getMacros() != macro.getMacros()) {
                throw ObjectMacroException.diffMacros();
            }

            verifyTypeDefinedMacros(macro);
            this.list_DefinedMacros.add(macro);
            this.children.add(macro);
            Macro.cycleDetector.detectCycle(this, macro);

            i++;
        }
    }

    void verifyTypeDefinedMacros(
            Macro macro) {

        macro.apply(new InternalsInitializer("DefinedMacros") {

            @Override
            void setMacro(
                    MMacro mMacro) {

            }
        });
    }

    public void addDefinedMacros(
            MMacro macro) {

        if (macro == null) {
            throw ObjectMacroException.parameterNull("DefinedMacros");
        }
        if (this.cacheBuilder != null) {
            throw ObjectMacroException
                    .cannotModify("IntermediateRepresentation");
        }

        if (getMacros() != macro.getMacros()) {
            throw ObjectMacroException.diffMacros();
        }

        this.list_DefinedMacros.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }

    public void addAllVersionDefinition(
            List<Macro> macros) {

        if (macros == null) {
            throw ObjectMacroException.parameterNull("VersionDefinition");
        }
        if (this.cacheBuilder != null) {
            throw ObjectMacroException
                    .cannotModify("IntermediateRepresentation");
        }

        int i = 0;

        for (Macro macro : macros) {
            if (macro == null) {
                throw ObjectMacroException.macroNull(i, "VersionDefinition");
            }

            if (getMacros() != macro.getMacros()) {
                throw ObjectMacroException.diffMacros();
            }

            verifyTypeVersionDefinition(macro);
            this.list_VersionDefinition.add(macro);
            this.children.add(macro);
            Macro.cycleDetector.detectCycle(this, macro);

            i++;
        }
    }

    void verifyTypeVersionDefinition(
            Macro macro) {

        macro.apply(new InternalsInitializer("VersionDefinition") {

            @Override
            void setVersions(
                    MVersions mVersions) {

            }
        });
    }

    public void addVersionDefinition(
            MVersions macro) {

        if (macro == null) {
            throw ObjectMacroException.parameterNull("VersionDefinition");
        }
        if (this.cacheBuilder != null) {
            throw ObjectMacroException
                    .cannotModify("IntermediateRepresentation");
        }

        if (getMacros() != macro.getMacros()) {
            throw ObjectMacroException.diffMacros();
        }

        this.list_VersionDefinition.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }

    private String buildDefinedMacros() {

        StringBuilder sb = new StringBuilder();
        Context local_context = this.DefinedMacrosContext;
        List<Macro> macros = this.list_DefinedMacros;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if (this.DefinedMacrosNone != null) {
            sb.append(this.DefinedMacrosNone.apply(i, "", nb_macros));
        }

        for (Macro macro : macros) {
            expansion = macro.build(local_context);

            if (this.DefinedMacrosBeforeFirst != null) {
                expansion = this.DefinedMacrosBeforeFirst.apply(i, expansion,
                        nb_macros);
            }

            if (this.DefinedMacrosAfterLast != null) {
                expansion = this.DefinedMacrosAfterLast.apply(i, expansion,
                        nb_macros);
            }

            if (this.DefinedMacrosSeparator != null) {
                expansion = this.DefinedMacrosSeparator.apply(i, expansion,
                        nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    private String buildVersionDefinition() {

        StringBuilder sb = new StringBuilder();
        Context local_context = this.VersionDefinitionContext;
        List<Macro> macros = this.list_VersionDefinition;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if (this.VersionDefinitionNone != null) {
            sb.append(this.VersionDefinitionNone.apply(i, "", nb_macros));
        }

        for (Macro macro : macros) {
            expansion = macro.build(local_context);

            if (this.VersionDefinitionBeforeFirst != null) {
                expansion = this.VersionDefinitionBeforeFirst.apply(i,
                        expansion, nb_macros);
            }

            if (this.VersionDefinitionAfterLast != null) {
                expansion = this.VersionDefinitionAfterLast.apply(i, expansion,
                        nb_macros);
            }

            if (this.VersionDefinitionSeparator != null) {
                expansion = this.VersionDefinitionSeparator.apply(i, expansion,
                        nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    private InternalValue getDefinedMacros() {

        return this.DefinedMacrosValue;
    }

    private InternalValue getVersionDefinition() {

        return this.VersionDefinitionValue;
    }

    private void initDefinedMacrosInternals(
            Context context) {

        for (Macro macro : this.list_DefinedMacros) {
            macro.apply(new InternalsInitializer("DefinedMacros") {

                @Override
                void setMacro(
                        MMacro mMacro) {

                }
            });
        }
    }

    private void initVersionDefinitionInternals(
            Context context) {

        for (Macro macro : this.list_VersionDefinition) {
            macro.apply(new InternalsInitializer("VersionDefinition") {

                @Override
                void setVersions(
                        MVersions mVersions) {

                }
            });
        }
    }

    private void initDefinedMacrosDirectives() {

        StringBuilder sb1 = new StringBuilder();
        sb1.append(LINE_SEPARATOR);
        this.DefinedMacrosSeparator = new DSeparator(sb1.toString());
        this.DefinedMacrosValue.setSeparator(this.DefinedMacrosSeparator);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(LINE_SEPARATOR);
        this.DefinedMacrosBeforeFirst = new DBeforeFirst(sb2.toString());
        this.DefinedMacrosValue.setBeforeFirst(this.DefinedMacrosBeforeFirst);
    }

    private void initVersionDefinitionDirectives() {

    }

    @Override
    void apply(
            InternalsInitializer internalsInitializer) {

        internalsInitializer.setIntermediateRepresentation(this);
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

        initDefinedMacrosDirectives();
        initVersionDefinitionDirectives();

        initDefinedMacrosInternals(null);
        initVersionDefinitionInternals(null);

        StringBuilder sb0 = new StringBuilder();

        sb0.append(buildVersionDefinition());
        sb0.append(LINE_SEPARATOR);
        sb0.append(buildDefinedMacros());

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
