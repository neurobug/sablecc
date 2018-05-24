/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.intermediate.macro;

public class MCannotModify {

    private final String pMacroName;

    private final MCannotModify mCannotModify = this;

    public MCannotModify(
            String pMacroName) {

        if (pMacroName == null) {
            throw new NullPointerException();
        }
        this.pMacroName = pMacroName;
    }

    String pMacroName() {

        return this.pMacroName;
    }

    private String rMacroName() {

        return this.mCannotModify.pMacroName();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(new MObjectMacroErrorHead().toString());
        sb.append(System.getProperty("line.separator"));
        sb.append("Instance of M");
        sb.append(rMacroName());
        sb.append(" cannot be updated after calling the method built.");
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }

}
