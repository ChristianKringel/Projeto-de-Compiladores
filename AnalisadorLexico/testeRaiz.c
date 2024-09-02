#include <stdio.h>

// Func para calcular a raiz quadrada usando o método de Newton
double sqrt_newton(double number) {
    double guess = number / 2.0; // chute inicial
    double epsilon = 0.0001;     // tolerancia
    double quotient;

    
    while (guess - (number / guess) > epsilon || (number / guess) - guess > epsilon) {
        quotient = number / guess;
        guess = (guess + quotient) / 2.0; // aprx
    }

    return guess;
}

int main() {
    double number;

    printf("Digite um nro para calcular a raiz quadrada: ");
    scanf("%lf", &number);
    
    double result = sqrt_newton(number);
    printf("A raiz quadrada aproximada de %.2lf eh %.5lf\n", number, result);

    return 0;
}
