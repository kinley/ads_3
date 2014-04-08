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
		return amperage*amperage*resistance;
	}
	
	
	
	public static class Circuit
	{
		private double amperage;
		private double resistance;
		private double voltage;
		private double power;
		
		public static Circuit SerialConnection(Bipole a, Bipole b)
		{
			Circuit c = new Circuit();
			c.amperage = (a.amperage + b.amperage)/2;
			c.voltage = a.Voltage() + b.Voltage();
			c.power = a.Power() + b.Power();
			c.resistance = a.resistance + b.resistance;
			return c;
		}
		
		public static Circuit ParallelConnection(Bipole a, Bipole b)
		{
			Circuit c = new Circuit();
			c.amperage = a.amperage + b.amperage;
			c.voltage = (a.Voltage() + b.Voltage())/2;
			c.power = c.power = a.Power() + b.Power();
			c.resistance = (a.resistance * b.resistance)/(a.resistance + b.resistance);
			return c;
		}
		
		public String toString()
		{
			return "amperage = " + amperage + "\n"
					+ "voltage = " + voltage + "\n"
					+ "power = " + power + "\n"
					+ "resistance = " + resistance;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bipole a = new Bipole(2,4);
		Bipole b = new Bipole(1,3);
		
		System.out.println(Circuit.ParallelConnection(a, b));
		System.out.println(Circuit.SerialConnection(a, b));

	}
}
