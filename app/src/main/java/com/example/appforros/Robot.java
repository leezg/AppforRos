package com.example.appforros;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Robot {
    private int robot_id = 0;
    private long robot_ip;
    private String form_ip;
    private Socket socket;

    public Robot() {

    }

    public Robot(int robot_id, long robot_ip,String form_ip) {
        this.robot_id = robot_id;
        this.form_ip = form_ip;
        this.robot_ip = robot_ip;
    }

    public int getRobot_id() {
        return robot_id;
    }

    public long getRobot_ip() {
        return robot_ip;
    }

    public String getForm_ip() {
        return form_ip;
    }

    public boolean sendHello() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    socket = new Socket(form_ip, 12574);

                    //向服务器发送数据
                    PrintWriter send = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8")));
                    send.println("hello");
                    send.flush();

                    //接受服务端数据
                    BufferedReader recv = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String recvMsg = recv.readLine();
                    if (recvMsg != null) {
//                          mRecvText.setText(recvMsg);
                        System.out.println(recvMsg);
                    } else {
//                          mRecvText.setText("Cannot receive data correctly.");
                    }

                    send.close();
                    recv.close();
                    socket.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }).start();
        return true;
    }

    public void move(String direction) {
        final String sendMesg;
        sendMesg = direction;
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    socket = new Socket(form_ip, 12574);

                    //向服务器发送数据
                    PrintWriter send = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8")));
                    send.println(sendMesg);
                    send.flush();

                    //接受服务端数据
                    BufferedReader recv = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String recvMsg = recv.readLine();
                    if (recvMsg != null) {
//                          mRecvText.setText(recvMsg);
                        System.out.println(recvMsg);
                    } else {
//                          mRecvText.setText("Cannot receive data correctly.");
                    }

                    send.close();
                    recv.close();
                    socket.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }).start();
    }

}
