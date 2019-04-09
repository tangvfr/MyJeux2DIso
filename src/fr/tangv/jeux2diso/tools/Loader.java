package fr.tangv.jeux2diso.tools;

import java.util.ArrayList;

public class Loader {

	private boolean start = false;
	private int number;
	private int numbercursor;
	ArrayList<Loading> listloading = new ArrayList<Loading>();
	
	public boolean addLoading(Loading[] loading) {
		if (!start) {
			for (Loading load : loading) {
				listloading.add(load);
			}
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addLoading(Loading loading) {
		if (!start) {
			listloading.add(loading);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean start() {
		if (!start) {
			start = true;
			number = listloading.size();
			numbercursor = 0;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean getStart() {
		return start;
	}
	
	public int getMax() {
		return number;
	}
	
	public int getCursor() {
		return numbercursor;
	}
	
	public boolean next() {
		if (!start) {
			return false;
		} else {
			if(numbercursor < number) {
				listloading.get(numbercursor).ini();
				numbercursor++;
				return true;
			} else {
				return false;
			}
		}
	}
	
}