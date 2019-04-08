package fr.tangv.jeux2diso.tools;

import java.util.ArrayList;

public class Loader {

	private boolean start;
	private int number;
	private int numbercursor;
	ArrayList<Runnable> listrunnable = new ArrayList<Runnable>();
	ArrayList<Loading> listloading = new ArrayList<Loading>();
	
	public boolean addRunnable(Runnable runnable) {
		if (!start) {
			listrunnable.add(runnable);
			return true;
		} else {
			return false;
		}
	}
	
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
			number = listrunnable.size() + listloading.size();
			numbercursor = 0;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean getStart() {
		return start;
	}
	
	public boolean next() {
		if (start) {
			return false;
		} else {
			if(numbercursor < listloading.size() ) {
				listloading.get(numbercursor).ini();
				numbercursor++;
				return true;
			} if(numbercursor < number) {
				listloading.get(numbercursor).ini();
				return true;
			} else {
				return false;
			}
		}
	}
	
}