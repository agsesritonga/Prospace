/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package galaxytrade;

import java.time.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author agsesyoh
 */
public class GalaxyTrade {

    private static HashMap<String, String> commodity = new HashMap<String, String>();
    private static HashMap<String, Integer> roman_number = new HashMap<String, Integer>();
    private static Scanner menu;
    private static Integer inp;
    
    public static void menu2(String query){
        String[] splitted = query.split(" ");
        Integer total=0, val1=0, val2=0, flagI=0, flagX=0, flagC=0, flagM=0, flagV=0, flagD=0, flagL=0;
        String symbol="";
        
        if(splitted.length == 1){
            symbol = symbol.concat(commodity.get(splitted[0]).toString());
        }
        else{
            for (int i = 0; i < splitted.length; i++) {
                if(commodity.containsKey(splitted[i])){
                    symbol = symbol.concat(commodity.get(splitted[i]).toString());
                }
            }
        }
        
        if(symbol.length() == 1){
                total = roman_number.get(commodity.get(splitted[0]).toString());
        }
        else{
            total = total + roman_number.get(commodity.get(splitted[0]).toString());
            for (int i = 0; i < symbol.length(); i++) {
                if(flagI < 3 || flagX < 3 || flagC < 3 || flagM < 3 || flagV < 1)
                {
                    if(symbol.charAt(i)== 'I'){
                        if(i + 1 < symbol.length()){
                            if(symbol.charAt(i+1) == symbol.charAt(i)){
                                flagI++;
                                total = total + roman_number.get(commodity.get(splitted[i]).toString());
                            }
                            else if(symbol.charAt(i+1) == 'V' || symbol.charAt(i+1) == 'X'){
                                if(i==0){
                                    total = total -1;
                                }
                                total = total + (roman_number.get(commodity.get(splitted[i+1]).toString()) - roman_number.get(commodity.get(splitted[i]).toString()));
                                flagI = 0;
                            }
                        }
                        else if(i != symbol.length()-1){
                            total = total + roman_number.get(commodity.get(splitted[i]).toString());
                        }
                        else{
                            total = total + roman_number.get(commodity.get(splitted[i]).toString());
                        }
                    }
                    else if(symbol.charAt(i)== 'X'){
                        if(i + 1 < symbol.length()){
                            if(symbol.charAt(i+1) == symbol.charAt(i)){
                                flagX++;
                                total = total + roman_number.get(commodity.get(splitted[i]).toString());
                            }
                            else if(symbol.charAt(i+1) == 'L' || symbol.charAt(i+1) == 'C'){
                                if(i==0){
                                    total = total -10;
                                }
                                total = total + (roman_number.get(commodity.get(splitted[i+1]).toString()) - roman_number.get(commodity.get(splitted[i]).toString()));
                                flagX = 0;
                            }
                        }
                        else if(i != symbol.length()-1 && symbol.charAt(i-1) != 'I' && i != 0){
                            total = total + roman_number.get(commodity.get(splitted[i]).toString());
                        }
                        else if(symbol.charAt(i-1) != 'I' && i != 0){
                            total = total + roman_number.get(commodity.get(splitted[i]).toString());
                        }
                        else {
                            total = total + roman_number.get(commodity.get(splitted[i]).toString());
                        }
                    }
                    else if(symbol.charAt(i)== 'C'){
                        if(i + 1 < symbol.length()){
                            if(symbol.charAt(i+1) == symbol.charAt(i)){
                                flagC++;
                                total = total + roman_number.get(commodity.get(splitted[i]).toString());
                            }
                            else if(symbol.charAt(i+1) == 'D' || symbol.charAt(i+1) == 'M'){
                                if(i==0){
                                    total = total -100;
                                }
                                total = total + (roman_number.get(commodity.get(splitted[i+1]).toString()) - roman_number.get(commodity.get(splitted[i]).toString()));
                                flagC = 0;
                            }
                        }
                        else if(i != symbol.length()-1 && symbol.charAt(i-1) != 'X' && i != 0){
                            total = total + roman_number.get(commodity.get(splitted[i]).toString());
                        }
                        else if(symbol.charAt(i-1) != 'X' && i != 0){
                            total = total + roman_number.get(commodity.get(splitted[i]).toString());
                        }
                    }
                    else if(symbol.charAt(i)== 'M'){
                        if(i + 1 < symbol.length()){
                            if(symbol.charAt(i+1) == symbol.charAt(i)){
                                flagM++;
                                total = total + roman_number.get(commodity.get(splitted[i]).toString());
                            }
                            else{
                                if(i==0){
                                    total = total -1000;
                                }
                                //total = total + (roman_number.get(commodity.get(splitted[i+1]).toString()) - roman_number.get(commodity.get(splitted[i]).toString()));
                                flagM = 0;
                            }
                        }
                        else if(i != symbol.length()-1 && i != 0){
                            total = total + roman_number.get(commodity.get(splitted[i]).toString());
                        }
                    }
                    else if(symbol.charAt(i)== 'V'){
                        if(i + 1 < symbol.length()){
                            if(symbol.charAt(i+1) == symbol.charAt(i)){
                                flagV++;
                            }
                            else if(i != 0 && symbol.charAt(i-1) != 'I'){
                                total = total + roman_number.get(commodity.get(splitted[i]).toString());
                            }
                        }
                        else if(i != symbol.length()-1 && symbol.charAt(i-1) != 'I'){
                            total = total + roman_number.get(commodity.get(splitted[i]).toString());
                        }
                    }
                    else if(symbol.charAt(i)== 'L'){
                        if(i + 1 < symbol.length()){
                            if(symbol.charAt(i+1) == symbol.charAt(i)){
                                flagL++;
                            }
                            else if(i != 0 && symbol.charAt(i-1) != 'X'){
                                total = total + roman_number.get(commodity.get(splitted[i]).toString());
                            }
                        }
                        else if(i != symbol.length()-1 && symbol.charAt(i-1) != 'X'){
                            total = total + roman_number.get(commodity.get(splitted[i]).toString());
                        }
                    }
                    else if(symbol.charAt(i)== 'D'){
                        if(i + 1 < symbol.length()){
                            if(symbol.charAt(i+1) == symbol.charAt(i)){
                                flagL++;
                            }
                            else if(i != 0 && symbol.charAt(i-1) != 'C'){
                                total = total + roman_number.get(commodity.get(splitted[i]).toString());
                            }
                        }
                        else if(i != symbol.length()-1 && symbol.charAt(i-1) != 'C'){
                            total = total + roman_number.get(commodity.get(splitted[i]).toString());
                        }
                    }
                }
                else{
                    System.out.println("I, X, C and M can't be repeated 3 times in succession");
                }
            }
        }
        System.out.println(total);
        menu.nextLine();
    }
    
    public static void menu1() {
        
        String inpC="";
        int flag;

        System.out.println("Please input the commodity with corresponding value of roman symbol");
        for (Map.Entry<String, Integer> entry : roman_number.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println("Value of "+ key +" is "+val);
        }
        
        do{
            flag = 0;
            ClearConsole();
            System.out.println("The format is [commodity] [is] [symbol], example -> thgg is I [type exit to quit this menu]");
            inpC = menu.nextLine();
            String[] splitted=inpC.split(" ");
            
            if(!inpC.equals("exit")){
                if(splitted.length != 3 ){
                    flag=1;
                }
                else if(!splitted[1].equals("is") || (!splitted[2].equals("I") && !splitted[2].equals("V") && !splitted[2].equals("X") && !splitted[2].equals("L") && !splitted[2].equals("C") && !splitted[2].equals("D") && !splitted[2].equals("M"))){
                    System.out.println("Format is not correct");
                    menu.nextLine();
                    flag=1;
                }
                else{
                    flag = 0;
                    commodity.put(splitted[0], splitted[2]);
                }
            }
        }while(flag == 1 || !inpC.equals("exit"));
    }
	
    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }
	
    public static void main(String[] args) {
        
        
        roman_number.put("I", 1);
        roman_number.put("V", 5);
        roman_number.put("X", 10);
        roman_number.put("L", 50);
        roman_number.put("C", 100);
        roman_number.put("D", 500);
        roman_number.put("M", 1000);
        menu = new Scanner(System.in);
        String query="";

        do {				
            do {
                ClearConsole();
                System.out.println("Welcome to Galaxy Trading");
                System.out.println("1. Input commodity");
                System.out.println("2. Input your query");
                System.out.println("3. not yet ready");
                System.out.println("4. Exit");
                try {
                    System.out.println("Choose your menu[1..4] [4 to exit program]");
                    inp = menu.nextInt();
                    menu.nextLine();
                }
                catch (Exception e) {
                    System.out.println("wrong input");
                    menu.nextLine();
                    continue;
                }

                if(inp == 1) {
                    menu1();
                }else if(inp == 2) {
                    ClearConsole();
                    System.out.println("Please input the combination based on your input on menu 1, example -> haha haha hihi");
                    query = menu.nextLine();
                    menu2(query);
                    menu.nextLine();
                }else if(inp == 3) {
                    System.out.println("not yet");
                }else if(inp == 4) {
                    break;
                }
            }while(inp >= 1 || inp <=4);
        }while(inp != 4 );
    }
}
