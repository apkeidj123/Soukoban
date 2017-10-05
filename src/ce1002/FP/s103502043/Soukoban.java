package ce1002.FP.s103502043;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.sound.midi.*;
import java.util.Stack;

public class Soukoban
{
	public static void main(String[] args)
	{
		new mainFrame();
	}
}

class mainFrame extends JFrame implements ActionListener,ItemListener
{
	JLabel lb;
	JLabel lb2;
	JButton brenew,blast,bnext,bchoose,bfirst,bfinal,bmuc,bback,bexit;
	mainpanel panel;
	Sound sound;
	//new JComboBox
	JComboBox jc=new JComboBox();
	//new MenuItem
	MenuItem renew=new MenuItem("    Restart");
	MenuItem back=new MenuItem("    Back");
	MenuItem last=new MenuItem("    Last");
	MenuItem next=new MenuItem("    Next");
	MenuItem choose=new MenuItem("    Choose");
	MenuItem exit=new MenuItem("    Exit");
	MenuItem m0=new MenuItem("    Music1");
	MenuItem m1=new MenuItem("    Music2");
	MenuItem m2=new MenuItem("    Music3");
	MenuItem m3=new MenuItem("    Music4");
	MenuItem m4=new MenuItem("    Music5");
	MenuItem m5=new MenuItem("    Music6");
	MenuItem m6=new MenuItem("    Music7");
	MenuItem m7=new MenuItem("    Music8");
	MenuItem m8=new MenuItem("    Music9");
	MenuItem m9=new MenuItem("    Music10");
	MenuItem m10=new MenuItem("    Music11");

	mainFrame()
	{
		super("Soukoban");
		setSize(740,710);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x=close
		Container ct=getContentPane();
		ct.setLayout(null);
		ct.setBackground(Color.black);
		//new Menu
		Menu choice=new Menu("    Choice");
		choice.add(renew);
		choice.add(last);
		choice.add(next);
		choice.add(choose);
		choice.add(back); 
		choice.addSeparator();
		choice.add(exit);

		renew.addActionListener(this);
		last.addActionListener(this);
		next.addActionListener(this);
		choose.addActionListener(this);
		exit.addActionListener(this);
		back.addActionListener(this);
		//new Menu
		Menu setmuc=new Menu("    SetMusic");
		setmuc.add(m0);
		setmuc.add(m1);
		setmuc.add(m2);
		setmuc.add(m3);
		setmuc.add(m4);
		setmuc.add(m5);
		setmuc.add(m6);
		setmuc.add(m7);
		setmuc.add(m8);
		setmuc.add(m9);
		setmuc.add(m10);

		m0.addActionListener(this);
		m1.addActionListener(this);
		m2.addActionListener(this);
		m3.addActionListener(this);
		m4.addActionListener(this);
		m5.addActionListener(this);
		m6.addActionListener(this);
		m7.addActionListener(this);
		m8.addActionListener(this);
		m9.addActionListener(this);
		m10.addActionListener(this);
		
		MenuBar bar=new MenuBar();//new MenuBar
		bar.add(choice);
		bar.add(setmuc);
		setMenuBar(bar);

		m0.setEnabled(false);
		lb=new JLabel("",SwingConstants.CENTER);
		lb2=new JLabel("Music",SwingConstants.CENTER);
		add(lb);
		add(lb2);
		lb.setBounds(100,20,400,20);
		lb.setForeground(Color.white);
		lb2.setBounds(625,480,55,20);
		lb2.setForeground(Color.white);
		//new JButton
		brenew = new JButton("ReStart");
		bback = new JButton("Back");
		blast = new JButton("Last");
		bnext = new JButton("Next");
		bchoose = new JButton("Choose");
		bfirst = new JButton("First");
		bfinal = new JButton("Final");
		bmuc = new JButton("Music Off");
		bexit = new JButton("Exit");

		add(brenew);
		add(blast);
		add(bnext);
		add(bchoose);
		add(bfirst);
		add(bfinal);
		add(bmuc);
		add(bback);
		add(bexit);
		//setLocation and size
		brenew.setBounds(625,50,100,30);
		brenew.addActionListener(this);
		bback.setBounds(625,100,100,30);
		bback.addActionListener(this);
		bfirst.setBounds(625,150,100,30);
		bfirst.addActionListener(this);
		blast.setBounds(625,200,100,30);
		blast.addActionListener(this);
		bnext.setBounds(625,250,100,30);
		bnext.addActionListener(this);
		bfinal.setBounds(625,300,100,30);
		bfinal.addActionListener(this);
		bchoose.setBounds(625,350,100,30);
		bchoose.addActionListener(this);
		bmuc.setBounds(625,400,100,30);
		bmuc.addActionListener(this);
		bexit.setBounds(625,450,100,30);
		bexit.addActionListener(this);

		jc.setBounds(625,500,100,20);
		jc.addItem("Music1");
		jc.addItem("Music2");
		jc.addItem("Music3");
		jc.addItem("Music4");
		jc.addItem("Music5");
		jc.addItem("Music6");
		jc.addItem("Music7");
		jc.addItem("Music8");
		jc.addItem("Music9");
		jc.addItem("Music10");
		jc.addItem("Music11");
		jc.addItemListener(this);
		ct.add(jc);
		sound=new Sound();
		sound.loadSound();
		panel=new mainpanel();
		add(panel);
		panel.Tuixiangzi(panel.level);
		panel.requestFocus();
		validate();
	}
	
	public void actionPerformed(ActionEvent e)//Jbutton pressed or Item pressed
	{
		if(e.getSource()==brenew||e.getSource()==renew)//renew
		{
			panel.Tuixiangzi(panel.level);
			panel.requestFocus();
			panel.remove();
		}
		else if(e.getSource()==blast||e.getSource()==last)//last level
		{
			panel.level--;
			if(panel.level<1)
			{
				panel.level++;
				JOptionPane.showMessageDialog(this,"It is level 1 now");
				panel.requestFocus();
			}
			else 
			{
				panel.Tuixiangzi(panel.level);
				panel.requestFocus();
			}
			panel.remove();
		}
		else if(e.getSource()==bnext||e.getSource()==next)//next level
		{
			panel.level++;
			if(panel.level>panel.maxlevel())
			{
				panel.level--;
				JOptionPane.showMessageDialog(this,"It is the final level");
				panel.requestFocus();
			}
			else 
			{
				panel.Tuixiangzi(panel.level);
				panel.requestFocus();
			}
			panel.remove();
		}
		else if(e.getSource()==bexit||e.getSource()==exit)//exit
			System.exit(0);
		else if(e.getSource()==bchoose||e.getSource()==choose)//choose level
		{
			String lel=JOptionPane.showInputDialog(this,"Please choose the level you want:(1~50)");
			try
			{
				panel.level=Integer.parseInt(lel);
				panel.remove();
				if(panel.level>panel.maxlevel()||panel.level<1)
				{
					JOptionPane.showMessageDialog(this, "No this level !!!");panel.requestFocus();
				}
				else
				{
					panel.Tuixiangzi(panel.level);
					panel.requestFocus();
				}
			}
			catch(NumberFormatException e1)
			{
				System.out.println(e1);
			}
		}

		else if(e.getSource()==bfirst)//to level1
		{
			panel.level=1;
			panel.Tuixiangzi(panel.level);
			panel.requestFocus();
			panel.remove();
		}
		else if(e.getSource()==bfinal)//to level 50
		{
			panel.level=panel.maxlevel();
			panel.Tuixiangzi(panel.level);
			panel.requestFocus();
			panel.remove();
		}
		else if(e.getSource()==bmuc)//turn the music on or off
		{
			if(sound.isplay())
			{
				sound.mystop();bmuc.setLabel("Music On");
			}
			else 
			{
				sound.loadSound();bmuc.setLabel("Music Off");
			}
			panel.requestFocus();
		}
		else if(e.getSource()==bback||e.getSource()==back)//get one step back
		{
			if(panel.isMystackEmpty())
				JOptionPane.showMessageDialog(this, "You have not moved !!!");
			else
			{
				switch(panel.back())
				{
				case 10:panel.backup(10);break;
				case 11:panel.backup(11);break;
				case 20:panel.backdown(20);break;
				case 21:panel.backdown(21);break;
				case 30:panel.backleft(30);break;
				case 31:panel.backleft(31);break;
				case 40:panel.backright(40);break;
				case 41:panel.backright(41);break;
				}
			}
			panel.requestFocus();
		}
		else if(e.getSource()==m0)
		{
			jc.setSelectedIndex(0);
		}

		else if(e.getSource()==m1)
		{
			jc.setSelectedIndex(1);
		}
		else if(e.getSource()==m2)
		{	
			jc.setSelectedIndex(2);
		}
		else if(e.getSource()==m3)
		{
			jc.setSelectedIndex(3);
		}
		else if(e.getSource()==m4)
		{
			jc.setSelectedIndex(4);
		}
		else if(e.getSource()==m5)
		{
			jc.setSelectedIndex(5);
		}
		else if(e.getSource()==m6)
		{
			jc.setSelectedIndex(6);
		}
		else if(e.getSource()==m7)
		{
			jc.setSelectedIndex(7);
		}
		else if(e.getSource()==m8)
		{
			jc.setSelectedIndex(8);
		}
		else if(e.getSource()==m9)
		{
			jc.setSelectedIndex(9);
		}
		else if(e.getSource()==m10)
		{
			jc.setSelectedIndex(10);
		}
	}
	public void itemStateChanged(ItemEvent ie)//Item choosed and change state
	{
		int no=jc.getSelectedIndex();
		switch(no)
		{
		case 0:sound.setMusic("Air.mid");//Music1
		if(sound.isplay())
			sound.mystop();
		sound.loadSound();
		bmuc.setLabel("Music Off");
		m0.setEnabled(false);
		m1.setEnabled(true);
		m2.setEnabled(true);
		m3.setEnabled(true);
		m4.setEnabled(true);
		m5.setEnabled(true);
		m6.setEnabled(true);
		m7.setEnabled(true);
		m8.setEnabled(true);
		m9.setEnabled(true);
		m10.setEnabled(true);
		panel.requestFocus(); break;
		case 1:sound.setMusic("Totoro.mid");//Music2
		if(sound.isplay())
			sound.mystop();
		sound.loadSound();
		bmuc.setLabel("Music Off");					 
		m0.setEnabled(true);
		m1.setEnabled(false);
		m2.setEnabled(true);
		m3.setEnabled(true);
		m4.setEnabled(true);
		m5.setEnabled(true);
		m6.setEnabled(true);
		m7.setEnabled(true);
		m8.setEnabled(true);
		m9.setEnabled(true);
		m10.setEnabled(true);
		panel.requestFocus(); break;
		case 2:sound.setMusic("dragon ball.mid");//Music3
		if(sound.isplay())
			sound.mystop();
		sound.loadSound();
		bmuc.setLabel("Music Off");					
		m0.setEnabled(true);
		m1.setEnabled(true);
		m2.setEnabled(false);
		m3.setEnabled(true);
		m4.setEnabled(true);
		m5.setEnabled(true);
		m6.setEnabled(true);
		m7.setEnabled(true);
		m8.setEnabled(true);
		m9.setEnabled(true);
		m10.setEnabled(true);
		panel.requestFocus();break;
		case 3:sound.setMusic("Sky.mid");//Music4
		if(sound.isplay())
			sound.mystop();
		sound.loadSound();
		bmuc.setLabel("Music Off");					
		m0.setEnabled(true);
		m1.setEnabled(true);
		m2.setEnabled(true);
		m3.setEnabled(false);
		m4.setEnabled(true);	
		m5.setEnabled(true);
		m6.setEnabled(true);
		m7.setEnabled(true);
		m8.setEnabled(true);
		m9.setEnabled(true);
		m10.setEnabled(true);
		panel.requestFocus();break;
		case 4:sound.setMusic("One piece.mid");//Music5
		if(sound.isplay())
			sound.mystop();
		sound.loadSound();
		bmuc.setLabel("Music Off");					
		m0.setEnabled(true);
		m1.setEnabled(true);
		m2.setEnabled(true);
		m3.setEnabled(true);
		m4.setEnabled(false);
		m5.setEnabled(true);
		m6.setEnabled(true);
		m7.setEnabled(true);
		m8.setEnabled(true);
		m9.setEnabled(true);
		m10.setEnabled(true);
		panel.requestFocus();break;
		case 5:sound.setMusic("WILL.mid");//Music6
		if(sound.isplay())
			sound.mystop();
		sound.loadSound();
		bmuc.setLabel("Music Off");					
		m0.setEnabled(true);
		m1.setEnabled(true);
		m2.setEnabled(true);
		m3.setEnabled(true);
		m4.setEnabled(true);
		m5.setEnabled(false);
		m6.setEnabled(true);
		m7.setEnabled(true);
		m8.setEnabled(true);
		m9.setEnabled(true);
		m10.setEnabled(true);
		panel.requestFocus();break;
		case 6:sound.setMusic("A Cruel Angel's Thesis.mid");//Music7
		if(sound.isplay())
			sound.mystop();
		sound.loadSound();
		bmuc.setLabel("Music Off");					
		m0.setEnabled(true);
		m1.setEnabled(true);
		m2.setEnabled(true);
		m3.setEnabled(true);
		m4.setEnabled(true);
		m5.setEnabled(true);
		m6.setEnabled(false);
		m7.setEnabled(true);
		m8.setEnabled(true);
		m9.setEnabled(true);
		m10.setEnabled(true);
		panel.requestFocus();break;
		case 7:sound.setMusic("Kirby.mid");//Music8
		if(sound.isplay())
			sound.mystop();
		sound.loadSound();
		bmuc.setLabel("Music Off");					
		m0.setEnabled(true);
		m1.setEnabled(true);
		m2.setEnabled(true);
		m3.setEnabled(true);
		m4.setEnabled(true);
		m5.setEnabled(true);
		m6.setEnabled(true);
		m7.setEnabled(false);
		m8.setEnabled(true);
		m9.setEnabled(true);
		m10.setEnabled(true);
		panel.requestFocus();break;
		case 8:sound.setMusic("Get Over.mid");//Music9
		if(sound.isplay())
			sound.mystop();
		sound.loadSound();
		bmuc.setLabel("Music Off");					
		m0.setEnabled(true);
		m1.setEnabled(true);
		m2.setEnabled(true);
		m3.setEnabled(true);
		m4.setEnabled(true);
		m5.setEnabled(true);
		m6.setEnabled(true);
		m7.setEnabled(true);
		m8.setEnabled(false);
		m9.setEnabled(true);
		m10.setEnabled(true);
		panel.requestFocus();break;
		case 9:sound.setMusic("Mario.mid");//Music10
		if(sound.isplay())
			sound.mystop();
		sound.loadSound();
		bmuc.setLabel("Music Off");					
		m0.setEnabled(true);
		m1.setEnabled(true);
		m2.setEnabled(true);
		m3.setEnabled(true);
		m4.setEnabled(true);
		m5.setEnabled(true);
		m6.setEnabled(true);
		m7.setEnabled(true);
		m8.setEnabled(true);
		m9.setEnabled(false);
		m10.setEnabled(true);
		panel.requestFocus();break;
		case 10:sound.setMusic("CHANGE THE WORLD.mid");//Music11
		if(sound.isplay())
			sound.mystop();
		sound.loadSound();
		bmuc.setLabel("Music Off");					
		m0.setEnabled(true);
		m1.setEnabled(true);
		m2.setEnabled(true);
		m3.setEnabled(true);
		m4.setEnabled(true);
		m5.setEnabled(true);
		m6.setEnabled(true);
		m7.setEnabled(true);
		m8.setEnabled(true);
		m9.setEnabled(true);
		m10.setEnabled(false);
		panel.requestFocus();break;
		}
	}
}

class mainpanel extends JPanel implements KeyListener// read map and manupulate character 
{
	int max=50;
	int[][] map,maptmp;
	int manX,manY,boxnum;
	Image[] myImage;
	Readmap Levelmap;
	Readmap Levelmaptmp;
	int len=30;
	public int level=1;
	Stack mystack=new Stack();
	mainpanel()
	{	
		setBounds(15,50,600,600);
		setBackground(Color.white);
		addKeyListener(this);
		myImage=new Image[10];
		for(int i=0; i<10; i++) 
		{
			myImage[i] = Toolkit.getDefaultToolkit().getImage(".\\src\\ce1002\\FP\\s103502043\\pictures\\"+i+".gif");
		}

		setVisible(true);
	}

	void Tuixiangzi(int i)
	{
		Levelmap=new Readmap(i);
		Levelmaptmp=new Readmap(i);
		map=Levelmap.getmap();
		manX=Levelmap.getmanX();
		manY=Levelmap.getmanY();
		maptmp=Levelmaptmp.getmap();
		repaint();
	}
	int maxlevel(){return max;}

	public void paint(Graphics g)
	{
		for(int i=0; i<20; i++)
			for(int j=0; j<20; j++)
			{
				g.drawImage(myImage[map[j][i]],i*len,j*len,this);
			}		
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("null",Font.BOLD,30));
		g.drawString("LEVEL",240,40);
		g.drawString(String.valueOf(level),350,40);

	}

	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode()==KeyEvent.VK_UP)//move up
		{
			moveup();
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN)//move down
		{
			movedown();
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)//move left
		{
			moveleft();
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)//move right
		{
			moveright();
		}
		if(iswin())//win
		{
			if(level==max)
			{
				JOptionPane.showMessageDialog(this, "Congratulation for passing the final level");
			}
			else
			{
				String msg="Congratulation for passing level "+level+" !!!\nDo you want to enter next level?";
				int type=JOptionPane.YES_NO_OPTION;
				String title="Congratulation";
				int choice=0;
				choice=JOptionPane.showConfirmDialog(null,msg,title,type);
				if(choice==1)System.exit(0);
				else if(choice==0)
				{
					level++;
					Tuixiangzi(level);
				}
			}
			mystack.removeAllElements();
		}
	}
	public void keyTyped(KeyEvent e)
	{

	}
	public void keyReleased(KeyEvent e)
	{

	}

	boolean isMystackEmpty()
	{
		return mystack.isEmpty();
	}

	int  back()
	{
		return (Integer)mystack.pop();
	}

	void remove()
	{
		mystack.removeAllElements();
	}

	void moveup()//move up
	{
		if(map[manY-1][manX]==2||map[manY-1][manX]==4)
		{
			if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
				map[manY][manX]=4;
			else 
				map[manY][manX]=2;
			map[manY-1][manX]=8;
			repaint();
			manY--;
			mystack.push(10);
		}
		else if(map[manY-1][manX]==3)
		{
			if(map[manY-2][manX]==4)
			{
				if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
					map[manY][manX]=4;
				else 
					map[manY][manX]=2;
				map[manY-1][manX]=8;
				map[manY-2][manX]=9;
				repaint();
				manY--;
				mystack.push(11);
			}
			else if(map[manY-2][manX]==2)
			{
				if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
					map[manY][manX]=4;
				else 
					map[manY][manX]=2;
				map[manY-1][manX]=8;
				map[manY-2][manX]=3;
				repaint();
				manY--;
				mystack.push(11);
			}
			else {map[manY][manX]=8;repaint();}
		}
		else if(map[manY-1][manX]==9)
		{
			if(map[manY-2][manX]==4)
			{
				if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
					map[manY][manX]=4;
				else 
					map[manY][manX]=2;
				map[manY-1][manX]=8;
				map[manY-2][manX]=9;
				repaint();
				manY--;
				mystack.push(11);
			}
			else if(map[manY-2][manX]==2)
			{
				if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
					map[manY][manX]=4;
				else map[manY][manX]=2;
				map[manY-1][manX]=8;
				map[manY-2][manX]=3;
				repaint();
				manY--;
				mystack.push(11);
			}
			else 
			{
				map[manY][manX]=8;repaint();
			}
		}
		if(map[manY-1][manX]==1)
		{
			map[manY][manX]=8;repaint();
		}
	}

	void backup(int t)//move back up
	{
		int n=t;
		if(n==10)
		{
			if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
			{
				map[manY][manX]=4;
			}
			else 
				map[manY][manX]=2;
		}
		else if(n==11)
		{
			if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
			{
				map[manY][manX]=9;
			}
			else 
				map[manY][manX]=3;
			if(maptmp[manY-1][manX]==4||maptmp[manY-1][manX]==9)
			{
				map[manY-1][manX]=4;
			}
			else 
				map[manY-1][manX]=2;
		}
		map[manY+1][manX]=8;
		repaint();
		manY++;
	}

	void movedown()//move down
	{
		if(map[manY+1][manX]==2||map[manY+1][manX]==4)
		{
			if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
				map[manY][manX]=4;
			else
				map[manY][manX]=2;
			map[manY+1][manX]=5;
			repaint();
			manY++;
			mystack.push(20);
		}
		else if(map[manY+1][manX]==3)
		{
			if(map[manY+2][manX]==4)
			{
				if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
					map[manY][manX]=4;
				else 
					map[manY][manX]=2;
				map[manY+1][manX]=5;
				map[manY+2][manX]=9;
				repaint();
				manY++;
				mystack.push(21);
			}
			else if(map[manY+2][manX]==2)
			{
				if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
					map[manY][manX]=4;
				else 
					map[manY][manX]=2;
				map[manY+1][manX]=5;
				map[manY+2][manX]=3;
				repaint();
				manY++;
				mystack.push(21);
			}
			else
			{
				map[manY][manX]=5;
				repaint();
			}
		}
		else if(map[manY+1][manX]==9)
		{
			if(map[manY+2][manX]==4)
			{
				if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
					map[manY][manX]=4;
				else 
					map[manY][manX]=2;
				map[manY+1][manX]=5;
				map[manY+2][manX]=9;
				repaint();
				manY++;
				mystack.push(21);
			}
			else if(map[manY+2][manX]==2)
			{
				if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
					map[manY][manX]=4;
				else 
					map[manY][manX]=2;
				map[manY+1][manX]=5;
				map[manY+2][manX]=3;
				repaint();
				manY++;
				mystack.push(21);
			}
			else
			{
				map[manY][manX]=5;
				repaint();
			}
		}
		else if(map[manY+1][manX]==1)
		{
			map[manY][manX]=5;
			repaint();
		}
	}

	void backdown(int t)//move back down
	{
		int n=t;
		if(n==20)
		{
			if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
			{
				map[manY][manX]=4;
			}
			else 
				map[manY][manX]=2;
		}
		else if(n==21)
		{
			if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
			{
				map[manY][manX]=9;
			}
			else 
				map[manY][manX]=3;
			if(maptmp[manY+1][manX]==4||maptmp[manY+1][manX]==9)
			{
				map[manY+1][manX]=4;
			}
			else 
				map[manY+1][manX]=2;
		}
		map[manY-1][manX]=5;
		repaint();
		manY--;
	}

	void moveleft()//move left
	{
		if(map[manY][manX-1]==2||map[manY][manX-1]==4)
		{
			if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
				map[manY][manX]=4;
			else 
				map[manY][manX]=2;
			map[manY][manX-1]=6;			
			repaint();
			manX--;
			mystack.push(30);
		}
		else if(map[manY][manX-1]==3)
		{
			if(map[manY][manX-2]==4)
			{
				if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
					map[manY][manX]=4;
				else
					map[manY][manX]=2;
				map[manY][manX-1]=6;
				map[manY][manX-2]=9;
				repaint();
				manX--;
				mystack.push(31);
			}
			else if(map[manY][manX-2]==2)
			{
				if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
					map[manY][manX]=4;
				else 
					map[manY][manX]=2;
				map[manY][manX-1]=6;
				map[manY][manX-2]=3;
				repaint();
				manX--;
				mystack.push(31);
			}
			else {map[manY][manX]=6;repaint();}
		}
		else if(map[manY][manX-1]==9)
		{
			if(map[manY][manX-2]==4)
			{
				if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
					map[manY][manX]=4;
				else 
					map[manY][manX]=2;
				map[manY][manX-1]=6;
				map[manY][manX-2]=9;
				repaint();
				manX--;
				mystack.push(31);
			}
			else if(map[manY][manX-2]==2)
			{
				if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
					map[manY][manX]=4;
				else 
					map[manY][manX]=2;
				map[manY][manX-1]=6;
				map[manY][manX-2]=3;
				repaint();
				manX--;
				mystack.push(31);
			}
			else
			{
				map[manY][manX]=6;repaint();
			}
		}
		else if(map[manY][manX-1]==1)
		{
			map[manY][manX]=6;
			repaint();
		}
	}

	void backleft(int t)//move back left
	{
		int n=t;
		if(n==30)
		{
			if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
			{
				map[manY][manX]=4;
			}
			else 
				map[manY][manX]=2;
		}
		else if(n==31)
		{
			if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
			{
				map[manY][manX]=9;
			}
			else 
				map[manY][manX]=3;
			if(maptmp[manY][manX-1]==4||maptmp[manY][manX-1]==9)
			{
				map[manY][manX-1]=4;
			}
			else 
				map[manY][manX-1]=2;
		}
		map[manY][manX+1]=6;
		repaint();
		manX++;
	}

	void moveright()//move right
	{
		if(map[manY][manX+1]==2||map[manY][manX+1]==4)
		{			
			if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
				map[manY][manX]=4;
			else 
				map[manY][manX]=2;
			map[manY][manX+1]=7;			
			repaint();
			manX++;
			mystack.push(40);
		}
		else if(map[manY][manX+1]==3)
		{
			if(map[manY][manX+2]==4)
			{
				if(maptmp[manY][manX]==4)
					map[manY][manX]=4;
				else 
					map[manY][manX]=2;
				map[manY][manX+1]=7;
				map[manY][manX+2]=9;
				repaint();
				manX++;
				mystack.push(41);
			}
			else if(map[manY][manX+2]==2)
			{
				if(maptmp[manY][manX]==4)
					map[manY][manX]=4;
				else 
					map[manY][manX]=2;
				map[manY][manX+1]=7;
				map[manY][manX+2]=3;
				repaint();
				manX++;
				mystack.push(41);
			}
			else 
			{
				map[manY][manX]=7;repaint();
			}
		}
		else if(map[manY][manX+1]==9)
		{
			if(map[manY][manX+2]==4)
			{
				if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
					map[manY][manX]=4;
				else 
					map[manY][manX]=2;
				map[manY][manX+1]=7;
				map[manY][manX+2]=9;
				repaint();
				manX++;
				mystack.push(41);
			}
			else if(map[manY][manX+2]==2)
			{
				if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
					map[manY][manX]=4;
				else 
					map[manY][manX]=2;
				map[manY][manX+1]=7;
				map[manY][manX+2]=3;
				repaint();
				manX++;
				mystack.push(41);
			}
			else 
			{
				map[manY][manX]=7;repaint();
			}
		}
		else if(map[manY][manX+1]==1)
		{
			map[manY][manX]=7;repaint();
		}
	}

	void backright(int t)//move back right
	{
		int n=t;
		if(n==40)
		{
			if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
			{
				map[manY][manX]=4;
			}
			else 
				map[manY][manX]=2;
		}
		else if(n==41)
		{
			if(maptmp[manY][manX]==4||maptmp[manY][manX]==9)
			{
				map[manY][manX]=9;
			}
			else 
				map[manY][manX]=3;
			if(maptmp[manY][manX+1]==4||maptmp[manY][manX+1]==9)
			{
				map[manY][manX+1]=4;
			}
			else 
				map[manY][manX+1]=2;
		}
		map[manY][manX-1]=7;
		repaint();
		manX--;
	}

	boolean iswin()
	{
		boolean num=false;
		out:for(int i=0; i<20; i++)
			for(int j=0; j<20; j++)
			{
				if(maptmp[i][j]==4||maptmp[i][j]==9)
					if(map[i][j]==9)
						num=true;
					else 
					{
						num=false;
						break out;
					}
			}
		return num;
	}
}

class Sound//Music
{
	String path=new String(".\\src\\ce1002\\FP\\s103502043\\music\\");
	String  file=new String("Air.mid");
	Sequence seq;
	Sequencer midi;
	boolean sign;
	void loadSound()
	{
		try {
			seq=MidiSystem.getSequence(new File(path+file));
			midi=MidiSystem.getSequencer();
			midi.open();
			midi.setSequence(seq);
			midi.start();
			midi.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		sign=true;
	}
	void mystop()
	{
		midi.stop();
		midi.close();
		sign=false;
	}
	boolean isplay()
	{
		return sign;
	}
	void setMusic(String e)
	{
		file=e;
	}
}

class Readmap//Map
{
	private int level,mx,my;
	private int[][] mymap=new int[20][20];
	FileReader r;
	BufferedReader br;
	String bb="";
	int[] x;
	int c=0;
	Readmap(int k)
	{
		level=k;
		String s;
		try
		{
			File f=new File(".\\src\\ce1002\\FP\\s103502043\\maps\\"+level+".map");
			r=new FileReader(f);
			br=new BufferedReader(r);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		try
		{
			while ((s=br.readLine())!=null)
			{
				bb=bb+s;
			}
		}
		catch (IOException g)
		{
			System.out.println(g);
		}
		byte[] d=bb.getBytes();
		int len=bb.length();
		int[] x=new int[len];
		for(int i=0;i<bb.length();i++)
			x[i]=d[i]-48;
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
			{
				mymap[i][j]=x[c];
				if(mymap[i][j]==5)
				{
					mx=j;my=i;
				}
				c++;
			}
		}
	}
	int[][] getmap()
	{
		return mymap;
	}
	int getmanX()
	{
		return mx;
	}
	int getmanY()
	{
		return my;
	}
}