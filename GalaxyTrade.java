package galaxytrade;

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
    private static HashMap<String, Integer> commodity_credits = new HashMap<String, Integer>();
    private static HashMap<String, Integer> roman_number = new HashMap<String, Integer>();
    private static ArrayList<Integer> number;
    private static Scanner menu;
    private static Integer inp;
    
    public static Integer menu2(String query){
        String[] splitted = query.split(" ");
        number = new ArrayList<>();
        Integer total=0, flagI=0, flagX=0, flagC=0, flagM=0, flagV=0, flagD=0, flagL=0, flagCombi=0;
        String symbol="";
        
        if(splitted.length == 1){
            if(commodity.containsKey(splitted[0])){
                    symbol = symbol.concat(commodity.get(splitted[0]).toString());
            }
            else{
                flagCombi++;
            }
        }
        else{
            for (int i = 0; i < splitted.length; i++) {
                if(commodity.containsKey(splitted[i])){
                    symbol = symbol.concat(commodity.get(splitted[i]).toString());
                }
                else{
                    flagCombi++;
                }
            }
        }
        
        if(flagCombi==0){
            for (int i = 0; i < symbol.length(); i++) {
                if(symbol.charAt(i) == 'D'){
                    flagD++;
                }
                else if(symbol.charAt(i) == 'L'){
                    flagL++;
                }else if(symbol.charAt(i) == 'V'){
                    flagV++;
                }
                else if(symbol.charAt(i) == 'I'){
                    if(i + 1 < symbol.length()){
                        if(symbol.charAt(i+1) == symbol.charAt(i)){
                            flagI++;                    
                        }
                        else if(symbol.charAt(i+1) != 'X' && symbol.charAt(i+1) != 'V'){
                            flagI = 3;                    
                        }
                        else{
                            flagI--;
                        }
                    }
                }
                else if(symbol.charAt(i) == 'X'){
                    if(i + 1 < symbol.length()){
                        if(symbol.charAt(i+1) == symbol.charAt(i)){
                            flagX++;                    
                        }
                        else if(symbol.charAt(i+1) != 'L' && symbol.charAt(i+1) != 'C' && symbol.charAt(i+1) != 'I' && symbol.charAt(i+1) != 'V'){
                            flagX = 3;                    
                        }
                        else{
                            flagX--;
                        }
                    }
                }
                else if(symbol.charAt(i) == 'C'){
                    if(i + 1 < symbol.length()){
                        if(symbol.charAt(i+1) == symbol.charAt(i)){
                            flagC++;                    
                        }
                        else{
                            flagC--;
                        }
                    }
                }
                else if(symbol.charAt(i) == 'M'){
                    if(i + 1 < symbol.length()){
                        if(symbol.charAt(i+1) == symbol.charAt(i)){
                            flagM++;                    
                        }
                        else{
                            flagC--;
                        }
                    }
                }
            }

            if(flagI < 3 && flagX < 3 && flagC < 3 && flagM < 3 && flagD < 2 && flagL < 2 && flagV < 2){
                for (int i = 0; i < symbol.length(); i++) {
                        number.add(roman_number.get(Character.toString(symbol.charAt(i))));
                }
                for (int i = 0; i < number.size(); i++) {
                    if(i != number.size()-1){
                        if(number.get(i+1) > number.get(i)){
                            number.set(i, (number.get(i)*-1));
                        }
                    }
                    total = total + number.get(i);
                }
            }
            else{
                System.out.println("Format is not correct as per roman number system");
            }
            //System.out.println(query+" is "+total);
        }
        else{
            System.out.println("I have no idea what you are talking about");
        }
        
        return total;
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
    
    public static void menu3() {
        
        String inpC="";
        int flag, flagCredit;

        System.out.println("Please input the commodity with credits []");
        for (Map.Entry<String, Integer> entry : roman_number.entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println("Value of "+ key +" is "+val);
        }
        
        do{
            flag= flagCredit = 0;
            ClearConsole();
            System.out.println("The format is [commodity] [commodity] [commodity] [is] [0..9] [Credits], example -> haha haha apple is 50 Credits [type exit to quit this menu]");
            inpC = menu.nextLine();
            String[] splitted=inpC.split(" ");
            Integer credit=0, priceCommodity = 0;
            
            if(!inpC.equals("exit")){
                if(splitted.length != 6 ){
                    flag=1;
                }
                else{
                    try {
                        credit = Integer.parseInt(splitted[4]);
                    } catch (Exception e) {
                        flagCredit=1;
                    }
                    if(commodity.containsKey(splitted[0]) && commodity.containsKey(splitted[1]) && splitted[3].equals("is") && flagCredit==0 && splitted[5].equals("Credits")){
                        flag = 0;
                        priceCommodity= credit/menu2(splitted[0]+" "+splitted[1]);
                        commodity_credits.put(splitted[2], priceCommodity);
                    }
                    else{
                        System.out.println("Format is not correct");
                        menu.nextLine();
                        flag=1;
                    }   
                }
            }
        }while(flag == 1 || !inpC.equals("exit"));
    }
    
    public static void calculate1(){
        int flag=0;
        String query="";
        
        do{
            ClearConsole();
            System.out.println("Please input the combination based on your input on menu 1, example -> how much is haha haha hihi [input exit to close]");
            query = menu.nextLine();

            if(!query.equals("exit")){
                if(query.length() > 12){
                    if(commodity.isEmpty()){
                        System.out.println("Commodity is still empty, please input by using menu 1");
                    }
                    else if(query.substring(0, 11).equals("how much is")){
                        System.out.println(query.substring(12)+" is "+menu2(query.substring(12)));
                    }
                    flag = 0;
                }
                else{
                    flag = 1;
                }
            }
            else{
                flag = 0;
            }
            menu.nextLine();
        }while(flag == 1 || !query.equals("exit"));
    }
    
    public static void calculate2(){
        String[] split={};
        Integer total=0;
        String query="";
        int flag=0;
        
        do{
            ClearConsole();
            System.out.println("Please input the combination based on your input on menu 3, example -> how many Credits is haha haha Silver [input exit to close]");
            query = menu.nextLine();

            if(!query.equals("exit")){
                if(query.length() > 19){
                    if(commodity_credits.isEmpty()){
                        System.out.println("Commodity is still empty, please input by using menu 3");
                    }
                    else if(query.substring(0, 19).equals("how many Credits is")){
                        split=query.split(" ");
                        if(commodity_credits.containsKey(split[6])){
                            total = menu2(split[4]+" "+split[5]) * commodity_credits.get(split[6]);
                            System.out.println(query.substring(20)+" is "+total);
                        }
                        flag = 0;
                    }
                    else{
                        System.out.println("Format is not correct");
                    }
                }
                else{
                    flag = 1;
                    System.out.println("Format is not correct");
                }
            }
            else{
                flag = 0;
            }
            menu.nextLine();
        }while(flag == 1 || !query.equals("exit"));
    }
    
    public static void initiate(){
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
                System.out.println("3. Input your comodity with credits");
                System.out.println("4. Input your query with credits");
                System.out.println("5. Exit");
                try {
                    System.out.println("Choose your menu[1..5] [5 to exit program]");
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
                    calculate1();
                }else if(inp == 3) {
                    menu3();
                }else if(inp == 4) {
                    calculate2();
                }
                else if(inp ==5){
                    break;
                }
            }while(inp >= 1 || inp <=5);
        }while(inp != 5 );
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
        initiate();
    }
}
