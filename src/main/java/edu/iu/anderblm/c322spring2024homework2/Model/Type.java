package edu.iu.anderblm.c322spring2024homework2.Model;

public enum Type {
    ACOUSTIC, ELECTRIC;

    public String toString() {
        switch(this) {
            case ACOUSTIC: return "Acoustic";
            case ELECTRIC: return "Electric";
            default: return "Unspecified";
        }
    }
}
