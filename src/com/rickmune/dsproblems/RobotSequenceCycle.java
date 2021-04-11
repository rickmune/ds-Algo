package com.rickmune.dsproblems;

public class RobotSequenceCycle {

    public static void main(String[] args) {
        String moves = "GLGLGLG";


        int x = 0, y = 0;
        int dir = 0;

        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);

            switch (c) {
                case 'L':
                    dir = (dir + 1) % 4;
                    break;
                case 'R':
                    dir = (4 + dir - 1) % 4;
                    break;
                case 'G':
                    switch (dir) {
                        case 0:
                            y++;
                            break;
                        case 1:
                            x++;
                            break;
                        case 2:
                            y--;
                            break;
                        case 3:
                            x--;
                            break;
                    }
            }

            if (c == 'L') {
                dir = (dir + 1) % 4;
            } else if (c == 'R') {
                dir = (4 + dir - 1) % 4;
            }
        }

        if (x == 0 & y == 0) System.out.println("RobotSequenceCycle.main" + " CIRCULAR");
    }
}
