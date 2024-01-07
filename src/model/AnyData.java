package model;

import java.io.Serializable;

import view.IDlg;

public abstract class AnyData implements Serializable {
	public abstract IDlg getDialog();
	public abstract IDlg getSonDialog();
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
