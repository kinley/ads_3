
public class Matrix {
	public final int  WIDTH=2;
	public final int HEIGHT=2;
	
	private double[][] array=new double[WIDTH][HEIGHT];
	
	public double getElement(int row, int column){
		return array[row][column];
	}
	
	public void setElement(int row, int column, double value){
		array[row][column]=value;
	}
	
	Matrix(double a11, double a12, double a21, double a22){
		setElement(0, 0, a11);
		setElement(0, 1, a12);
		setElement(1, 0, a21);
		setElement(1, 1, a22);
	}
	Matrix(){
		
	}
	/**
	 * Покомпонентное сложение матриц
	 * @param addition Матрица, прибавляемая к текущей
	 */
	public void sum(Matrix addition){
		if(this.HEIGHT!=addition.HEIGHT||this.WIDTH!=addition.WIDTH){
			throw new IllegalArgumentException();
		}
		for(int i=0;i<this.HEIGHT;i++){
			for(int j=0;j<this.WIDTH;j++){
				setElement(i, j, addition.getElement(i, j)+this.getElement(i, j));
			}
		}
	}
	/**
	 * Умножение матрицы на скаляр
	 * @param scalar Скалярная величина
	 */
	public void mult(double scalar){
		for(int i=0;i<this.HEIGHT;i++){
			for(int j=0;j<this.WIDTH;j++){
				setElement(i, j, this.getElement(i, j)*scalar);
			}
		}
	}
	/**
	 * Умножение текущей матрицы на другую матрицу
	 * @param multiplier Множитель
	 * @return Результирующая матрица
	 */
	public Matrix mult(Matrix multiplier){
		if(this.HEIGHT!=multiplier.WIDTH){
			throw new IllegalArgumentException();
		}
		Matrix result=new Matrix();
		for(int i=0;i<this.WIDTH;i++){
			for(int j=0;j<multiplier.HEIGHT;j++){
				int sum=0;
				for(int k=0;k<this.HEIGHT;k++){
					sum+=this.getElement(i, k)*multiplier.getElement(k, j);
				}
				result.setElement(i, j, sum);
			}
		}
		return result;
	}
	@Override
	public String toString() {
		String result="";
		for(int i=0;i<this.HEIGHT;i++){
			for(int j=0;j<this.WIDTH;j++){
				result=result+(Double.toString(getElement(i, j))+"   ");
			}
			result=result+("\n");
		}
		return result;
	}
	/**
	 * Определитель матрицы
	 * @return Определитель
	 */
	public double det(){
		return getElement(0, 0)*getElement(1,1)-getElement(0, 1)*getElement(1, 0);
	}
	public static void main(String[] args) {
		Matrix matrix=new Matrix();
		matrix.setElement(0, 0, 5);
		matrix.setElement(1, 1, 2);
		System.out.println(matrix);
		Matrix anotherMatrix=new Matrix(0,1,-2,4);
		anotherMatrix.setElement(0, 1, -5);
		matrix.sum(anotherMatrix);
		System.out.println(matrix);
		matrix.mult(2);
		System.out.println(matrix);
		matrix=matrix.mult(matrix);
		System.out.println(matrix);
		System.out.println(matrix.det());
	}
}
