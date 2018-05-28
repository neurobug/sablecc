/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.errormessage;

import java.util.*;

public class MInternalError
        extends Macro {

    String field_StackTrace;

    String field_Message;

    MInternalError(
            String pStackTrace,
            String pMessage,
            Macros macros) {

        setMacros(macros);
        setPStackTrace(pStackTrace);
        setPMessage(pMessage);
    }

    private void setPStackTrace(
            String pStackTrace) {

        if (pStackTrace == null) {
            throw ObjectMacroException.parameterNull("StackTrace");
        }

        this.field_StackTrace = pStackTrace;
    }

    private void setPMessage(
            String pMessage) {

        if (pMessage == null) {
            throw ObjectMacroException.parameterNull("Message");
        }

        this.field_Message = pMessage;
    }

    String buildStackTrace() {

        return this.field_StackTrace;
    }

    String buildMessage() {

        return this.field_Message;
    }

    String getStackTrace() {

        return this.field_StackTrace;
    }

    String getMessage() {

        return this.field_Message;
    }

    @Override
    void apply(
            InternalsInitializer internalsInitializer) {

        internalsInitializer.setInternalError(this);
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

        sb0.append("*** INTERNAL ERROR ***");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append(buildStackTrace());
        sb0.append(LINE_SEPARATOR);
        sb0.append("An internal error was raised with the following message:");
        sb0.append(LINE_SEPARATOR);
        sb0.append(" ");
        sb0.append(buildMessage());
        sb0.append(".");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append(
                "Please submit a defect ticket with the full error trace above on:");
        sb0.append(LINE_SEPARATOR);
        sb0.append(" http://sablecc.org/");

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
