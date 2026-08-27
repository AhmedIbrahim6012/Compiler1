package CodeGeneration;
public class CodeWriter {

    private final StringBuilder builder = new StringBuilder();
    private int indent = 0;

    public void indent() {
        indent++;
    }

    public void dedent() {
        indent--;
    }

    public void writeln(String line) {
        builder.append("    ".repeat(Math.max(0, indent)));
        builder.append(line);
        builder.append("\n");
    }

    public void write(String text) {
        builder.append(text);
    }

    public String getCode() {
        return builder.toString();
    }
}