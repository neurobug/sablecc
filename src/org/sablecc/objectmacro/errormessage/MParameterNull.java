/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.errormessage;

public class MParameterNull {

    private final String pParamName;

    private final MParameterNull mParameterNull = this;

    public MParameterNull(
            String pParamName) {

        if (pParamName == null) {
            throw new NullPointerException();
        }
        this.pParamName = pParamName;
    }

    String pParamName() {

        return this.pParamName;
    }

    private String rParamName() {

        return this.mParameterNull.pParamName();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Parameter '");
        sb.append(rParamName());
        sb.append("' cannot be null.");
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }

}
