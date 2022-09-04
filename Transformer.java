import java.util.*;

// Класс Трансформатор

public class Transformer extends Electro
{
	private double powerSetupTrans;	// установленная мощность трансформатора
	private double currentA;		// ток по фазе A для Рачета 4
	private double currentB;		// ток по фазе B для Рачета 4
	private double currentC;		// ток по фазе C для Рачета 4
	private double powerA;			// мощность по фазе A для Рачета 4
	private double powerB;			// мощность по фазе B для Рачета 4
	private double powerC;			// мощность по фазе C для Рачета 4
	private double powerTrans;		// сумма мощностей по фазам для Рачета 4
	private double loadTrans;		// коэффициент загрузки трансформатора (в процентах)
	
	// Создаем поток ввода
	Scanner in = new Scanner(System.in);
	
	// Ввод мощности трансформатора и токов по фазам пользорателем
	public void setPowerCurrent()
	{
		System.out.println("Введите значение мощности трансформатора, кВА: ");
		powerSetupTrans = in.nextDouble();
		System.out.println("Введите значение тока по фазе А, в Амперах: ");
		currentA = in.nextDouble();
		System.out.println("Введите значение тока по фазе B, в Амперах: ");
		currentB = in.nextDouble();
		System.out.println("Введите значение тока по фазе C, в Амперах: ");
		currentC = in.nextDouble();
	}
	
	// Расчет коэффициента загрузки
	public void setLoad()
	{
		powerA = Electro.VOLNN * currentA;
		powerB = Electro.VOLNN * currentB;
		powerC = Electro.VOLNN * currentC;
		powerTrans = powerA + powerB + powerC;
		loadTrans = ((powerTrans / 1000) / powerSetupTrans) * 100;
	}
	
	// Вывод результатов расчет 4 на экран
	public void showLoadTrans()
	{
		System.out.printf("Загрузка трансформатора составляет: %.2f%%\n", loadTrans);
	}
}
