/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.macro;

public class M_top_level_text_block_accessor
        extends Macro {

    // ---- EOL ----
    private static final String EOL = System.getProperty("line.separator");

    // ---- parameters ----
    private final String p_text_block_name;

    // ---- text blocks ----

    // ---- expands ----

    // ---- parent ----
    @Override
    public Macro get_parent() {

        return null;
    }

    // ---- constructor ----
    M_top_level_text_block_accessor(
            String p_text_block_name) {

        this.p_text_block_name = p_text_block_name;
    }

    // ---- local parameter accessors ----

    String get_local_p_text_block_name() {

        return this.p_text_block_name;
    }

    // ---- local text block accessors ----

    // ---- parameter accessors ----

    private String cached_p_text_block_name;

    String get_p_text_block_name() {

        String result = this.cached_p_text_block_name;
        if (result == null) {
            Macro current = this;
            while (!(current instanceof M_top_level_text_block_accessor)) {
                current = current.get_parent();
            }
            result = ((M_top_level_text_block_accessor) current)
                    .get_local_p_text_block_name();
            this.cached_p_text_block_name = result;
        }
        return result;
    }

    // ---- text block accessors ----

    // sub-macro creators

    // ---- append ----

    @Override
    public void appendTo(
            StringBuilder sb) {

        sb.append("  private T_");
        sb.append(get_p_text_block_name());
        sb.append(" cached_t_");
        sb.append(get_p_text_block_name());
        sb.append(";");
        sb.append(EOL);
        sb.append(EOL);
        sb.append("  T_");
        sb.append(get_p_text_block_name());
        sb.append(" get_t_");
        sb.append(get_p_text_block_name());
        sb.append("() {");
        sb.append(EOL);
        sb.append("    T_");
        sb.append(get_p_text_block_name());
        sb.append(" result = this.cached_t_");
        sb.append(get_p_text_block_name());
        sb.append(";");
        sb.append(EOL);
        sb.append(EOL);
        sb.append("    if(result == null) {");
        sb.append(EOL);
        sb.append("      result = T_");
        sb.append(get_p_text_block_name());
        sb.append(".getInstance();");
        sb.append(EOL);
        sb.append("      this.cached_t_");
        sb.append(get_p_text_block_name());
        sb.append(" = result;");
        sb.append(EOL);
        sb.append("    }");
        sb.append(EOL);
        sb.append(EOL);
        sb.append("    return result;");
        sb.append(EOL);
        sb.append("  }");
        sb.append(EOL);
        sb.append(EOL);
    }
}
