package com.sshmygin.labs.Lab2;


import com.sshmygin.labs.Lab1.LexAnalyser;
import com.sshmygin.labs.Lab1.Lexeme;
import com.sshmygin.labs.Lab1.LexemeClass;
import com.sshmygin.labs.Lab1.LexemeType;

import java.util.*;
import java.util.stream.Collectors;

public class SyntaxAnalyser {
    public static List<Lexeme> lexemes = new ArrayList<>();
    public static int index;

    public static void main(String[] args) {
        LexAnalyser.main(new String[]{});

        lexemes = LexAnalyser.lexemes
                .stream()
                .sorted(Comparator.comparingInt(Lexeme::getPosition))
                .collect(Collectors.toList());

        index = 0;
        analyse();
    }

    public static void analyse(){
        while(index < lexemes.size() && lexemes.get(index).getLexemeType() != LexemeType.END){
            if (!isUntilStatement()){
                return;
            }
        }
    }

    public static boolean isUntilStatement(){
        if (index >= lexemes.size() || lexemes.get(index).getLexemeType() != LexemeType.DO){
            int position = index >= lexemes.size() ? getAfterIndex() : lexemes.get(index).getPosition();
            printError("Ключевое слово do ожидалось в позиции " + position);
            return false;
        }
        index++;
        if (!isStatement(true)) return false;

        if (index >= lexemes.size() || lexemes.get(index).getLexemeType() != LexemeType.LOOP){
            int position = index >= lexemes.size() ? getAfterIndex() : lexemes.get(index).getPosition();
            printError("Ключевое слово loop ожидалось в позиции " + position);
            return false;
        }

        index++;
        if (index >= lexemes.size() || lexemes.get(index).getLexemeType() != LexemeType.UNTIL){
            int position = index >= lexemes.size() ? getAfterIndex() : lexemes.get(index).getPosition();
            printError("Ключевое слово until ожидалось в позиции " + position);
            return false;
        }

        index++;
        if (!isCondition()) return false;

        return true;
    }

    public static boolean isCondition(){ // a < 10 or b < 5
        if (!isLogExpression()) return false;

        if (index >= lexemes.size())
            return true;

        while (lexemes.get(index) != null && lexemes.get(index).getLexemeType() == LexemeType.OR){
            index++;
            if (!isLogExpression()) return false;
        }
        return true;
    }

    public static boolean isLogExpression(){ // a < 10 and b < 5
        if (!isRelExpression()) return false;

        if (index >= lexemes.size())
            return true;

        while (index < lexemes.size() && lexemes.get(index).getLexemeType() == LexemeType.AND){
            index++;
            if (!isRelExpression())return false;
        }

        return true;
    }

    public static boolean isRelExpression(){
        if (!isOperand()) return false;

        if (index >= lexemes.size() || lexemes.get(index).getLexemeType() != LexemeType.COMPARISON){
            printError("Оператор сравнения ожидался в позиции " +lexemes.get(index).getPosition());
            return false;
        }

        if (lexemes.get(index).getLexemeType() == LexemeType.COMPARISON){
            index++;
            if (!isOperand()) return false;
        }
        return true;
    }

    public static boolean isOperand(){
        if (index >= lexemes.size() || (lexemes.get(index).getLexemeClass() != LexemeClass.CONSTANT
        && lexemes.get(index).getLexemeClass() != LexemeClass.IDENTIFIER)){
            printError("Переменная или константа ожидалась в позиции " +lexemes.get(index).getPosition());
            return false;
        }
        index++;
        return true;
    }

    public static boolean isLogicalOp(){
        if (index >= lexemes.size() || (lexemes.get(index).getLexemeType() != LexemeType.AND
        && lexemes.get(index).getLexemeType() != LexemeType.OR)){
            printError("Логическая операция ожидалась в позиции " +lexemes.get(index).getPosition());
            return false;
        }

        return true;
    }

    public static boolean isStatement(boolean isRequired){

        if (lexemes.get(index).getLexemeClass() == LexemeClass.IDENTIFIER){
            if (!isDefaultStatement()){
                return false;
            }
        }
        else if (lexemes.get(index).getLexemeType() == LexemeType.INPUT){
            if (!isInputStatement()){
                return false;
            }
        }
        else if (lexemes.get(index).getLexemeType() == LexemeType.OUTPUT){
            if (!isOutputStatement()){
                return false;
            }
        }
        else{
            if (isRequired){
                printError("Input, output или идентификатор ожидался в позиции " + lexemes.get(index).getPosition());
                return false;
            }
        }

        return true;
    }

    public static boolean isDefaultStatement(){ //a = b + c
        index++;
        if (index >= lexemes.size() || lexemes.get(index).getLexemeType() != LexemeType.ASSIGNMENT){
            printError("Присваивание ожидалось в позиции " +lexemes.get(index).getPosition());
            return false;
        }

        index++;
        if (!isArithmExpr()) return false;

        isStatement(false);

        return true;
    }

    public static boolean isInputStatement(){ //input a
        index++;
        if (index >= lexemes.size() || lexemes.get(index).getLexemeClass() != LexemeClass.IDENTIFIER){
            printError("Переменная ожидалась в позиции " +lexemes.get(index).getPosition());
            return false;
        }

        index++;
        isStatement(false);

        return true;
    }

    public static boolean isOutputStatement(){ //output a
        index++;
        if (index >= lexemes.size() || lexemes.get(index).getLexemeClass() != LexemeClass.IDENTIFIER ||
                lexemes.get(index).getLexemeClass() != LexemeClass.CONSTANT){
            printError("Переменная или константа ожидалась в позиции " +lexemes.get(index).getPosition());
            return false;
        }

        index++;
        isStatement(false);

        return true;
    }

    public static boolean isArithmExpr(){
        if (!isOperand()) return false;

        while (index < lexemes.size() && lexemes.get(index).getLexemeType() == LexemeType.ARITHMETIC){
            index++;
            if (!isOperand()) return false;
        }

        return true;
    }

    public static int getAfterIndex(){
        int position = -1;
        if (index >= lexemes.size())
            position = lexemes.get(index-1).getPosition() + lexemes.get(index-1).getValue().length() + 1;
        else
            position = lexemes.get(index).getPosition();

        return position;
    }

    public static void printError(String message){
        System.out.println("Ошибка: " + message);
    }
}
