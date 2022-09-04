import java.util.Scanner;

// Класс для линий электропередачи

public class PowerLine extends Electro 
{
	private double currentLine;		// ток на линии, в Амперах
	private double voltageLine;		// напряжение на линии, в килоВольтах
	
	// На линни есть также активная, реактивная мощности, косинус, 
	// которые наследуются из суперкласса электроустановок Electro
	
	// Создаем вводной поток
	Scanner in = new Scanner(System.in);
		
	// Получение напряжения от пользователя
	public void setVoltageLine()
	{
		System.out.println("Введите значение напряжения, кВ (например: 10,3): ");
		voltageLine = in.nextDouble();
	}
	
	// Расчет тока линии
	public void setCurrentLine()
	{
		currentLine = this.fullpower / (Electro.SQRT3 * voltageLine);
	}
	
	// Вывод результатов расчета по линии
	public void showResultLine()
	{
		System.out.printf("Полная мощность будет равна: %.0f кВА\n", this.fullpower);
		System.out.printf("Cos ф равен: %.3f\n", this.cosinus);
		System.out.printf("Ток равен: %.0fA\n", currentLine);
	}
}
