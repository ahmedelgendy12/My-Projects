#include <curses.h>
#include <ncurses.h>
#include <strings.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <termios.h>
#include <time.h>
#define BACK     ' '
#define BACK_PAIR     1
#define PLAYER_PAIR    2
#define BLANK "             "
#define MENUWIDTH   30
#define MENUHEIGHT  10
int  mStartx = 0;
int  mStarty = 0;
char *mchoices[] = { //menu choices
    "Start Game",
    "Rage Mode",
    "Exit",
};
int numChoices = 3;
int timeChange = 3000;
clock_t start, end;
void board();
void drawBack(void);
void gameWon();
void input();
void fruit();
void gameWin();
void logic();
int isMove(int y, int x);
void gameOver();
void snakeMove();
int trophy = 4;
int score = 0;
int ch = 0;
int rage = 0;
int speed = 110;
int y, x;
int fruitX,  fruitY;
int height = 0, width = 0;
int totalTail = 5;
int tailX[300], tailY[300];
int dir = +1;
double timeFruit;
WINDOW *my_win;



void print_menu(WINDOW *menu_win, int highlight) //prints the menu
{
    int x, y, i;

    x = 2;
    y = 2;
    box(menu_win, 0, 0);
    for(i = 0; i < numChoices; ++i) //prints each choice into the menu
    {    if(highlight == i + 1)
    {    wattron(menu_win, A_REVERSE);
        mvwprintw(menu_win, y, x, "%s", mchoices[i]);
        wattroff(menu_win, A_REVERSE);
    }
    else
        mvwprintw(menu_win, y, x, "%s", mchoices[i]);
        ++y;
    }
    wrefresh(menu_win);
}


// function to check if a keyboard button was hit
int kbhit(void)
{
  struct termios oldt, newt;
  int oldf;

  tcgetattr(STDIN_FILENO, &oldt);
  newt = oldt;
  newt.c_lflag &= ~(ICANON | ECHO);
  tcsetattr(STDIN_FILENO, TCSANOW, &newt);
  oldf = fcntl(STDIN_FILENO, F_GETFL, 0);
  fcntl(STDIN_FILENO, F_SETFL, oldf | O_NONBLOCK);

  ch = getchar();

  tcsetattr(STDIN_FILENO, TCSANOW, &oldt);
  fcntl(STDIN_FILENO, F_SETFL, oldf);

  if(ch != EOF)
  {
    ungetc(ch, stdin);
    return 1;
  }

  return 0;
}

int main(void)
{

    WINDOW *menu_win;
    int highlight = 1; //begin highlighter at position 1
    int choice = 0;
    int c;
    
    initscr();
    clear();
    noecho();
    cbreak();
    mStartx = (80 - MENUWIDTH) / 2;
    mStarty = (24 - MENUHEIGHT) / 2;
        
    menu_win = newwin(MENUHEIGHT, MENUWIDTH, mStarty, mStartx);
    keypad(menu_win, TRUE);
    mvprintw(0, 0, "Use arrow keys to go up and down, Press enter to select a choice");
    refresh();
    print_menu(menu_win, highlight);
    while(1)
    {   c = wgetch(menu_win);
        switch(c)
        {    case KEY_UP:
                if(highlight == 1) //if at the first choice, go to last choice at the bottom
                    highlight = numChoices;
                else
                    --highlight; //else go up a choice
                break;
            case KEY_DOWN:
                if(highlight == numChoices) //if at the end of choices, go back to first choice at the top
                    highlight = 1;
                else
                    ++highlight; //else go down a choice
                break;
            case 10:
                choice = highlight; //when enter is pressed, choice is set to whatever is highlighted
                break;
            default:
                refresh();
                break;
        }
        print_menu(menu_win, highlight);
        if(choice != 0)
            break;
    }
    clear();
    if(choice==3) { //exit if exit is selected
        endwin();
        exit(0);
    }
    if(choice==2){ //enable rage mode if rage is selected
        rage = 1;
    }
    refresh();
    trophy = rand()%9+1;


    time_t t;
    srand(time(&t)); //ensures the seed is constanly changing to generate random numbers
    start = clock();
    char message[] = "@"; // head of snake
    char blank[] = "       "; // white space to remove snake
    int next_x = 0;
    int checker;
    int hasInput;
    
    // sets up the screen
    initscr();
    keypad(stdscr, TRUE);
    curs_set(0); // Hide the Curser
    noecho(); //makes sure the cursor isn't displayed on the terminal
    cbreak();
    // sets color for the background
    start_color();
    init_pair(BACK_PAIR, COLOR_RED, COLOR_MAGENTA);
    init_pair(PLAYER_PAIR, COLOR_YELLOW,  COLOR_GREEN);
    clear();
    

    // initialize the MAP
    drawBack();
    scrollok(stdscr, TRUE);
    nodelay(stdscr, TRUE);

    // start player in the middle
    y = LINES/2 - 1;
    x = 30;
  
  
    //The snake starts moving to a random direction
       ch = rand()%4+1;
    
        
      //The fruit start at random spot
    fruitX =  rand()%(LINES-1);
    fruitY = rand()%(COLS-1);

    do {
    refresh();
    fruit(); // method call to display fruit (trophy)
    snakeMove();
    refresh();
    logic();
    input();
    }while ((ch != 'q') || (ch != 'Q')); //ends game if q or Q is pressed

    endwin(); //closes window
    exit(0);
}

// checks if snake can move
int isMove(int y, int x)
{
    int testch;
    testch = mvinch(y, x);
    if(testch > 48 && testch < 60){
        testch = BACK;
    }
    return ((testch & A_CHARTEXT) == BACK);
}

//makes the backgroud with color
void drawBack(void)
{
    int y, x;
// background
    attron(COLOR_PAIR(BACK_PAIR));
    for (y = 0; y <= LINES; y++) {
        mvhline(y, 0, BACK, COLS);
    }
    attroff(COLOR_PAIR(BACK_PAIR));

}

// takes input from keyboard and sets to a case
void input(){
    int preCh;
    if(kbhit){
        preCh = ch;
        switch(getch()){
         case KEY_UP:
        case 'w':
        case 'W':
        ch = 1;
        if(preCh == 2){
            gameOver();
        }
            break;
        case KEY_DOWN:
        case 's':
        case 'S':
        ch = 2;
        if(preCh == 1){
            gameOver();
        }
            break;
        case KEY_LEFT:
        case 'a':
        case 'A':
        ch = 3;
        if(preCh == 4){
            gameOver();
        }
            break;
        case KEY_RIGHT:
        case 'd':
        case 'D':
        ch = 4;
        if(preCh == 3){
            gameOver();
        }
            break;
        case 'r':
        case 'R':
        rage = 1;
        break;


        }
    }
}

// makes the snake moves to the next spot depending on the input
void logic(){

// RAGE mode activated if pressed r
if (rage == 1){
    speed = 50;
    init_pair(BACK_PAIR, COLOR_RED, COLOR_RED); //changes background to red
    init_pair(PLAYER_PAIR, COLOR_YELLOW,  COLOR_YELLOW);
    timeChange = 6000;
    rage = 0;
} 
if (speed < 70){  
    timeChange = 6000;
} else if (speed < 40){
    timeChange = 7000;
} 
     switch (ch) {
        case 1:
            if ((y >= 0) && isMove(y, x)) {
                   drawBack();
                y = y - 1;
            } else {
           gameOver();
            }
            
            break;
        case 2:
            if ((y < LINES) && isMove(y, x)) {
            drawBack();

                y = y + 1;
            } else {
           gameOver();
            }
            break;
        case 3:
            if ((x >= 0) && isMove(y, x)) {
                drawBack();
                x = x - 1;
                dir = -1;
            } else {
           gameOver();
            }
            break;
        case 4:
            if ((x < COLS) && isMove(y, x)) {
                 drawBack();
            
                x = x + 1;
                dir = +1;
            } else {
           gameOver();
            }
            
            break;
        }
        napms(speed);
}

 //Checks if the fruit is eaten or expired and creates a new one at a random spot
 void fruit(){
    time_t c;
    srand((unsigned) time(&c)); //ensures the seed is constanly changing to generate random numbers
     if ((timeFruit > (trophy * timeChange))){ //updates position of the fruit
    start = clock();
    end = clock();
    timeFruit = ((double) (end - start));

    trophy = rand()%9+1; //trophy is random number from 1-9


    fruitX = rand()%(LINES-2);
    fruitY = rand()%(COLS-2);
    }
    if(fruitY == tailX[0] && fruitX == tailY[0]){

    start = clock();
    fruitX = rand()%(LINES-2);
    fruitY = rand()%(COLS-2);
    totalTail = totalTail + trophy;

    if (speed > 70){
    speed = speed - 15;
    } else if (speed > 40){
        speed = speed - 10;
    } else if (speed > 20){
        speed = speed - 5;
    } else {
       speed = speed - 1;
    }
    score = score + trophy;
    trophy = rand()%9+1; //trophy is random number from 1-9
    }
    end = clock();
    timeFruit = ((double) (end - start));
  mvaddch(fruitX, fruitY, trophy+'0'); //prints trophy as random number
  if(score >= (COLS+LINES))
    gameWon();
 }

//Prints game over and closes the window
 void gameOver(){
            move(LINES/2 - 1,COLS/2 - 1);
            attroff(COLOR_PAIR(PLAYER_PAIR));
            addstr("GAME OVER");
            move(LINES/2 + 2,COLS/2 - 1);
            char str[8];
            sprintf(str, "%d", score);
            addstr("Score: ");
            addstr(str);
            refresh();
            sleep(5);
            endwin();
            exit(0);
 }

//Prints game won and closes the window
 void gameWon(){
            move(LINES/2 - 1,COLS/2 - 1); //prints in the middle of the screen
            attroff(COLOR_PAIR(PLAYER_PAIR));
            addstr("GAME WON");
            move(LINES/2 + 2,COLS/2 - 1);
            char str[8];
            sprintf(str, "%d", score);
            addstr("Score: ");
            addstr(str);
            refresh();
            sleep(5);
            endwin();
            exit(0);
 }

//moves the snake and turns on color for it too
void snakeMove(){
    int prevX = tailX[0];
    int prevY = tailY[0];
    int prev2X, prev2Y;
    tailX[0] = x;
    tailY[0] = y;
    for (int i = 1; i < totalTail; i++)
    {
        prev2X = tailX[i];
        prev2Y = tailY[i];
        tailX[i] = prevX;
        tailY[i] = prevY;
        prevX = prev2X;
        prevY = prev2Y;
       
       if(i == 1){
        attron(COLOR_PAIR(PLAYER_PAIR)); //makes the snake a different color

       mvaddch(tailY[i],tailX[i] ,'@');
       } else {
       mvaddch(tailY[i],tailX[i] ,'O');
       }
    }
     attron(COLOR_PAIR(PLAYER_PAIR)); //makes the snake a different color
}
