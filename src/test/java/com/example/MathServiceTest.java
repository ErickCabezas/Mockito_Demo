package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

interface Calculator {
    int add(int a, int b);
    int divide(int a, int b);
}

class MathService {
    private final Calculator calculator;

    public MathService(Calculator calculator) {
        this.calculator = calculator;
    }

    public int addNumbers(int a, int b) {
        return calculator.add(a, b);
    }

    public int divideNumbers(int a, int b) { return calculator.divide(a, b);}
}
class MathServiceTest {
    @Test
    void testAddNumbers() {
        // Crear el mock
        Calculator calculatorMock = mock(Calculator.class);

        // Definir el comportamiento del método add()
        when(calculatorMock.add(2, 3)).thenReturn(5);

        // Crear el servicio con el mock
        MathService mathService = new MathService(calculatorMock);

        // Llamar al método del servicio y verificar el resultado
        int result = mathService.addNumbers(2, 3);
        assertEquals(5, result);

        // Verificar que el método del mock fue llamado con los argumentos correctos
        verify(calculatorMock).add(2, 3);

    }

    @Test
    void testDivideByZero() {
        // Crear el mock
        Calculator calculatorMock = mock(Calculator.class);

        // Definir el comportamiento del método divide()
        when(calculatorMock.divide(10, 0)).thenThrow(new ArithmeticException("Division by zero"));

        // Crear el servicio con el mock
        MathService mathService = new MathService(calculatorMock);

        // Verificar que la excepción es lanzada al intentar dividir por cero
        assertThrows(ArithmeticException.class, () -> mathService.divideNumbers(10, 0));

    }
}
class MathServiceTestMocks{
    @Test
    void testAddNumbers() {
        // Crear el mock
        Calculator calculatorMock = mock(Calculator.class);

        // Definir el comportamiento del método add()
        when(calculatorMock.add(2, 3)).thenReturn(5);

        // Crear el servicio con el mock
        MathService mathService = new MathService(calculatorMock);

        // Llamar al método del servicio y verificar el resultado
        int result = mathService.addNumbers(2, 3);
        assertEquals(5, result);

        // Verificar que el método del mock fue llamado con los argumentos correctos
        verify(calculatorMock).add(2, 3);
    }
    @Test
    void testDivideByZero() {
        // Crear el mock
        Calculator calculatorMock = mock(Calculator.class);

        // Definir el comportamiento del método divide()
        when(calculatorMock.divide(10, 0)).thenThrow(new ArithmeticException("Division by zero"));

        // Crear el servicio con el mock
        MathService mathService = new MathService(calculatorMock);

        // Verificar que la excepción es lanzada al intentar dividir por cero
        assertThrows(ArithmeticException.class, () -> mathService.divideNumbers(10, 0));
    }
}