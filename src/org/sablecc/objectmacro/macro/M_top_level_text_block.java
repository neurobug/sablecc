/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.macro;

public class M_top_level_text_block
        extends Macro {

    // ---- EOL ----
    private static final String EOL = System.getProperty("line.separator");

    // ---- parameters ----

    // ---- text blocks ----

    // ---- expands ----

    // ---- parent ----
    private final Macro parent;

    @Override
    public Macro get_parent() {

        return this.parent;
    }

    // ---- constructor ----
    M_top_level_text_block(
            Macro parent) {

        this.parent = parent;
    }

    // ---- local parameter accessors ----

    // ---- local text block accessors ----

    // ---- parameter accessors ----

    private String cached_p_block_name;

    String get_p_block_name() {

        String result = this.cached_p_block_name;
        if (result == null) {
            Macro current = this;
            while (!(current instanceof M_text_block)) {
                current = current.get_parent();
            }
            result = ((M_text_block) current).get_local_p_block_name();
            this.cached_p_block_name = result;
        }
        return result;
    }

    // ---- text block accessors ----

    // sub-macro creators

    // ---- append ----

    @Override
    public void appendTo(
            StringBuilder sb) {

        sb.append("  // ---- constructor ----");
        sb.append(EOL);
        sb.append(EOL);
        sb.append("  private T_");
        sb.append(get_p_block_name());
        sb.append("() {");
        sb.append(EOL);
        sb.append("  }");
        sb.append(EOL);
        sb.append(EOL);
        sb.append("  // ---- instance ----");
        sb.append(EOL);
        sb.append(EOL);
        sb.append("  private static final T_");
        sb.append(get_p_block_name());
        sb.append(" instance = new T_");
        sb.append(get_p_block_name());
        sb.append("();");
        sb.append(EOL);
        sb.append(EOL);
        sb.append("  static T_");
        sb.append(get_p_block_name());
        sb.append(" getInstance() {");
        sb.append(EOL);
        sb.append("    return instance;");
        sb.append(EOL);
        sb.append("  }");
        sb.append(EOL);
        sb.append(EOL);
    }
}
