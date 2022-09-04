// Класс интерактивных меню программы

public class Menu 
{
	// Приветствие программы
	public static void hello()
	{
		System.out.println("\nВас привествует программа для расчета электрических величин!");
		System.out.println("Автор: Виталий Яковлев, yakovitalik@mail.ru");
	}
	
	// Меню выбора расчета
	public static void showMenu()
	{
		System.out.println("\nВыберите вариант расчета(Введите цифру): \n");
		System.out.println("1. Расчет мощности трансформатора по активной мощности");
		System.out.println("2. Расчет полной мощности по активной и реактивной");
		System.out.println("3. Расчет тока и косинуса по мощностям");
		System.out.println("4. Расчет загрузки трансформатора по стороне 0,4кВ");
		System.out.println("Для выхода из программы нажмите клавишу 'q':");
	}
	
	// Меню выбора косинуса
	public static void chLoad()
	{
		System.out.println("\nВыберите тип нагрузки:");
		System.out.println("1. Коммунально-бытовая (cos = 0,93)");
		System.out.println("2. Производственная (cos = 0,75)");
		System.out.println("3. Смешанная (cos = 0,85)");
	}	
}
