package hu.neuron.runner;

public class Result
{
	private long init;
	private long rendez;
	private long listaz;
	private long delete;

	public Result()
	{
		
	}
	
	public long getInit()
	{
		return init;
	}

	public void setInit(long init)
	{
		this.init = init;
	}

	public long getRendez()
	{
		return rendez;
	}

	public void setRendez(long rendez)
	{
		this.rendez = rendez;
	}

	public long getListaz()
	{
		return listaz;
	}

	public void setListaz(long listaz)
	{
		this.listaz = listaz;
	}

	public long getDelete()
	{
		return delete;
	}

	public void setDelete(long delete)
	{
		this.delete = delete;
	}

	@Override
	public String toString()
	{
		return "Result [init=" + init + ", rendez=" + rendez + ", listaz=" + listaz + ", delete="
				+ delete + "]";
	}

}
