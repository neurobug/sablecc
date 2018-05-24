/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.codegeneration.java.macro;

import java.util.*;

public class MInitStringBuilder
        extends Macro {

    private String field_IndexBuilder;

    public MInitStringBuilder(
            String pIndexBuilder) {

        setPIndexBuilder(pIndexBuilder);

    }

    private void setPIndexBuilder(
            String pIndexBuilder) {

        if (pIndexBuilder == null) {

            throw ObjectMacroException.parameterNull("IndexBuilder");

        }

        this.field_IndexBuilder = pIndexBuilder;

    }

    private String buildIndexBuilder() {

        return this.field_IndexBuilder;

    }

    private String getIndexBuilder() {

        return this.field_IndexBuilder;

    }

    @Override

    void apply(

            InternalsInitializer internalsInitializer) {

        internalsInitializer.setInitStringBuilder(this);

    }

    @Override

    public String build() {

        BuildState buildState = this.build_state;

        if (buildState == null) {

            buildState = new BuildState();

        }

        else if (buildState.getExpansion() == null) {

            throw ObjectMacroException.cyclicReference("InitStringBuilder");

        }

        else {

            return buildState.getExpansion();

        }

        this.build_state = buildState;

        List<String> indentations = new LinkedList<>();

        StringBuilder sbIndentation = new StringBuilder();

        StringBuilder sb0 = new StringBuilder();

        sb0.append("StringBuilder sb");

        sb0.append(buildIndexBuilder());

        sb0.append(" = new StringBuilder();");

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
