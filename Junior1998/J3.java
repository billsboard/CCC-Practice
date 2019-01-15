package ca.billweb.Junior1998;

import java.util.ArrayList;
import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < inputs; i++) {
            int nDist = 0, sDist = 0, eDist = 0, wDist = 0; //North, East, South, West distances - Right will be east
            String facing = "N";


            String line = scan.nextLine();
            boolean moving = false;

            while(!line.equals("0")) {
                int command = Integer.parseInt(line);

                if (command == 1 && !moving) {
                    moving = true;
                } else if (command == 2 || command == 3) {
                    facing = rotate(facing, command);
                } else {
                    switch (facing) {
                        case "N": {
                            nDist += command;
                            break;
                        }
                        case "E": {
                            eDist += command;
                            break;
                        }
                        case "S": {
                            sDist += command;
                            break;
                        }
                        case "W": {
                            wDist += command;
                            break;
                        }
                    }
                    moving = false;
                }

                line = scan.nextLine();
            }

            int totalDist = 0;
            totalDist += Math.abs(nDist - sDist);
            totalDist += Math.abs(eDist - wDist);

            System.out.println("Distance is " + totalDist);
            ArrayList<Integer> sequence = new ArrayList<>();

            if(totalDist != 0){
                String vFace = nDist > sDist ? "S" : "N";
                String hFace = eDist > wDist ? "W" : "E";


                if(facing.equals(hFace) || facing.equals(vFace)) {
                    if (facing.equals(hFace)) {
                        sequence.add(1); //Movement command
                        sequence.add(Math.abs(wDist - eDist));

                        if(rotate(facing, 2).equals(vFace)){
                            sequence.add(2);
                            sequence.add(1); //Movement command
                            sequence.add(Math.abs(nDist - sDist));
                        }
                        else {
                            sequence.add(3);
                            sequence.add(1); //Movement command
                            sequence.add(Math.abs(nDist - sDist));
                        }
                    }
                    else {
                        sequence.add(1); //Movement command
                        sequence.add(Math.abs(nDist - sDist));

                        if(rotate(facing, 2).equals(hFace)){
                            sequence.add(2);
                            sequence.add(1); //Movement command
                            sequence.add(Math.abs(eDist - wDist));
                        }
                        else {
                            sequence.add(3);
                            sequence.add(1); //Movement command
                            sequence.add(Math.abs(eDist - wDist));
                        }
                    }
                }
                else if(rotate(facing, 2).equals(hFace) || rotate(facing, 2).equals(vFace)){
                    if(rotate(facing, 2).equals(vFace)){
                        facing = rotate(facing, 2);
                        sequence.add(2);
                        sequence.add(1); //Movement command
                        sequence.add(Math.abs(nDist - sDist));

                        if(rotate(facing, 2).equals(hFace)){
                            sequence.add(2);
                            sequence.add(1); //Movement command
                            sequence.add(Math.abs(eDist - wDist));
                        }
                        else {
                            sequence.add(3);
                            sequence.add(1); //Movement command
                            sequence.add(Math.abs(eDist - wDist));
                        }
                    }
                    else if(rotate(facing, 2).equals(hFace)) {
                        facing = rotate(facing, 2);
                        sequence.add(2);
                        sequence.add(1); //Movement command
                        sequence.add(Math.abs(eDist - wDist));

                        if (rotate(facing, 2).equals(vFace)) {
                            sequence.add(2);
                            sequence.add(1); //Movement command
                            sequence.add(Math.abs(nDist - sDist));
                        }
                        else {
                            sequence.add(3);
                            sequence.add(1); //Movement command
                            sequence.add(Math.abs(nDist - sDist));
                        }
                    }
                }
                else {
                    if(rotate(facing, 3).equals(vFace)){
                        facing = rotate(facing, 2);
                        sequence.add(3);
                        sequence.add(1); //Movement command
                        sequence.add(Math.abs(nDist - sDist));

                        if(rotate(facing, 2).equals(hFace)){
                            sequence.add(2);
                            sequence.add(1); //Movement command
                            sequence.add(Math.abs(eDist - wDist));
                        }
                        else {
                            sequence.add(3);
                            sequence.add(1); //Movement command
                            sequence.add(Math.abs(eDist - wDist));
                        }
                    }
                    else if(rotate(facing, 3).equals(hFace)) {
                        facing = rotate(facing, 2);
                        sequence.add(3);
                        sequence.add(1); //Movement command
                        sequence.add(Math.abs(eDist - wDist));

                        if (rotate(facing, 2).equals(vFace)) {
                            sequence.add(2);
                            sequence.add(1); //Movement command
                            sequence.add(Math.abs(nDist - sDist));
                        } else {
                            sequence.add(3);
                            sequence.add(1); //Movement command
                            sequence.add(Math.abs(nDist - sDist));
                        }
                    }
                }
            }

            for (Integer ii: sequence) {
                System.out.println(ii);
            }
            System.out.println();
        }
    }

    public static String rotate(String facing, int movementDirection){ //2 for right and 3 for left
        if(movementDirection == 2){
            if(facing == "N"){ facing = "E"; }
            else if(facing == "E"){ facing = "S"; }
            else if(facing == "S"){ facing = "W"; }
            else { facing = "N"; }
        }
        if(movementDirection == 3){
            if(facing == "N"){ facing = "W"; }
            else if(facing == "W"){ facing = "S"; }
            else if(facing == "S"){ facing = "E"; }
            else { facing = "N"; }
        }

        return facing;
    }
}
