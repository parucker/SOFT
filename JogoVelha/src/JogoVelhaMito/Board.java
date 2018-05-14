package JogoVelhaMito;



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
    private final int[][] Board= new int[3][3];
    private int round, x, y;
    
    public Board(){
        clearBoard();
    }
    
    public void clearBoard(){
        round=0;
        for(int line=0 ; line<3 ; line++)
            for(int column=0 ; column<3 ; column++)
                Board[line][column]=0;
    }
    
    public void showBoard(){
        System.out.println();
        for(int line=0 ; line<3 ; line++){
        
            for(int column=0 ; column<3 ; column++){
                
                if(Board[line][column]==-1){
                    System.out.print(" X ");
                }
                if(Board[line][column]==1){
                    System.out.print(" O ");
                }
                if(Board[line][column]==0){
                    System.out.print("   ");
                }
                
                if(column==0 || column==1)
                    System.out.print("|");
            }
            System.out.println();
        }
                
    }

    public int getPosition(int[] attempt){
        return Board[attempt[0]][attempt[1]];
    }
    
    public void setPosition(int[] attempt, int player){
        round++;
        x=attempt[0];
        y=attempt[1];
        if(player == 1)
            Board[attempt[0]][attempt[1]] = -1;
        else
            Board[attempt[0]][attempt[1]] = 1;
    }

    public int checkLines(){
        for(int line=0 ; line<3 ; line++){

            if( (Board[line][0] + Board[line][1] + Board[line][2]) == -3)
                return -1;
            if( (Board[line][0] + Board[line][1] + Board[line][2]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    public int checkColumns(){
        for(int column=0 ; column<3 ; column++){

            if( (Board[0][column] + Board[1][column] + Board[2][column]) == -3)
                return -1;
            if( (Board[0][column] + Board[1][column] + Board[2][column]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    public int checkDiagonals(){
        if( (Board[0][0] + Board[1][1] + Board[2][2]) == -3)
            return -1;
        if( (Board[0][0] + Board[1][1] + Board[2][2]) == 3)
            return 1;
        if( (Board[0][2] + Board[1][1] + Board[2][0]) == -3)
            return -1;
        if( (Board[0][2] + Board[1][1] + Board[2][0]) == 3)
            return 1;
        
        return 0;
    }
    
    public boolean fullBoard(){
        for(int line=0 ; line<3 ; line++)
            for(int column=0 ; column<3 ; column++)
                if( Board[line][column]==0 )
                    return false;
        return true;
          
    }
    
    // A partir daqui são funcoes para o computador
    public int checkLinesComp(int line){
            if( (Board[line][0] + Board[line][1] ) == 2)
                return 2;
            if( (Board[line][0] + Board[line][2] ) == 2)
                return 1;
            if( (Board[line][1] + Board[line][2] ) == 2)
                return 0;
        return 5;
    }
    public int checkLinesCompLoose(int line){
            if( (Board[line][0] + Board[line][1] ) == -2)
                return 2;
            if( (Board[line][0] + Board[line][2] ) == -2)
                return 1;
            if( (Board[line][1] + Board[line][2] ) == -2)
                return 0;
        return 5;
    }
    public int checkColumnsComp(int column){
            if( (Board[0][column] + Board[1][column]) == 2)
                return 2;
            if( (Board[0][column] + Board[2][column]) == 2)
               return 1;
            if( (Board[1][column] + Board[2][column]) == 2)
               return 0;       
        return 5;
                
    }
    public int checkColumnsCompLoose(int column){
            if( (Board[0][column] + Board[1][column]) == -2)
                return 2;
            if( (Board[0][column] + Board[2][column]) == -2)
               return 1;
            if( (Board[1][column] + Board[2][column]) == -2)
               return 0;       
        return 5;
                
    }
    public int checkDiagonalsPriComp(){
        if( (Board[0][0] + Board[1][1]) == 2)
            return 2;
        if( (Board[0][0] + Board[2][2]) == 2)
            return 1;
        if((Board[1][1] + Board[2][2]) == 2)
            return 0;
        
        
        return 5;
    }
    public int checkDiagonalsPriCompLoose(){
        if( (Board[0][0] + Board[1][1]) == -2)
            return 2;
        if( (Board[0][0] + Board[2][2]) == -2)
            return 1;
        if((Board[1][1] + Board[2][2]) == -2)
            return 0;
        
        
        return 5;
    }
    public int checkDiagonalSegComp(){
        if( (Board[0][2] + Board[1][1]) == 2)
            return 2;
        if( (Board[0][2] + Board[2][0]) == 2)
            return 1;
        if((Board[1][1] + Board[2][0]) == 2)
            return 0;
        return 5;
    }
    public int checkDiagonalSegCompLoose(){
        if( (Board[0][2] + Board[1][1]) == -2)
            return 2;
        if( (Board[0][2] + Board[2][0]) == -2)
            return 1;
        if((Board[1][1] + Board[2][0]) == -2)
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
        boolean p1=false, p2=false;
        int blank =0;
        
        for(int i =0; i<3; i++){
            for(int j=0; j<3; j++){
                switch (Board[i][j]) {
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
        boolean p1=false, p2=false;
        int blank =0;
        
        for(int i =0; i<3; i++){
            for(int j=0; j<3; j++){
                switch (Board[j][i]) {
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
        boolean p1=false, p2=false;
        int blank =0;
        
        switch (Board[0][0]) {
            case -1:    p1=true;    break;
            case 1:     p2=true;    break;
            default:    blank++;    break;
        }
        switch (Board[1][1]) {
            case -1:    p1=true;    break;
            case 1:     p2=true;    break;
            default:    blank++;    break;
        }
        switch (Board[2][2]) {
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
        boolean p1=false, p2=false;
        int blank =0;
        switch (Board[0][2]) {
            case -1:    p1=true;    break;
            case 1:     p2=true;    break;
            default:    blank++;    break;
        }
        switch (Board[1][1]) {
            case -1:    p1=true;    break;
            case 1:     p2=true;    break;
            default:    blank++;    break;
        }
        switch (Board[2][0]) {
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
        boolean p1=false, p2=false;
        int blank =0;      
        //Verifica se há possibilidade de vitória com alguma linha.
        if(grannyLine()==false){
            return false;
        }     
        //Verifica se há possibilidade de vitória com alguma coluna.
        if(grannyColumn()==false){
            return false;
        }      
        //Verifica se há possibilidade de vitória com diagonal principal.
        if(grannyDiagPrin()==false){
            return false;
        }       
        //Verifica se há possibilidade de vitória com diagonal auxiliar.
        if(grannyDiagAux()==false){
            return false;
        }
        return true;
    }
    
    public void fillUp(){
        Board[0][0]= -1;
        Board[1][0]=  1;
        Board[2][0]= -1;
        Board[0][2]= 1;
        Board[1][2]= -1;
        Board[2][2]= 1; 
        round = 6;
    }
}