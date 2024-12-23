package org.example;

import java.util.*;

public class ExpressionEvaluator {

	// Метод для порівняння пріоритету операторів
	private static int getOperatorPriority(String operator) {
		switch (operator) {
			case "^":
				return 3;
			case "*":
			case "/":
				return 2;
			case "+":
			case "-":
				return 1;
			default:
				return 0;
		}
	}

	// Метод для виконання арифметичної операції
	private static double applyOperator(double a, double b, String operator) {
		switch (operator) {
			case "+":
				return a + b;
			case "-":
				return a - b;
			case "*":
				return a * b;
			case "/":
				return a / b;
			case "^":
				return Math.pow(a, b);
			default:
				throw new IllegalArgumentException("Невідомий оператор: " + operator);
		}
	}

	// Метод для обчислення виразу з використанням двонаправленого списку
	public static double evaluateExpressionWithList(String expression) {
		// Розбиваємо вираз на токени
		String[] tokens = expression.split(" ");

		// Створюємо двонаправлений список для зберігання операндів та операторів
		LinkedList<String> tokenList = new LinkedList<>(Arrays.asList(tokens));

		// Стек для зберігання операндів і операторів під час обробки виразу
		LinkedList<String> operatorStack = new LinkedList<>();
		LinkedList<Double> operandStack = new LinkedList<>();

		while (!tokenList.isEmpty()) {
			String token = tokenList.pollFirst();

			if (token.equals("(")) {
				// Якщо відкриваюча дужка - додаємо її в стек
				operatorStack.push(token);

			} else if (token.equals(")")) {
				// Якщо закриваюча дужка - обчислюємо вираз до відкриваючої дужки
				while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
					String operator = operatorStack.pop();
					double b = operandStack.pop();
					double a = operandStack.pop();
					double result = applyOperator(a, b, operator);
					operandStack.push(result);
				}
				operatorStack.pop(); // Видаляємо відкриваючу дужку
			} else if (isOperator(token)) {
				// Якщо токен - оператор
				while (!operatorStack.isEmpty() && getOperatorPriority(operatorStack.peek()) >= getOperatorPriority(token)) {
					String operator = operatorStack.pop();
					double b = operandStack.pop();
					double a = operandStack.pop();
					double result = applyOperator(a, b, operator);
					operandStack.push(result);
				}
				operatorStack.push(token);
			} else {
				// Якщо токен - це число, додаємо його в стек
				operandStack.push(Double.parseDouble(token));
			}
		}

		// Обчислюємо залишкові операції в стеці
		while (!operatorStack.isEmpty()) {
			String operator = operatorStack.pop();
			double b = operandStack.pop();
			double a = operandStack.pop();
			double result = applyOperator(a, b, operator);
			operandStack.push(result);
		}

		// Повертаємо остаточний результат
		return operandStack.pop();
	}

	// Допоміжний метод для перевірки, чи є токен оператором
	private static boolean isOperator(String token) {
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^");
	}

}
