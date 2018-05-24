/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.errormessage;

import java.util.*;

public class MUnknownVersion
        extends Macro {

    private String field_Name;

    private String field_Line;

    private String field_Char;

    public MUnknownVersion(
            String pName,
            String pLine,
            String pChar) {

        setPName(pName);
        setPLine(pLine);
        setPChar(pChar);

    }

    private void setPName(
            String pName) {

        if (pName == null) {
            throw ObjectMacroException.parameterNull("Name");
        }

        this.field_Name = pName;
    }

    private void setPLine(
            String pLine) {

        if (pLine == null) {
            throw ObjectMacroException.parameterNull("Line");
        }

        this.field_Line = pLine;
    }

    private void setPChar(
            String pChar) {

        if (pChar == null) {
            throw ObjectMacroException.parameterNull("Char");
        }

        this.field_Char = pChar;
    }

    private String buildName() {

        return this.field_Name;
    }

    private String buildLine() {

        return this.field_Line;
    }

    private String buildChar() {

        return this.field_Char;
    }

    private String getName() {

        return this.field_Name;
    }

    private String getLine() {

        return this.field_Line;
    }

    private String getChar() {

        return this.field_Char;
    }

    @Override
    void apply(
            InternalsInitializer internalsInitializer) {

        internalsInitializer.setUnknownVersion(this);
    }

    @Override
    public String build() {

        BuildState buildState = this.build_state;

        if (buildState == null) {
            buildState = new BuildState();
        }
        else if (buildState.getExpansion() == null) {
            throw ObjectMacroException.cyclicReference("UnknownVersion");
        }
        else {
            return buildState.getExpansion();
        }
        this.build_state = buildState;
        List<String> indentations = new LinkedList<>();
        StringBuilder sbIndentation = new StringBuilder();

        StringBuilder sb0 = new StringBuilder();

        MSemanticErrorHead minsert_1 = new MSemanticErrorHead();

        sb0.append(minsert_1.build(null));
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("Line: ");
        sb0.append(buildLine());
        sb0.append(LINE_SEPARATOR);
        sb0.append("Char: ");
        sb0.append(buildChar());
        sb0.append(LINE_SEPARATOR);
        sb0.append("Version \"");
        sb0.append(buildName());
        sb0.append("\" does not exist.");

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
