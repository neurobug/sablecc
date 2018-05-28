/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.errormessage;

import java.util.*;

public class MSelfReference
        extends Macro {

    String field_Reference;

    String field_Line;

    String field_Char;

    String field_Context;

    String field_ContextLine;

    String field_ContextChar;

    MSelfReference(
            String pReference,
            String pLine,
            String pChar,
            String pContext,
            String pContextLine,
            String pContextChar,
            Macros macros) {

        setMacros(macros);
        setPReference(pReference);
        setPLine(pLine);
        setPChar(pChar);
        setPContext(pContext);
        setPContextLine(pContextLine);
        setPContextChar(pContextChar);
    }

    private void setPReference(
            String pReference) {

        if (pReference == null) {
            throw ObjectMacroException.parameterNull("Reference");
        }

        this.field_Reference = pReference;
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

    private void setPContext(
            String pContext) {

        if (pContext == null) {
            throw ObjectMacroException.parameterNull("Context");
        }

        this.field_Context = pContext;
    }

    private void setPContextLine(
            String pContextLine) {

        if (pContextLine == null) {
            throw ObjectMacroException.parameterNull("ContextLine");
        }

        this.field_ContextLine = pContextLine;
    }

    private void setPContextChar(
            String pContextChar) {

        if (pContextChar == null) {
            throw ObjectMacroException.parameterNull("ContextChar");
        }

        this.field_ContextChar = pContextChar;
    }

    String buildReference() {

        return this.field_Reference;
    }

    String buildLine() {

        return this.field_Line;
    }

    String buildChar() {

        return this.field_Char;
    }

    String buildContext() {

        return this.field_Context;
    }

    String buildContextLine() {

        return this.field_ContextLine;
    }

    String buildContextChar() {

        return this.field_ContextChar;
    }

    String getReference() {

        return this.field_Reference;
    }

    String getLine() {

        return this.field_Line;
    }

    String getChar() {

        return this.field_Char;
    }

    String getContext() {

        return this.field_Context;
    }

    String getContextLine() {

        return this.field_ContextLine;
    }

    String getContextChar() {

        return this.field_ContextChar;
    }

    @Override
    void apply(
            InternalsInitializer internalsInitializer) {

        internalsInitializer.setSelfReference(this);
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

        StringBuilder sb0 = new StringBuilder();

        MSemanticErrorHead m1 = getMacros().newSemanticErrorHead();

        sb0.append(m1.build(null));
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("Line: ");
        sb0.append(buildLine());
        sb0.append(LINE_SEPARATOR);
        sb0.append("Char: ");
        sb0.append(buildChar());
        sb0.append(LINE_SEPARATOR);
        sb0.append("\"");
        sb0.append(buildReference());
        sb0.append("\" is a self reference to \"");
        sb0.append(buildContext());
        sb0.append("\" of line ");
        sb0.append(buildContextLine());
        sb0.append(", char ");
        sb0.append(buildContextChar());
        sb0.append(".");

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
