package casoPOO;

public class Season {
	
	private String Name;
	private int startMonth;
	private int endMonth;
	private int solMin;
	private int solMax;
	private int precipitacionMin;
	private int precipitacionMax;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}
	public int getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}
	public int getSolMin() {
		return solMin;
	}
	public void setSolMin(int solMin) {
		this.solMin = solMin;
	}
	public int getSolMax() {
		return solMax;
	}
	public void setSolMax(int solMax) {
		this.solMax = solMax;
	}
	public int getPrecipitacionMin() {
		return precipitacionMin;
	}
	public void setPrecipitacionMin(int precipitacionMin) {
		this.precipitacionMin = precipitacionMin;
	}
	public int getPrecipitacionMax() {
		return precipitacionMax;
	}
	public void setPrecipitacionMax(int precipitacionMax) {
		this.precipitacionMax = precipitacionMax;
	}
}