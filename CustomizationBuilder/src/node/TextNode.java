package node;

public class TextNode extends VisibleNode {

	protected String text;
	protected TextAlign align;
	protected String font;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public TextAlign getAlign() {
		return align;
	}
	public void setAlign(TextAlign align) {
		this.align = align;
	}
	
	public String getFont() {
		return font;
	}
	public void setFont(String font) {
		this.font = font;
	}
	
}
