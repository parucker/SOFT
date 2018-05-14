package jogovelha;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */

        
public class Board {
    private final int[][] board= new int[3][3];
    private int round, x, y;
    
    public Board(){
        clearBoard();
    }
    
    public void clearBoard(){
        round=0;
        for(int line=0 ; line<3 ; line++)
            for(int column=0 ; column<3 ; column++)
                board[line][column]=0;
    }
    
    public void showBoard(){
        System.out.println();
        for(int line=0 ; line<3 ; line++){
        
            for(int column=0 ; column<3 ; column++){
                
                if(board[line][column]==-1){
                    System.out.print(" X ");
                }
                if(board[line][column]==1){
                    System.out.print(" O ");
                }
                if(board[line][column]==0){
                    System.out.print("   ");
                }
                
                if(column==0 || column==1)
                    System.out.print("|");
            }
            System.out.println();
        }
                
    }

    public int getPosition(int[] attempt){
        return board[attempt[0]][attempt[1]];
    }
    
    public void setPosition(int[] attempt, int player){
        round++;
        x=attempt[0];
        y=attempt[1];
        if(player == 1)
            board[attempt[0]][attempt[1]] = -1;
        else
            board[attempt[0]][attempt[1]] = 1;
    }

    public int checkLines(){
        for(int line=0 ; line<3 ; line++){

            if( (board[line][0] + board[line][1] + board[line][2]) == -3)
                return -1;
            if( (board[line][0] + board[line][1] + board[line][2]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    public int checkColumns(){
        for(int column=0 ; column<3 ; column++){

            if( (board[0][column] + board[1][column] + board[2][column]) == -3)
                return -1;
            if( (board[0][column] + board[1][column] + board[2][column]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    public int checkDiagonals(){
        if( (board[0][0] + board[1][1] + board[2][2]) == -3)
            return -1;
        if( (board[0][0] + board[1][1] + board[2][2]) == 3)
            return 1;
        if( (board[0][2] + board[1][1] + board[2][0]) == -3)
            return -1;
        if( (board[0][2] + board[1][1] + board[2][0]) == 3)
            return 1;
        
        return 0;
    }
    
    public boolean fullBoard(){
        for(int line=0 ; line<3 ; line++)
            for(int column=0 ; column<3 ; column++)
                if( board[line][column]==0 )
                    return false;
        return true;
          
    }
    
    // A partir daqui são funcoes para o computador
    public int checkLinesComp(int line){
            if( (board[line][0] + board[line][1] ) == 2)
                return 2;
            if( (board[line][0] + board[line][2] ) == 2)
                return 1;
            if( (board[line][1] + board[line][2] ) == 2)
                return 0;
        return 5;
    }
    public int checkLinesCompLoose(int line){
            if( (board[line][0] + board[line][1] ) == -2)
                return 2;
            if( (board[line][0] + board[line][2] ) == -2)
                return 1;
            if( (board[line][1] + board[line][2] ) == -2)
                return 0;
        return 5;
    }
    public int checkColumnsComp(int column){
            if( ((board[0][column] + board[1][column]) == 2) && (board[2][column] == 0))
                return 2;
            if( ((board[0][column] + board[2][column]) == 2) && (board[1][column] == 0))
               return 1;
            if( ((board[1][column] + board[2][column]) == 2) && (board[0][column] == 0))
               return 0;       
        return 5; // Como se fosse um return False
                
    }
    public int checkColumnsCompLoose(int column){
           if( ((board[0][column] + board[1][column]) == -2) && (board[2][column] == 0))
                return 2;
            if( ((board[0][column] + board[2][column]) == -2) && (board[1][column] == 0))
               return 1;
            if( ((board[1][column] + board[2][column]) == -2) && (board[0][column] == 0))
               return 0;       
        return 5; // Como se fosse um return False
                
    }
    public int checkDiagonalsPriComp(){
        if( ((board[0][0] + board[1][1]) == 2) && (board[2][2] == 0))
            return 2;
        if( ((board[0][0] + board[2][2]) == 2) && (board[1][1] == 0))
            return 1;
        if(((board[1][1] + board[2][2]) == 2) && (board[0][0] == 0))
            return 0;
        
        
        return 5;
    }
    public int checkDiagonalsPriCompLoose(){
        if( ((board[0][0] + board[1][1]) == -2) && (board[2][2] == 0))
            return 2;
        if( ((board[0][0] + board[2][2]) == -2) && (board[1][1] == 0))
            return 1;
        if(((board[1][1] + board[2][2]) == -2) && (board[0][0] == 0))
            return 0;
        
        
        return 5;
    }
    public int checkDiagonalSegComp(){
        if( ((board[0][2] + board[1][1]) == 2) && (board[2][0] == 0))
            return 2;
        if( ((board[0][2] + board[2][0]) == 2) && (board[1][1] == 0))
            return 1;
        if(((board[1][1] + board[2][0]) == 2) && (board[0][2] == 0))
            return 0;
        return 5;
    }
    public int checkDiagonalSegCompLoose(){
        if( (board[0][2] + board[1][1]) == -2)
            return 2;
        if( (board[0][2] + board[2][0]) == -2)
            return 1;
        if((board[1][1] + board[2][0]) == -2)
            return 0;
        return 5;
    }
 
    // A partir daqui são as funções para declarar a partida como "velha".
    public void displayRound(){
        int remain = 9 - round;
        int Xleft;
        int Oleft;
        if( round%2 == 1){
            Xleft= (remain/2);
            Oleft= remain/2;
        }else{
            Xleft = (remain/2)+1;
            Oleft = remain/2;
        }
        System.out.printf("\nRound: %d\nRemaining: %d\nXleft: %d\nOleft: %d", round, remain, Xleft, Oleft);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    public boolean grannyLine(){
        int remain = 9 - round;
        int Xleft;
        int Oleft;
        
        if( round%2 == 1){
            Xleft= (remain/2);
            Oleft= remain/2;
        }else{
            Xleft = (remain/2)+1;
            Oleft = remain/2;
        }
        boolean p1=false;
        boolean p2=false;
        int blank =0;
        
        for(int i =0; i<3; i++){
            for(int j=0; j<3; j++){
                switch (board[i][j]) {
                    case -1:    p1=true;    break;
                    case 1:     p2=true;    break;
                    default:    blank++;    break;
                }
            }
            if( !(p1 && p2)){
                if(p1){
                    if(remain-blank >= Oleft){
                        return false;
                    }
                }else if(p2){
                    if(remain-blank >= Xleft){
                        return false;
                    }
                }else{
                    if(remain-blank >= Xleft){
                        return false;
                    }
                    if(remain-blank >= Oleft){
                        return false;
                    }
                }
            }
            p1=p2=false;
            blank = 0;
        }
        return true;
    }
    
    public boolean grannyColumn(){
        int remain = 9 - round;
        int Xleft;
        int Oleft;
        
        if( round%2 == 1){
            Xleft= (remain/2);
            Oleft= remain/2;
        }else{
            Xleft = (remain/2)+1;
            Oleft = remain/2;
        }
        boolean p1=false;
        boolean p2=false;
        int blank =0;
        
        for(int i =0; i<3; i++){
            for(int j=0; j<3; j++){
                switch (board[j][i]) {
                    case -1:    p1=true;    break;
                    case 1:     p2=true;    break;
                    default:    blank++;    break;
                }
            }
            if( !(p1 && p2)){
                if(p1){
                    if(remain-blank >= Oleft){
                        return false;
                    }
                }else if(p2){
                    if(remain-blank >= Xleft){
                        return false;
                    }
                }else{
                    if(remain-blank >= Xleft){
                        return false;
                    }
                    if(remain-blank >= Oleft){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    public boolean grannyDiagPrin(){
        int remain = 9 - round;
        int Xleft;
        int Oleft;
        
        if( round%2 == 1){
            Xleft= (remain/2);
            Oleft= remain/2;
        }else{
            Xleft = (remain/2)+1;
            Oleft = remain/2;
        }
        boolean p1=false;
        boolean p2=false;
        int blank =0;
        
        switch (board[0][0]) {
            case -1:    p1=true;    break;
            case 1:     p2=true;    break;
            default:    blank++;    break;
        }
        switch (board[1][1]) {
            case -1:    p1=true;    break;
            case 1:     p2=true;    break;
            default:    blank++;    break;
        }
        switch (board[2][2]) {
            case -1:    p1=true;    break;
            case 1:     p2=true;    break;
            default:    blank++;    break;
        }
        if( !(p1 && p2)){
            if(p1){
                if(remain-blank >= Oleft){
                    return false;
                }
            }else if(p2){
                if(remain-blank >= Xleft){
                    return false;
                }
            }else{
                if(remain-blank >= Xleft){
                    return false;
                }
                if(remain-blank >= Oleft){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean grannyDiagAux(){
        int remain = 9 - round;
        int Xleft;
        int Oleft;
        
        if( round%2 == 1){
            Xleft= (remain/2);
            Oleft= remain/2;
        }else{
            Xleft = (remain/2)+1;
            Oleft = remain/2;
        }
        boolean p1=false;
        boolean p2=false;
        int blank =0;
        
        switch (board[0][2]) {
            case -1:    p1=true;    break;
            case 1:     p2=true;    break;
            default:    blank++;    break;
        }
        switch (board[1][1]) {
            case -1:    p1=true;    break;
            case 1:     p2=true;    break;
            default:    blank++;    break;
        }
        switch (board[2][0]) {
            case -1:    p1=true;    break;
            case 1:     p2=true;    break;
            default:    blank++;    break;
        }
        if( !(p1 && p2)){
            if(p1){
                if(remain-blank >= Oleft){
                    return false;
                }
            }else if(p2){
                if(remain-blank >= Xleft){
                    return false;
                }
            }else{
                if(remain-blank >= Xleft){
                    return false;
                }
                if(remain-blank >= Oleft){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkGranny(){      
        //Verifica se há possibilidade de vitória com alguma linha.
        if(!grannyLine()){
            return false;
        }     
        //Verifica se há possibilidade de vitória com alguma coluna.
        if(!grannyColumn()){
            return false;
        }      
        //Verifica se há possibilidade de vitória com diagonal principal.
        if(!grannyDiagPrin()){
            return false;
        }       
        //Verifica se há possibilidade de vitória com diagonal auxiliar.
        return grannyDiagAux();
    }
    
    public void fillUp(){
        board[0][0]= -1;
        board[1][0]=  1;
        board[2][0]= -1;
        board[0][2]= 1;
        board[1][2]= -1;
        board[2][2]= 1; 
        round = 6;
    }
}