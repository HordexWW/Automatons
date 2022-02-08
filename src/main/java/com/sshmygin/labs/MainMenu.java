package com.sshmygin.labs;

import com.sshmygin.labs.Lab1.LexAnalyser;
import com.sshmygin.labs.Lab2.SyntaxAnalyser;
import com.sshmygin.labs.Lab3.SyntaxSemanticAnalyser;
import com.sshmygin.labs.Lab4.Interpreter;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        menu:
        while(true){
            System.out.println("1. Лексический анализатор");
            System.out.println("2. Синтаксический анализатор");
            System.out.println("3. Семантический анализатор");
            System.out.println("4. Интерпретатор");

            String option = sc.nextLine();
            switch (option){
                case "1":
                    LexAnalyser.main(args);
                    break menu;
                case "2":
                    SyntaxAnalyser.main(args);
                    break menu;
                case "3":
                    SyntaxSemanticAnalyser.main(args);
                    break menu;
                case "4":
                    Interpreter.main(args);
                    break menu;
            }
        }

    }
}
