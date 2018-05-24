/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.intermediate.macro;

import java.util.*;

public class MVersions
        extends Macro {

    private final List<Macro> list_Versions;

    private DSeparator VersionsSeparator;

    private DBeforeFirst VersionsBeforeFirst;

    private DAfterLast VersionsAfterLast;

    private DNone VersionsNone;

    private final InternalValue VersionsValue;

    private final Context VersionsContext = new Context();

    public MVersions() {

        this.list_Versions = new ArrayList<>();

        this.VersionsValue
                = new InternalValue(this.list_Versions, this.VersionsContext);
    }

    public void addVersions(
            MSimpleName macro) {

        if (macro == null) {
            throw ObjectMacroException.parameterNull("Versions");
        }
        if (this.build_state != null) {
            throw ObjectMacroException.cannotModify("SimpleName");
        }

        this.list_Versions.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }

    private String buildVersions() {

        StringBuilder sb = new StringBuilder();
        Context local_context = this.VersionsContext;
        List<Macro> macros = this.list_Versions;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if (this.VersionsNone != null) {
            sb.append(this.VersionsNone.apply(i, "", nb_macros));
        }

        for (Macro macro : macros) {
            expansion = macro.build(local_context);

            if (this.VersionsBeforeFirst != null) {
                expansion = this.VersionsBeforeFirst.apply(i, expansion,
                        nb_macros);
            }

            if (this.VersionsAfterLast != null) {
                expansion
                        = this.VersionsAfterLast.apply(i, expansion, nb_macros);
            }

            if (this.VersionsSeparator != null) {
                expansion
                        = this.VersionsSeparator.apply(i, expansion, nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    private InternalValue getVersions() {

        return this.VersionsValue;
    }

    private void initVersionsInternals(
            Context context) {

        for (Macro macro : this.list_Versions) {
            macro.apply(new InternalsInitializer("Versions") {

                @Override
                void setSimpleName(
                        MSimpleName mSimpleName) {

                }
            });
        }
    }

    private void initVersionsDirectives() {

        StringBuilder sb0 = new StringBuilder();
        sb0.append(", ");
        sb0.append(LINE_SEPARATOR);
        this.VersionsSeparator = new DSeparator(sb0.toString());
        this.VersionsValue.setSeparator(this.VersionsSeparator);
    }

    @Override
    void apply(
            InternalsInitializer internalsInitializer) {

        internalsInitializer.setVersions(this);
    }

    @Override
    public String build() {

        BuildState buildState = this.build_state;

        if (buildState == null) {
            buildState = new BuildState();
        }
        else if (buildState.getExpansion() == null) {
            throw ObjectMacroException.cyclicReference("Versions");
        }
        else {
            return buildState.getExpansion();
        }
        this.build_state = buildState;
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();

        initVersionsDirectives();

        initVersionsInternals(null);

        StringBuilder sb0 = new StringBuilder();

        sb0.append("Version ");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        StringBuilder sb1 = new StringBuilder();
        sbIndentation = new StringBuilder();
        sbIndentation.append("    ");
        indentations.add(sbIndentation.toString());
        sb1.append(buildVersions());
        sb0.append(applyIndent(sb1.toString(),
                indentations.remove(indentations.size() - 1)));
        sb0.append(LINE_SEPARATOR);
        sb0.append("}");

        buildState.setExpansion(sb0.toString());
        return sb0.toString();
    }

    @Override
    String build(
            Context context) {

        return build();
    }

    private String applyIndent(
            String macro,
            String indent) {

        StringBuilder sb = new StringBuilder();
        String[] lines = macro.split("\n");

        if (lines.length > 1) {
            for (int i = 0; i < lines.length; i++) {
                String line = lines[i];
                sb.append(indent).append(line);

                if (i < lines.length - 1) {
                    sb.append(LINE_SEPARATOR);
                }
            }
        }
        else {
            sb.append(indent).append(macro);
        }

        return sb.toString();
    }
}
