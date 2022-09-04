import java.util.*;
import static java.lang.Math.sqrt;

// Общий класс электроустановок

public class Electro 
{
	public static final double SQRT3 = 1.73; // корень из числа 3
	
	// коэффициенты мощности
	public static final double COS1 = 0.93;	// для комунально-бытовой нагрузки
	public static final double COS2 = 0.75;	// для производственной нагрузки
	public static final double COS3 = 0.85;	// для смешанной нагрузки
	
	// Напряжение(фазное) на стороне НН 
	public static final double VOLNN = 230.0;
	
	protected double actpower;				// активная мощность, кВт
	protected double reactpower;			// реактивная мощность, кВар
	protected double fullpower;				// полная мощность, кВА
	protected double cosinus;				// косинус (коэффициент мощности)
	
	// Создаем вводной поток
	Scanner in = new Scanner(System.in);
		
	// Ввод пользователем активной мощности
	public void setAct()
	{
		System.out.println("Введите значение активной мощности, кВт: ");
		actpower = in.nextDouble();
	}
	
	// Ввод пользователем реактивной мощности
	public void setReact()
	{
		System.out.println("Введите значение активной мощности, кВт: ");
		reactpower = in.nextDouble();
	}
	
	// Определение косинуса(cosinus) по типу нагрузки (для расчета 1)
	public void setCosinusR1()
	{
		int changeCos;				// переменная выбора косинуса (цифра меню)
		changeCos = in.nextInt();
		if(changeCos == 1)
			cosinus = COS1;
		else if(changeCos == 2)
			cosinus = COS2;
		else if(changeCos == 3)
			cosinus = COS3;
		else
		{
			System.out.println("Некорректное значение, выбран косинус по умолчанию (0,93)");
			cosinus = COS1;
		}
	}
	
	// Определение косинуса по величине активной и полной мощности(для расчета3)
	public void setCosinusR3()
	{
		cosinus = actpower / fullpower;
	}
	
	// Расчет полной мощности по активной и коэффициенту мощности(Расчет1)
	public void setFullPower1()
	{
		System.out.println("Выполняем расчет мощности трансформатора по активной мощности");
		fullpower = actpower / cosinus;
	}
	
	// Расчет полной мощности по активной и реактивной(Расчет2)
	public void setFullPower2()
	{
		fullpower = sqrt((actpower * actpower) + (reactpower * reactpower));
	}
	
	// Вывод результатов расчета полной мощности на экран
	public void showFullPower()
	{
		System.out.println("Расчет выполнен!");
		System.out.printf("Полная мощность будет равна: %.0f кВА.\n", fullpower);
	}
}
