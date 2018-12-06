package work;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.zip.InflaterOutputStream;

public class Server2 {
	private static int index = 666;
    

	 /**
	   * 入口
	   * 
	   * @param args
	   * @throws IOException
	   */
	    public static void main(String[] args) throws IOException {
	        // 为了简单起见，所有的异常信息都往外抛
	        int port = 8800;
	        // 定义一个ServiceSocket监听在端口8899上
	        ServerSocket server = new ServerSocket(port);
	        System.out.println("等待与客户端建立连接...");
	        Socket socket = server.accept();
	        
	        BufferedReader reader=null;
	        BufferedWriter writer=null;
	        
	        reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
	        
            String lineResult;
            if((lineResult= reader.readLine()) != null){
            	System.out.println("lineResult"+lineResult);
            	BufferedReader inFile = new BufferedReader(new FileReader("F:\\777.txt"));
    	        StringBuilder sb = new StringBuilder();
    	        String str;
    	        while((str = inFile.readLine())!= null){
    	        	sb.append(str);
    	        }
    	        sb.append("\n");
    	        inFile.close();
    	        System.out.println("返回给客户端信息了");
    	        writer.write(sb.toString());
    	        writer.flush();
            }
            
	        
	        
	        
        	/*OutputStream output = socket.getOutputStream();
        	InputStream input = socket.getInputStream();
        	
            byte[] buff = new byte[1024];
            int len = 0;
            len = input.read(buff);
            //sb.append(new String(buff, 0, len,"UTF-8"));
            System.out.println("接收到数据:"+sb.toString());
            output.write((socket.getLocalPort()+""+index++).getBytes("UTF-8"));
            output.flush();*/
	       
	         //server.close();
	    }
}






