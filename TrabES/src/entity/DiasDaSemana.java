package entity;


public class DiasDaSemana {

	public boolean monday;
	private boolean tuesday;
	private boolean wednesday;
	private boolean	thursday;
	private boolean	friday;
	private boolean	saturday;
	private boolean sunday;
	

	
	public DiasDaSemana(boolean monday, boolean tuesday, boolean wednesday,
			boolean thursday, boolean friday, boolean saturday, boolean sunday) {
		
		setMonday(monday);
		setTuesday(tuesday);
		setWednesday(wednesday);
		setThursday(thursday);
		setFriday(friday);
		setSaturday(saturday);
		setSunday(sunday);
		

	}

	public boolean isMonday() {
		return monday;
	}

	public void setMonday(boolean monday) {
		this.monday = monday;
	}

	public boolean isTuesday() {
		return tuesday;
	}

	public void setTuesday(boolean tuesday) {
		this.tuesday = tuesday;
	}

	public boolean isWednesday() {
		return wednesday;
	}

	public void setWednesday(boolean wednesday) {
		this.wednesday = wednesday;
	}

	public boolean isThursday() {
		return thursday;
	}

	public void setThursday(boolean thursday) {
		this.thursday = thursday;
	}

	public boolean isFriday() {
		return friday;
	}

	public void setFriday(boolean friday) {
		this.friday = friday;
	}

	public boolean isSaturday() {
		return saturday;
	}

	public void setSaturday(boolean saturday) {
		this.saturday = saturday;
	}

	public boolean isSunday() {
		return sunday;
	}

	public void setSunday(boolean sunday) {
		this.sunday = sunday;
	}
	

	@Override
	public String toString() {
		return "DiasDaSemana [monday=" + monday + ", tuesday=" + tuesday
				+ ", wednesday=" + wednesday + ", thursday=" + thursday
				+ ", friday=" + friday + ", saturday=" + saturday + ", sunday="
				+ sunday + "]";
	}

	
	
	
}
