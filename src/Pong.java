import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.lang.Math.*;
import java.net.*;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Pong implements ActionListener, KeyListener{
        
        public static boolean resume = true;
        public static int gameOver = 0;
	public static Pong pong;
	public int width = 700,width2 = 300, height = 700;
  
	public Renderer renderer;
        public ScoreBoard scoreboard;
	public Paddle p1, p2,p3,p4;
	public Ball ball;
        public String thisip,hostip;
        public int ballVelocity;
	public int difficulty, myTheme,myMaxPoints;
	//public int difficulty = 1;
	public int GroupPort = 9875;
        public int localport = 9876;
        public int otherPort = 9874;
        public HashMap<Paddle,String> paddleAssignment = new HashMap<Paddle,String>();
	public DatagramSocket receivingsocket,sendingsocket,sendsocket;
	public ArrayList<String> IP_list = new ArrayList<String>() ;
	public InetAddress thispcip;
	public boolean host = true, bot = true, w = false, s = false, up = false, down = false,play=true,left = false, right = false;
	private static Random random;
        public static JFrame jFrame;
        public int noofPlayers = 1;
        public boolean ballreceivingstatus = false, status1 = false,status2 = false,status3=false,status4 = false;
	public Pong(int noOfPlayers,int level,int theme,int maxPoints) throws SocketException, UnknownHostException, IOException{
            bot = (noOfPlayers==1);
            difficulty = level ;
            switch(level){
                case 0:
                    ballVelocity = 3;
                    break;
                case 1:
                    ballVelocity = 5;
                    break;
                case 2:
                    ballVelocity = 7;
                    break;
            }
            myTheme = theme;
            myMaxPoints = maxPoints;
              
            Timer timer = new Timer(20, this);
            if(!bot){
                Timer timer2 = new Timer(50, new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for(final String Addr:IP_list){

                            Runnable sending =  new Runnable(){
                                @Override
                                public void run(){
                                    try {
                                        byte[] senddata = new byte[1024];
                                      //  String ballinfo = "ball " + ball.x + " "+ ball.y + " "+ball.motionX + " "+ball.motionY; 
                                      String paddleinfo = "paddle " + itspaddle().x +" " +  itspaddle().y;  
                                      senddata = paddleinfo.getBytes();
                                        DatagramPacket sendPacket = new DatagramPacket(senddata,senddata.length,InetAddress.getByName(Addr),GroupPort);
                                        sendsocket.send(sendPacket);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Pong.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            };

                Thread sendingThread = new Thread(sending);
                sendingThread.start();
               }
               }

                });
                timer2.start();
                 Timer checktimer = new Timer(500, new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        /*if(status1 = false){
                            noofPlayers -= 1;
                            IP_list.remove(paddleAssignment.get(p1));
                            paddleAssignment.remove(p1);
                            paddleAssignment.put(p1,"bot");
                        }
                        if(status2 = false){
                            noofPlayers -= 1;
                            IP_list.remove(paddleAssignment.get(p2));
                            paddleAssignment.remove(p2);
                            paddleAssignment.put(p2,"bot");
                        }
                        if(status3 = false){
                            noofPlayers -= 1;
                            IP_list.remove(paddleAssignment.get(p3));
                            paddleAssignment.remove(p3);
                            paddleAssignment.put(p3,"bot");
                        }
                        if(status4 = false){
                            noofPlayers -= 1;
                            IP_list.remove(paddleAssignment.get(p4));
                            paddleAssignment.remove(p4);
                            paddleAssignment.put(p4,"bot");
                        }*/
                        if(ballreceivingstatus=false){
                            try{
                                if(status2) 
                                    Send("host",paddleAssignment.get(p2));
                                else if(status3)
                                    Send("host",paddleAssignment.get(p3));
                                else if(status4)
                                    Send("host",paddleAssignment.get(p4));
                            }catch(IOException error){
                                error.printStackTrace();
                            }
                        }

                        ballreceivingstatus=false;
                        status1=false;
                        status2=false;
                        status3=false;
                        status4=false;
                    }

                });
                checktimer.start();
            }
            jFrame = new JFrame("Pong");
            jFrame.setSize(width + width2, height + 22);
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
            JPanel main = new JPanel();
            
            renderer = new Renderer(myTheme);
            renderer.setBorder(new LineBorder(new Color(204,204,0), 14, false));
            
            scoreboard = new ScoreBoard();
            scoreboard.setFocusable(false);
            renderer.setFocusable(true);
            main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));
            jFrame.getContentPane().add(main);
            main.add(renderer);
            main.add(scoreboard);
                
            //jFrame.addKeyListener(this);
            renderer.addKeyListener(this);
            
            start();
		
            timer.start(); 
	}
        public Paddle itspaddle(){
            if(paddleAssignment.get(p1).equals(thisip)){
                return p1;
            }else if(paddleAssignment.get(p2).equals(thisip)){
                return p2;
            }else if(paddleAssignment.get(p3).equals(thisip)){
                return p3;
            }else return p4;
        }
        

        public JPanel getPanel(){
            return renderer;
        }
        
	private void start() throws IOException {
                p1 = new Paddle(this, 1);
		p2 = new Paddle(this, 2);
                p3 = new Paddle(this, 3);
		p4 = new Paddle(this, 4);
                
                paddleAssignment.put(p1,"bot");
                paddleAssignment.put(p2,"bot");
                paddleAssignment.put(p3,"bot");
                paddleAssignment.put(p4,"bot");
                
                
		ball = new Ball(this,this.width/2 - (25/2),this.height/2 - (25/2));
		random = new Random();
		int rand = random.nextInt(2);
		if(rand == 1){
			ball.motionX = ballVelocity + random.nextInt(4);
		}else{
			ball.motionX = -(ballVelocity + random.nextInt(4));
		}
                
		int randy = random.nextInt(2);
 		if(randy == 1){
		ball.motionY = ballVelocity + random.nextInt(3);
 		}else{
 			ball.motionY = -(ballVelocity + random.nextInt(3));
 	 	}
		while(ball.motionX == ball.motionY || ball.motionX == -ball.motionY){
			ball.motionY = ballVelocity + random.nextInt(3);
		}
                if(!bot){
                    play = false;
                    IP_list = new ArrayList<String>();
                    receivingsocket =  new DatagramSocket(GroupPort);
                    sendingsocket = new DatagramSocket(localport);
                    sendsocket = new DatagramSocket(otherPort);
                    System.out.println("sockets started");
                    thispcip = InetAddress.getLocalHost();
                    thisip = thispcip.getHostName();
                    IP_list.add(thisip);
                    if(noofPlayers == IP_list.size()){
                        play = true;
                    }
                    if(!host){
                        Send("addme",hostip);
                    }else{
                        paddleAssignment.remove(p1);
                        paddleAssignment.put(p1, thisip);
                    }
                    
                    //Sending();
                    receiving();
                    
                }
                /*
		IP_list = new ArrayList<String>();
		socket = new DatagramSocket(GroupPort);
		System.out.println("socket started");
		Send("addme",firsthost);
		
		StartNetwork();*/
	}
        private void receiving() {
            Runnable receiving;
            receiving = new Runnable(){
                @Override
                public void run(){
                    while(true){
                        try {
                            byte[] receivedata = new byte[1024];
                            DatagramPacket receivedPacket = new DatagramPacket(receivedata,receivedata.length);
                            receivingsocket.receive(receivedPacket);
                            String Receiveddata = new String(receivedPacket.getData()).trim();
                            if(Receiveddata.equals("addme")){
                                Addme(receivedPacket.getAddress().getHostName());
                            }
                            if(Receiveddata.startsWith("Player Added")){
                                String args[] = Receiveddata.split(" ");
                                Addme(args[2]);
                            }
                            if(Receiveddata.equals("host")){
                                host = true;
                            }
                            if(Receiveddata.startsWith("ball")){
                                String args[] = Receiveddata.split(" ");
                                int x =Integer.parseInt(args[1]);
                                int y = Integer.parseInt(args[2]);
                                ball = new Ball(pong,x,y);
                                int mX = Integer.parseInt(args[3]);
                                int mY = Integer.parseInt(args[4]);
                                ball.motionX=mX;
                                ball.motionY=mY;
                                ballreceivingstatus = true;
                            }
                            if(Receiveddata.equals("paddlaA")){
                                String args[] = Receiveddata.split(" ");
                                paddleAssignment.clear();
                                paddleAssignment.put(p1, args[1]);
                                paddleAssignment.put(p2, args[2]);
                                paddleAssignment.put(p4, args[3]);
                                paddleAssignment.put(p4, args[4]);
                                Send("play");
                            }
                            if(Receiveddata.startsWith("paddle")){
                                String args[]=Receiveddata.split(" ");
                                 if(receivedPacket.getAddress().getHostName().equals(paddleAssignment.get(p1))){
                                    p1.x = Integer.parseInt(args[1]);
                                    p1.y = Integer.parseInt(args[2]);
                                 }
                                 if(receivedPacket.getAddress().getHostName().equals(paddleAssignment.get(p2))){
                                    p2.x = Integer.parseInt(args[1]);
                                    p2.y = Integer.parseInt(args[2]);
                                 }
                                 if(receivedPacket.getAddress().getHostName().equals(paddleAssignment.get(p3))){
                                    p3.x = Integer.parseInt(args[1]);
                                    p3.y = Integer.parseInt(args[2]);
                                 }
                                 if(receivedPacket.getAddress().getHostName().equals(paddleAssignment.get(p4))){
                                    p4.x = Integer.parseInt(args[1]);
                                    p4.y = Integer.parseInt(args[2]);
                                 }
                            }
                            if(Receiveddata.equals("play")){
                                play = true;
                            }
                            if(Receiveddata.equals("true")){
                                 if(receivedPacket.getAddress().getHostName().equals(paddleAssignment.get(p1))){
                                    p1.move(true);
                                    status1 = true;
                                 }
                                 if(receivedPacket.getAddress().getHostName().equals(paddleAssignment.get(p2))){
                                     p2.move(true);
                                     status2=true;
                                 }
                                 if(receivedPacket.getAddress().getHostName().equals(paddleAssignment.get(p3))){
                                     p3.movex(true);
                                     status3=true;
                                 }
                                 if(receivedPacket.getAddress().getHostName().equals(paddleAssignment.get(p4))){
                                     p4.movex(true);
                                     status4=true;
                                 }
                            }
                            if(Receiveddata.startsWith("score")){
                                String args[] = Receiveddata.split(" ");
                                System.out.println("Received Data: "+Receiveddata);
                                ball.a = Integer.parseInt(args[1]);
                                ball.b = Integer.parseInt(args[2]);
                                ball.c = Integer.parseInt(args[3]);
                                ball.d = Integer.parseInt(args[4]);
                           
                            }
                            if(Receiveddata.equals("false")){
                                 if(receivedPacket.getAddress().getHostName().equals(paddleAssignment.get(p1))){
                                     p1.move(false);
                                    status1 = true;
                                 }
                                 if(receivedPacket.getAddress().getHostName().equals(paddleAssignment.get(p2))){
                                     p2.move(false);
                                     status2=true;
                                 }
                                 if(receivedPacket.getAddress().getHostName().equals(paddleAssignment.get(p3))){
                                     p3.movex(false);
                                     status3=true;
                                 }
                                 if(receivedPacket.getAddress().getHostName().equals(paddleAssignment.get(p4))){
                                     p4.movex(false);
                                     status4=true;

                                 }
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(Pong.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                }
            };
            Thread receivingThread = new Thread(receiving);
            receivingThread.start();

            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        private void Addme(String hostName) throws IOException {
            if(noofPlayers > IP_list.size()){
                if(IP_list.contains(hostName)){
                    System.out.println("already added");
                }else{
                    if(host){
                     Send("Player Added " + hostName);
                    IP_list.add(hostName);
                    switch(IP_list.size()){
                        case 2:
                            paddleAssignment.remove(p2);
                            paddleAssignment.put(p2, hostName);
                            break;
                        case 3:
                            if(noofPlayers <= 3){
                                paddleAssignment.remove(p3);
                                paddleAssignment.put(p3, hostName);
                            }
                            break;
                        case 4:
                            if(noofPlayers <=4){
                                paddleAssignment.remove(p4);
                                paddleAssignment.put(p4,hostName);
                            }
                            break;
                    }
                    }
                    Send("addme",hostName);
                    if(noofPlayers == IP_list.size()){
                        Send("paddlaA " + paddleAssignment.get(p1) + " " + paddleAssignment.get(p2) + " " + paddleAssignment.get(p3) + " " + paddleAssignment.get(p4));
                    }

                }
            }
        }
        private void Sending() {
            for(final String Addr:IP_list){

                Runnable sending =  new Runnable(){
                    @Override
                    public void run(){
                        try {
                            while(true){
                                byte[] senddata = new byte[1024];
                                String ballinfo = "ball " + ball.x + " "+ ball.y + " "+ball.motionX + " "+ball.motionY; 
                                senddata = ballinfo.getBytes();
                                DatagramPacket sendPacket = new DatagramPacket(senddata,senddata.length,InetAddress.getByName(Addr),GroupPort);
                                sendingsocket.send(sendPacket);
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(Pong.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
            
            Thread sendingThread = new Thread(sending);
            sendingThread.start();
           }
        }
        public void Send(String string, String firsthost2) throws IOException {
		byte[] SendData = new byte[1024];
		SendData = string.getBytes();
		InetAddress InetAddr;
			InetAddr = InetAddress.getByName(firsthost2);
		
		DatagramPacket SendPacket = new DatagramPacket(SendData,SendData.length,InetAddr,GroupPort);
		sendingsocket.send(SendPacket);
		System.out.println("sent:"+string);
		// TODO Auto-generated method stub
		
	}

//	private void StartNetwork() throws SocketException {
//		// TODO Auto-generated method stub
//		Runnable networkThread = new Runnable(){
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//			while(true){
//				try {
//					byte[] ReceiveData = new byte[1024];
//					DatagramPacket ReceivePacket = new DatagramPacket(ReceiveData,ReceiveData.length);
//					receivingsocket.receive(ReceivePacket);
//					System.out.println("received:" + (new String(ReceivePacket.getData())).trim());
//					
//					if(IP_list.isEmpty()){
//						String hostAddress = ReceivePacket.getAddress().getHostAddress();
//						IP_list.add(hostAddress);
//						bot = false;
//						play = true;
//						//connection();
//					}
//					String received = (new String(ReceivePacket.getData())).trim();
//					if(received.equals("addme")){
//						Send("ball "+ball.x+" "+ ball.y+" "+ball.motionX+" "+ball.motionY+" "+p1.y+" "+p2.y);
//					//	try {
//							//Thread.sleep(8);
//						//} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							//e.printStackTrace();
//						//}
//						play = true;
//					}
//					if(received.equals("true")){
//						p1.move(true);
//					}
//					if(received.equals("false")){
//						p1.move(false);
//					}
//					if(received.startsWith("ball")){
//						String args[] = received.split(" ");
//						int x =pong.width - Integer.parseInt(args[1]);
//						int y = Integer.parseInt(args[2]);
//						ball = new Ball(pong,x,y);
//						int mX = -Integer.parseInt(args[3]);
//						int mY = Integer.parseInt(args[4]);
//						ball.motionX=mX;
//						ball.motionY=mY;
//						int pad1Y=Integer.parseInt(args[5]);
//						int pad2Y=Integer.parseInt(args[6]);
//						p2.y=pad1Y;
//						p1.y=pad2Y;
//						play = true;
//					}
//					if(received.startsWith("BIall")){
//						String args[] = received.split(" ");
//						int x =pong.width - Integer.parseInt(args[1]);
//						int y = Integer.parseInt(args[2]);
//						ball = new Ball(pong,x,y);
//						int mX = -Integer.parseInt(args[3]);
//						int mY = Integer.parseInt(args[4]);
//						ball.motionX=mX;
//						ball.motionY=mY;
//						}
//					if(received.startsWith("paddle")){
//						String args[] = received.split(" ");
//						p1.y = Integer.parseInt(args[3]);
//						p2.y = Integer.parseInt(args[2]);
//					}
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//				
//			}
//
//		};
//		Thread t = new Thread(networkThread);
//		t.start();
//		
//	}
//	private void connection() {
//		// TODO Auto-generated method stub
//		Runnable continuous = new Runnable(){
//
//			@Override
//			public void run() {
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				while(true){
//				// TODO Auto-generated method stub
//					Send("ball "+ball.x+" "+ ball.y+" "+ball.motionX+" "+ball.motionY/*+" "+p1.y+" "+p2.y*/);
//					try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				}
//				}
//			
//		};
//		Thread t = new Thread(continuous);
//		t.start();
//	}

	public void update() throws IOException{
                if(ball.paddlesleft.size() == 1){
                    int i = ball.paddlesleft.get(0);
                    switch(i){
                        case 1 :
                            System.out.println("bot1 won");
                            break;
                        case 2 :
                            System.out.println("bot2 won");
                            break;
                        case 3 :
                            System.out.println("bot 3 won");
                            break;
                        case 4 :
                            gameOver = 2;
                            System.out.println("bot4 won");
                            break;
                    }        
                }else{
                    if(play)ball.update(p1, p2,p3,p4, pong);
                    if(bot) {
                            if(ball.a >= 0) p1.update(pong, difficulty, ball);
                            if(ball.c >= 0) p2.update(pong, difficulty, ball);
                            if(ball.b >= 0) p3.update(pong, difficulty, ball);
                            //if(ball.d <= 2) p4.update(pong, difficulty, ball);
                            if(left) p4.movex(true);
                            if(right) p4.movex(false);
                    }else{  
                            if(paddleAssignment.get(p1).equals("bot")){
                                p1.update(pong, difficulty, ball);
                            }else{
                                if(up){
                                    if(!IP_list.isEmpty()){
                                           // Send("true");
                                            p1.move(true);
                                    }
                                }else if(down){
                                    if(!IP_list.isEmpty()){
                                          //  Send("false");
                                            p1.move(false);
                                    }
                                }
                            }
                            
                            if(paddleAssignment.get(p2).equals("bot")){
                                p2.update(pong, difficulty, ball);
                            }else{
                                if(up){
                                    if(!IP_list.isEmpty()){
                                          //  Send("true");
                                            p2.move(true);
                                    }
                                }else if(down){
                                    if(!IP_list.isEmpty()){
                                           // Send("false");
                                            p2.move(false);
                                    }
                                }
                            }
                            
                            if(paddleAssignment.get(p3).equals("bot")){
                                p3.update(pong, difficulty, ball);
                            }else{
                                if(left){
                                    if(!IP_list.isEmpty()){
                                           // Send("true");
                                            p3.movex(true);
                                    }
                                }else if(right){
                                    if(!IP_list.isEmpty()){
                                           // Send("false");
                                            p3.movex(false);
                                    }
                                }
                            }
                                
                            
                            
                            if(paddleAssignment.get(p4).equals("bot")){
                                p4.update(pong, difficulty, ball);
                            }else{
                                if(left){
                                    if(!IP_list.isEmpty()){
                                            //Send("true");
                                            p4.move(true);
                                    }
                                }else if(right){
                                    if(!IP_list.isEmpty()){
                                           // Send("false");
                                            p4.move(false);
                                    }
                                }
                            }
                    }
                }
		/*if(w)
			p1.move(true);
		else if(s)
			p1.move(false);
		*/
	}
	
        public void Send(String string) {
		// TODO Auto-generated method stub
		final String data = string;
		for(final String Addr : IP_list){
                    Runnable sendthread = new Runnable(){

                            @Override
                            public void run() {
                                    // TODO Auto-generated method stub
                                            try {
                                                    byte[] SendData = new byte[1024];
                                                    SendData = data.getBytes();
                                                    InetAddress InetAddr;
                                                            InetAddr = InetAddress.getByName(Addr);

                                                    DatagramPacket SendPacket = new DatagramPacket(SendData,SendData.length,InetAddr,GroupPort);
                                                    sendingsocket.send(SendPacket);
                                                    System.out.println("Sent:"+ new String(SendData).trim());

                                            } catch (UnknownHostException e) {
                                                    // TODO Auto-generated catch block
                                                    e.printStackTrace();
                                            }catch(IOException e){
                                                    e.printStackTrace();
                                            }

                                    }
                    };
                    Thread t = new Thread(sendthread);
                    t.start();
                }
	}
        
	public void render(Graphics2D g) {
            scoreboard.render(ball.a, ball.b, ball.c, ball.d);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, width, height);
       	    if(ball.a >= 0) p1.render(g,1);
            if(ball.c >= 0) p2.render(g,1);
            if(ball.b >= 0) p3.render(g,2);
            if(ball.d >= 0) p4.render(g,2);
            ball.render(g);
            if(!resume){
                g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
                g.setColor(Color.red);
                g.drawString("PAUSED", width/2 - 80, height/2);
                g.setFont(new Font("TimesRoman", Font.ITALIC, 20));
                g.drawString("Hit ESC to quit to main menu", width/2 - 100, height/2 + 20);
            }
            if(gameOver!=0){
                g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
                if(gameOver==1)
                    g.drawString("YOU LOST!", width/2 - 120, height/2);
                else
                    g.drawString("YOU WON!", width/2 - 120, height/2);
                g.setFont(new Font("TimesRoman", Font.ITALIC, 20));
                g.drawString("Hit ESC to quit to main menu", width/2 - 100, height/2 + 20);
            }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
            renderer.requestFocusInWindow();
            if(resume && !((gameOver!=0) && bot)){
		try {
			update();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
            }
            renderer.repaint(); 
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int id = e.getKeyCode();
		if(resume || id == KeyEvent.VK_SPACE || id == KeyEvent.VK_ESCAPE){
                    switch(id){
                            case KeyEvent.VK_W:
                                    w = true;
                                    break;

                            case KeyEvent.VK_S:
                                    s = true;
                                    break;

                            case KeyEvent.VK_LEFT:
                                    left = true;
                                    break;

                            case KeyEvent.VK_RIGHT:
                                    right =true;
                                    break;
                            case KeyEvent.VK_UP:
                                    up = true;
                                    break;

                            case KeyEvent.VK_DOWN:
                                    down = true;
                                    break;

                            case KeyEvent.VK_SPACE:
                                if(gameOver!=0)
                                    break;
                                resume = (resume)?false:true;
                                break;
                                
                            case KeyEvent.VK_ESCAPE:
                                if(resume && gameOver==0)  break;
                                jFrame.dispose();
                                resume = true;
                                gameOver = 0;
                                FirstScreen.fScreen.setVisible(true);
                                break;
                    }
                }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int id = e.getKeyCode();
		if(resume || id == KeyEvent.VK_SPACE){
                    switch(id){
                            case KeyEvent.VK_W:
                                    w = false;
                                    break;

                            case KeyEvent.VK_S:
                                    s = false;
                                    break;
                            case KeyEvent.VK_LEFT:
                                    left = false;
                                    break;

                            case KeyEvent.VK_RIGHT:
                                    right =false;
                                    break;

                            case KeyEvent.VK_UP:
                                    up = false;
                                    break;

                            case KeyEvent.VK_DOWN:
                                    down = false;
                                    break;
                    }
                }
        }

    

    
}
