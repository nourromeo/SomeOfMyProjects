import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;
import javax.swing.JComponent;

class paint extends JComponent {
	private String text;

	public paint(String text, Color Color) {
		super();
		this.text = text;
		setFont(new Font("Sans", Font.BOLD, 160));
		this.setForeground(Color);

		
	}
	
	@Override
	public Dimension getPreferredSize() {
		Graphics2D g = (Graphics2D)this.getGraphics();
		g.setFont(getFont());
		var matrics = g.getFontMetrics().getStringBounds(this.text, g);
		
		return new Dimension((int)matrics.getWidth() + 10, (int)matrics.getHeight() + 10);
	}
	
	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		Graphics2D g = (Graphics2D)arg0;
		
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		g.setFont(getFont());
		g.drawString(text, 5, 130);
		
		g.setColor(Color.blue);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		
	}
	
	
}
