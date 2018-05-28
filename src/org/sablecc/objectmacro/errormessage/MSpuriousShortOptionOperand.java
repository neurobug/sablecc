/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.errormessage;

import java.util.*;

public class MSpuriousShortOptionOperand
        extends Macro {

    String field_OptionName;

    String field_OperandText;

    MSpuriousShortOptionOperand(
            String pOptionName,
            String pOperandText,
            Macros macros) {

        setMacros(macros);
        setPOptionName(pOptionName);
        setPOperandText(pOperandText);
    }

    private void setPOptionName(
            String pOptionName) {

        if (pOptionName == null) {
            throw ObjectMacroException.parameterNull("OptionName");
        }

        this.field_OptionName = pOptionName;
    }

    private void setPOperandText(
            String pOperandText) {

        if (pOperandText == null) {
            throw ObjectMacroException.parameterNull("OperandText");
        }

        this.field_OperandText = pOperandText;
    }

    String buildOptionName() {

        return this.field_OptionName;
    }

    String buildOperandText() {

        return this.field_OperandText;
    }

    String getOptionName() {

        return this.field_OptionName;
    }

    String getOperandText() {

        return this.field_OperandText;
    }

    @Override
    void apply(
            InternalsInitializer internalsInitializer) {

        internalsInitializer.setSpuriousShortOptionOperand(this);
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

        MCommandLineErrorHead m1 = getMacros().newCommandLineErrorHead();

        sb0.append(m1.build(null));
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        sb0.append("The following option is rejected:");
        sb0.append(LINE_SEPARATOR);
        sb0.append(" -");
        sb0.append(buildOptionName());
        sb0.append("=");
        sb0.append(buildOperandText());
        sb0.append(LINE_SEPARATOR);
        sb0.append("This option does not accept an operand.");
        sb0.append(LINE_SEPARATOR);
        sb0.append(LINE_SEPARATOR);
        MCommandLineErrorTail m2 = getMacros().newCommandLineErrorTail();

        sb0.append(m2.build(null));

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
