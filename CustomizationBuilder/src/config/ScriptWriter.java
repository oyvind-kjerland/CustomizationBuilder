package config;

public class ScriptWriter {

	
	private String script;
	private int indentLevel;
	
	public ScriptWriter() {
		script = "";
		indentLevel = 0;
	}
	
	public void setIndentLevel(int indentLevel) {
		this.indentLevel = indentLevel;
	}
	
	public int getIndentLevel() {
		return indentLevel;
	}
	
	public void indent() {
		indentLevel++;
	}
	
	public void deindent() {
		indentLevel--;
	}
	
	public String getScript() {
		return script;
	}
	
	public void clear() {
		script = "";
		indentLevel = 0;
	}
	
	public void newLine() {
		String indent = "";
		for (int i=0; i<indentLevel; i++) {
			indent+="\t";
		}
		script += "\n"+indent;
	}
	
	public void append(String string) {
		script += string;
	}
	
}
