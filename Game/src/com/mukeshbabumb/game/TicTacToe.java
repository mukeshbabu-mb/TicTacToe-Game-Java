package com.mukeshbabumb.game;

import java.util.Scanner;
public class TicTacToe{

	private static int[][] values = new int[3][3];
	private static int gameover = 9;
	private static Scanner scan = new Scanner(System.in);

	public static void startGame() {
		int i=0;
		while(true) {
			gameFrame();
			System.out.println(i%2==0?"Player O ":"Player X ");
			System.out.print("Enter the Block Number : ");
			int blockNumber = scan.nextInt();
			blockOperation(blockNumber,i%2==0?'O':'X');
			validation();
			System.out.println();
			i++;
		}
	}


	private static void validation() {
		
		//Boolean Flag for Result Display
		boolean result = false;
		String player = "";//Player name

		// 'X' Validation
		if(values[0][0]=='X'&&values[0][1]=='X'&&values[0][2]=='X'){
			result = true;//row1
			player += ""+((char)values[0][0]);
		}else if(values[1][0]=='X'&&(values[1][1]=='X') && (values[1][2]=='X')) {
			result = true;//row2
			player += ""+((char)values[1][0]);
		}else if((values[2][0]=='X')&&(values[2][1]=='X') && (values[2][2]=='X')) {
			result = true;//row3
			player += ""+((char)values[2][0]);
		}else if((values[0][0]=='X')&&(values[1][0]=='X') && (values[2][0]=='X')) {
			result = true;//col1
			player += ""+((char)values[0][0]);
		}else if((values[0][1]=='X')&&(values[1][1]=='X') && (values[2][1]=='X')) {
			result = true;//col2
			player += ""+((char)values[0][1]);
		}else if((values[0][2]=='X')&&(values[1][2]=='X') && (values[2][2]=='X')) {
			result = true;//col3
			player += ""+((char)values[0][2]);
		}else if((values[0][0]=='X')&&(values[1][1]=='X') && (values[2][2]=='X')) {
			result = true;
			player += ""+((char)values[0][0]);
		}else if((values[0][2]=='X')&&(values[1][1]=='X') && (values[2][0]=='X')) {
			result = true;
			player += ""+((char)values[0][2]);
		}


		// 'O' Validations
		if((values[0][0]=='O')&&(values[0][1]=='O') && (values[0][2]=='O')){
			result = true;//row1
			player += ""+((char)values[0][0]);
		}else if((values[1][0]=='O')&&(values[1][1]=='O') && (values[1][2]=='O')) {
			result = true;//row2
			player += ""+((char)values[1][0]);
		}else if((values[2][0]=='O')&&(values[2][1]=='O') && (values[2][2]=='O')) {
			result = true;//row3
			player += ""+((char)values[2][0]);
		}else if((values[0][0]=='O')&&(values[1][0]=='O') && (values[2][0]=='O')) {
			result = true;//col1
			player += ""+((char)values[0][0]);
		}else if((values[0][1]=='O')&&(values[1][1]=='O') && (values[2][1]=='O')) {
			result = true;//col2
			player += ""+((char)values[0][1]);
		}else if((values[0][2]=='O')&&(values[1][2]=='O') && (values[2][2]=='O')) {
			result = true;//col3
			player += ""+((char)values[0][2]);
		}else if((values[0][0]=='O')&&(values[1][1]=='O') && (values[2][2]=='O')) {
			result = true;
			player += ""+((char)values[0][0]);
		}else if((values[0][2]=='O')&&(values[1][1]=='O') && (values[2][0]=='O')) {
			result = true;
			player += ""+((char)values[0][2]);
		}

		if(result==true) {
			gameFrame();
			System.out.println("Winner is "+player);
			System.exit(0);
		}
	}

	private static void gameFrame() {
		/**
		 * Expected Output
		    +---+---+---+
		    | 1 | 2 | 3 |
		    +---+---+---+
		    | 4 | 5 | 6 |
		    +---+---+---+
		    | 7 | 8 | 9 |
		    +---+---+---+
		 **/

		//Display the Numbers in each block
		int count = 1;
		for(int frame = 0 ; frame < 7 ; frame++ ) {
			if(frame%2==0) {
				// Output +---+---+---+ 
				for(int block = 0 ; block < 7 ; block++) {
					System.out.print(block%2==0?"+":"---"); 
				}
				System.out.println();
			}else {
				// Output | 1 | 2 | 3 |
				for(int block = 0 ; block < 7 ; block++) {
					System.out.print(block%2==0?"| ":(blockOperation(count++)+" "));
				}
				System.out.println();
			}
		}
	}


	private static String blockOperation(int blockNumber) {
		int returnValue = 0;
		switch (blockNumber) {
		case 1 : 
			returnValue = values[0][0];
			break;
		case 2 : 
			returnValue = values[0][1];
			break;
		case 3 : 
			returnValue = values[0][2];
			break;
		case 4 : 
			returnValue = values[1][0];
			break;	
		case 5 : 
			returnValue = values[1][1];
			break;
		case 6 : 
			returnValue = values[1][2];
			break;
		case 7 : 
			returnValue = values[2][0];
			break;
		case 8 : 
			returnValue = values[2][1];
			break;
		case 9 : 
			returnValue = values[2][2];
			break;
		}
		return returnValue!=0?(""+(char)returnValue):(""+blockNumber);
	}
	
	private static void displayIfValuePresent(char ch) { System.out.println("Already "+ch+" is Present and you turn is over \nand wait for you Trun");}

	private static void blockOperation(int blockNumber , char Symbol) {
		boolean status = false;
		switch (blockNumber) {
		case 1:
			if(values[0][0]==0) {
				values[0][0] = Symbol;
				status = true;
				}else {displayIfValuePresent((char)values[0][0]);}
			break;
		case 2:
			if(values[0][1]==0) {
				values[0][1] = Symbol;
				status = true;
				}else {displayIfValuePresent((char)values[0][1]);}
			break;
		case 3:
			if(values[0][2]==0) {
				values[0][2] = Symbol;
				status = true;
				}else {displayIfValuePresent((char)values[0][2]);}
			break;
		case 4:
			if(values[1][0]==0) {
				values[1][0] = Symbol;
				status = true;
				}else {displayIfValuePresent((char)values[1][0]);}
			break;
		case 5:
			if(values[1][1]==0) {
				values[1][1] = Symbol;
				status = true;
				}else {displayIfValuePresent((char)values[1][1]);}
			break;
		case 6:
			if(values[1][2]==0) {
				values[1][2] = Symbol;
				status = true;
				}else {displayIfValuePresent((char)values[1][2]);}
			break;
		case 7:
			if(values[2][0]==0) {
				values[2][0] = Symbol;
				status = true;
				}else {displayIfValuePresent((char)values[2][0]);}
			break;
		case 8:
			if(values[2][1]==0) {
				values[2][1] = Symbol;
				status = true;
				}else {displayIfValuePresent((char)values[2][1]);}
			break;
		case 9:
			if(values[2][2]==0) {
				values[2][2] = Symbol;
				status = true;
				}else {displayIfValuePresent((char)values[2][2]);}
			break;
		}

		if(status==true) {gameover--;}
		gameOverfuntion();
	}

	private static void gameOverfuntion() {
		if(gameover==0) {
			gameFrame();
			System.out.println("Game Over :(");
			System.exit(0);
		}
	}
}