//Name:Parmvir Grewal
//Date: December 21, 2017
//Purpose:To make chess

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;

public class ChessGame extends Applet implements ActionListener
{
	Boolean tf=false;
	int posxb=0;
	int posyb=0;
	int posxw=0;
	int posyw=0;
	int checkmate=0;
	JLabel turnpic;
	char turn ='B';
	int last =-1;
	Panel p_card;  //to hold all of the screens
	Panel card1, card2, card3, card4, card5; //the two screens
	CardLayout cdLayout = new CardLayout ();

	//grid
	int row = 8;
	int col = 8;
	JButton a[] = new JButton [row * col];
	char c[][] = {{'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}, {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'}, {'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'}};
	char c1[][] = {{'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}, {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'}, {'B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'}};
	char p [][]= {{'R', 'N', 'B', 'K', 'Q', 'B', 'N', 'R'}, {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'}, {'R', 'N', 'B', 'K', 'Q', 'B', 'N', 'R'}};
	char p1 [][]= {{'R', 'N', 'B', 'K', 'Q', 'B', 'N', 'R'}, {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}, {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'}, {'R', 'N', 'B', 'K', 'Q', 'B', 'N', 'R'}};
	char ld [][]= {{'L', 'D', 'L', 'D', 'L', 'D', 'L', 'D'}, {'D', 'L', 'D', 'L', 'D', 'L', 'D', 'L'}, {'L', 'D', 'L', 'D', 'L', 'D', 'L', 'D'}, {'D', 'L', 'D', 'L', 'D', 'L', 'D', 'L'}, {'L', 'D', 'L', 'D', 'L', 'D', 'L', 'D'}, {'D', 'L', 'D', 'L', 'D', 'L', 'D', 'L'}, {'L', 'D', 'L', 'D', 'L', 'D', 'L', 'D'}, {'D', 'L', 'D', 'L', 'D', 'L', 'D', 'L'}};
	char us[][]= {{'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}};
	char us1[][]= {{'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}};
	char ussr[][]= {{'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}, {'U', 'U', 'U', 'U', 'U', 'U', 'U', 'U'}};

	public void init ()
	{
		p_card = new Panel ();
		p_card.setLayout (cdLayout);
		screen1 ();
		screen2 ();
		screen3 ();
		screen4 ();
		screen5 ();
		resize (515, 600);
		setLayout (new BorderLayout ());
		add ("Center", p_card);
	}


	public void screen1 ()
	{ //screen 1 is set up.

		card1 = new Panel ();
		card1.setBackground (Color.white);
		JButton next =new JButton(createImageIcon("chess.png"));
		next.setActionCommand ("s2");
		next.addActionListener (this);

		card1.add (next);
		p_card.add ("1", card1);

	}


	public void screen2 ()
	{ //screen 2 is set up.
		card2 = new Panel ();
		card2.setBackground (Color.white);
		JButton next =new JButton(createImageIcon("intchess.png"));
		next.setActionCommand ("s3");
		next.addActionListener (this);
		card2.add (next);
		p_card.add ("2", card2);
	}


	public void screen3 ()
	{ //screen 3 is set up.

		card3 = new Panel ();
		card3.setBackground (Color.orange);
		JLabel title = new JLabel ("CHESS");
		title.setFont(new Font("TimesRoman", Font.PLAIN, 34)); 

		JButton next = new JButton ("Next");
		next.setActionCommand ("s4");
		next.addActionListener (this);
		turnpic =new JLabel(createImageIcon("BPDU.jpg"));

		//Set up grid
		Panel pan = new Panel (new GridLayout (row, col));
		int move = 0;
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{ 
				a [move] = new JButton (createImageIcon (c [i] [j] +""+p [i][j]+""+ld [i][j]+""+ us[i][j]+".jpg"));
				a [move].setPreferredSize (new Dimension (60, 60));
				a [move].addActionListener (this);
				a [move].setActionCommand ("" + move);
				pan.add (a [move]);
				move++;
			}
		}
		card3.add (title);
		card3.add (pan);
		card3.add (next);
		card3.add (turnpic);
		p_card.add ("3", card3);
	}


	public void screen4 ()
	{ //screen 4 is set up.
		card4 = new Panel ();
		card4.setBackground (Color.black);
		JButton next =new JButton(createImageIcon("black.png"));
		next.setActionCommand ("s5");
		next.addActionListener (this);
		card4.add (next);
		p_card.add ("4", card4);
	}


	public void screen5 ()
	{ //screen 5 is set up.
		card5 = new Panel ();
		card5.setBackground (Color.white);
		JButton next =new JButton(createImageIcon("white.png"));
		next.setActionCommand ("s6");
		next.addActionListener (this);
		card5.add (next);
		p_card.add ("5", card5);
	}


	protected static ImageIcon createImageIcon (String path)
	{ //change the red to your class name
		java.net.URL imgURL = ChessGame.class.getResource (path);
		if (imgURL != null)
		{
			return new ImageIcon (imgURL);
		}
		else
		{
			System.err.println ("Couldn't find file: " + path);
			return null;
		}
	}


	public void redraw ()
	{
		int move = 0;
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{
				a [move].setIcon (createImageIcon (c [i] [j] +""+p [i][j]+""+ld [i][j]+""+ us[i][j]+".jpg"));
				move++;
			}
		}
	}
	public void reset()
	{
		int move = 0;
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{
				p[i][j]=p1[i][j];
				c[i][j]=c1[i][j];
				us[i][j]=us1[i][j];
				ussr[i][j]=us1[i][j];
				turn='B';
				a [move].setIcon (createImageIcon (c [i] [j] +""+p [i][j]+""+ld [i][j]+""+ us[i][j]+".jpg"));
				move++;
			}
		}

	}
	public void selectPawn (int x, int y) {

		if (turn=='B') {

			if (c[x][y]=='B')
				us [x-1][y]='S';
			if (c[x][y]=='B'&&x==6)
				us [x-2][y]='S';
		}
		else {

			if (c[x][y]=='W')
				us [x+1][y]='S';
			if (c[x][y]=='W'&&x==1)
				us [x+2][y]='S';      

		}

	}
	public void selectPawnussr (int x, int y) {

		if (c[x][y]=='B') {
			if (c[x][y]=='B')
				ussr [x-1][y]='S';
			if (c[x][y]=='B'&&x==6)
				ussr [x-2][y]='S';
		}
		if (c[x][y]=='W') {
			if (c[x][y]=='W')
				ussr [x+1][y]='S';
			if (c[x][y]=='W'&&x==1)
				ussr [x+2][y]='S';      

		}

		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				if (p[i][j]=='K') {
					us[i][j]='U';
				}
			}
		}
	}
	public void selectBishopussr (int x, int y) {

		int cx1=x-1;
		int cy1=y+1;
		while (cx1>=0 &&cy1<=7&& c[cx1][cy1]=='O') {
			ussr[cx1][cy1]='S';
			cx1--;
			cy1++;
		}
		if (cx1>=0&&cy1<=7&&c[cx1][cy1]!=c[x][y]&& c[cx1][cy1]!='O') {
			ussr[cx1][cy1]='S';	
		}

		int cx2=x-1;
		int cy2=y-1;
		while (cx2>=0 &&cy2>=0&& c[cx2][cy2]=='O') {
			ussr[cx2][cy2]='S';
			cx2--;
			cy2--;
		}
		if (cx2>=0&&cy2>=0&&c[cx2][cy2]!=c[x][y]&& c[cx2][cy2]!='O') {
			ussr[cx2][cy2]='S';	
		}
		int cx3=x+1;
		int cy3=y+1;
		while (cx3<=7 &&cy3<=7&& c[cx3][cy3]=='O') {
			ussr[cx3][cy3]='S';
			cx3++;
			cy3++;
		}
		if (cx3<=7 &&cy3<=7&&c[cx3][cy3]!=c[x][y]&& c[cx3][cy3]!='O') {
			ussr[cx3][cy3]='S';	
		}
		int cx4=x+1;
		int cy4=y-1;
		while (cx4<=7 &&cy4>=0&& c[cx4][cy4]=='O') {
			ussr[cx4][cy4]='S';
			cx4++;
			cy4--;
		}
		if (cx4<=7 &&cy4>=0&&c[cx4][cy4]!=c[x][y]&& c[cx4][cy4]!='O') {
			ussr[cx4][cy4]='S';	
		}
	}
	public void selectRookussr (int x, int y) {
		int cx1=x-1;
		while (cx1>=0 && c[cx1][y]=='O') {
			ussr[cx1][y]='S';
			cx1--;
		}
		if (cx1>=0&&c[cx1][y]!=c[x][y]&& c[cx1][y]!='O') {
			ussr[cx1][y]='S';	
		}


		int cx2=x+1;
		while (cx2<=7 && c[cx2][y]=='O') {
			ussr[cx2][y]='S';
			cx2++;
		}
		if (cx2<=7&&c[cx2][y]!=c[x][y]&& c[cx2][y]!='O') {
			ussr[cx2][y]='S';	
		}
		int cy1=y+1;
		while (cy1<=7 && c[x][cy1]=='O') {
			ussr[x][cy1]='S';
			cy1++;
		}
		if (cy1<=7&&c[x][cy1]!=c[x][y]&& c[x][cy1]!='O') {
			ussr[x][cy1]='S';	
		}
		int cy2=y-1;
		while (cy2>=0 && c[x][cy2]=='O') {
			ussr[x][cy2]='S';
			cy2--;
		}
		if (cy2>=0&&c[x][cy2]!=c[x][y]&& c[x][cy2]!='O') {
			ussr[x][cy2]='S';	
		}




	}
	public void selectRook (int x, int y) {
		int cx1=x-1;
		while (cx1>=0 && c[cx1][y]=='O') {
			us[cx1][y]='S';
			cx1--;
		}
		if (cx1>=0&&c[cx1][y]!=c[x][y]&& c[cx1][y]!='O') {
			us[cx1][y]='S';	
		}


		int cx2=x+1;
		while (cx2<=7 && c[cx2][y]=='O') {
			us[cx2][y]='S';
			cx2++;
		}
		if (cx2<=7&&c[cx2][y]!=c[x][y]&& c[cx2][y]!='O') {
			us[cx2][y]='S';	
		}
		int cy1=y+1;
		while (cy1<=7 && c[x][cy1]=='O') {
			us[x][cy1]='S';
			cy1++;
		}
		if (cy1<=7&&c[x][cy1]!=c[x][y]&& c[x][cy1]!='O') {
			us[x][cy1]='S';	
		}
		int cy2=y-1;
		while (cy2>=0 && c[x][cy2]=='O') {
			us[x][cy2]='S';
			cy2--;
		}
		if (cy2>=0&&c[x][cy2]!=c[x][y]&& c[x][cy2]!='O') {
			us[x][cy2]='S';	
		}


		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				if (p[i][j]=='K') {
					us[i][j]='U';
				}
			}
		}

	}
	public void selectBishop (int x, int y) {
		int cx1=x-1;
		int cy1=y+1;
		while (cx1>=0 &&cy1<=7&& c[cx1][cy1]=='O') {
			us[cx1][cy1]='S';
			cx1--;
			cy1++;
		}
		if (cx1>=0&&cy1<=7&&c[cx1][cy1]!=c[x][y]&& c[cx1][cy1]!='O') {
			us[cx1][cy1]='S';	
		}


		int cx2=x-1;
		int cy2=y-1;
		while (cx2>=0 &&cy2>=0&& c[cx2][cy2]=='O') {
			us[cx2][cy2]='S';
			cx2--;
			cy2--;
		}
		if (cx2>=0&&cy2>=0&&c[cx2][cy2]!=c[x][y]&& c[cx2][cy2]!='O') {
			us[cx2][cy2]='S';	
		}
		int cx3=x+1;
		int cy3=y+1;
		while (cx3<=7 &&cy3<=7&& c[cx3][cy3]=='O') {
			us[cx3][cy3]='S';
			cx3++;
			cy3++;
		}
		if (cx3<=7 &&cy3<=7&&c[cx3][cy3]!=c[x][y]&& c[cx3][cy3]!='O') {
			us[cx3][cy3]='S';	
		}
		int cx4=x+1;
		int cy4=y-1;
		while (cx4<=7 &&cy4>=0&& c[cx4][cy4]=='O') {
			us[cx4][cy4]='S';
			cx4++;
			cy4--;
		}
		if (cx4<=7 &&cy4>=0&&c[cx4][cy4]!=c[x][y]&& c[cx4][cy4]!='O') {
			us[cx4][cy4]='S';	
		}
		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				if (p[i][j]=='K') {
					us[i][j]='U';
				}
			}
		}
	}


	public void selectQueen (int x, int y) {
		selectBishop(x,y);
		selectRook(x,y);
		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				if (p[i][j]=='K') {
					us[i][j]='U';
				}
			}
		}

	}
	public void selectQueenussr (int x, int y) {
		selectBishopussr(x,y);
		selectRookussr(x,y);

	}
	public void selectKnightussr (int x,int y){
		if (turn=='B') {
			if (x>=2&&y>=1&&c[x-2][y-1]!='B') {
				ussr [x-2][y-1]='S';


			}
			if (x>=2&&y<=6&&c[x-2][y+1]!='B') {
				ussr [x-2][y+1]='S';


			}
			if (x<=5&&y>=1&&c[x+2][y-1]!='B') {
				ussr [x+2][y-1]='S';


			}
			if (x<=5&&y<=6&&c[x+2][y+1]!='B') {
				ussr [x+2][y+1]='S';


			}
			if (x-1>=0&&y-2>=0&&c[x-1][y-2]!='B') {
				ussr [x-1][y-2]='S';


			}
			if (x+1<=7&&y-2>=0&&c[x+1][y-2]!='B') {
				ussr [x+1][y-2]='S';


			}
			if (x-1>=0&&y+2<=7&&c[x-1][y+2]!='B') {
				ussr [x-1][y+2]='S';


			}
			if (x+1<=7&&y+2<=7&&c[x+1][y+2]!='B') {
				ussr [x+1][y+2]='S';


			}


		}
		else {
			if (x>=2&&y>=1&&c[x-2][y-1]!='W') {
				ussr [x-2][y-1]='S';


			}
			if (x>=2&&y<=6&&c[x-2][y+1]!='W') {
				ussr [x-2][y+1]='S';


			}
			if (x<=5&&y>=1&&c[x+2][y-1]!='W') {
				ussr [x+2][y-1]='S';


			}
			if (x<=5&&y<=6&&c[x+2][y+1]!='W') {
				ussr [x+2][y+1]='S';


			}
			if (x-1>=0&&y-2>=0&&c[x-1][y-2]!='W') {
				ussr [x-1][y-2]='S';


			}
			if (x+1<=7&&y-2>=0&&c[x+1][y-2]!='W') {
				ussr [x+1][y-2]='S';


			}
			if (x-1>=0&&y+2<=7&&c[x-1][y+2]!='W') {
				ussr [x-1][y+2]='S';


			}
			if (x+1<=7&&y+2<=7&&c[x+1][y+2]!='W') {
				ussr [x+1][y+2]='S';


			}

		}

	}

	public void selectKnight (int x, int y) {
		if (turn=='B') {
			if (x>=2&&y>=1&&c[x-2][y-1]!='B') {
				us [x-2][y-1]='S';


			}
			if (x>=2&&y<=6&&c[x-2][y+1]!='B') {
				us [x-2][y+1]='S';


			}
			if (x<=5&&y>=1&&c[x+2][y-1]!='B') {
				us [x+2][y-1]='S';


			}
			if (x<=5&&y<=6&&c[x+2][y+1]!='B') {
				us [x+2][y+1]='S';


			}
			if (x-1>=0&&y-2>=0&&c[x-1][y-2]!='B') {
				us [x-1][y-2]='S';


			}
			if (x+1<=7&&y-2>=0&&c[x+1][y-2]!='B') {
				us [x+1][y-2]='S';


			}
			if (x-1>=0&&y+2<=7&&c[x-1][y+2]!='B') {
				us [x-1][y+2]='S';


			}
			if (x+1<=7&&y+2<=7&&c[x+1][y+2]!='B') {
				us [x+1][y+2]='S';


			}
			for(int i=0;i<=7;i++) {
				for(int j=0;j<=7;j++) {
					if (p[i][j]=='K') {
						us[i][j]='U';
					}
				}
			}

		}
		else {
			if (x>=2&&y>=1&&c[x-2][y-1]!='W') {
				us [x-2][y-1]='S';


			}
			if (x>=2&&y<=6&&c[x-2][y+1]!='W') {
				us [x-2][y+1]='S';


			}
			if (x<=5&&y>=1&&c[x+2][y-1]!='W') {
				us [x+2][y-1]='S';


			}
			if (x<=5&&y<=6&&c[x+2][y+1]!='W') {
				us [x+2][y+1]='S';


			}
			if (x-1>=0&&y-2>=0&&c[x-1][y-2]!='W') {
				us [x-1][y-2]='S';


			}
			if (x+1<=7&&y-2>=0&&c[x+1][y-2]!='W') {
				us [x+1][y-2]='S';


			}
			if (x-1>=0&&y+2<=7&&c[x-1][y+2]!='W') {
				us [x-1][y+2]='S';


			}
			if (x+1<=7&&y+2<=7&&c[x+1][y+2]!='W') {
				us [x+1][y+2]='S';


			}

		}

	}

	public void selectKingussr (int x, int y) {
		if (turn=='B') {
			if (y+1<=7&&x-1>=0&&c[x-1][y+1]!='B'&&ussr[x-1][y+1]!='S') {
				us [x-1][y+1]='S';

			}
			if (x-1>=0&&c[x-1][y]!='B'&&ussr[x-1][y]!='S') {
				us [x-1][y]='S';
			}
			if (x-1>=0&&y-1>=0&&c[x-1][y-1]!='B'&&ussr[x-1][y-1]!='S') {
				us [x-1][y-1]='S';
			}
			if (y-1>=0&&c[x][y-1]!='B'&&ussr[x][y-1]!='S') {
				us [x][y-1]='S';
			}
			if (y+1<=7&&x+1<=7&&c[x+1][y+1]!='B'&&ussr[x+1][y+1]!='S') {
				us [x+1][y+1]='S';
			}
			if (x+1<=7&&c[x+1][y]!='B'&&ussr[x+1][y]!='S') {
				us [x+1][y]='S';
			}
			if (x+1<=7&&y-1>=0&&c[x+1][y-1]!='B'&&ussr[x+1][y-1]!='S') {
				us [x+1][y-1]='S';
			}
			if (y+1<=7&&c[x][y+1]!='B'&&ussr[x][y+1]!='S') {
				us [x][y+1]='S';
			}
		}
		else {
			if (y+1<=7&&x-1>=0&&c[x-1][y+1]!='W'&&ussr[x-1][y+1]!='S') {
				us [x-1][y+1]='S';
			}
			if (x-1>=0&&c[x-1][y]!='W'&&ussr[x-1][y]!='S') {
				us [x-1][y]='S';
			}
			if (x-1>=0&&y-1>=0&&c[x-1][y-1]!='W'&&ussr[x-1][y-1]!='S') {
				us [x-1][y-1]='S';
			}
			if (y-1>=0&&c[x][y-1]!='W'&&ussr[x][y-1]!='S') {
				us [x][y-1]='S';
			}
			if (y+1<=7&&x+1<=7&&c[x+1][y+1]!='W'&&ussr[x+1][y+1]!='S') {
				us [x+1][y+1]='S';
			}
			if (x+1<=7&&c[x+1][y]!='W'&&ussr[x+1][y]!='S') {
				us [x+1][y]='S';
			}
			if (x+1<=7&&y-1>=0&&c[x+1][y-1]!='W'&&ussr[x+1][y-1]!='S') {
				us [x+1][y-1]='S';
			}
			if (y+1<=7&&c[x][y+1]!='W'&&ussr[x][y+1]!='S') {
				us [x][y+1]='S';
			}
		}
	}
	public void checkw (int x,int y){

		for(int a=0;a<=7;a++) {
			for(int b=0;b<=7;b++) {
				if (p[a][b]=='K'&&c[a][b]=='W'){
					posxw=a;
					posyw=b;
				}
			} 
		}
		for(int a=0;a<=7;a++) {
			for(int b=0;b<=7;b++) {
				if (p[a][b]=='P'&&c[a][b]!='W') {
					selectPawnussr(a,b);

					if (ussr[posxw][posyw]=='S'&&turn=='W') {
						if(p[x][y]=='K'){
							selectKingussr(posxw,posyw);
						}

						tf=true;
					}
				}
				if (p[a][b]=='R'&&c[a][b]!='W') {
					selectRookussr(a,b);
					if (ussr[posxw][posyw]=='S'&&turn=='W') {

						if(p[x][y]=='K'){
							selectKingussr(posxw,posyw);
						}
						tf=true;
					}
				}
				if (p[a][b]=='B'&&c[a][b]!='W') {
					selectBishopussr(a,b);
					if (ussr[posxw][posyw]=='S'&&turn=='W') {

						if(p[x][y]=='K'){
							selectKingussr(posxw,posyw);
						}
						tf=true;
					}


				}
				if (p[a][b]=='Q'&&c[a][b]!='W') {
					selectQueenussr(a,b);
					if (ussr[posxw][posyw]=='S'&&turn=='W') {

						if(p[x][y]=='K'){
							selectKingussr(posxw,posyw);
						}
						tf=true;
					}
				}
				if (p[a][b]=='N'&&c[a][b]!='W') {
					selectKnightussr(a,b);
					if (ussr[posxw][posyw]=='S'&&turn=='W') {

						if(p[x][y]=='K'){
							selectKingussr(posxw,posyw);
						}
						tf=true;
					}
				}
				if (p[a][b]=='N'&&c[a][b]!='W') {
					selectKnightussr(a,b);
					if (ussr[posxw][posyw]=='S'&&turn=='W') {

						if(p[x][y]=='K'){
							selectKingussr(posxw,posyw);
						}
						tf=true;
					}
				}

			}
		}
		if(checkmate==0&&ussr[posxw][posyw]=='S') {
			reset();
			cdLayout.show (p_card, "4");

		}
		if (checkmate!=0) {
			checkmate=0;
			showStatus("");
		}

	}


	public void checkb (int x, int y) {

		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				if (p[i][j]=='K'&&c[i][j]=='B'){
					posxb=i;
					posyb=j;
				}
			} 
		}
		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				if (p[i][j]=='P'&&c[i][j]!='B') {
					selectPawnussr(i,j);

					if (ussr[posxb][posyb]=='S'&&turn=='B') {
						if(p[x][y]=='K'){
							selectKingussr(posxb,posyb);
						}

						tf=true;
					}
				}
				if (p[i][j]=='R'&&c[i][j]!='B') {
					selectRookussr(i,j);
					if (ussr[posxb][posyb]=='S'&&turn=='B') {

						if(p[x][y]=='K'){
							selectKingussr(posxb,posyb);
						}
						tf=true;
					}
				}
				if (p[i][j]=='B'&&c[i][j]!='B') {
					selectBishopussr(i,j);
					if (ussr[posxb][posyb]=='S'&&turn=='B') {

						if(p[x][y]=='K'){
							selectKingussr(posxb,posyb);
						}
						tf=true;
					}


				}
				if (p[i][j]=='Q'&&c[i][j]!='B') {
					selectQueenussr(i,j);
					if (ussr[posxb][posyb]=='S'&&turn=='B') {

						if(p[x][y]=='K'){
							selectKingussr(posxb,posyb);
						}
						tf=true;
					}
				}
				if (p[i][j]=='N'&&c[i][j]!='B') {
					selectKnightussr(i,j);
					if (ussr[posxb][posyb]=='S'&&turn=='B') {

						if(p[x][y]=='K'){
							selectKingussr(posxb,posyb);
						}
						tf=true;
					}
				}
				if (p[i][j]=='N'&&c[i][j]!='B') {
					selectKnightussr(i,j);
					if (ussr[posxb][posyb]=='S'&&turn=='B') {

						if(p[x][y]=='K'){
							selectKingussr(posxb,posyb);
						}
						tf=true;
					}
				}

			}
		}
		if(checkmate==0&&ussr[posxb][posyb]=='S') {
			reset();
			cdLayout.show (p_card, "5");
		}
		if (checkmate!=0) {
			checkmate=0;
			showStatus("");
		}
		for(int i=0;i<=7;i++) {
			for(int j=0;j<=7;j++) {
				ussr[i][j]='U';

			}
		}

	}

	public void actionPerformed (ActionEvent e)
	{ //moves between the screens
		if (e.getActionCommand ().equals ("s1"))
			cdLayout.show (p_card, "1");
		else if (e.getActionCommand ().equals ("s2"))
			cdLayout.show (p_card, "2");
		else if (e.getActionCommand ().equals ("s3"))
			cdLayout.show (p_card, "3");
		else if (e.getActionCommand ().equals ("s4"))
			cdLayout.show (p_card, "4");
		else if (e.getActionCommand ().equals ("s5"))
			cdLayout.show (p_card, "1");
		else if (e.getActionCommand ().equals ("s6"))
			cdLayout.show (p_card, "1");
		else
		{ //code to handle the game

			int n = Integer.parseInt (e.getActionCommand ());
			int x = n / col;
			int y = n % col;
			if (turn=='B'){
				checkb(x,y);
			}
			if (turn=='W'){
				checkw(x,y);
			}
			if (turn!=c[x][y]&&last==-1)
				showStatus ("It's not your turn");
			else if (last==-1 && turn==c[x][y]) {
				showStatus ("");


				if (tf==false) {
					if(p[x][y]=='P')                         
						selectPawn(x,y);
					if (p[x][y]=='R')                               
						selectRook(x,y);
					if (p[x][y]=='B')
						selectBishop(x,y);
					if (p[x][y]=='Q')
						selectQueen(x,y);
					if (p[x][y]=='N')
						selectKnight(x,y);
					if (p[x][y]=='K')
						selectKingussr(x,y);

				}
				else if (tf==true) {
					tf=false;
				}
				//add other pieces
				last=n;
			}
			else {
				int lastx=last/col;
				int lasty= last%col;
				if (us[x][y]=='S') {
					p[x][y]=p[lastx][lasty];
					p[lastx][lasty]='O';
					c[x][y]=c[lastx][lasty];
					c[lastx][lasty]='O';



					//add more
					if (turn=='B'){
						turnpic.setIcon(createImageIcon("WPLU.jpg"));
						turn='W';
					}
					else{
						turnpic.setIcon(createImageIcon("BPDU.jpg"));
						turn='B';
					}
				}


				for(int i=0; i<row;i++) {
					for(int j=0;j<col;j++)
					{
						us[i][j]='U';
						ussr[i][j]='U';
					}
				}
				last=-1;
			}
			redraw();

		}
	}
}