import java.io.*;

/**
* Программа расчета электрических величин
* Содержит 4 основных расчета:
* 1. Расчет мощности трансформатора по активной мощности нагрузки
* 2. Расчет полной мощности по активной и реактивной
* 3. Расчет тока и косинуса по активной и реактивной мощностям
* 4. Расчет загрузки трансформатора в процентах по стороне 0,4кВ
* @version 18.0.2.1 2022-09-04
* @author Vitaliy Yakovlev
* yakovitalik@mail.ru
*/

public class ElectricCalc 
{
	public static void main(String[] args) throws IOException
	{
		// Выводим меню и создаем объекты классов
		Electro e1 = new Electro();
		Electro e2 = new Electro();
		Transformer t1 = new Transformer();
		PowerLine line1 = new PowerLine();
		char choice;			// переменная выбора расчета из меню
		
		Menu.hello();
		
		do {
			System.out.println();
			System.out.println();
			Menu.showMenu();	
			
			// Создаем вводной поток
			choice = (char) System.in.read();
			
			if(choice == 'q')
			{
				return;
			}
			
			if(choice == '1')	// расчет1: полной мощности трансформатора активной и коэф.мощности
			{
				e1.setAct();			// ввод активки
				Menu.chLoad();			// отображение меню выбора типа нагрузки
				e1.setCosinusR1();		// выбор типа нагрузки
				e1.setFullPower1();		// выполняем расчет;
				e1.showFullPower();		// выводим результаты расчета
				
			}
			else if(choice == '2')	// расчет2: полной мощности по активке и реактивке
			{
				e2.setAct();			// ввод активки
				e2.setReact();			// ввод реактивки
				e2.setFullPower2();		// расчет полной мощности
				e2.showFullPower();		// выводим результаты расчета
			}
			else if(choice == '3')	// расчет3: параметров ВЛ: косинуса, тока
			{
				line1.setAct();			// ввод активки
				line1.setReact();		// ввод реактивки
				line1.setVoltageLine(); // ввод напряжения
				line1.setFullPower2();	// расчет полной мощности
				line1.setCosinusR3(); 	// расчет косинуса
				line1.setCurrentLine(); // расчет тока
				line1.showResultLine(); // выводим результаты расчета
			}
			else if(choice == '4')	// расчет4: загрузки трансформатора по нагрузкам 0,4кВ
			{
				t1.setPowerCurrent(); 	// ввод значений
				t1.setLoad();			// расчет загрузки трансформатора
				t1.showLoadTrans();		// выводим результаты расчета
			}
			else 
			{
				System.out.println("Некорректное значение!");
			}
			
		} while(choice != 'q');
	}

}
