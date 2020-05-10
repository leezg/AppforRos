package com.example.appforros;

public class Robot {
    private int robot_id = 0;
    private long robot_ip;
    private String form_ip;

    public Robot() {

    }

    public Robot(long ip,String form_ip) {
        this.form_ip = form_ip;
        robot_ip = ip;
    }

    public long getRobot_ip() {
        return robot_ip;
    }

    public String getForm_ip() {
        return form_ip;
    }

    public void move(String direction) {
        if (direction == "forward") {

        } else if (direction  == "turnleft") {

        } else if (direction == "turnright") {

        } else if (direction == "backoff") {

        } else {

        }
    }

}
