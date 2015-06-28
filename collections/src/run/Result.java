package run;

public class Result {
	
	
	private long init;
	private long sort;
	private long getElement;
	private long delete;
	
	public Result() {

	}

	public long getInit() {
		return init;
	}

	public void setInit(long init) {
		this.init = init;
	}

	public long getSort() {
		return sort;
	}

	public void setSort(long sort) {
		this.sort = sort;
	}

	public long getGetElement() {
		return getElement;
	}

	public void setGetElement(long getElement) {
		this.getElement = getElement;
	}

	public long getDelete() {
		return delete;
	}

	public void setDelete(long delete) {
		this.delete = delete;
	}

	@Override
	public String toString() {
		return "Result [init=" + init + ", sort=" + sort + ", getElement=" + getElement + ", delete=" + delete + "]";
	}
	

	
	
	
	
	
	

}
