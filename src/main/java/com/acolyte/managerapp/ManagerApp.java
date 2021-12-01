package com.acolyte.managerapp;

import com.acolyte.managerapp.filework.FileHandler;
import com.acolyte.managerapp.manager.MembershipManagment;
import com.acolyte.managerapp.member.Member;

import java.util.LinkedList;
import java.util.List;

public class ManagerApp {

    public static final String SEPARATOR = System.lineSeparator();

    public static void main(String[] args) {
        String memberInf;
        MembershipManagment managment = new MembershipManagment();
        FileHandler fileHandler = new FileHandler();
        LinkedList<Member> members = fileHandler.readFile();
        int choise = managment.getChoise();

        while (choise != -1) {
            switch (choise) {
                case 1:
                    memberInf = managment.addMembers(members);
                    fileHandler.appendFile(memberInf);
                    break;
                case 2:
                    managment.removeMember(members);
                    fileHandler.overwriteFile(members);
                    break;
                case 3:
                    managment.printMemberInfo(members);
                    break;
                default:
                    System.out.println(SEPARATOR + "You have selected an invalid option." + SEPARATOR);
                    break;
            }
            choise = managment.getChoise();
        }
        System.out.println(SEPARATOR + "Thank you for watching and testing this app");
    }
}
