package model;

import view.DlgGroup;
import view.DlgStudent;
import view.IDlg;

public class Group extends AnyData {
	private String curatorName;
	private int countStud;
	public Group(String name, String curatorName,
			int countStud) {
		this.name = name;
		this.curatorName = curatorName;
		this.countStud = countStud;
	}
	public String getCuratorName() {
		return curatorName;
	}
	public void setCuratorName(String curatorName) {
		this.curatorName = curatorName;
	}
	public int getCountStud() {
		return countStud;
	}
	public void setCountStud(int countStud) {
		this.countStud = countStud;
	}
	@Override
	public IDlg getDialog() {
		return new DlgGroup();
	}
	@Override
	public IDlg getSonDialog() {
		return new DlgStudent();
	}
}
