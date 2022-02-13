public class Patient implements Comparable<Patient>{
	String name;
	int  priority;
	public Patient() {
		name = "";
		priority = 0;
	}
	public Patient(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPriority( int priority) {
		this.priority = priority;
	}
	public Object clone() {
		return this;
	}
	public String getName() {
		return this.name;
	}
	public int getPriority() {
		return this.priority;
	}
	public boolean equals(Object o) {
		if(o instanceof Patient == false)
			return false;
		else
		return this.compareTo((Patient)o)==0;
	}
	
	public int compareTo(Patient o) {
		int comparePriority = ((Patient) o).getPriority();
		if(this.getPriority() > comparePriority)
			return 1;
		else if(this.getPriority() == comparePriority)
			return 0;
		else
		return -1;
	}
	public String toString() {
		return name + " " + priority;
	}

}