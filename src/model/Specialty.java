package model;

import view.DlgGroup;
import view.DlgSpecialty;
import view.IDlg;

public class Specialty extends AnyData {
	private String specCode;
	private int countStud;
	
	public Specialty(String specCode, String name, int countStud) {
		super();
		this.specCode = specCode;
		this.name = name;
		this.countStud = countStud;
	}
	
	public String getSpecCode() {
		return specCode;
	}
	public void setSpecCode(String specCode) {
		this.specCode = specCode;
	}
	public int getCountStud() {
		return countStud;
	}
	public void setCountStud(int countStud) {
		this.countStud = countStud;
	}

	@Override
	public IDlg getDialog() {
		return new DlgSpecialty();
	}

	@Override
	public IDlg getSonDialog() {
		return new DlgGroup();
	}
}
