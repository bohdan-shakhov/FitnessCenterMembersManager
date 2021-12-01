package com.acolyte.managerapp.manager;

import com.acolyte.managerapp.calculator.Calculator;
import com.acolyte.managerapp.member.Member;
import com.acolyte.managerapp.member.MultiClubMember;
import com.acolyte.managerapp.member.SingleClubMember;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MembershipManagment {
    public static final String SEPARATOR = System.lineSeparator();
    private final Scanner SCANNER = new Scanner(System.in);

    private int getIntInput() {
        int choise = 0;

        while (choise == 0) {
            try {
                choise = SCANNER.nextInt();
                if (choise == 0) {
                    throw new InputMismatchException();
                }
                SCANNER.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("INVALID INPUT. Please try again: ");
            }
        }
        return choise;
    }

    private void printClubOptions() {
        System.out.println("Choose club(s)");
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }

    public int getChoise() {
        int choise;
        // for prettier output
        try {
            Thread.sleep(333);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("WELCOME TO OUR FITNESS CENTER");
        System.out.println("==============================");
        System.out.println("1) Add member");
        System.out.println("2) Remove member");
        System.out.println("3) Display member information");
        System.out.println("Please select an option (or Enter -1 to quit)");

        choise = getIntInput();
        return choise;
    }

    public String addMembers(LinkedList<Member> members) {
        String name;
        int club = -1;
        String memberInf = null;
        double fees;
        int memberID;
        Member member;
        Calculator<Integer> calculator;

        //get member`s name
        System.out.print("Print member`s name: ");
        name = SCANNER.nextLine();

        //get member`s club
        while (club < 1 || club > 4) {
            printClubOptions();
            club = getIntInput();
            if (club < 1 || club > 4) {
                System.err.println("Input correct value!!!");
                club = -1;
            }
        }

        // get member`s id
        if (members.size() > 0) {
            memberID = members.getLast().getMemberID() + 1;
        } else {
            memberID = 1;
        }

        if (club != 4) {
            calculator = n -> {
                if (n == 1) {
                    return 900;
                } else if (n == 2) {
                    return 950;
                } else if (n == 3) {
                    return 1000;
                }
                return -1;
            };
            fees = calculator.calculateFees(club);

            member = new SingleClubMember('S', memberID, name, fees, club);
            members.add(member);
            memberInf = member.toString();
            System.out.println(SEPARATOR+ "--------------STATUS: Single club member added------------" + SEPARATOR);
        } else {
            if (club == 4) {
                calculator = n -> {
                    if (n == 4) {
                        return 1200;
                    } else {
                        return -1;
                    }
                };
                fees = calculator.calculateFees(club);

                member = new MultiClubMember('M', memberID, name, fees, 100);
                members.add(member);
                memberInf = member.toString();
                System.out.println(SEPARATOR + "---------STATUS: Multiclub member added---------------" + SEPARATOR);
            }
        }
        return memberInf;
    }

    public void removeMember(LinkedList<Member> members) {
        int memberID;

        System.out.print("Enter the id of the member you want to remove: ");
        memberID = getIntInput();

        for (int i = 0; i < members.size(); i++) {
                if (members.get(i).getMemberID() == memberID) {
                    members.remove(i);
                    System.out.println("Remove operation successfully done" + SEPARATOR);
                    return;
                } else {
                    System.err.println("Member with this id doesn't represent in list" + SEPARATOR);
                }
            return;
        }
    }

    public void printMemberInfo(LinkedList<Member> members) {
        int memberID;

        System.out.print("Enter the id of the member you want to print: ");
        memberID = getIntInput();

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getMemberID() == memberID) {
                String[] memberInf = members.get(i).toString().split(", ");
                if (memberInf[0].equals("S")) {
                    String clubName = null;
                    if (Integer.parseInt(memberInf[4]) == 1) {
                        clubName = "Mercury";
                    } else if (Integer.parseInt(memberInf[4]) == 2) {
                        clubName = "Neptune";
                    } else if (Integer.parseInt(memberInf[4]) == 3) {
                        clubName = "Jupiter";
                    }
                    System.out.println("Member type: " + "Single" + SEPARATOR +
                            "Member ID: " + memberInf[1] + SEPARATOR +
                            "Member name: " + memberInf[2] + SEPARATOR +
                            "Member fees: " + memberInf[3] + "$" + SEPARATOR +
                            "Club: " + clubName + SEPARATOR);
                } else {
                    System.out.println("Member type: " + "Multiple" + SEPARATOR +
                            "Member ID: " + memberInf[1] + SEPARATOR +
                            "Member name: " + memberInf[2] + SEPARATOR +
                            "Member fees: " + memberInf[3] + "$" + SEPARATOR +
                            "Membership points: " + memberInf[4] + SEPARATOR);
                }
            } else {
                System.err.println("Member with this id doesn't represent in list" + SEPARATOR);
                return;
            }
        }
    }
}
