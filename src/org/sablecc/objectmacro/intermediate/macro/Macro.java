/* This file was generated by SableCC's ObjectMacro. */

package org.sablecc.objectmacro.intermediate.macro;

import java.util.*;

public abstract class Macro {

    final static String LINE_SEPARATOR = System.getProperty("line.separator");

    BuildState build_state = null;

    final Map<Context, BuildState> build_states = new LinkedHashMap<>();

    final LinkedList<Macro> children = new LinkedList<>();

    static final CycleDetector cycleDetector = new CycleDetector();

    public String build() {

        throw new RuntimeException("build cannot be invoked here");
    }

    String build(
            Context context) {

        throw new RuntimeException("build cannot be invoked here");
    }

    void apply(
            InternalsInitializer internalsInitializer) {

        throw new RuntimeException("apply cannot be called here");
    }

    LinkedList<Macro> getChildren() {

        return this.children;
    }
}
