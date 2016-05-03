import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.*;


public class Ball {
	public int x,y,motionX,motionY,width = 25,height = 25;
	public static Random random;
        public int a, b, c, d;
        public ArrayList<Integer> paddlesleft = new ArrayList<Integer>();
	public Ball(Pong pong,int X,int Y){
		random =  new Random();
		//this.x = pong.width/2 - width/2;
		//this.y = pong.height/2 - height/2;
		this.x = X;
		this.y = Y;
                paddlesleft.add(1);
                paddlesleft.add(2);
                paddlesleft.add(3);
                paddlesleft.add(4);
                a = b = c = d = pong.myMaxPoints;
                /*int rand = random.nextInt(2);
		if(rand == 1){
			this.motionX = 5 + random.nextInt(4);
		}else{
			this.motionX = -(5 + random.nextInt(4));
		}

		
		int randy = random.nextInt(2);
 		if(randy == 1){
		this.motionY = 5 + random.nextInt(3);
 		}else{
 			this.motionY = -(5 + random.nextInt(3));
 	 	}
		while(motionX == motionY || motionX == -motionY){
			this.motionY = 5 + random.nextInt(3);
		}
		*/
	}
	public void update(Paddle paddle1,Paddle paddle2,Paddle paddle3,Paddle paddle4,Pong pong){
		if(a >= 0) checkCollision(paddle1,pong);
		if(c >= 0) checkCollision(paddle2,pong);
                if(b >= 0) checkCollision(paddle3,pong);
		if(d >= 0) checkCollision(paddle4,pong);
                if((x + width + motionX > pong.width) ){
			motionX = -motionX;
                        
                        if(c >= 0){
                            c--;
                            pong.Send("Score "+ a + " "+ b+" "+c+" "+d);
                            pong.Send("ball " + x +" "+ y+" "+motionX+" "+motionY);

                            if(c == -1){
                                paddlesleft.remove((Integer)3);
                            }
                            System.out.println("Score of left bot : " + a);
                            System.out.println("Score of top bot : " + b);
                            System.out.println("Score of right bot : " + c);
                            System.out.println("Score of bottom bot : "+d);
                        }
                }
                if((x + motionX < 0)  ){
			motionX = -motionX;
                        if(a >= 0){
                            a--;
                            pong.Send("Score "+ a + " "+ b+" "+c+" "+d);
                            pong.Send("ball " + x +" "+ y+" "+motionX+" "+motionY);
                            if(a == -1){
                                paddlesleft.remove((Integer)1);
                            }
                            System.out.println("Score of left bot : " + a);
                            System.out.println("Score of top bot : " + b);
                            System.out.println("Score of right bot : " + c);
                            System.out.println("Score of bottom bot : "+d);
                        }                
                }
                if((y + height + motionY > pong.height)){
			motionY = -motionY;
                        if(d >= 0){
                            d--;
                            pong.Send("Score "+ a + " "+ b+" "+c+" "+d);
                            pong.Send("ball " + x +" "+ y+" "+motionX+" "+motionY);
                        
                            if(d == -1){
                                paddlesleft.remove((Integer)4);
                                Pong.gameOver = 1;
                            }
                            System.out.println("Score of left bot : " + a);
                            System.out.println("Score of top bot : " + b);
                            System.out.println("Score of right bot : " + c);
                            System.out.println("Score of bottom bot : "+d);
                        }		
                }       
                if((y + motionY < 0)){
			motionY = -motionY;
                        if(b >= 0){
                            b--;
                            pong.Send("Score "+ a + " "+ b+" "+c+" "+d);
                            pong.Send("ball " + x +" "+ y+" "+motionX+" "+motionY);
                            
                            if(b == -1){
                                paddlesleft.remove((Integer)2);
                            }
                            System.out.println("Score of left bot : " + a);
                            System.out.println("Score of top bot : " + b);
                            System.out.println("Score of right bot : " + c);
                            System.out.println("Score of bottom bot : "+d);
                        }
                }

		this.x += motionX;
		this.y += motionY;
	}
	public void checkCollision(Paddle paddle,Pong pong){
		if(paddle.paddleNumber == 1){
                    if((this.x + this.motionX < paddle.width) && (this.x > paddle.width)){
                        if((this.y + this.height + this.motionY > paddle.y - 5) && (this.y + this.motionY < paddle.y + 5 + paddle.height))
                            System.out.println("here________________________");
                            this.motionX = -this.motionX;
                           // pong.Send("ball " + x +" "+ y+" "+motionX+" "+motionY);

                    }else{
                        if((this.y + this.motionY + this.height > paddle.y - 5) && (this.y + this.height < paddle.y)){
                            if(this.x + this.motionX < paddle.width)
                                this.motionY = -this.motionY;
                             //   pong.Send("ball " + x +" "+ y+" "+motionX+" "+motionY);
                        }
                        else{
                            if((this.y + this.motionY < paddle.y + 5 + paddle.height) && (this.y > paddle.y + paddle.height))
                                if(this.x + this.motionX < paddle.width)
                                    this.motionY = -this.motionY;
                               //     pong.Send("ball " + x +" "+ y+" "+motionX+" "+motionY);
                }
                    }
		}else if(paddle.paddleNumber == 2){
                    if((this.x+this.width + this.motionX > pong.width - paddle.width) && (this.x+this.width < pong.width - paddle.width)){
                        if((this.y + this.height + this.motionY > paddle.y - 5) && (this.y + this.motionY < paddle.y + 5 + paddle.height))
                            this.motionX = -this.motionX;
                            //pong.Send("ball " + x +" "+ y+" "+motionX+" "+motionY);
                    }else{
                        if((this.y + this.motionY + this.height > paddle.y - 5) && (this.y + this.height < paddle.y)){
                            if(this.x +this.width+ this.motionX > pong.width - paddle.width)
                                this.motionY = -this.motionY;
                              //  pong.Send("ball " + x +" "+ y+" "+motionX+" "+motionY);
                            
                        }
                        else{
                            if((this.y + this.motionY < paddle.y + 5 + paddle.height) && (this.y > paddle.y + paddle.height))
                                if(this.x+this.width + this.motionX > pong.width - paddle.width)
                                    this.motionY = -this.motionY;
                                //    pong.Send("ball " + x +" "+ y+" "+motionX+" "+motionY);

                        }
                    }
//                        if((x+width+motionX) > (paddle.x )){
//                            if(((y+motionY)>paddle.y)&&((y+motionY)<(paddle.y + paddle.height))){
//                                    motionX = -motionX;
//                            }else{
//                                    if((((y+motionY+height) > (paddle.y))&&((y + height)<(paddle.y)))){
//                                            motionY = -motionY;
// //                                           System.out.println("here in 1_____________");
//                                    }
//                                    if(((y+motionY)<(paddle.y+paddle.height))&&((y)>(paddle.y +paddle.height))){
//                                            motionY=-motionY;
// //                                           System.out.println("here in 2_____________");
//                                    }
//                            }
//                            }		
                }else if(paddle.paddleNumber == 3){
                    if((this.y + this.motionY < paddle.height) && (this.y > paddle.height)){
                        if((this.x + this.width + this.motionX > paddle.x - 5) && (this.x + this.motionX < paddle.x + 5 + paddle.width))
                            this.motionY = -this.motionY;
                            //pong.Send("ball " + x +" "+ y+" "+motionX+" "+motionY);

                    }else{
                        if((this.x + this.motionX + this.width > paddle.x - 5) && (this.x + this.width < paddle.x)){
                            if(this.y + this.motionY < paddle.height)
                                this.motionX = -this.motionX;
                              //  pong.Send("ball " + x +" "+ y+" "+motionX+" "+motionY);

                        }
                        else{
                            if((this.x + this.motionX < paddle.x + 5 + paddle.width) && (this.x > paddle.x + paddle.width))
                                if(this.y + this.motionY < paddle.height)
                                    this.motionX = -this.motionX;
                                //    pong.Send("ball " + x +" "+ y+" "+motionX+" "+motionY);
            
                        }
                    }
                }else{
                    if((this.y + this.height+ this.motionY > pong.height - paddle.height) && (this.y + this.height< pong.height - paddle.height)){
                        if((this.x + this.width + this.motionX > paddle.x - 5) && (this.x + this.motionX < paddle.x + 5 + paddle.width))
                            this.motionY = -this.motionY;
                            //pong.Send("ball " + x +" "+ y+" "+motionX+" "+motionY);

                    }else{
                        if((this.x + this.motionX + this.width > paddle.x - 5) && (this.x + this.width < paddle.x)){
                            if(this.y +this.height+ this.motionY > pong.height - paddle.height)
                                this.motionX = -this.motionX;
                              //  pong.Send("ball " + x +" "+ y+" "+motionX+" "+motionY);

                        }
                        else{
                            if((this.x + this.motionX < paddle.x + 5 + paddle.width) && (this.x > paddle.x + paddle.width))
                                if(this.y + this.motionY > pong.height - paddle.height)
                                    this.motionX = -this.motionX;
                                //    pong.Send("ball " + x +" "+ y+" "+motionX+" "+motionY);
            
                        }
                    }
                }
                
	}
	
	public void render(Graphics g){
		g.setColor(Color.WHITE);
		g.fillOval(x, y, width, height);
	}
	
}
