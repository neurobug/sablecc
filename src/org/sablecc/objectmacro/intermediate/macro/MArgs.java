/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.intermediate.macro;

import java.util.*;

public class MArgs
        extends Macro {

    private final List<Macro> list_Arguments;

    private DSeparator ArgumentsSeparator;

    private DBeforeFirst ArgumentsBeforeFirst;

    private DAfterLast ArgumentsAfterLast;

    private DNone ArgumentsNone;

    private final InternalValue ArgumentsValue;

    private final Context ArgumentsContext = new Context();

    public MArgs() {

        this.list_Arguments = new ArrayList<>();

        this.ArgumentsValue
                = new InternalValue(this.list_Arguments, this.ArgumentsContext);
    }

    public void addArguments(
            MVarArgument macro) {

        if (macro == null) {
            throw ObjectMacroException.parameterNull("Arguments");
        }
        if (this.build_state != null) {
            throw ObjectMacroException.cannotModify("VarArgument");
        }

        this.list_Arguments.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }

    public void addArguments(
            MTextArgument macro) {

        if (macro == null) {
            throw ObjectMacroException.parameterNull("Arguments");
        }
        if (this.build_state != null) {
            throw ObjectMacroException.cannotModify("TextArgument");
        }

        this.list_Arguments.add(macro);
        this.children.add(macro);
        Macro.cycleDetector.detectCycle(this, macro);
    }

    private String buildArguments() {

        StringBuilder sb = new StringBuilder();
        Context local_context = this.ArgumentsContext;
        List<Macro> macros = this.list_Arguments;

        int i = 0;
        int nb_macros = macros.size();
        String expansion = null;

        if (this.ArgumentsNone != null) {
            sb.append(this.ArgumentsNone.apply(i, "", nb_macros));
        }

        for (Macro macro : macros) {
            expansion = macro.build(local_context);

            if (this.ArgumentsBeforeFirst != null) {
                expansion = this.ArgumentsBeforeFirst.apply(i, expansion,
                        nb_macros);
            }

            if (this.ArgumentsAfterLast != null) {
                expansion = this.ArgumentsAfterLast.apply(i, expansion,
                        nb_macros);
            }

            if (this.ArgumentsSeparator != null) {
                expansion = this.ArgumentsSeparator.apply(i, expansion,
                        nb_macros);
            }

            sb.append(expansion);
            i++;
        }

        return sb.toString();
    }

    private InternalValue getArguments() {

        return this.ArgumentsValue;
    }

    private void initArgumentsInternals(
            Context context) {

        for (Macro macro : this.list_Arguments) {
            macro.apply(new InternalsInitializer("Arguments") {

                @Override
                void setVarArgument(
                        MVarArgument mVarArgument) {

                }

                @Override
                void setTextArgument(
                        MTextArgument mTextArgument) {

                }
            });
        }
    }

    private void initArgumentsDirectives() {

        StringBuilder sb0 = new StringBuilder();
        sb0.append(", ");
        this.ArgumentsSeparator = new DSeparator(sb0.toString());
        this.ArgumentsValue.setSeparator(this.ArgumentsSeparator);
    }

    @Override
    void apply(
            InternalsInitializer internalsInitializer) {

        internalsInitializer.setArgs(this);
    }

    @Override
    public String build() {

        BuildState buildState = this.build_state;

        if (buildState == null) {
            buildState = new BuildState();
        }
        else if (buildState.getExpansion() == null) {
            throw ObjectMacroException.cyclicReference("Args");
        }
        else {
            return buildState.getExpansion();
        }
        this.build_state = buildState;
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();

        initArgumentsDirectives();

        initArgumentsInternals(null);

        StringBuilder sb0 = new StringBuilder();

        sb0.append("Args");
        sb0.append("{");
        sb0.append(LINE_SEPARATOR);
        StringBuilder sb1 = new StringBuilder();
        sbIndentation = new StringBuilder();
        sbIndentation.append("    ");
        indentations.add(sbIndentation.toString());
        sb1.append(buildArguments());
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
