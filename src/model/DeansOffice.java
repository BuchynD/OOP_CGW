package model;

import view.DlgDeansOffice;
import view.DlgSpecialty;
import view.IDlg;

public class DeansOffice extends AnyData {
	private String deanName;

	public DeansOffice(String name, String deanName) {
		this.name = name;
		this.deanName = deanName;
	}

	public String getDeanName() {
		return deanName;
	}

	public void setDeanName(String deanName) {
		this.deanName = deanName;
	}

	@Override
	public IDlg getDialog() {
		return new DlgDeansOffice();
	}

	@Override
	public IDlg getSonDialog() {
		// TODO Auto-generated method stub
		return new DlgSpecialty();
	}
}
