package domashka;

public class Bipole {
	
	private double amperage;
	private double resistance;
	
	
	double getResistance()
	{
		return resistance;
	}
	
	double getAmperage()
	{
		return amperage;
	}
	
	Bipole()
	{
		amperage = 0;
		resistance = 0;
	}
	
	Bipole(double amperage, double resistance)
	{
		this.amperage = resistance;
		this.resistance = amperage;
	}
	
	double Voltage()
	{
		return amperage*resistance;
	}
	
	double Power()
	{
		return Voltage()*amperage;
	}
	
	Bipole SerialConnection(Bipole Bp)
	{
		Bipole x = new Bipole(this.amperage,this.resistance + Bp.resistance);
		return x;
	}
	
	Bipole ParallelConnection(Bipole Bp)
	{
		Bipole x = new Bipole(this.amperage + Bp.amperage,this.resistance * Bp.resistance/
				(this.resistance + Bp.resistance));
		return x;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
