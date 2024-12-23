package org.example;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
import java.util.regex.*;
import java.util.*;

import static org.example.ExpressionEvaluator.evaluateExpressionWithList;


// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	public static void main(String[] args) {
		System.out.println();
		System.out.println("\u001b[38;5;13m-------------------solveEquationWithParameter-------------------\033[0m");

		solveEquationWithParameter(2, 3, 5, 1); // Рівняння 2x + 3y = 6
		System.out.println("----------------------------------------------------------------");
		solveEquationWithParameter(0, 0, 1, 0); // Некоректне рівняння
		System.out.println("----------------------------------------------------------------");
		solveEquationWithParameter(0, 4, 8, -4); // Рівняння з одним рішенням для y
		System.out.println("----------------------------------------------------------------");
		solveEquationWithParameter(5, 0, 10, 0); // Рівняння з одним рішенням для x


		System.out.println();
		System.out.println("\u001b[38;5;13m------------------------solveInequality-------------------------\033[0m");

		solveInequality(2, 3, 5); // 2x + 3 > 5
		System.out.println("----------------------------------------------------------------");
		solveInequality(-1, 4, 2); // -x + 4 > 2
		System.out.println("----------------------------------------------------------------");
		solveInequality(0, 4, 3); // 0x + 4 > 3
		System.out.println("----------------------------------------------------------------");
		solveInequality(0, 2, 5); // 0x + 2 > 5


		System.out.println();
		System.out.println("\u001b[38;5;13m--------------------solveTwoVariableEquation--------------------\033[0m");

		solveTwoVariableEquation(2, 3, 6); // Рівняння 2x + 3y = 6
		System.out.println("----------------------------------------------------------------");
		solveTwoVariableEquation(0, 0, 1); // Некоректне рівняння
		System.out.println("----------------------------------------------------------------");
		solveTwoVariableEquation(0, 4, 4); // Рівняння з одним рішенням для y
		System.out.println("----------------------------------------------------------------");
		solveTwoVariableEquation(5, 0, 10); // Рівняння з одним рішенням для x

		System.out.println();
		System.out.println("\u001b[38;5;13m--------------------solveThreeVariableSystem--------------------\033[0m");

		solveThreeVariableSystem(
				1, 2,  3, 4, // Рівняння 1: x + 2y + 3z = 4
				    2, -1, 1, 1, // Рівняння 2: 2x - y + z = 1
				    3, 1,  -1,    2  // Рівняння 3: 3x + y - z = 2
		);
		System.out.println("----------------------------------------------------------------");
		solveThreeVariableSystem(
				1, 1, 1, 6, // Несумісна система
				2, 2, 2, 14,
				3, 3, 3, 22
		);
		System.out.println("\u001b[38;5;13m------------------solveAbsoluteValueEquation------------------\033[0m");

		solveAbsoluteValueEquation(2, 3, 7); // |2x + 3| = 7
		System.out.println("----------------------------------------------------------------");
		solveAbsoluteValueEquation(1, -2, 4); // |x - 2| = 4
		System.out.println("----------------------------------------------------------------");
		solveAbsoluteValueEquation(0, 5, 5); // |5| = 5
		System.out.println("----------------------------------------------------------------");
		solveAbsoluteValueEquation(2, 3, -5); // |2x + 3| = -5 (неможливо)
		System.out.println("----------------------------------------------------------------");
		solveAbsoluteValueEquation(0, 0, 0); // |0| = 0

		System.out.println("\u001b[38;5;13m------------------solveFractionalEquation------------------\033[0m");

		solveFractionalEquation(2, 3, 4, 5); // (2x + 3) / 4 = 5
		System.out.println("----------------------------------------------------------------");
		solveFractionalEquation(0, 3, 4, 5); // (3) / 4 = 5
		System.out.println("----------------------------------------------------------------");
		solveFractionalEquation(2, 3, 0, 5); // Знаменник = 0
		System.out.println("----------------------------------------------------------------");
		solveFractionalEquation(0, 4, 4, 1); // (4) / 4 = 1
		System.out.println("----------------------------------------------------------------");
		solveFractionalEquation(3, 6, 2, 4); // (3x + 6) / 2 = 4

		System.out.println("\u001b[38;5;13m-------------------------calculateRPN------------------------\033[0m");
		String expression = "3 4 + 2 * 7 /";
		calculateRPN(expression);
		System.out.println("----------------------------------------------------------------");
		expression = "2 3 + 4 5 * -";
		calculateRPN(expression);
		System.out.println("----------------------------------------------------------------");
		expression = "2 3 + 4 5 $ -";
		calculateRPN(expression);

		System.out.println("\u001b[38;5;13m----------------findMinimumMaximumInExpression----------------\033[0m");
		findMinimumMaximumInExpression(1,-4,3);
		System.out.println("----------------------------------------------------------------");
		findMinimumMaximumInExpression(-10,1,-7);
		System.out.println("----------------------------------------------------------------");
		findMinimumMaximumInExpression(0,5,5);



		System.out.println("\u001b[38;5;13m-------------------evaluateExpressionWithList------------------\033[0m");
		evaluateExpressionWithListPrinting("10 + 5 * ( 2 - 10 ^ 2 )");
		System.out.println("----------------------------------------------------------------");
		evaluateExpressionWithListPrinting("10 + 5 * ( 2 - 10 ^ 2 ) / 0");
		System.out.println("----------------------------------------------------------------");
		evaluateExpressionWithListPrinting("10 + 5 * ( 2 - 10 ^ 2 ) )");


		System.out.println("\u001b[38;5;13m----------------------findRootsInQuadratic---------------------\033[0m");
		String expression1 = "3x^2 + 5x + 7";
		findRootsInList(expression1);
		System.out.println("----------------------------------------------------------------");
		expression1 = "3x^2 + 7";
		findRootsInList(expression1);
		System.out.println("----------------------------------------------------------------");
		expression1 = "3x^2 + 5x";
		findRootsInList(expression1);
		System.out.println("----------------------------------------------------------------");
		expression1 = "x^2 -5x - 7";
		findRootsInList(expression1);
		System.out.println("----------------------------------------------------------------");
		expression1 = "5.0 x ^ 2 + 3.0 x + -7.0";
		findRootsInList(expression1);


		System.out.println("\u001b[38;5;13m----------------evaluateExpressionWithDictionary---------------\033[0m");
		Map<String, Double> values = new HashMap<>();
		values.put("a", 5.0);
		values.put("b", 3.0);
		values.put("c", -7.0);
		evaluateExpressionWithDictionary("( 2 a ^ 2 + 5 ) * b ^ 2 / c",values);



		System.out.println("\u001b[38;5;13m--------------------solvePolynomialEquation--------------------\033[0m");
		Map<String, Double> values1 = new HashMap<>();
		values1.put("a", 5.0);
		values1.put("b", 3.0);
		values1.put("c", -7.0);
		solvePolynomialEquation("a x^2 + b x + c", values1);
	}

	public static void solveInequality(double a, double b, double c) {
		System.out.println("Нерівність: " + a + "x + " + b + " > " + c);

		// Перетворення нерівності до стандартного вигляду ax > c - b
		double rhs = c - b;

		// Якщо a == 0, перевіряємо можливість виконання нерівності
		if (a == 0) {
			if (b > c) {
				System.out.println("Нерівність виконується для будь-якого x.");
			} else {
				System.out.println("Нерівність не виконується для будь-якого х.");
			}
			return;
		}

		// Якщо a > 0, x > (c - b) / a
		double x = rhs / a;
		if (a > 0) {
			System.out.println("Нерівність виконується для x > " + x);
		}
		// Якщо a < 0, x < (c - b) / a
		else {
			System.out.println("Нерівність виконується для x < " + x);
		}

	}

	public static void solveEquationWithParameter(double a, double b, double c, double k) {

		System.out.println("Рівняння: " + a + "x + " + b + "y = " + c + " + "+k);
		System.out.println("Тотожне рівняння: " + a + "x + " + b + "y = " + (c + k));

		// Якщо a і b дорівнюють нулю, рівняння не має розв'язків
		if (a == 0 && b == 0) {
			System.out.println("Рівняння не має розв'язків.");
			return;
		}

		// Якщо b ≠ 0, знаходимо y при x = 0
		if(b!=0&&a!=0){
			double y = (c + k) / b;
			System.out.println("Для x = 0, y = " + y);
			double x = (c + k) / a;
            System.out.println("Для y = 0, x = " + x);
			return;
		}
		if (b != 0) {
			double y = (c + k) / b;
			System.out.println("y = " + y);
			System.out.println("x не визначено, оскільки a = 0.");
		} else {
			double x = (c + k) / a;
			System.out.println("x = " + x);
			System.out.println("y не визначено, оскільки b = 0.");
		}



	}
	public static void solveTwoVariableEquation(double a, double b, double c) {

		System.out.println("Рівняння: " + a + "x + " + b + "y = " + c );


		// Якщо a і b дорівнюють нулю, рівняння не має розв'язків
		if (a == 0 && b == 0) {
			System.out.println("Рівняння не має розв'язків.");
			return;
		}

		// Якщо b ≠ 0, знаходимо y при x = 0
		if(b!=0&&a!=0){
			double y = c / b;
			System.out.println("Для x = 0, y = " + y);
			double x = c / a;
			System.out.println("Для y = 0, x = " + x);
			return;
		}
		if (b != 0) {
			double y = c / b;
			System.out.println("y = " + y);
			System.out.println("x не визначено, оскільки a = 0.");
		} else {
			double x = c / a;
			System.out.println("x = " + x);
			System.out.println("y не визначено, оскільки b = 0.");
		}



	}
	public static void solveThreeVariableSystem(
			double a1, double b1, double c1, double d1,
			double a2, double b2, double c2, double d2,
			double a3, double b3, double c3, double d3) {

		System.out.println("Система рівнянь:");
		System.out.println(a1 + "x + " + b1 + "y + " + c1 + "z = " + d1);
		System.out.println(a2 + "x + " + b2 + "y + " + c2 + "z = " + d2);
		System.out.println(a3 + "x + " + b3 + "y + " + c3 + "z = " + d3);

		// Обчислення визначників (метод Крамера)
		double det = a1 * (b2 * c3 - b3 * c2)
				- b1 * (a2 * c3 - a3 * c2)
				+ c1 * (a2 * b3 - a3 * b2);

		// Якщо det == 0, система може бути несумісною або мати нескінченну кількість розв'язків
		if (det == 0) {
			System.out.println("Система не має єдиного розв'язку (несумісна або має нескінченну кількість розв'язків).");
			return;
		}

		// Обчислення визначників для x, y, z
		double detX = d1 * (b2 * c3 - b3 * c2)
				- b1 * (d2 * c3 - d3 * c2)
				+ c1 * (d2 * b3 - d3 * b2);

		double detY = a1 * (d2 * c3 - d3 * c2)
				- d1 * (a2 * c3 - a3 * c2)
				+ c1 * (a2 * d3 - a3 * d2);

		double detZ = a1 * (b2 * d3 - b3 * d2)
				- b1 * (a2 * d3 - a3 * d2)
				+ d1 * (a2 * b3 - a3 * b2);

		// Знаходження x, y, z
		double x = detX / det;
		double y = detY / det;
		double z = detZ / det;

		System.out.println("Розв'язок:");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("z = " + z);
	}
	public static void solveAbsoluteValueEquation(double a, double b, double c) {
		System.out.println("Рівняння: |" + a + "x + " + b + "| = " + c);

		// Перевіряємо, чи рівняння має розв'язки
		if (c < 0) {
			System.out.println("Рівняння не має розв'язків, оскільки права частина менша за 0.");
			return;
		}

		// Рівняння |ax + b| = c перетворюється на дві можливості:
		// 1. ax + b = c
		// 2. ax + b = -c

		// Розв'язуємо перше рівняння: ax + b = c
		double x1 = (c - b) / a;

		// Розв'язуємо друге рівняння: ax + b = -c
		double x2 = (-c - b) / a;

		// Якщо a == 0, рівняння стає некоректним
		if (a == 0) {
			if (b == c || b == -c) {
				System.out.println("Рівняння виконується для всіх x.");
			} else {
				System.out.println("Рівняння не має розв'язків.");
			}
			return;
		}

		// Виводимо розв'язки
		if (x1 == x2) {
			System.out.println("Рівняння має один розв'язок: x = " + x1);
		} else {
			System.out.println("Рівняння має два розв'язки: x1 = " + x1 + ", x2 = " + x2);
		}
	}
	public static void solveFractionalEquation(double numeratorA, double numeratorB, double denominator, double constant) {
		System.out.println("Рівняння: (" + numeratorA + "x + " + numeratorB + ") / " + denominator + " = " + constant);

		// Перевірка на неможливість через нульовий знаменник
		if (denominator == 0) {
			System.out.println("Рівняння не має розв'язків, оскільки знаменник дорівнює нулю.");
			return;
		}

		// Розв'язок рівняння (a * x + b) / c = d
		double leftSide = constant * denominator; // Приводимо до (a * x + b) = d * c

		if (numeratorA == 0) {
			if (numeratorB == leftSide) {
				System.out.println("Рівняння виконується для будь-якого x.");
			} else {
				System.out.println("Рівняння не має розв'язків.");
			}
			return;
		}

		double x = (leftSide - numeratorB) / numeratorA;
		System.out.println("Розв'язок рівняння: x = " + x);
	}
	public static void  calculateRPN(String expression) {
		System.out.println("Вираз: " + expression);
		Stack<Double> stack = new Stack<>();
		String[] tokens = expression.split(" ");

		for (String token : tokens) {
			if (isNumber(token)) {
				// Якщо токен - це число, додаємо його в стек
				stack.push(Double.parseDouble(token));
			} else {
				// Якщо токен - оператор, застосовуємо його до двох останніх чисел в стеці
				double b = stack.pop();
				double a = stack.pop();

				switch (token) {
					case "+":
						stack.push(a + b);
						break;
					case "-":
						stack.push(a - b);
						break;
					case "*":
						stack.push(a * b);
						break;
					case "/":
						stack.push(a / b);
						break;
					default:
						System.out.println("Невідомий оператор: " + token);
						return;
				}
			}
		}
		System.out.println("Результат обчислення: " + stack.pop());

	}
	private static boolean isNumber(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	public static void findMinimumMaximumInExpression(double a, double b, double c) {
		System.out.println("Шукаємо максимум або мінімум функції y(x) = " + a + "x^2 + " + b + "x + " + c);
		if (a == 0) {
			System.out.println("a не може бути 0 для квадратичної функції");
			return ;
		}
		double xVertex = -b / (2 * a);
		double yVertex = a * xVertex * xVertex + b * xVertex + c;
		if(a>0){
			System.out.println("Мінімум функції");
		}
		else{
			System.out.println("Максимум функції" );
		}
		System.out.println("x = " + xVertex);
		System.out.println("y = " + yVertex);
	}
	public static void evaluateExpressionWithListPrinting(String expression){
		System.out.println("Вираз: " + expression);
		try{System.out.println("Розв`язок: " + evaluateExpressionWithList(expression));}
		catch(Exception e){
			System.out.println("Помилка2: " + e.getMessage());
        }
	}
	public static List<Double> parseQuadraticExpression(String expression) {
		System.out.println("Знаходимо корені полінома: "+expression);
		// Створюємо двонаправлений список для зберігання коефіцієнтів
		List<Double> coefficients = new LinkedList<>();

		// Видалимо всі пробіли та нормалізуємо вираз
		expression = expression.replaceAll("\\s+", "");

		// Спочатку обробляємо коефіцієнт a для x^2
		Pattern patternA = Pattern.compile("([+-]?\\d*\\.?\\d*)x\\^2");
		Matcher matcherA = patternA.matcher(expression);
		if (matcherA.find()) {
			double a = matcherA.group(1).isEmpty() || matcherA.group(1).equals("+") ? 1 : (matcherA.group(1).equals("-") ? -1 : Double.parseDouble(matcherA.group(1)));
			coefficients.add(a);
		} else {
			coefficients.add(0.0); // Якщо немає x^2, то a = 0
		}

		// Тепер шукаємо коефіцієнт b для x
		Pattern patternB = Pattern.compile("([+-]?\\d*\\.?\\d*)x(?!\\^2)");
		Matcher matcherB = patternB.matcher(expression);
		if (matcherB.find()) {
			double b = matcherB.group(1).isEmpty() || matcherB.group(1).equals("+") ? 1 : (matcherB.group(1).equals("-") ? -1 : Double.parseDouble(matcherB.group(1)));
			coefficients.add(b);
		} else {
			coefficients.add(0.0); // Якщо немає x, то b = 0
		}

		// Тепер шукаємо вільний член c
		// Модифікований регулярний вираз для пошуку лише вільного члена без x
		Pattern patternC = Pattern.compile("([+-]?\\d*\\.?\\d+)$");
		Matcher matcherC = patternC.matcher(expression);
		if (matcherC.find()) {
			double c = Double.parseDouble(matcherC.group(1));
			coefficients.add(c);
		} else {
			coefficients.add(0.0); // Якщо немає вільного члена, то c = 0
		}

		System.out.println("a=" + coefficients.get(0) + ", b=" + coefficients.get(1) + ", c=" + coefficients.get(2));

		return coefficients;

	}

	// Функція для знаходження коренів квадратного рівняння
	public static void findRootsInList(String expression) {

		List<Double> coefficients = parseQuadraticExpression(expression);
		double a = coefficients.get(0);
		double b = coefficients.get(1);
		double c = coefficients.get(2);

		// Обчислення дискримінанта
		double discriminant = b * b - 4 * a * c;

		// Перевірка на корені
		if (discriminant > 0) {
			// Два різні корені
			double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
			double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
			System.out.println("Корені: " + root1 + " і " + root2);
		} else if (discriminant == 0) {
			// Один корінь
			double root = -b / (2 * a);
			System.out.println("Єдиний корінь: " + root);
		} else {
			// Немає дійсних коренів
			System.out.println("Коренів немає (дискримінант менший за 0)");
		}
	}
	public static String substituteVariables(String expression, Map<String, Double> values) {
		// Розбиваємо вираз на токени
		String[] tokens = expression.split(" ");
		StringBuilder substitutedExpression = new StringBuilder();

		for (String token : tokens) {
			if (values.containsKey(token)) {
				// Якщо токен є змінною, підставляємо її значення
				substitutedExpression.append(values.get(token)).append(" ");
			} else {
				// Якщо це не змінна, залишаємо токен як є
				substitutedExpression.append(token).append(" ");
			}
		}

		// Повертаємо новий вираз з підставленими значеннями змінних
		return substitutedExpression.toString().trim();
	}
	public static String substituteVariablesWithMultiplication(String expression, Map<String, Double> values) {
		// Розбиваємо вираз на токени
		String[] tokens = expression.split(" ");
		StringBuilder substitutedExpression = new StringBuilder();

		// Підставляємо значення змінних у вираз
		for (String token : tokens) {
			if (values.containsKey(token)) {
				// Якщо токен є змінною, підставляємо її значення
				substitutedExpression.append(values.get(token)).append(" ");
			} else {
				// Якщо це не змінна, залишаємо токен як є
				substitutedExpression.append(token).append(" ");
			}
		}

		// Отримуємо остаточний рядок з підставленими значеннями
		String result = substitutedExpression.toString().trim();

		// Тепер додаємо множення між числами
		StringBuilder finalResult = new StringBuilder();
		String[] resultTokens = result.split(" ");
		for (int i = 0; i < resultTokens.length; i++) {
			// Додаємо число до результату
			finalResult.append(resultTokens[i]);

			// Перевіряємо, чи є наступний токен числом
			if (i < resultTokens.length - 1 && isNumber(resultTokens[i]) && isNumber(resultTokens[i + 1])) {
				finalResult.append(" *"); // Додаємо знак множення між числами
			}

			finalResult.append(" ");
		}

		return finalResult.toString().trim();
	}
	public static void evaluateExpressionWithDictionary(String expression, Map<String, Double> values) {
		System.out.println("Знаходимо значення виразу: "+expression);
		System.out.println("Для змінних: ");
		for (Map.Entry<String, Double> entry : values.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

		// Підставляємо значення змінних у вираз
		try{
			String substitutedExpression = substituteVariablesWithMultiplication(expression, values);
			System.out.println("Підставляємо значення змінних у вираз: "+substitutedExpression);
			// Знаходимо корені виразу
			evaluateExpressionWithListPrinting(substitutedExpression);
		}

		catch(Exception e){
			System.out.println("Помилка: " + e.getMessage());
		}


	}
	public static void solvePolynomialEquation(String expression, Map<String, Double> values){
		System.out.println("Знаходимо корені полінома: "+expression);
		System.out.println("Для коефіцієнтів: ");
		for (Map.Entry<String, Double> entry : values.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

		// Підставляємо значення змінних у вираз
		try{
			String substitutedExpression = substituteVariables(expression, values);
			System.out.println("Підставляємо значення змінних у вираз: "+substitutedExpression);
			// Знаходимо корені виразу
			findRootsInList(substitutedExpression);
		}

		catch(Exception e){
			System.out.println("Помилка: " + e.getMessage());
		}
	}
}



