package view;

import model.AnyData;

public interface IDlg {
	public void setVisible(boolean b);
	public void dispose();
	
	public void setEditable(boolean b);
	public void setData(AnyData obj);
	public void clear();
	public AnyData getObject();
	
	default void showObject(AnyData obj, boolean b) {
		if (obj == null)
			this.clear();
		else
			setData(obj);
		setEditable(b);
		setVisible(true);
	}

}
